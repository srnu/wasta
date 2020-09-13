package com.id.wasta.business.service.impl;

import static com.id.wasta.util.action.CommonConstants.GROUP;
import static com.id.wasta.util.action.CommonConstants.ONE_TO_ONE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.id.wasta.bean.ShareInfoBean;
import com.id.wasta.bean.jpa.TIdBoxTypeAccessEntity;
import com.id.wasta.data.repository.jpa.TIdBoxTypeAccessJpaRepository;

@Component
public class BoxTypeAccessService {

	@Autowired
	private TIdBoxTypeAccessJpaRepository tIdBoxTypeAccessJpaRepository;
	
	public void saveBoxTypeAccess(String menuType,ShareInfoBean shareInfoBean) { 
		if(shareInfoBean.getDataRefKey()==null) {
			tIdBoxTypeAccessJpaRepository.deleteBybtaMenuTypeAndBtaProfilePinKeyAndCreatedBy(menuType,shareInfoBean.getPinKey(),shareInfoBean.getCreatedBy());
		} else {
			List<TIdBoxTypeAccessEntity> tIdBoxTypeAccessEntityList =  tIdBoxTypeAccessJpaRepository.findByBtaMenuTypeAndBtaProfilePinKeyAndCreatedBy(menuType,shareInfoBean.getPinKey(),shareInfoBean.getCreatedBy()); 
			saveBoxTypeAccess(tIdBoxTypeAccessEntityList, shareInfoBean);
		}
	}
	
	public void saveBoxTypeAccess(String menuType, String fieldTypeInfo, ShareInfoBean shareInfoBean) {
		if(shareInfoBean.getDataRefKey()==null) {
			tIdBoxTypeAccessJpaRepository.deleteBybtaMenuTypeAndFieldTypeAndBtaProfilePinKeyAndCreatedBy(menuType,fieldTypeInfo, shareInfoBean.getPinKey(),shareInfoBean.getCreatedBy());
		} else {
			List<TIdBoxTypeAccessEntity> tIdBoxTypeAccessEntityList =  tIdBoxTypeAccessJpaRepository.findByBtaMenuTypeAndFieldTypeAndBtaProfilePinKeyAndCreatedBy(menuType,fieldTypeInfo,shareInfoBean.getPinKey(),shareInfoBean.getCreatedBy()); 
			saveBoxTypeAccess(tIdBoxTypeAccessEntityList, shareInfoBean);
		}
	}
	
	private void saveBoxTypeAccess(List<TIdBoxTypeAccessEntity> tIdBoxTypeAccessEntityList, ShareInfoBean shareInfoBean ) {
		if(tIdBoxTypeAccessEntityList!=null && tIdBoxTypeAccessEntityList.size()>0) {
			for(TIdBoxTypeAccessEntity tIdBoxTypeAccessEntity : tIdBoxTypeAccessEntityList) {
				if(tIdBoxTypeAccessEntity.getBtaRemoveAccess()!=null && !tIdBoxTypeAccessEntity.getBtaRemoveAccess().isEmpty()) {
					List<String> rmAccValue=Arrays.asList(tIdBoxTypeAccessEntity.getBtaRemoveAccess().split(","));
					if(!(rmAccValue.contains(shareInfoBean.getDataRefKey()+""))){
						tIdBoxTypeAccessEntity.setBtaRemoveAccess(tIdBoxTypeAccessEntity.getBtaRemoveAccess()+","+shareInfoBean.getDataRefKey());
					}
				} else {
					tIdBoxTypeAccessEntity.setBtaRemoveAccess(shareInfoBean.getDataRefKey()+"");
				}
			}
			tIdBoxTypeAccessJpaRepository.save(tIdBoxTypeAccessEntityList);
		}
	}
	
	public List<Long> boxTypeAccess(ShareInfoBean shareInfoBean,List<Long> dataRefKey,String menuType,String fieldType,List<Long> removeAccess) {
		if(shareInfoBean.getDataRefKey()==null) {
			if(fieldType==null) {
				tIdBoxTypeAccessJpaRepository.deleteBybtaMenuTypeAndBtaShareTypeAndBtaProfilePinKeyAndCreatedBy(menuType,shareInfoBean.getShareType(),shareInfoBean.getPinKey(), shareInfoBean.getCreatedBy()); 
			}else {
				tIdBoxTypeAccessJpaRepository.deleteBybtaMenuTypeAndBtaShareTypeAndFieldTypeAndBtaProfilePinKeyAndCreatedBy(menuType,shareInfoBean.getShareType(),fieldType,shareInfoBean.getPinKey(), shareInfoBean.getCreatedBy()); 
			}
			//Save the t_id_box_type_access object.
			TIdBoxTypeAccessEntity tIdBoxTypeAccessEntity = null;
			List<TIdBoxTypeAccessEntity> listOfTIdBoxTypeAccessEntity = new ArrayList<TIdBoxTypeAccessEntity>();
			List<String> sharePinkeys = new ArrayList<String>();
			if(!(shareInfoBean.getAccessInfo().isEmpty()) && shareInfoBean.getAccessInfo()!=null) {
				sharePinkeys = Arrays.asList(shareInfoBean.getAccessInfo().split(","));
				for(String sharePinKey : sharePinkeys ) {
					tIdBoxTypeAccessEntity = new TIdBoxTypeAccessEntity();
					tIdBoxTypeAccessEntity.setBtaMenuType(menuType);
					tIdBoxTypeAccessEntity.setBtaFiledType(fieldType);
					tIdBoxTypeAccessEntity.setBtaProfilePinKey(shareInfoBean.getPinKey());
					tIdBoxTypeAccessEntity.setBtaPinKey(Long.valueOf(sharePinKey));
					tIdBoxTypeAccessEntity.setBtaShareType(shareInfoBean.getShareType());
					tIdBoxTypeAccessEntity.setBtaAccessType(shareInfoBean.getAccessType());
					String removeKeys = removeAccess.stream().map(String::valueOf).collect(Collectors.joining(","));
					tIdBoxTypeAccessEntity.setBtaRemoveAccess(removeKeys);
					tIdBoxTypeAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
					tIdBoxTypeAccessEntity.setActiveStatus("A");
					tIdBoxTypeAccessEntity.setLockKey(0L);
					listOfTIdBoxTypeAccessEntity.add(tIdBoxTypeAccessEntity);
				}
			}
			tIdBoxTypeAccessJpaRepository.save(listOfTIdBoxTypeAccessEntity);	
			return null;
		}
		return getProfiles(shareInfoBean, fieldType, dataRefKey, menuType);
	}
	
	private void groupBoxAccess(ShareInfoBean shareInfoBean, String fieldType,List<Long> dataRefKey,String menuType) {
		if(shareInfoBean.getRecallGroupList().size()>0) {
	    	for(Long pinKey : shareInfoBean.getRecallGroupList()) {
	    		String removeAccessValue=null;
	    		if(fieldType==null) {
	    			 removeAccessValue =  tIdBoxTypeAccessJpaRepository.findByBtaMenuTypeAndBtaPinKeyAndBtaShareTypeAndBtaProfilePinKey(menuType,pinKey,shareInfoBean.getShareType(),shareInfoBean.getPinKey()); 
	    		}else {
	    			removeAccessValue =  tIdBoxTypeAccessJpaRepository.findByBtaMenuTypeAndBtaPinKeyAndBtaShareTypeAndBtaFiledTypeAndBtaProfilePinKey(menuType,pinKey,shareInfoBean.getShareType(),fieldType,shareInfoBean.getPinKey());  
	    		}
	    		if(removeAccessValue!=null) {
	    			List<String> rmAccValue=Arrays.asList(removeAccessValue.split(","));
	    			String dataValue = dataRefKey.get(0).toString();
	    			if(!(rmAccValue.contains(dataValue))){
	    				if(removeAccessValue.equals("")) {
	    					if(fieldType==null) {
	    						tIdBoxTypeAccessJpaRepository.updateBymenuTypeAndIdAndBtaProfilePinKey(menuType,pinKey,dataRefKey.get(0).toString(),shareInfoBean.getShareType(),shareInfoBean.getPinKey()); 
	    					}else {
	    						tIdBoxTypeAccessJpaRepository.updateBymenuTypeAndIdAndBtaProfilePinKey(menuType,pinKey,dataRefKey.get(0).toString(),shareInfoBean.getShareType(),fieldType,shareInfoBean.getPinKey()); 
	    					}
	    				}else {
	    					if(fieldType==null) {
	    						tIdBoxTypeAccessJpaRepository.updateBymenuTypeAndIdAndBtaProfilePinKey(menuType,pinKey,removeAccessValue+","+dataRefKey.get(0),shareInfoBean.getShareType(),shareInfoBean.getPinKey()); 
	    					}else {
	    						tIdBoxTypeAccessJpaRepository.updateBymenuTypeAndIdAndBtaProfilePinKey(menuType,pinKey,removeAccessValue+","+dataRefKey.get(0),shareInfoBean.getShareType(),fieldType,shareInfoBean.getPinKey()); 
	    					}
	    				}
	    			}
	    		}
	    	}
		}
	}
	
	private void nonGroupBoxAccess(ShareInfoBean shareInfoBean,String fieldType,List<Long> dataRefKey,String menuType) {
		if(shareInfoBean.getRecallOneToOneList().size()>0) {
			for(Long pinkey : shareInfoBean.getRecallOneToOneList()) {
				String removeAccessValue = null;
				if(fieldType==null) {
					removeAccessValue = tIdBoxTypeAccessJpaRepository.findByBtaMenuTypeAndBtaPinKeyAndBtaShareTypeAndBtaProfilePinKey(menuType,pinkey,shareInfoBean.getShareType(),shareInfoBean.getPinKey()); 
				}else {
					removeAccessValue = tIdBoxTypeAccessJpaRepository.findByBtaMenuTypeAndBtaPinKeyAndBtaShareTypeAndBtaFiledTypeAndBtaProfilePinKey(menuType,pinkey,shareInfoBean.getShareType(),fieldType,shareInfoBean.getPinKey()); 
				}
	    		if(removeAccessValue!=null) {
	    			List<String> listRmvAcsValue = Arrays.asList(removeAccessValue.split(","));
	    			String dataKey= Long.toString(dataRefKey.get(0));
	    			if(!(listRmvAcsValue.contains(dataKey))) {
	    				if(removeAccessValue.equals("")) {
	    					if(fieldType==null) {
	    						tIdBoxTypeAccessJpaRepository.updateBymenuTypeAndIdAndBtaProfilePinKey(menuType,pinkey,dataRefKey.get(0).toString(),shareInfoBean.getShareType(),shareInfoBean.getPinKey()); 
	    					}else {
	    						tIdBoxTypeAccessJpaRepository.updateBymenuTypeAndIdAndBtaProfilePinKey(menuType,pinkey,dataRefKey.get(0).toString(),shareInfoBean.getShareType(),fieldType,shareInfoBean.getPinKey()); 
	    					}
	    				} else {
	    					if(fieldType==null) {
	    						tIdBoxTypeAccessJpaRepository.updateBymenuTypeAndIdAndBtaProfilePinKey(menuType,pinkey,removeAccessValue+","+dataRefKey.get(0),shareInfoBean.getShareType(),shareInfoBean.getPinKey()); 
	    					}else {
	    						tIdBoxTypeAccessJpaRepository.updateBymenuTypeAndIdAndBtaProfilePinKey(menuType,pinkey,removeAccessValue+","+dataRefKey.get(0),shareInfoBean.getShareType(),fieldType,shareInfoBean.getPinKey()); 
	    					}
	    				}
	    			}
	    		}
			}
		}
	}
	
	private List<Long> getProfiles(ShareInfoBean shareInfoBean, String fieldType,List<Long> dataRefKey,String menuType) {
		List<Long> listofProfiles = new ArrayList<Long>();
		if(GROUP.equals(shareInfoBean.getShareType())) {
			groupBoxAccess(shareInfoBean, fieldType, dataRefKey,menuType);
		    if(shareInfoBean.getAccessInfo()!=null && !shareInfoBean.getAccessInfo().isEmpty()) {
		    	listofProfiles.addAll(Arrays.asList(shareInfoBean.getAccessInfo().replace("\"", "").split(",")).stream().map(s -> Long.valueOf(s.trim())).collect(Collectors.toList()));
		    }
		} else {
			nonGroupBoxAccess(shareInfoBean, fieldType, dataRefKey, menuType);
			if(shareInfoBean.getAccessInfo()!=null && !shareInfoBean.getAccessInfo().isEmpty()) {
				listofProfiles.addAll(Arrays.asList(shareInfoBean.getAccessInfo().replace("\"", "").split(",")).stream().map(s -> Long.valueOf(s.trim())).collect(Collectors.toList()));
			}
		}
		List<Long> listofProfiles2 = new ArrayList<Long>();
		for(Long pinkey : listofProfiles) {
			String removeAccessValue = null;
			if(fieldType==null) {
				removeAccessValue = tIdBoxTypeAccessJpaRepository.findByBtaMenuTypeAndBtaPinKeyAndBtaShareTypeAndBtaProfilePinKey(menuType, pinkey,shareInfoBean.getShareType(),shareInfoBean.getPinKey()); 
			}else {
				removeAccessValue = tIdBoxTypeAccessJpaRepository.findByBtaMenuTypeAndBtaPinKeyAndBtaShareTypeAndBtaFiledTypeAndBtaProfilePinKey(menuType, pinkey,shareInfoBean.getShareType(),fieldType,shareInfoBean.getPinKey()); 
			}
			if(removeAccessValue!=null) {
				List<String> listRmvAcsValue = Arrays.asList(removeAccessValue.split(",")); 
				/*List<Long> listRmvAcsValue = Arrays.asList(removeAccessValue.split(","))
                        .stream()
                        .map(String::trim)
                        .map(Long::parseLong)
                        .collect(Collectors.toList());;*/
				String dataRegKeyValue = Long.toString(dataRefKey.get(0));
				if(listRmvAcsValue.contains(dataRegKeyValue)){
					String rmvAccsvalue = (removeAccessValue.contains(dataRegKeyValue))?removeAccessValue.replace(dataRegKeyValue, ""):removeAccessValue.replace(dataRegKeyValue,""); 
					if(fieldType==null) {
						tIdBoxTypeAccessJpaRepository.updateBymenuTypeAndIdAndBtaProfilePinKey(menuType,pinkey,rmvAccsvalue,shareInfoBean.getShareType(),shareInfoBean.getPinKey()); 
					}else {
						tIdBoxTypeAccessJpaRepository.updateBymenuTypeAndIdAndBtaProfilePinKey(menuType,pinkey,rmvAccsvalue,shareInfoBean.getShareType(),fieldType,shareInfoBean.getPinKey()); 
					}
				}
			}
			listofProfiles2.add(pinkey);
		}
		return listofProfiles2;
	}
	
	private void fillSharedPinKeys(List<TIdBoxTypeAccessEntity> listOfTIdBoxTypeAccessEntityObj, ShareInfoBean shareInfoBean) {
		for(TIdBoxTypeAccessEntity obj : listOfTIdBoxTypeAccessEntityObj) {
			if(ONE_TO_ONE.equals(obj.getBtaShareType())) {
				if(shareInfoBean.isFullShare()) {
					shareInfoBean.getFullOneToOneList().add(obj.getBtaPinKey());
				}else if(shareInfoBean.isBoxShare()) {
					shareInfoBean.getBoxOneToOneList().add(obj.getBtaPinKey());
				}else {
					shareInfoBean.getOneToOneList().add(obj.getBtaPinKey());
				}
			}else {// if(GROUP.equals(obj.getBtaShareType())) {
				if(shareInfoBean.isFullShare()) {
					shareInfoBean.getFullGroupList().add(obj.getBtaPinKey());
				}else if(shareInfoBean.isBoxShare()) {
					shareInfoBean.getBoxGroupList().add(obj.getBtaPinKey());
				}else {
					shareInfoBean.getGroupList().add(obj.getBtaPinKey());
				}
			}
		}
	}
	
	public void checkBoxAccess(String menuType,ShareInfoBean shareInfoBean, String fieldType) {
		List<TIdBoxTypeAccessEntity> listOfTIdBoxTypeAccessEntityObj = tIdBoxTypeAccessJpaRepository.findByBtaMenuTypeAndFieldTypeAndBtaRemoveAccessAndBtaProfilePinKey(menuType, fieldType, shareInfoBean.getPinKey(),shareInfoBean.getPinKey()); 
		fillSharedPinKeys(listOfTIdBoxTypeAccessEntityObj, shareInfoBean);
	}
	
	public void checkBoxAccess(String menuType, ShareInfoBean shareInfoBean, Long key) {
		List<TIdBoxTypeAccessEntity> listOfTIdBoxTypeAccessEntity = tIdBoxTypeAccessJpaRepository.findByBtaMenuTypeAndBtaRemoveAccessAndBtaProfilePinKey(menuType, key,shareInfoBean.getPinKey()); 
		fillSharedPinKeys(listOfTIdBoxTypeAccessEntity, shareInfoBean);
	}
	
	public boolean hasBoxAccess(Long loginPinKey, Long propertyKey, Long propertyCreatedBy, Long contactPinKey, String menuType, String fieldType) {
		 Integer boxPropertyAccessGranted = tIdBoxTypeAccessJpaRepository.isPropertyInBoxAccessGiven(propertyKey, loginPinKey, menuType, contactPinKey,ONE_TO_ONE,propertyCreatedBy);
		 if(boxPropertyAccessGranted!=null && boxPropertyAccessGranted>0) {
			 return true;
		 }else {
			 boxPropertyAccessGranted = tIdBoxTypeAccessJpaRepository.isPropertyInBoxAccessGivenForGroup(propertyKey, loginPinKey, menuType, contactPinKey,GROUP,propertyCreatedBy);
			 if(boxPropertyAccessGranted!=null && boxPropertyAccessGranted>0) {
				 return true;
			 }
		 }
		return false;
	}
	
	public boolean hasBoxAccess(Long loginPinKey, Long propertyKey, Long contactPinKey, String menuType, String fieldType) {
		int count =0;
		if(fieldType!=null) {
			count = tIdBoxTypeAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE, contactPinKey, menuType, fieldType);
		}
		else {
			count = tIdBoxTypeAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE, contactPinKey, menuType);
		}
		 if(count>0) {
			 return true;
		 }else {
			 if(fieldType!=null) {
				 count = tIdBoxTypeAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP, contactPinKey, menuType, fieldType);
			 }
			 else {
				 count = tIdBoxTypeAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP, contactPinKey, menuType);
			 }
			 if(count>0) {
				 return true;
			 }							 
		 }
		 return false;
	}
}
