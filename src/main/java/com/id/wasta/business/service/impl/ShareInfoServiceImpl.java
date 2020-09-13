package com.id.wasta.business.service.impl;

import static com.id.wasta.util.action.CommonConstants.ADD_INFORMATION;
import static com.id.wasta.util.action.CommonConstants.ADD_POTENTIAL;
import static com.id.wasta.util.action.CommonConstants.ALL;
import static com.id.wasta.util.action.CommonConstants.AWARDS_RECOG;
import static com.id.wasta.util.action.CommonConstants.BUSINESS_POTENTIAL;
import static com.id.wasta.util.action.CommonConstants.DISCUSSION_DETAILS;
import static com.id.wasta.util.action.CommonConstants.EDUCATION;
import static com.id.wasta.util.action.CommonConstants.EXPERIENCE;
import static com.id.wasta.util.action.CommonConstants.GROUP;
import static com.id.wasta.util.action.CommonConstants.HEADER_INFO;
import static com.id.wasta.util.action.CommonConstants.HEADER_LIST;
import static com.id.wasta.util.action.CommonConstants.LANDLINE_NUMBER;
import static com.id.wasta.util.action.CommonConstants.MENU_TYPE_LIST;
import static com.id.wasta.util.action.CommonConstants.MOBILE_NUMBER;
import static com.id.wasta.util.action.CommonConstants.NONE;
import static com.id.wasta.util.action.CommonConstants.ONE_TO_ONE;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_INFO;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_INFO_TYPE_LIST;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_INTEREST;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_PRIORITIES;
import static com.id.wasta.util.action.CommonConstants.PERSONAL_RELATIONSHIP;
import static com.id.wasta.util.action.CommonConstants.PHONE_NO;
import static com.id.wasta.util.action.CommonConstants.PROFESSIONAL_INTEREST;
import static com.id.wasta.util.action.CommonConstants.PROFESSIONAL_RELATIONSHIP;
import static com.id.wasta.util.action.CommonConstants.PROF_EXPERTISE;
import static com.id.wasta.util.action.CommonConstants.PROJ_EXECUTED;
import static com.id.wasta.util.action.CommonConstants.RECREATION;
import static com.id.wasta.util.action.CommonConstants.VIEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.id.util.bean.common.SelectListBean;
import com.id.wasta.bean.CustRelShipBean;
import com.id.wasta.bean.RelationShipInfoBean;
import com.id.wasta.bean.ShareInfoBean;
import com.id.wasta.bean.TIdLandingNotification;
import com.id.wasta.bean.jpa.PersonIndividualExperienceViewEntity;
import com.id.wasta.bean.jpa.TIdAddPotentialServicesAccessEntity;
import com.id.wasta.bean.jpa.TIdAdditionalInformationAccessEntity;
import com.id.wasta.bean.jpa.TIdAwardsInformationAccessEntity;
import com.id.wasta.bean.jpa.TIdBoxTypeAccessEntity;
import com.id.wasta.bean.jpa.TIdBusinessPotentialInfoAccessEntity;
import com.id.wasta.bean.jpa.TIdCompanyContactLinkViewEntity;
import com.id.wasta.bean.jpa.TIdEducationalInformationAccessEntity;
import com.id.wasta.bean.jpa.TIdExperienceInformationAccessEntity;
import com.id.wasta.bean.jpa.TIdGroupLinkEntity;
import com.id.wasta.bean.jpa.TIdLandingNotificationEntity;
import com.id.wasta.bean.jpa.TIdPersonalInfoAccessEntity;
import com.id.wasta.bean.jpa.TIdPersonalInformationViewEntity;
import com.id.wasta.bean.jpa.TIdPersonalInterestsAccessEntity;
import com.id.wasta.bean.jpa.TIdPersonalPrioritiesAccessEntity;
import com.id.wasta.bean.jpa.TIdProfessionalExpertiseAccessEntity;
import com.id.wasta.bean.jpa.TIdProfessionalInterestsAccessEntity;
import com.id.wasta.bean.jpa.TIdProfileAddressDetailsViewEntity;
import com.id.wasta.bean.jpa.TIdProjectsInformationAccessEntity;
import com.id.wasta.bean.jpa.TIdRecreationInfoAccessEntity;
import com.id.wasta.bean.jpa.TIdRelationshipInfoAccessEntity;
import com.id.wasta.bean.jpa.TIdRelationshipInfoLinkViewEntity;
import com.id.wasta.bean.jpa.TIdVisitInformationAccessEntity;
import com.id.wasta.business.service.ShareInfoService;
import com.id.wasta.data.repository.jpa.PersonIndividualExperienceViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAddPotentialServicesAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAddPotentialServicesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAddPotentialServicesViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAdditionalInformationAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAdditionalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAwardsInformationAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdAwardsInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBoxTypeAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBusinessPotentialInfoAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBusinessPotentialInfoJpaRepository;
import com.id.wasta.data.repository.jpa.TIdBusinessPotentialInfoViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyContactLinkViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCompanyIndustryLinkViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInformationAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEducationalInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdExperienceInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdGroupHeaderJpaRepository;
import com.id.wasta.data.repository.jpa.TIdGroupLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingNotificationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLandingRecreationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInfoAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInterestsAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInterestsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInterestsViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalPrioritiesAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalPrioritiesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalExpertiseAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalExpertiseJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalExpertiseViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalInterestsAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalInterestsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfessionalInterestsViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfileAddressDetailsViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProjectsInformationAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProjectsInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRecreationInfoAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRecreationInfoJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRecreationInfoViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdReferenceCodesDetailJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInfoAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInfoLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdRelationshipInfoLinkViewJpaRepository;
import com.id.wasta.data.repository.jpa.TIdVisitInformationAccessJpaRepository;
import com.id.wasta.data.repository.jpa.TIdVisitInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdVisitInformationViewJpaRepository;
import com.id.wasta.util.action.CommonConstants;
import com.id.wasta.util.action.StringUtil;

@Service
@Transactional
public class ShareInfoServiceImpl implements ShareInfoService {

	@Resource
	private TIdPersonalInformationJpaRepository tIdPersonalInformationJpaRepository;
	@Resource
	private TIdVisitInformationJpaRepository tIdVisitInformationJpaRepository;
	@Resource
	private TIdVisitInformationAccessJpaRepository tIdVisitInformationAccessJpaRepository;
	@Resource
	private TIdVisitInformationViewJpaRepository tIdVisitInformationViewJpaRepository;
	@Resource
	private TIdBusinessPotentialInfoJpaRepository tIdBusinessPotentialInfoJpaRepository;
	@Resource
	private TIdBusinessPotentialInfoViewJpaRepository tIdBusinessPotentialInfoViewJpaRepository;
	@Resource
	private TIdCompanyContactLinkViewJpaRepository tIdCompanyContactLinkViewJpaRepository;
	@Resource
	private TIdRelationshipInfoLinkViewJpaRepository tIdRelationshipInfoLinkViewJpaRepository;
	@Resource
	private TIdBusinessPotentialInfoAccessJpaRepository tIdBusinessPotentialInfoAccessJpaRepository;
	@Resource
	private TIdAddPotentialServicesJpaRepository tIdAddPotentialServicesJpaRepository;
	@Resource
	private TIdAddPotentialServicesViewJpaRepository tIdAddPotentialServicesViewJpaRepository;
	@Resource
	private TIdAddPotentialServicesAccessJpaRepository tIdAddPotentialServicesAccessJpaRepository;
	@Resource
	private TIdReferenceCodesDetailJpaRepository tIdReferenceCodesDetailJpaRepository;
	@Resource
	private TIdRecreationInfoJpaRepository tIdRecreationInfoJpaRepository;
	@Resource
	private TIdRecreationInfoViewJpaRepository tIdRecreationInfoViewJpaRepository;
	@Resource
	private TIdRecreationInfoAccessJpaRepository tIdRecreationInfoAccessJpaRepository;
	@Resource
	private TIdPersonalInterestsJpaRepository tIdPersonalInterestsJpaRepository;
	@Resource
	private TIdPersonalInterestsViewJpaRepository tIdPersonalInterestsViewJpaRepository;
	@Resource
	private TIdPersonalInterestsAccessJpaRepository tIdPersonalInterestsAccessJpaRepository;
	@Resource
	private TIdProfessionalInterestsJpaRepository tIdProfessionalInterestsJpaRepository;
	@Resource
	private TIdProfessionalInterestsViewJpaRepository tIdProfessionalInterestsViewJpaRepository;
	@Resource
	private TIdProfessionalInterestsAccessJpaRepository tIdProfessionalInterestsAccessJpaRepository;
	@Resource
	private TIdPersonalPrioritiesJpaRepository tIdPersonalPrioritiesJpaRepository;
	@Resource
	private TIdPersonalPrioritiesAccessJpaRepository tIdPersonalPrioritiesAccessJpaRepository;
	@Resource
	private TIdExperienceInformationJpaRepository tIdExperienceInformationJpaRepository;
	@Resource
	private TIdExperienceInformationViewJpaRepository tIdExperienceInformationViewJpaRepository;
	@Resource
	private TIdExperienceInformationAccessJpaRepository tIdExperienceInformationAccessJpaRepository;
	@Resource
	private TIdEducationalInformationJpaRepository tIdEducationalInformationJpaRepository;
	@Resource
	private TIdEducationalInformationViewJpaRepository tIdEducationalInformationViewJpaRepository;
	@Resource
	private TIdEducationalInformationAccessJpaRepository tIdEducationalInformationAccessJpaRepository;
	@Resource
	private TIdProjectsInformationJpaRepository tIdProjectsInformationJpaRepository;
	@Resource
	private TIdProjectsInformationAccessJpaRepository tIdProjectsInformationAccessJpaRepository;
	@Resource
	private TIdProfessionalExpertiseJpaRepository tIdProfessionalExpertiseJpaRepository;
	@Resource
	private TIdProfessionalExpertiseViewJpaRepository tIdProfessionalExpertiseViewJpaRepository;
	@Resource
	private TIdProfessionalExpertiseAccessJpaRepository tIdProfessionalExpertiseAccessJpaRepository;
	@Resource
	private TIdAwardsInformationJpaRepository tIdAwardsInformationJpaRepository;
	@Resource
	private TIdAwardsInformationAccessJpaRepository tIdAwardsInformationAccessJpaRepository;  
	@Resource
	private TIdAdditionalInformationJpaRepository tIdAdditionalInformationJpaRepository;
	@Resource
	private TIdAdditionalInformationAccessJpaRepository tIdAdditionalInformationAccessJpaRepository;
	@Resource
	private TIdGroupHeaderJpaRepository tIdGroupHeaderJpaRepository;
	@Resource
	private PersonIndividualExperienceViewJpaRepository personIndividualExperienceViewJpaRepository;
	@Resource
	private TIdLandingRecreationJpaRepository tIdLandingRecreationJpaRepository;
	@Resource
	private TIdLandingNotificationJpaRepository tIdLandingNotificationJpaRepository;
	@Resource
	private TIdCompanyIndustryLinkViewJpaRepository tIdCompanyIndustryLinkViewJpaRepository;
	@Resource
	private TIdGroupLinkJpaRepository tIdGroupLinkJpaRepository;
	@Resource
	private TIdRelationshipInfoAccessJpaRepository tIdRelationshipInfoAccessJpaRepository;
	@Resource
	private TIdPersonalInfoAccessJpaRepository tIdPersonalInfoAccessJpaRepository;
	@Resource
	private TIdRelationshipInfoLinkJpaRepository tIdRelationshipInfoLinkJpaRepository;
	@Resource
	private TIdPersonalInformationViewJpaRepository tIdPersonalInformationViewJpaRepository;
	@Resource
	private TIdProfileAddressDetailsViewJpaRepository tIdProfileAddressDetailsViewJpaRepository;
	
	@Autowired
	private BoxTypeAccessService boxTypeAccessService;
	
	@Autowired
	private TIdBoxTypeAccessJpaRepository tIdBoxTypeAccessJpaRepository;
	
	private static final Logger logger=Logger.getLogger(ShareInfoService.class);

	@Override
	public String saveShareInfoDtls(ShareInfoBean shareInfoBean) {
		List<Long> dataRefKey = new ArrayList<Long>();
		if(shareInfoBean.getDataRefKey()!=null) {
			dataRefKey.add(shareInfoBean.getDataRefKey());
		}
		
		if(PHONE_NO.equals(shareInfoBean.getMenuType())) {
			saveShareInfoWizard(dataRefKey, HEADER_INFO, LANDLINE_NUMBER, shareInfoBean);
			saveShareInfoWizard(dataRefKey, HEADER_INFO, MOBILE_NUMBER, shareInfoBean);
			
		} else if(!ALL.equals(shareInfoBean.getMenuType())) {
			saveShareInfoWizard(dataRefKey, shareInfoBean.getMenuType(),shareInfoBean.getFieldType(), shareInfoBean);
		
		} else {
			for(String menuType : MENU_TYPE_LIST) {
				saveShareInfoWizard(dataRefKey, menuType, shareInfoBean.getFieldType(), shareInfoBean);
			}
			for(String fieldType: HEADER_LIST) {
				saveShareInfoWizard(dataRefKey, HEADER_INFO, fieldType, shareInfoBean);
			}
			
			if(GROUP.equals(shareInfoBean.getShareType())) {
				if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
					List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
					List<Long> listOfGroupProfiles = new ArrayList<Long>();
					listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
					tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, "Complete Profile", "ALL", shareInfoBean.getPinKey());
				}
			} else {
				if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
					tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), "Complete Profile", "ALL", shareInfoBean.getPinKey());
				}
			}

			if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !NONE.equals(shareInfoBean.getShareType())) {
				List<TIdCompanyContactLinkViewEntity> tIdCompanyContactLinkViewEntityList = tIdCompanyContactLinkViewJpaRepository.findByCclPinKey(shareInfoBean.getPinKey());
				List<CustRelShipBean> custRelShipBeanList = new ArrayList<CustRelShipBean>();
				CustRelShipBean custRelShipBean = null;
				for(TIdCompanyContactLinkViewEntity tIdCompanyContactLinkViewEntity : tIdCompanyContactLinkViewEntityList){
					custRelShipBean = new CustRelShipBean();
					custRelShipBean.setGroupCmKey(tIdCompanyContactLinkViewEntity.getCclCompanyKey());
					custRelShipBean.setGroupCmName(tIdCompanyContactLinkViewEntity.getCclCompanyName());
					custRelShipBean.setCorpRelationKey(tIdCompanyContactLinkViewEntity.getCclCompanyRelation());
					custRelShipBean.setCorpRelationName(tIdCompanyContactLinkViewEntity.getCclCompanyRelationValue());
					custRelShipBeanList.add(custRelShipBean);
				}
				List<TIdRelationshipInfoLinkViewEntity> tIdRelationshipInfoLinkViewEntityList = tIdRelationshipInfoLinkViewJpaRepository.findByPrlkToPinKey(shareInfoBean.getPinKey());
				List<RelationShipInfoBean> relationShipInfoBeanList = new ArrayList<RelationShipInfoBean>();
				RelationShipInfoBean relationShipInfoBean = null;
				for(TIdRelationshipInfoLinkViewEntity tIdRelationshipInfoLinkViewEntity : tIdRelationshipInfoLinkViewEntityList) {
					if(tIdRelationshipInfoLinkViewEntity.getPrlkContact()==0) {
						relationShipInfoBean = new RelationShipInfoBean();
						relationShipInfoBean.setRelShip(tIdRelationshipInfoLinkViewEntity.getPrlkRelationship());
						relationShipInfoBean.setRelShipFirstName(tIdRelationshipInfoLinkViewEntity.getPinFirstName());
						relationShipInfoBean.setRelShipPinKey(tIdRelationshipInfoLinkViewEntity.getPrlkFromPinKey());
						relationShipInfoBean.setRelShipProfileKey(tIdRelationshipInfoLinkViewEntity.getProfileKey());
						relationShipInfoBeanList.add(relationShipInfoBean);
					} else {
						custRelShipBean = new CustRelShipBean();
						custRelShipBean.setGroupCmKey(tIdRelationshipInfoLinkViewEntity.getPrlkFromPinKey());
						custRelShipBean.setGroupCmName(tIdRelationshipInfoLinkViewEntity.getPinFirstName()+" " +tIdRelationshipInfoLinkViewEntity.getPinLirstName());
						custRelShipBean.setCorpRelationKey(tIdRelationshipInfoLinkViewEntity.getPrlkRelationshipKey());
						custRelShipBean.setCorpRelationName(tIdRelationshipInfoLinkViewEntity.getPrlkRelationship());
						custRelShipBean.setUserPinKey(tIdRelationshipInfoLinkViewEntity.getPrlkFromPinKey());
						custRelShipBeanList.add(custRelShipBean);
					}
				}
				String latestUpdate = "";
				if(custRelShipBeanList.size()>0) {
					latestUpdate=custRelShipBeanList.get(0).getCorpRelationName()+" of "+custRelShipBeanList.get(0).getGroupCmName();
				} else if(relationShipInfoBeanList.size()>0) {
					latestUpdate=relationShipInfoBeanList.get(0).getRelShip()+" of "+relationShipInfoBeanList.get(0).getRelShipFirstName();
				}
				
				saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
							shareInfoBean.getShareType(), "Complete Profile", shareInfoBean.getPinKey(), ALL, latestUpdate);
			}
		}
		return "Success";
	}
	
	public void saveShareInfoWizard(List<Long> dataRefKey, String menuType, String fieldType, ShareInfoBean shareInfoBean) { 
		List<String> filedTypeList = new ArrayList<String>(); 
		List<Long> removeKeys = new ArrayList<>();
		switch(menuType) {
		
		case HEADER_INFO:
			if(shareInfoBean.isAdmin()){
				tIdPersonalInfoAccessJpaRepository.deleteByPiaPinKeyAndPiaFieldType(shareInfoBean.getPinKey(),fieldType);
			}
			
			if(NONE.equals(shareInfoBean.getShareType())) {
				tIdPersonalInfoAccessJpaRepository.deleteByPiaPinKeyAndPiaFieldTypeAndCreatedBy(shareInfoBean.getPinKey(),fieldType,shareInfoBean.getCreatedBy());
			} else {
				
				String latestUpdate = "";
				TIdPersonalInformationViewEntity tIdPersonalInformationViewEntity = tIdPersonalInformationViewJpaRepository.findOne(shareInfoBean.getPinKey());
				
				if(fieldType.equals(CommonConstants.EMAIL_ID)) {
					latestUpdate = tIdPersonalInformationViewEntity.getPinEmail()!=null?tIdPersonalInformationViewEntity.getPinEmail():"";
					
				} else if(fieldType.equals(CommonConstants.LANDLINE_NUMBER)) {
					latestUpdate = tIdPersonalInformationViewEntity.getLandLine()!=null?tIdPersonalInformationViewEntity.getLandLine():"";
					
				} else if(fieldType.equals(CommonConstants.MOBILE_NUMBER)) {
					latestUpdate = tIdPersonalInformationViewEntity.getMobile()!=null?tIdPersonalInformationViewEntity.getMobile():"";
					
				}

				if(!StringUtil.isBlank(latestUpdate)) {
					TIdPersonalInfoAccessEntity tIdPersonalInfoAccessEntity = 
							tIdPersonalInfoAccessJpaRepository.findByPiaPinKeyAndPiaFieldTypeAndCreatedByAndPiaShareType(shareInfoBean.getPinKey(),
									fieldType,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
					if(tIdPersonalInfoAccessEntity==null && !shareInfoBean.isRecall()) {
						tIdPersonalInfoAccessEntity = new TIdPersonalInfoAccessEntity();
						tIdPersonalInfoAccessEntity.setPiaPinKey(shareInfoBean.getPinKey());
						tIdPersonalInfoAccessEntity.setPiaFieldType(fieldType);
						tIdPersonalInfoAccessEntity.setPiaShareType(shareInfoBean.getShareType());
						tIdPersonalInfoAccessEntity.setPiaAccessType(shareInfoBean.getAccessType());
						tIdPersonalInfoAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
						tIdPersonalInfoAccessEntity.setActiveStatus("A");
						tIdPersonalInfoAccessEntity.setLockKey(1L);
					}
					if(tIdPersonalInfoAccessEntity!=null) {
						if(shareInfoBean.isApprove() && tIdPersonalInfoAccessEntity.getPiaAccessInfo()!=null) {
							tIdPersonalInfoAccessEntity.setPiaAccessInfo(tIdPersonalInfoAccessEntity.getPiaAccessInfo()+","+shareInfoBean.getAccessInfo());
						}else {
							tIdPersonalInfoAccessEntity.setPiaAccessInfo(shareInfoBean.getAccessInfo());
						}
						tIdPersonalInfoAccessJpaRepository.save(tIdPersonalInfoAccessEntity);
					}
					if(GROUP.equals(shareInfoBean.getShareType())) {
						if(shareInfoBean.getRecallGroupList().size()>0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, fieldType, shareInfoBean.getPinKey());
						}
					} else {
						if(shareInfoBean.getRecallOneToOneList().size()>0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, fieldType, shareInfoBean.getPinKey());
						}
					}
					if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
							saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
									shareInfoBean.getShareType(), menuType, shareInfoBean.getPinKey(), fieldType, latestUpdate);
					}
				}
			}
			break;
			
		case PERSONAL_INFO:
			if("".equals(fieldType)) {
				filedTypeList.addAll(PERSONAL_INFO_TYPE_LIST);
			} else {
				filedTypeList.add(fieldType);
			}
			
			for(String fieldTypeInfo : filedTypeList) {
				
				if(shareInfoBean.isAdmin()){
					tIdPersonalInfoAccessJpaRepository.deleteByPiaPinKeyAndPiaFieldType(shareInfoBean.getPinKey(),fieldTypeInfo);
				}
				
				if(NONE.equals(shareInfoBean.getShareType())) {
					 tIdPersonalInfoAccessJpaRepository.deleteByPiaPinKeyAndPiaFieldTypeAndCreatedBy(shareInfoBean.getPinKey(),fieldTypeInfo,shareInfoBean.getCreatedBy());
	                    if(shareInfoBean.getDataRefKey()==null) {
	                        tIdBoxTypeAccessJpaRepository.deleteBybtaMenuTypeAndFieldTypeAndBtaProfilePinKeyAndCreatedBy(menuType,fieldTypeInfo, shareInfoBean.getPinKey(),shareInfoBean.getCreatedBy());
	                    } else {
	                        List<TIdBoxTypeAccessEntity> tIdBoxTypeAccessEntityList =  tIdBoxTypeAccessJpaRepository.findByBtaMenuTypeAndFieldTypeAndBtaProfilePinKeyAndCreatedBy(menuType,fieldTypeInfo,shareInfoBean.getPinKey(),shareInfoBean.getCreatedBy()); 
	                        
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
					boxTypeAccessService.saveBoxTypeAccess(menuType, fieldTypeInfo, shareInfoBean);
				} else {
					
					String latestUpdate = "";
					List<TIdProfileAddressDetailsViewEntity> tIdProfileAddressDetailsViewEntityList = null;
					TIdPersonalInformationViewEntity tIdPersonalInformationViewEntity = null;
					
					if(fieldTypeInfo.equals(CommonConstants.HOME_ADDRESS)) {
						tIdProfileAddressDetailsViewEntityList = tIdProfileAddressDetailsViewJpaRepository
								.findByPadPinKeyAndAddressTypeAbbreviation(shareInfoBean.getPinKey(), fieldTypeInfo);
						if(tIdProfileAddressDetailsViewEntityList.size()>0) {
							latestUpdate = tIdProfileAddressDetailsViewEntityList.get(0).getPadAddressLine1()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getPadAddressLine2()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getCityName()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getStateName()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getCountryName()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getPadPinzip();
						}
					} else if(fieldTypeInfo.equals(CommonConstants.OFFICE_ADDRESS)) {
						tIdProfileAddressDetailsViewEntityList = tIdProfileAddressDetailsViewJpaRepository
								.findByPadPinKeyAndAddressTypeAbbreviation(shareInfoBean.getPinKey(), fieldTypeInfo);
						if(tIdProfileAddressDetailsViewEntityList.size()>0) {
							latestUpdate = tIdProfileAddressDetailsViewEntityList.get(0).getPadAddressLine1()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getPadAddressLine2()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getCityName()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getStateName()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getCountryName()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getPadPinzip();
						}
					} else if(fieldTypeInfo.equals(CommonConstants.HOMETOWN_ADDRESS)) {
						tIdProfileAddressDetailsViewEntityList = tIdProfileAddressDetailsViewJpaRepository
								.findByPadPinKeyAndAddressTypeAbbreviation(shareInfoBean.getPinKey(), fieldTypeInfo);
						if(tIdProfileAddressDetailsViewEntityList.size()>0) {
							latestUpdate = tIdProfileAddressDetailsViewEntityList.get(0).getPadAddressLine1()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getPadAddressLine2()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getCityName()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getStateName()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getCountryName()+" "+
									tIdProfileAddressDetailsViewEntityList.get(0).getPadPinzip();
						}
					} else if(fieldTypeInfo.equals(CommonConstants.GENDER)) {
						tIdPersonalInformationViewEntity = new TIdPersonalInformationViewEntity();
						tIdPersonalInformationViewEntity = tIdPersonalInformationViewJpaRepository.findOne(shareInfoBean.getPinKey());
						latestUpdate = tIdPersonalInformationViewEntity.getPinGender()!=null?tIdPersonalInformationViewEntity.getPinGender():"";
						
					} else if(fieldTypeInfo.equals(CommonConstants.NATIONALITY)) {
						tIdPersonalInformationViewEntity = new TIdPersonalInformationViewEntity();
						tIdPersonalInformationViewEntity = tIdPersonalInformationViewJpaRepository.findOne(shareInfoBean.getPinKey());
						latestUpdate = tIdPersonalInformationViewEntity.getNationality()!=null?tIdPersonalInformationViewEntity.getNationality():"";
						
					} else if(fieldTypeInfo.equals(CommonConstants.DOB)) {
						tIdPersonalInformationViewEntity = new TIdPersonalInformationViewEntity();
						tIdPersonalInformationViewEntity = tIdPersonalInformationViewJpaRepository.findOne(shareInfoBean.getPinKey());
						String templatestUpdate = tIdPersonalInformationViewEntity.getPinDob()!=null?tIdPersonalInformationViewEntity.getPinDob().toString():"";
						if(templatestUpdate!=null) {
							if(templatestUpdate.length()>9) {
								latestUpdate = templatestUpdate.substring(0,10);
							}
						}
						
					} else if(fieldTypeInfo.equals(CommonConstants.DOA)) {
						tIdPersonalInformationViewEntity = new TIdPersonalInformationViewEntity();
						tIdPersonalInformationViewEntity = tIdPersonalInformationViewJpaRepository.findOne(shareInfoBean.getPinKey());
						String templatestUpdate = tIdPersonalInformationViewEntity.getPinDoa()!=null?tIdPersonalInformationViewEntity.getPinDoa().toString():"";
						if(templatestUpdate!=null) {
							if(templatestUpdate.length()>9) {
								latestUpdate = templatestUpdate.substring(0,10);
							}
						}
					}
					
					if(shareInfoBean.getDataRefKey()==null) {
						 boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,fieldTypeInfo, removeKeys);
					} else {
						List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,fieldTypeInfo,removeKeys);
						if(listofProfiles2!=null && listofProfiles2.size()>0) {
							shareInfoBean.setAccessInfo(listofProfiles2.stream().map(String::valueOf).collect(Collectors.joining(",")));
//							shareInfoBean.setAccessInfo(listofProfiles2.toString().replace("[","").replace("]", ""));
							
							if(!StringUtil.isBlank(latestUpdate)) {
								TIdPersonalInfoAccessEntity tIdPersonalInfoAccessEntity = 
										tIdPersonalInfoAccessJpaRepository.findByPiaPinKeyAndPiaFieldTypeAndCreatedByAndPiaShareType(shareInfoBean.getPinKey(),
												fieldTypeInfo,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
								if(tIdPersonalInfoAccessEntity==null) {
									tIdPersonalInfoAccessEntity = new TIdPersonalInfoAccessEntity();
									tIdPersonalInfoAccessEntity.setPiaPinKey(shareInfoBean.getPinKey());
									tIdPersonalInfoAccessEntity.setPiaFieldType(fieldTypeInfo);
									tIdPersonalInfoAccessEntity.setPiaShareType(shareInfoBean.getShareType());
									tIdPersonalInfoAccessEntity.setPiaAccessType(shareInfoBean.getAccessType());
									tIdPersonalInfoAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
									tIdPersonalInfoAccessEntity.setActiveStatus("A");
									tIdPersonalInfoAccessEntity.setLockKey(1L);
								}
								if(shareInfoBean.isApprove() && tIdPersonalInfoAccessEntity.getPiaAccessInfo()!=null) {
									tIdPersonalInfoAccessEntity.setPiaAccessInfo(tIdPersonalInfoAccessEntity.getPiaAccessInfo()+","+shareInfoBean.getAccessInfo());
								} else {
									tIdPersonalInfoAccessEntity.setPiaAccessInfo(shareInfoBean.getAccessInfo());
								}
								tIdPersonalInfoAccessJpaRepository.save(tIdPersonalInfoAccessEntity);
								
							}
						}
					}
					if(GROUP.equals(shareInfoBean.getShareType())) {
						if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, fieldTypeInfo, shareInfoBean.getPinKey());
						}
					} else {
						if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, fieldTypeInfo, shareInfoBean.getPinKey());
						}
					}
					if(!StringUtil.isBlank(latestUpdate)) {
						if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
							saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
									shareInfoBean.getShareType(), menuType, shareInfoBean.getPinKey(), fieldTypeInfo, latestUpdate);
						}
					}
				}
			}
			break;
			
		case PERSONAL_RELATIONSHIP:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdRelationshipInfoLinkJpaRepository.findPrlkFromPinKeyAndRelationType(shareInfoBean.getPinKey(),"Personal"));
			}
			if(shareInfoBean.isAdmin()){
					tIdRelationshipInfoAccessJpaRepository.deleteByRiaPrlkKeyIn(dataRefKey);
			}			
			if(NONE.equals(shareInfoBean.getShareType())) {
				tIdRelationshipInfoAccessJpaRepository.deleteByRiaPrlkKeyInAndCreatedBy(dataRefKey, shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			} else {
				if(shareInfoBean.getDataRefKey()==null) {
					 boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if(listofProfiles2!=null && listofProfiles2.size()>0) {
						shareInfoBean.setAccessInfo(listofProfiles2.stream().map(String::valueOf).collect(Collectors.joining(",")));
//						shareInfoBean.setAccessInfo(listofProfiles2.toString().replace("[","").replace("]", ""));
						TIdRelationshipInfoAccessEntity tIdRelationshipInfoAccessEntity = null;
						List<TIdRelationshipInfoAccessEntity> tIdRelationshipInfoAccessEntityList = new ArrayList<TIdRelationshipInfoAccessEntity>(); 
						for(Long key : dataRefKey) {
							tIdRelationshipInfoAccessEntity = tIdRelationshipInfoAccessJpaRepository.
									findByRiaPrlkKeyAndCreatedByAndRiaShareType(key,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
							if(tIdRelationshipInfoAccessEntity==null) {
								tIdRelationshipInfoAccessEntity = new TIdRelationshipInfoAccessEntity();
								tIdRelationshipInfoAccessEntity.setRiaPrlkKey(key);					
								tIdRelationshipInfoAccessEntity.setRiaRelationType(menuType);
								fieldType = tIdRelationshipInfoLinkJpaRepository.findPrlkRelationship(key);
								tIdRelationshipInfoAccessEntity.setRiaRelationship(fieldType);
								tIdRelationshipInfoAccessEntity.setRiaShareType(shareInfoBean.getShareType());
								tIdRelationshipInfoAccessEntity.setRiaAccessType(shareInfoBean.getAccessType());
								tIdRelationshipInfoAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								tIdRelationshipInfoAccessEntity.setActiveStatus("A");
								tIdRelationshipInfoAccessEntity.setLockKey(1L);					
							}
							if(shareInfoBean.isApprove() && tIdRelationshipInfoAccessEntity.getRiaAccessInfo()!=null) {
								tIdRelationshipInfoAccessEntity.setRiaAccessInfo(tIdRelationshipInfoAccessEntity.getRiaAccessInfo()+","+shareInfoBean.getAccessInfo());
							} else {
								tIdRelationshipInfoAccessEntity.setRiaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdRelationshipInfoAccessEntityList.add(tIdRelationshipInfoAccessEntity);
							
						}
						tIdRelationshipInfoAccessJpaRepository.save(tIdRelationshipInfoAccessEntityList);
					}
				}
				for(Long key : dataRefKey) {
					if(GROUP.equals(shareInfoBean.getShareType())) {
						if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, "Personal", key);
						}
					} else {
						if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, "Personal", key);
						}
					}
					if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
								shareInfoBean.getShareType(), menuType, key, "Personal", tIdRelationshipInfoLinkJpaRepository.findPrlkRelationship(key));
					}
				}
			}
			break;
		
		case PROFESSIONAL_RELATIONSHIP:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdRelationshipInfoLinkJpaRepository.findPrlkFromPinKeyAndRelationType(shareInfoBean.getPinKey(),"Professional"));
			}
			if(shareInfoBean.isAdmin()){
					tIdRelationshipInfoAccessJpaRepository.deleteByRiaPrlkKeyIn(dataRefKey);
			}			
			if(NONE.equals(shareInfoBean.getShareType())) {
				tIdRelationshipInfoAccessJpaRepository.deleteByRiaPrlkKeyInAndCreatedBy(dataRefKey, shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			} else {
				if(shareInfoBean.getDataRefKey()==null) {
					 boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if(listofProfiles2!=null && listofProfiles2.size()>0) {
						shareInfoBean.setAccessInfo(listofProfiles2.stream().map(String::valueOf).collect(Collectors.joining(",")));
//						shareInfoBean.setAccessInfo(listofProfiles2.toString().replace("[","").replace("]", ""));
						TIdRelationshipInfoAccessEntity tIdRelationshipInfoAccessEntity = null;
						List<TIdRelationshipInfoAccessEntity> tIdRelationshipInfoAccessEntityList = new ArrayList<TIdRelationshipInfoAccessEntity>(); 
						for(Long key : dataRefKey) {
							tIdRelationshipInfoAccessEntity = tIdRelationshipInfoAccessJpaRepository.
									findByRiaPrlkKeyAndCreatedByAndRiaShareType(key,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
							if(tIdRelationshipInfoAccessEntity==null) {
								tIdRelationshipInfoAccessEntity = new TIdRelationshipInfoAccessEntity();
								tIdRelationshipInfoAccessEntity.setRiaPrlkKey(key);					
								tIdRelationshipInfoAccessEntity.setRiaRelationType(menuType);
								fieldType = tIdRelationshipInfoLinkJpaRepository.findPrlkRelationship(key);
								tIdRelationshipInfoAccessEntity.setRiaRelationship(fieldType);
								tIdRelationshipInfoAccessEntity.setRiaShareType(shareInfoBean.getShareType());
								tIdRelationshipInfoAccessEntity.setRiaAccessType(shareInfoBean.getAccessType());
								tIdRelationshipInfoAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								tIdRelationshipInfoAccessEntity.setActiveStatus("A");
								tIdRelationshipInfoAccessEntity.setLockKey(1L);					
							}
							if(shareInfoBean.isApprove() && tIdRelationshipInfoAccessEntity.getRiaAccessInfo()!=null) {
								tIdRelationshipInfoAccessEntity.setRiaAccessInfo(tIdRelationshipInfoAccessEntity.getRiaAccessInfo()+","+shareInfoBean.getAccessInfo());
							} else {
								tIdRelationshipInfoAccessEntity.setRiaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdRelationshipInfoAccessEntityList.add(tIdRelationshipInfoAccessEntity);
							
						}
						tIdRelationshipInfoAccessJpaRepository.save(tIdRelationshipInfoAccessEntityList);
					}
				}
				for(Long key : dataRefKey) {
					if(GROUP.equals(shareInfoBean.getShareType())) {
						if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, "Professional", key);
						}
					} else {
						if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, "Professional", key);
						}
					}
					if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
								shareInfoBean.getShareType(), menuType, key, "Professional", tIdRelationshipInfoLinkJpaRepository.findPrlkRelationship(key));
					}
				}
			}
			break;
			
		case DISCUSSION_DETAILS:
			if(shareInfoBean.getDataRefKey()==null) { // boxshare
				dataRefKey.clear();
				dataRefKey.addAll(tIdVisitInformationJpaRepository.findPivPinKey(shareInfoBean.getPinKey()));
				removeKeys = tIdVisitInformationJpaRepository.findPivPinKey(shareInfoBean.getPinKey(),shareInfoBean.getCreatedBy());
				if(removeKeys.size()>0) {
					for(Long removeKey: removeKeys) {
						dataRefKey.remove(removeKey);
					}
				}
				 
			}				
			if(shareInfoBean.isAdmin()){
				tIdVisitInformationAccessJpaRepository.deleteByViaPivKeyIn(dataRefKey);
			}
			
			if(NONE.equals(shareInfoBean.getShareType())) {
				tIdVisitInformationAccessJpaRepository.deleteByViaPivKeyInAndCreatedBy(dataRefKey, shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			} else {
				if(shareInfoBean.getDataRefKey()==null) {
					 boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if(listofProfiles2!=null && listofProfiles2.size()>0) {
						shareInfoBean.setAccessInfo(listofProfiles2.stream().map(String::valueOf).collect(Collectors.joining(",")));
//						shareInfoBean.setAccessInfo(listofProfiles2.toString().replace("[","").replace("]", ""));
						TIdVisitInformationAccessEntity tIdVisitInformationAccessEntity = null;
						List<TIdVisitInformationAccessEntity> tIdVisitInformationAccessEntityList = new ArrayList<TIdVisitInformationAccessEntity>();				
						for(Long key : dataRefKey) {
							
									tIdVisitInformationAccessEntity = tIdVisitInformationAccessJpaRepository.findByViaPivKeyAndCreatedByAndShareType(key,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
									if(tIdVisitInformationAccessEntity==null) {
										tIdVisitInformationAccessEntity = new TIdVisitInformationAccessEntity();
										tIdVisitInformationAccessEntity.setViaPivKey(key);
										tIdVisitInformationAccessEntity.setShareType(shareInfoBean.getShareType());
										tIdVisitInformationAccessEntity.setAccessType(shareInfoBean.getAccessType());
										tIdVisitInformationAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
										tIdVisitInformationAccessEntity.setActiveStatus("A");
										tIdVisitInformationAccessEntity.setLockKey(1L);
									}
									if(shareInfoBean.isApprove() && tIdVisitInformationAccessEntity.getViaAccessInfo()!=null) {
										tIdVisitInformationAccessEntity.setViaAccessInfo(tIdVisitInformationAccessEntity.getViaAccessInfo()+","+shareInfoBean.getAccessInfo());
									} else {
										tIdVisitInformationAccessEntity.setViaAccessInfo(shareInfoBean.getAccessInfo());
									}
									tIdVisitInformationAccessEntityList.add(tIdVisitInformationAccessEntity);
								}
								tIdVisitInformationAccessJpaRepository.save(tIdVisitInformationAccessEntityList);
							}
						}
						for(Long key : dataRefKey) {
							if(GROUP.equals(shareInfoBean.getShareType())) {
								if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
									List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
									List<Long> listOfGroupProfiles = new ArrayList<Long>();
									listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
									tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, "Purpose", key);
								}
							} else {
								if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
									tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, "Purpose", key);
								}
							}
							if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
								saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
										shareInfoBean.getShareType(), menuType, key, "Purpose", tIdVisitInformationViewJpaRepository.findPivVisitedPurpose(key));
							}
						}
					}
			break;
			
		case BUSINESS_POTENTIAL:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdBusinessPotentialInfoJpaRepository.findBpiPinKey(shareInfoBean.getPinKey()));
				removeKeys = tIdBusinessPotentialInfoJpaRepository.findBpiPinKey(shareInfoBean.getPinKey(), shareInfoBean.getCreatedBy());
				if(removeKeys.size()>0) {
					for(Long removeKey: removeKeys) {
						dataRefKey.remove(removeKey);
					}
				}
			}				
			if(shareInfoBean.isAdmin()){
				tIdBusinessPotentialInfoAccessJpaRepository.deleteByBpiaBpiKeyIn(dataRefKey);
			}	
			if(NONE.equals(shareInfoBean.getShareType())) {
				tIdBusinessPotentialInfoAccessJpaRepository.deleteByBpiaBpiKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			}else {
				if(shareInfoBean.getDataRefKey()==null) {
					 boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if(listofProfiles2!=null && listofProfiles2.size()>0) {
						shareInfoBean.setAccessInfo(listofProfiles2.stream().map(String::valueOf).collect(Collectors.joining(",")));//listofProfiles2.toString().replace("[","").replace("]", ""));
						TIdBusinessPotentialInfoAccessEntity tIdBusinessPotentialInfoAccessEntity = null;
						List<TIdBusinessPotentialInfoAccessEntity> tIdBusinessPotentialInfoAccessEntityList = new ArrayList<TIdBusinessPotentialInfoAccessEntity>();				
						for(Long key : dataRefKey) {
							tIdBusinessPotentialInfoAccessEntity = tIdBusinessPotentialInfoAccessJpaRepository.findByBpiaBpiKeyAndCreatedByAndShareType(key,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
							if(tIdBusinessPotentialInfoAccessEntity==null) {
								tIdBusinessPotentialInfoAccessEntity = new TIdBusinessPotentialInfoAccessEntity();
								tIdBusinessPotentialInfoAccessEntity.setBpiaBpiKey(key);
								tIdBusinessPotentialInfoAccessEntity.setShareType(shareInfoBean.getShareType());
								tIdBusinessPotentialInfoAccessEntity.setAccessType(shareInfoBean.getAccessType());
								tIdBusinessPotentialInfoAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								tIdBusinessPotentialInfoAccessEntity.setActiveStatus("A");
								tIdBusinessPotentialInfoAccessEntity.setLockKey(1L);
							}
							if(shareInfoBean.isApprove() && tIdBusinessPotentialInfoAccessEntity.getBpiaAccessInfo()!=null) {
								tIdBusinessPotentialInfoAccessEntity.setBpiaAccessInfo(tIdBusinessPotentialInfoAccessEntity.getBpiaAccessInfo()+","+shareInfoBean.getAccessInfo());
							} else {
								tIdBusinessPotentialInfoAccessEntity.setBpiaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdBusinessPotentialInfoAccessEntityList.add(tIdBusinessPotentialInfoAccessEntity);
							logger.info("============4================>");
						}
						tIdBusinessPotentialInfoAccessJpaRepository.save(tIdBusinessPotentialInfoAccessEntityList);
						logger.info("============5================>");
					}
					logger.info("============6================>");
				}
				for(Long key : dataRefKey) {
					if(GROUP.equals(shareInfoBean.getShareType())) {
						if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, "Business Potential", key);
						}
					} else {
						if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, "Business Potential", key);
						}
					}
					if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
								shareInfoBean.getShareType(), menuType, key, "Business Potential", tIdBusinessPotentialInfoViewJpaRepository.findName(key));
					}
				}
			}
			break;
			
		case ADD_POTENTIAL:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdAddPotentialServicesJpaRepository.findApsPinKey(shareInfoBean.getPinKey()));
				removeKeys = tIdAddPotentialServicesJpaRepository.findApsPinKey(shareInfoBean.getPinKey(), shareInfoBean.getCreatedBy());
				if(removeKeys.size()>0) {
					for(Long removeKey: removeKeys) {
						dataRefKey.remove(removeKey);
					}
				}
			}
			if(shareInfoBean.isAdmin()){
				tIdAddPotentialServicesAccessJpaRepository.deleteByApsaApsKeyIn(dataRefKey);
			}
			if(NONE.equals(shareInfoBean.getShareType())){
				tIdAddPotentialServicesAccessJpaRepository.deleteByApsaApsKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			}else {
				if(shareInfoBean.getDataRefKey()==null) {
					 tIdBusinessPotentialInfoAccessJpaRepository.deleteByBpiaBpiKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
					 boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if(listofProfiles2!=null && listofProfiles2.size()>0) {
						shareInfoBean.setAccessInfo(listofProfiles2.stream().map(String::valueOf).collect(Collectors.joining(",")));
						TIdAddPotentialServicesAccessEntity tIdAddPotentialServicesAccessEntity = null;
						List<TIdAddPotentialServicesAccessEntity> tIdAddPotentialServicesAccessEntityList = new ArrayList<TIdAddPotentialServicesAccessEntity>();				
						for(Long key : dataRefKey) {
							tIdAddPotentialServicesAccessEntity = tIdAddPotentialServicesAccessJpaRepository.findByApsaApsKeyAndCreatedByAndShareType(key,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
							if(tIdAddPotentialServicesAccessEntity==null) {
								tIdAddPotentialServicesAccessEntity = new TIdAddPotentialServicesAccessEntity();
								tIdAddPotentialServicesAccessEntity.setApsaApsKey(key);
								tIdAddPotentialServicesAccessEntity.setShareType(shareInfoBean.getShareType());
								tIdAddPotentialServicesAccessEntity.setAccessType(shareInfoBean.getAccessType());
								tIdAddPotentialServicesAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								tIdAddPotentialServicesAccessEntity.setActiveStatus("A");
								tIdAddPotentialServicesAccessEntity.setLockKey(1L);
							}
							if(shareInfoBean.isApprove() && tIdAddPotentialServicesAccessEntity.getApsaAccessInfo()!=null) {
								tIdAddPotentialServicesAccessEntity.setApsaAccessInfo(tIdAddPotentialServicesAccessEntity.getApsaAccessInfo()+","+shareInfoBean.getAccessInfo());
							} else {
								tIdAddPotentialServicesAccessEntity.setApsaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdAddPotentialServicesAccessEntityList.add(tIdAddPotentialServicesAccessEntity);
						}
						tIdAddPotentialServicesAccessJpaRepository.save(tIdAddPotentialServicesAccessEntityList);
					}
				}
				for(Long key : dataRefKey) {
					if(GROUP.equals(shareInfoBean.getShareType())) {
						if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, "Add Potential", key);
						}
					} else {
						if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, "Add Potential", key);
						}
					}
					if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
								shareInfoBean.getShareType(), menuType, key, "Add Potential", tIdAddPotentialServicesViewJpaRepository.findName(key));
					}
				}
					}
			break;
			
		case RECREATION:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdRecreationInfoJpaRepository.findReiPinKey(shareInfoBean.getPinKey()));
			}				
			if(shareInfoBean.isAdmin()){
				tIdRecreationInfoAccessJpaRepository.deleteByRiaReiKeyIn(dataRefKey);
			}
			if(NONE.equals(shareInfoBean.getShareType())){
				tIdRecreationInfoAccessJpaRepository.deleteByRiaReiKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			}else {
				if(shareInfoBean.getDataRefKey()==null) {
					 boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if(listofProfiles2!=null && listofProfiles2.size()>0) {
						shareInfoBean.setAccessInfo(listofProfiles2.stream().map(String::valueOf).collect(Collectors.joining(",")));
						TIdRecreationInfoAccessEntity tIdRecreationInfoAccessEntity = null;
						List<TIdRecreationInfoAccessEntity> tIdRecreationInfoAccessEntityList = new ArrayList<TIdRecreationInfoAccessEntity>();				
						for(Long key : dataRefKey) {
							tIdRecreationInfoAccessEntity = tIdRecreationInfoAccessJpaRepository.findByRiaReiKeyAndCreatedByAndShareType(key,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
							if(tIdRecreationInfoAccessEntity==null) {
								tIdRecreationInfoAccessEntity = new TIdRecreationInfoAccessEntity();
								tIdRecreationInfoAccessEntity.setRiaReiKey(key);
								tIdRecreationInfoAccessEntity.setShareType(shareInfoBean.getShareType());
								tIdRecreationInfoAccessEntity.setAccessType(shareInfoBean.getAccessType());
								tIdRecreationInfoAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								tIdRecreationInfoAccessEntity.setActiveStatus("A");
								tIdRecreationInfoAccessEntity.setLockKey(1L);
							}
							if(shareInfoBean.isApprove() && tIdRecreationInfoAccessEntity.getRiaAccessInfo()!=null) {
								tIdRecreationInfoAccessEntity.setRiaAccessInfo(tIdRecreationInfoAccessEntity.getRiaAccessInfo()+","+shareInfoBean.getAccessInfo());
							} else {
								tIdRecreationInfoAccessEntity.setRiaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdRecreationInfoAccessEntityList.add(tIdRecreationInfoAccessEntity);
							
						}
						tIdRecreationInfoAccessJpaRepository.save(tIdRecreationInfoAccessEntityList);
					}
				}
				for(Long key : dataRefKey) {
					if(GROUP.equals(shareInfoBean.getShareType())) {
						if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, "Recreation", key);
						}
					} else {
						if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, "Recreation", key);
						}
					}
					if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
								shareInfoBean.getShareType(), menuType, key, "Recreation", tIdRecreationInfoViewJpaRepository.findName(key));
					}
				}
			}
		
			break;
			
		case PERSONAL_INTEREST:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdPersonalInterestsJpaRepository.findPeriPinKey(shareInfoBean.getPinKey()));
			}				
			if(shareInfoBean.isAdmin()){
				tIdPersonalInterestsAccessJpaRepository.deleteByPiaPeriKeyIn(dataRefKey);
			}
			if(NONE.equals(shareInfoBean.getShareType())){
				tIdPersonalInterestsAccessJpaRepository.deleteByPiaPeriKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			}else {
				if(shareInfoBean.getDataRefKey()==null) {
					 boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 =boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if(listofProfiles2!=null && listofProfiles2.size()>0) {
						shareInfoBean.setAccessInfo(listofProfiles2.stream().map(String::valueOf).collect(Collectors.joining(",")));
						TIdPersonalInterestsAccessEntity tIdPersonalInterestsAccessEntity = null;
						List<TIdPersonalInterestsAccessEntity> tIdPersonalInterestsAccessEntityList = new ArrayList<TIdPersonalInterestsAccessEntity>();				
						for(Long key : dataRefKey) {
							tIdPersonalInterestsAccessEntity = tIdPersonalInterestsAccessJpaRepository.findByPiaPeriKeyAndCreatedByAndShareType(key,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
							if(tIdPersonalInterestsAccessEntity==null) {
								tIdPersonalInterestsAccessEntity = new TIdPersonalInterestsAccessEntity();
								tIdPersonalInterestsAccessEntity.setPiaPeriKey(key);
								tIdPersonalInterestsAccessEntity.setShareType(shareInfoBean.getShareType());
								tIdPersonalInterestsAccessEntity.setAccessType(shareInfoBean.getAccessType());
								tIdPersonalInterestsAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								tIdPersonalInterestsAccessEntity.setActiveStatus("A");
								tIdPersonalInterestsAccessEntity.setLockKey(1L);
							}
							if(shareInfoBean.isApprove() && tIdPersonalInterestsAccessEntity.getPiaAccessInfo()!=null) {
								tIdPersonalInterestsAccessEntity.setPiaAccessInfo(tIdPersonalInterestsAccessEntity.getPiaAccessInfo()+","+shareInfoBean.getAccessInfo());
							} else {
								tIdPersonalInterestsAccessEntity.setPiaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdPersonalInterestsAccessEntityList.add(tIdPersonalInterestsAccessEntity);
						}
						tIdPersonalInterestsAccessJpaRepository.save(tIdPersonalInterestsAccessEntityList);
					}
				}
				for(Long key : dataRefKey) {
					if(GROUP.equals(shareInfoBean.getShareType())) {
						if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, "Personal Int", key);
						}
					} else {
						if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, "Personal Int", key);
						}
					}
					if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
								shareInfoBean.getShareType(), menuType, key, "Personal Int", tIdPersonalInterestsViewJpaRepository.findName(key));
					}
				}
				
			}
			break;
			
		case PROFESSIONAL_INTEREST:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdProfessionalInterestsJpaRepository.findPriPinKey(shareInfoBean.getPinKey()));
			}				
			if(shareInfoBean.isAdmin()){
				tIdProfessionalInterestsAccessJpaRepository.deleteByPiaPriKeyIn(dataRefKey);
			}
			if(NONE.equals(shareInfoBean.getShareType())){
				tIdProfessionalInterestsAccessJpaRepository.deleteByPiaPriKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			}else {
				if(shareInfoBean.getDataRefKey()==null) {
					 boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if(listofProfiles2!=null && listofProfiles2.size()>0) {
							shareInfoBean.setAccessInfo(listofProfiles2.stream().map(String::valueOf).collect(Collectors.joining(",")));
						TIdProfessionalInterestsAccessEntity tIdProfessionalInterestsAccessEntity = null;
						List<TIdProfessionalInterestsAccessEntity> tIdProfessionalInterestsAccessEntityList = new ArrayList<TIdProfessionalInterestsAccessEntity>();				
						for(Long key : dataRefKey) {
							tIdProfessionalInterestsAccessEntity = tIdProfessionalInterestsAccessJpaRepository.findByPiaPriKeyAndCreatedByAndShareType(key,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
							if(tIdProfessionalInterestsAccessEntity==null) {
								tIdProfessionalInterestsAccessEntity = new TIdProfessionalInterestsAccessEntity();
								tIdProfessionalInterestsAccessEntity.setPiaPriKey(key);
								tIdProfessionalInterestsAccessEntity.setShareType(shareInfoBean.getShareType());
								tIdProfessionalInterestsAccessEntity.setAccessType(shareInfoBean.getAccessType());
								tIdProfessionalInterestsAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								tIdProfessionalInterestsAccessEntity.setActiveStatus("A");
								tIdProfessionalInterestsAccessEntity.setLockKey(1L);
							}
							if(shareInfoBean.isApprove() && tIdProfessionalInterestsAccessEntity.getPiaAccessInfo()!=null) {
								tIdProfessionalInterestsAccessEntity.setPiaAccessInfo(tIdProfessionalInterestsAccessEntity.getPiaAccessInfo()+","+shareInfoBean.getAccessInfo());
							} else {
								tIdProfessionalInterestsAccessEntity.setPiaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdProfessionalInterestsAccessEntityList.add(tIdProfessionalInterestsAccessEntity);
						}
						tIdProfessionalInterestsAccessJpaRepository.save(tIdProfessionalInterestsAccessEntityList);
					}
				}
				
				for(Long key : dataRefKey) {
					if(GROUP.equals(shareInfoBean.getShareType())) {
						if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, "Professional Int", key);
						}
					} else {
						if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, "Professional Int", key);
						}
					}
					if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
								shareInfoBean.getShareType(), menuType, key, "Professional Int", tIdProfessionalInterestsViewJpaRepository.findName(key));
					}
				}
			}
			break;
			
		case PERSONAL_PRIORITIES:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdPersonalPrioritiesJpaRepository.findPerpPinKey(shareInfoBean.getPinKey()));
			}				
			if(shareInfoBean.isAdmin()){
				tIdPersonalPrioritiesAccessJpaRepository.deleteByPpaPerpKeyIn(dataRefKey);
			}
			if(NONE.equals(shareInfoBean.getShareType())){
				tIdPersonalPrioritiesAccessJpaRepository.deleteByPpaPerpKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			}else {
				if(shareInfoBean.getDataRefKey()==null) {
					 boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if (listofProfiles2!=null && listofProfiles2.size() > 0) {
						shareInfoBean.setAccessInfo(listofProfiles2.toString().replace("[", "").replace("]", ""));
						TIdPersonalPrioritiesAccessEntity TIdPersonalPrioritiesAccessEntity = null;
						List<TIdPersonalPrioritiesAccessEntity> tIdPersonalPrioritiesAccessEntityList = new ArrayList<TIdPersonalPrioritiesAccessEntity>();
						for (Long key : dataRefKey) {
							TIdPersonalPrioritiesAccessEntity = tIdPersonalPrioritiesAccessJpaRepository
									.findByPpaPerpKeyAndCreatedByAndShareType(key, shareInfoBean.getCreatedBy(),
											shareInfoBean.getShareType());
							if (TIdPersonalPrioritiesAccessEntity == null) {
								TIdPersonalPrioritiesAccessEntity = new TIdPersonalPrioritiesAccessEntity();
								TIdPersonalPrioritiesAccessEntity.setPpaPerpKey(key);
								TIdPersonalPrioritiesAccessEntity.setShareType(shareInfoBean.getShareType());
								TIdPersonalPrioritiesAccessEntity.setAccessType(shareInfoBean.getAccessType());
								TIdPersonalPrioritiesAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								TIdPersonalPrioritiesAccessEntity.setActiveStatus("A");
								TIdPersonalPrioritiesAccessEntity.setLockKey(1L);
							}
							if (shareInfoBean.isApprove()
									&& TIdPersonalPrioritiesAccessEntity.getPpaAccessInfo() != null) {
								TIdPersonalPrioritiesAccessEntity
										.setPpaAccessInfo(TIdPersonalPrioritiesAccessEntity.getPpaAccessInfo() + ","
												+ shareInfoBean.getAccessInfo());
							} else {
								TIdPersonalPrioritiesAccessEntity.setPpaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdPersonalPrioritiesAccessEntityList.add(TIdPersonalPrioritiesAccessEntity);

						}
						tIdPersonalPrioritiesAccessJpaRepository.save(tIdPersonalPrioritiesAccessEntityList);
					}
				}
				for (Long key : dataRefKey) {
					if (GROUP.equals(shareInfoBean.getShareType())) {
						if (shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size() > 0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository
									.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(
									tIdGroupLinkList1.stream().map(p -> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType,
									"Personal Priorities", key);
						}
					} else {
						if (shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size() > 0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(),
									menuType, "Personal Priorities", key);
						}
					}
					if (!shareInfoBean.isRecall() && !shareInfoBean.isApprove()
							&& !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(),
								shareInfoBean.getAccessInfo(), shareInfoBean.getShareType(), menuType, key,
								"Personal Priorities", tIdPersonalPrioritiesJpaRepository.findName(key));
					}
				}
			}
			break;
			
		case EXPERIENCE:
			
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdExperienceInformationJpaRepository.findPexPinKey(shareInfoBean.getPinKey()));
			}				
			if(shareInfoBean.isAdmin()){
				tIdExperienceInformationAccessJpaRepository.deleteByEiaPexKeyIn(dataRefKey);
			}
			if(NONE.equals(shareInfoBean.getShareType())){
				tIdExperienceInformationAccessJpaRepository.deleteByEiaPexKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			}else {
				if(shareInfoBean.getDataRefKey()==null) {
					 boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
						if(listofProfiles2!=null && listofProfiles2.size()>0) {
							shareInfoBean.setAccessInfo(listofProfiles2.stream().map(String::valueOf).collect(Collectors.joining(",")));
							TIdExperienceInformationAccessEntity tIdExperienceInformationAccessEntity = null;
							List<TIdExperienceInformationAccessEntity> tIdExperienceInformationAccessEntityList = new ArrayList<TIdExperienceInformationAccessEntity>();				
							for(Long key : dataRefKey) {
								tIdExperienceInformationAccessEntity = tIdExperienceInformationAccessJpaRepository.findByEiaPexKeyAndCreatedByAndShareType(key,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
								if(tIdExperienceInformationAccessEntity==null) {
									tIdExperienceInformationAccessEntity = new TIdExperienceInformationAccessEntity();
									tIdExperienceInformationAccessEntity.setEiaPexKey(key);
									tIdExperienceInformationAccessEntity.setShareType(shareInfoBean.getShareType());
									tIdExperienceInformationAccessEntity.setAccessType(shareInfoBean.getAccessType());
									tIdExperienceInformationAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
									tIdExperienceInformationAccessEntity.setActiveStatus("A");
									tIdExperienceInformationAccessEntity.setLockKey(1L);
								}
								if(shareInfoBean.isApprove() && tIdExperienceInformationAccessEntity.getEiaAccessInfo()!=null) {
									tIdExperienceInformationAccessEntity.setEiaAccessInfo(tIdExperienceInformationAccessEntity.getEiaAccessInfo()+","+shareInfoBean.getAccessInfo());
								} else {
									tIdExperienceInformationAccessEntity.setEiaAccessInfo(shareInfoBean.getAccessInfo());
								}
								tIdExperienceInformationAccessEntityList.add(tIdExperienceInformationAccessEntity);
							}
							tIdExperienceInformationAccessJpaRepository.save(tIdExperienceInformationAccessEntityList);
						}
				}
				
				for(Long key : dataRefKey) {
					if(GROUP.equals(shareInfoBean.getShareType())) {
						if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, "Experience", key);
						}
					} else {
						if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, "Experience", key);
						}
					}
				
					if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
								shareInfoBean.getShareType(), menuType, key, "Experience", tIdExperienceInformationViewJpaRepository.findCompany(key));
					}
				}
			}
			break;
			
		case EDUCATION:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdEducationalInformationJpaRepository.findPeiPinKey(shareInfoBean.getPinKey()));
			}				
			if(shareInfoBean.isAdmin()){
				tIdEducationalInformationAccessJpaRepository.deleteByEiaPeiKeyIn(dataRefKey);
			}
			if(NONE.equals(shareInfoBean.getShareType())){
				tIdEducationalInformationAccessJpaRepository.deleteByEiaPeiKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			}else {
				
				if(shareInfoBean.getDataRefKey()==null) {
					 boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if(listofProfiles2!=null && listofProfiles2.size()>0) {
						shareInfoBean.setAccessInfo(listofProfiles2.stream().map(String::valueOf).collect(Collectors.joining(",")));
						TIdEducationalInformationAccessEntity TIdEducationalInformationAccessEntity = null;
						List<TIdEducationalInformationAccessEntity> tIdEducationalInformationAccessEntityList = new ArrayList<TIdEducationalInformationAccessEntity>();				
						for(Long key : dataRefKey) {
							TIdEducationalInformationAccessEntity = tIdEducationalInformationAccessJpaRepository.findByEiaPeiKeyAndCreatedByAndShareType(key,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
							if(TIdEducationalInformationAccessEntity==null) {
								TIdEducationalInformationAccessEntity = new TIdEducationalInformationAccessEntity();
								TIdEducationalInformationAccessEntity.setEiaPeiKey(key);
								TIdEducationalInformationAccessEntity.setShareType(shareInfoBean.getShareType());
								TIdEducationalInformationAccessEntity.setAccessType(shareInfoBean.getAccessType());
								TIdEducationalInformationAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								TIdEducationalInformationAccessEntity.setActiveStatus("A");
								TIdEducationalInformationAccessEntity.setLockKey(1L);
							}
							if(shareInfoBean.isApprove() && TIdEducationalInformationAccessEntity.getEiaAccessInfo()!=null) {
								TIdEducationalInformationAccessEntity.setEiaAccessInfo(TIdEducationalInformationAccessEntity.getEiaAccessInfo()+","+shareInfoBean.getAccessInfo());
							} else {
								TIdEducationalInformationAccessEntity.setEiaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdEducationalInformationAccessEntityList.add(TIdEducationalInformationAccessEntity);
							
						}
						tIdEducationalInformationAccessJpaRepository.save(tIdEducationalInformationAccessEntityList);
					}
				}
					
					for(Long key : dataRefKey) {
						if(GROUP.equals(shareInfoBean.getShareType())) {
							if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
								List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
								List<Long> listOfGroupProfiles = new ArrayList<Long>();
								listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
								tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, "Education", key);
							}
						} else {
							if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
								tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, "Education", key);
							}
						}
						if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
							saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
									shareInfoBean.getShareType(), menuType, key, "Education", tIdEducationalInformationViewJpaRepository.findQualification(key));
						}
					}
				}
			
			break;
			
		case PROJ_EXECUTED:
			if (shareInfoBean.getDataRefKey() == null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdProjectsInformationJpaRepository.findPipPinKey(shareInfoBean.getPinKey()));
			}
			if (shareInfoBean.isAdmin()) {
				tIdProjectsInformationAccessJpaRepository.deleteByPiaPipKeyIn(dataRefKey);
			}
			if (NONE.equals(shareInfoBean.getShareType())) {
				tIdProjectsInformationAccessJpaRepository.deleteByPiaPipKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			} else {
				if (shareInfoBean.getDataRefKey() == null) {
					boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if (listofProfiles2!=null && listofProfiles2.size() > 0) {
						shareInfoBean.setAccessInfo(listofProfiles2.toString().replace("[", "").replace("]", ""));
						TIdProjectsInformationAccessEntity tIdProjectsInformationAccessEntity = null;
						List<TIdProjectsInformationAccessEntity> tIdProjectsInformationAccessEntityList = new ArrayList<TIdProjectsInformationAccessEntity>();
						for (Long key : dataRefKey) {
							tIdProjectsInformationAccessEntity = tIdProjectsInformationAccessJpaRepository
									.findByPiaPipKeyAndCreatedByAndShareType(key, shareInfoBean.getCreatedBy(),
											shareInfoBean.getShareType());
							if (tIdProjectsInformationAccessEntity == null) {
								tIdProjectsInformationAccessEntity = new TIdProjectsInformationAccessEntity();
								tIdProjectsInformationAccessEntity.setPiaPipKey(key);
								tIdProjectsInformationAccessEntity.setShareType(shareInfoBean.getShareType());
								tIdProjectsInformationAccessEntity.setAccessType(shareInfoBean.getAccessType());
								tIdProjectsInformationAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								tIdProjectsInformationAccessEntity.setActiveStatus("A");
								tIdProjectsInformationAccessEntity.setLockKey(1L);
							}
							if (shareInfoBean.isApprove()
									&& tIdProjectsInformationAccessEntity.getPiaAccessInfo() != null) {
								tIdProjectsInformationAccessEntity
										.setPiaAccessInfo(tIdProjectsInformationAccessEntity.getPiaAccessInfo() + ","
												+ shareInfoBean.getAccessInfo());
							} else {
								tIdProjectsInformationAccessEntity.setPiaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdProjectsInformationAccessEntityList.add(tIdProjectsInformationAccessEntity);

						}
						tIdProjectsInformationAccessJpaRepository.save(tIdProjectsInformationAccessEntityList);
					}
				}
				for (Long key : dataRefKey) {
					if (GROUP.equals(shareInfoBean.getShareType())) {
						if (shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size() > 0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository
									.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(
									tIdGroupLinkList1.stream().map(p -> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType,
									"Proj Exec", key);
						}
					} else {
						if (shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size() > 0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(),
									menuType, "Proj Exec", key);
						}
					}
					if (!shareInfoBean.isRecall() && !shareInfoBean.isApprove()
							&& !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(),
								shareInfoBean.getAccessInfo(), shareInfoBean.getShareType(), menuType, key, "Proj Exec",
								tIdProjectsInformationJpaRepository.findPipProjectName(key));
					}
				}
			}
			
			break;
			
		case PROF_EXPERTISE:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdProfessionalExpertiseJpaRepository.findPpePinKey(shareInfoBean.getPinKey()));
			}				
			if(shareInfoBean.isAdmin()){
				tIdProfessionalExpertiseAccessJpaRepository.deleteByPeaPpeKeyIn(dataRefKey);
			}
			if(NONE.equals(shareInfoBean.getShareType())){
				tIdProfessionalExpertiseAccessJpaRepository.deleteByPeaPpeKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			}else {
				if (shareInfoBean.getDataRefKey() == null) {
					boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if (listofProfiles2!=null && listofProfiles2.size() > 0) {
						shareInfoBean.setAccessInfo(listofProfiles2.toString().replace("[", "").replace("]", ""));
						TIdProfessionalExpertiseAccessEntity tIdProfessionalExpertiseAccessEntity = null;
						List<TIdProfessionalExpertiseAccessEntity> tIdProfessionalExpertiseAccessEntityList = new ArrayList<TIdProfessionalExpertiseAccessEntity>();
						for (Long key : dataRefKey) {
							tIdProfessionalExpertiseAccessEntity = tIdProfessionalExpertiseAccessJpaRepository
									.findByPeaPpeKeyAndCreatedByAndShareType(key, shareInfoBean.getCreatedBy(),
											shareInfoBean.getShareType());
							if (tIdProfessionalExpertiseAccessEntity == null) {
								tIdProfessionalExpertiseAccessEntity = new TIdProfessionalExpertiseAccessEntity();
								tIdProfessionalExpertiseAccessEntity.setPeaPpeKey(key);
								tIdProfessionalExpertiseAccessEntity.setShareType(shareInfoBean.getShareType());
								tIdProfessionalExpertiseAccessEntity.setAccessType(shareInfoBean.getAccessType());
								tIdProfessionalExpertiseAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								tIdProfessionalExpertiseAccessEntity.setActiveStatus("A");
								tIdProfessionalExpertiseAccessEntity.setLockKey(1L);
							}
							if (shareInfoBean.isApprove()
									&& tIdProfessionalExpertiseAccessEntity.getPeaAccessInfo() != null) {
								tIdProfessionalExpertiseAccessEntity
										.setPeaAccessInfo(tIdProfessionalExpertiseAccessEntity.getPeaAccessInfo() + ","
												+ shareInfoBean.getAccessInfo());
							} else {
								tIdProfessionalExpertiseAccessEntity.setPeaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdProfessionalExpertiseAccessEntityList.add(tIdProfessionalExpertiseAccessEntity);
						}
						tIdProfessionalExpertiseAccessJpaRepository.save(tIdProfessionalExpertiseAccessEntityList);
					}
				}
				for (Long key : dataRefKey) {
					if (GROUP.equals(shareInfoBean.getShareType())) {
						if (shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size() > 0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository
									.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p -> p.getGlPinKey())
									.collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType,
									"Prof Exp", key);
						}
					} else {
						if (shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size() > 0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(
									shareInfoBean.getRecallOneToOneList(), menuType, "Prof Exp", key);
						}
					}
					if (!shareInfoBean.isRecall() && !shareInfoBean.isApprove()
							&& !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(),
								shareInfoBean.getAccessInfo(), shareInfoBean.getShareType(), menuType, key,
								"Prof Exp", tIdProfessionalExpertiseViewJpaRepository.findName(key));
					}
				}
			}
			
			break;
			
		case AWARDS_RECOG:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdAwardsInformationJpaRepository.findPiaPinKey(shareInfoBean.getPinKey()));
			}				
			if(shareInfoBean.isAdmin()){
				tIdAwardsInformationAccessJpaRepository.deleteByAiaPiaKeyIn(dataRefKey);
			}
			if(NONE.equals(shareInfoBean.getShareType())){
				tIdAwardsInformationAccessJpaRepository.deleteByAiaPiaKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			}else {
				if (shareInfoBean.getDataRefKey() == null) {
					boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if (listofProfiles2!=null && listofProfiles2.size() > 0) {
						shareInfoBean.setAccessInfo(listofProfiles2.toString().replace("[", "").replace("]", ""));
						TIdAwardsInformationAccessEntity tIdAwardsInformationAccessEntity = null;
						List<TIdAwardsInformationAccessEntity> tIdAwardsInformationAccessEntityList = new ArrayList<TIdAwardsInformationAccessEntity>();				
						for(Long key : dataRefKey) {
							tIdAwardsInformationAccessEntity = tIdAwardsInformationAccessJpaRepository.findByAiaPiaKeyAndCreatedByAndShareType(key,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
							if(tIdAwardsInformationAccessEntity==null) {
								tIdAwardsInformationAccessEntity = new TIdAwardsInformationAccessEntity();
								tIdAwardsInformationAccessEntity.setAiaPiaKey(key);
								tIdAwardsInformationAccessEntity.setShareType(shareInfoBean.getShareType());
								tIdAwardsInformationAccessEntity.setAccessType(shareInfoBean.getAccessType());
								tIdAwardsInformationAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								tIdAwardsInformationAccessEntity.setActiveStatus("A");
								tIdAwardsInformationAccessEntity.setLockKey(1L);
							}
							if(shareInfoBean.isApprove() && tIdAwardsInformationAccessEntity.getAiaAccessInfo()!=null) {
								tIdAwardsInformationAccessEntity.setAiaAccessInfo(tIdAwardsInformationAccessEntity.getAiaAccessInfo()+","+shareInfoBean.getAccessInfo());
							} else {
								tIdAwardsInformationAccessEntity.setAiaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdAwardsInformationAccessEntityList.add(tIdAwardsInformationAccessEntity);
						}
						tIdAwardsInformationAccessJpaRepository.save(tIdAwardsInformationAccessEntityList);
					}
				}
				for(Long key : dataRefKey) {
					if(GROUP.equals(shareInfoBean.getShareType())) {
						if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, "Award Recog", key);
						}
					} else {
						if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, "Award Recog", key);
						}
					}
					
					if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
								shareInfoBean.getShareType(), menuType, key, "Award Recog", tIdAwardsInformationJpaRepository.findAwardName(key));
					}
				}
			}
			break;
			
			
		case ADD_INFORMATION:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdAdditionalInformationJpaRepository.findPiadPinKey(shareInfoBean.getPinKey()));
			}				
			if(shareInfoBean.isAdmin()){
				tIdAdditionalInformationAccessJpaRepository.deleteByAiaPiadKeyIn(dataRefKey);
			}
			if(NONE.equals(shareInfoBean.getShareType())){
				tIdAdditionalInformationAccessJpaRepository.deleteByAiaPiadKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				boxTypeAccessService.saveBoxTypeAccess(menuType, shareInfoBean);
			}else {
				if (shareInfoBean.getDataRefKey() == null) {
					boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
				} else {
					List<Long> listofProfiles2 = boxTypeAccessService.boxTypeAccess(shareInfoBean, dataRefKey, menuType,null,removeKeys);
					if (listofProfiles2!=null && listofProfiles2.size() > 0) {
						shareInfoBean.setAccessInfo(listofProfiles2.toString().replace("[", "").replace("]", ""));
						TIdAdditionalInformationAccessEntity tIdAdditionalInformationAccessEntity = null;
						List<TIdAdditionalInformationAccessEntity> tIdAdditionalInformationAccessEntityList = new ArrayList<TIdAdditionalInformationAccessEntity>();				
						for(Long key : dataRefKey) {
							tIdAdditionalInformationAccessEntity = tIdAdditionalInformationAccessJpaRepository.findByAiaPiadKeyAndCreatedByAndShareType(key,shareInfoBean.getCreatedBy(),shareInfoBean.getShareType());
							if(tIdAdditionalInformationAccessEntity==null) {
								tIdAdditionalInformationAccessEntity = new TIdAdditionalInformationAccessEntity();
								tIdAdditionalInformationAccessEntity.setAiaPiadKey(key);
								tIdAdditionalInformationAccessEntity.setShareType(shareInfoBean.getShareType());
								tIdAdditionalInformationAccessEntity.setAccessType(shareInfoBean.getShareType());
								tIdAdditionalInformationAccessEntity.setCreatedBy(shareInfoBean.getCreatedBy());
								tIdAdditionalInformationAccessEntity.setActiveStatus("A");
								tIdAdditionalInformationAccessEntity.setLockKey(1L);
							}
							if(shareInfoBean.isApprove() && tIdAdditionalInformationAccessEntity.getAiaAccessInfo()!=null) {
								tIdAdditionalInformationAccessEntity.setAiaAccessInfo(tIdAdditionalInformationAccessEntity.getAiaAccessInfo()+","+shareInfoBean.getAccessInfo());
							} else {
								tIdAdditionalInformationAccessEntity.setAiaAccessInfo(shareInfoBean.getAccessInfo());
							}
							tIdAdditionalInformationAccessEntityList.add(tIdAdditionalInformationAccessEntity);
						}
						tIdAdditionalInformationAccessJpaRepository.save(tIdAdditionalInformationAccessEntityList);
					}
				}
				for(Long key : dataRefKey) {
					if(GROUP.equals(shareInfoBean.getShareType())) {
						if(shareInfoBean.getRecallGroupList()!=null && shareInfoBean.getRecallGroupList().size()>0) {
							List<TIdGroupLinkEntity> tIdGroupLinkList1 = tIdGroupLinkJpaRepository.getListOfGlPinKey(shareInfoBean.getRecallGroupList());
							List<Long> listOfGroupProfiles = new ArrayList<Long>();
							listOfGroupProfiles.addAll(tIdGroupLinkList1.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
							tIdLandingNotificationJpaRepository.deleteListOfId(listOfGroupProfiles, menuType, "Add Info", key);
						}
					} else {
						if(shareInfoBean.getRecallOneToOneList()!=null && shareInfoBean.getRecallOneToOneList().size()>0) {
							tIdLandingNotificationJpaRepository.deleteListOfId(shareInfoBean.getRecallOneToOneList(), menuType, "Add Info", key);
						}
					}
					
					if(!shareInfoBean.isRecall() && !shareInfoBean.isApprove() && !ALL.equals(shareInfoBean.getMenuType())) {
						saveShareNotification(shareInfoBean.getCreatedBy(), shareInfoBean.getPinKey(), shareInfoBean.getAccessInfo(), 
								shareInfoBean.getShareType(), menuType, key, "Add Info", tIdAdditionalInformationJpaRepository.findPiadOrganization(key));
					}
				}
			}
			break;
		}

	}
	
	public void saveShareNotification(Long userPinKey, Long contactPinKey, String accessInfo, String shareType, 
			String menuType, Long key, String fieldName, String latestUpdate) {
		
		List<Long> listofProfiles = new ArrayList<Long>();
		
		if(accessInfo!=null && !accessInfo.trim().isEmpty()) {
			List<Long> listOfValues = Arrays.asList(accessInfo.replace("\"", "").split(",")).stream().map(s -> Long.valueOf(s.trim())).collect(Collectors.toList());
			if(GROUP.equals(shareType)) {
				List<TIdGroupLinkEntity> tIdGroupLinkList = tIdGroupLinkJpaRepository.getListOfGlPinKey(listOfValues);
				listofProfiles.addAll(tIdGroupLinkList.stream().map(p-> p.getGlPinKey()).collect(Collectors.toList()));
			} else {
				listofProfiles.addAll(listOfValues);
			}
		}
		
		if(listofProfiles.size()>0) {
			listofProfiles.removeAll(tIdLandingNotificationJpaRepository.getListOfId(listofProfiles, menuType, fieldName, key));
		}
		
		List<TIdLandingNotificationEntity> tIdLandingNotificationEntityList = new ArrayList<TIdLandingNotificationEntity>();
		
		PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(userPinKey);
		String userTitle = tIdReferenceCodesDetailJpaRepository.getTitleValue(Long.valueOf(personIndividualExperienceViewEntity.getPinTitle()));
		String userName = personIndividualExperienceViewEntity.getPinFirstName()+" "+personIndividualExperienceViewEntity.getPinLastName();
		personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(contactPinKey);
		String contactTitle = tIdReferenceCodesDetailJpaRepository.getTitleValue(Long.valueOf(personIndividualExperienceViewEntity.getPinTitle()));
		String contactName = personIndividualExperienceViewEntity.getPinFirstName()+" "+personIndividualExperienceViewEntity.getPinLastName();
		String company = personIndividualExperienceViewEntity.getCompany();
		String industry = tIdCompanyIndustryLinkViewJpaRepository.getName(personIndividualExperienceViewEntity.getPexKey());
		String country = personIndividualExperienceViewEntity.getPinCountryName();
		
		listofProfiles.stream().forEach(profileId->{
			//dataRefKey.stream().forEach(key->{
				TIdLandingNotificationEntity tIdLandingNotificationEntity = new TIdLandingNotificationEntity();
				tIdLandingNotificationEntity.setLdUserPinKey(userPinKey);
				tIdLandingNotificationEntity.setLdUserTitle(userTitle);
				tIdLandingNotificationEntity.setLdUserName(userName);
				tIdLandingNotificationEntity.setLdContactPinKey(contactPinKey);
				tIdLandingNotificationEntity.setLdContactTitle(contactTitle);
				tIdLandingNotificationEntity.setLdContactName(contactName);
				tIdLandingNotificationEntity.setLdCompany(company);
				tIdLandingNotificationEntity.setLdIndustry(industry);
				tIdLandingNotificationEntity.setLdCountry(country);
				tIdLandingNotificationEntity.setLdBoxName(menuType);
				tIdLandingNotificationEntity.setLdFieldName(fieldName);
				tIdLandingNotificationEntity.setLdLatestUpdate(latestUpdate);
				tIdLandingNotificationEntity.setLdUpdateKey(key);
				tIdLandingNotificationEntity.setLdToPinKey(profileId);
				PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity1 = personIndividualExperienceViewJpaRepository.findOne(profileId);
				tIdLandingNotificationEntity.setLdToTitle(tIdReferenceCodesDetailJpaRepository.getTitleValue(Long.valueOf(personIndividualExperienceViewEntity1.getPinTitle())));
				tIdLandingNotificationEntity.setLdToName(personIndividualExperienceViewEntity1.getPinFirstName()+" "+personIndividualExperienceViewEntity1.getPinLastName());
				tIdLandingNotificationEntity.setLdReadFlag(false);
				tIdLandingNotificationEntity.setLockKey(0L);
				tIdLandingNotificationEntity.setProfileKey(1L);
				tIdLandingNotificationEntity.setCreatedOn(new Date());
				tIdLandingNotificationEntity.setLdRequest(false);
				tIdLandingNotificationEntity.setLdAppRejFlag(2L);
				tIdLandingNotificationEntityList.add(tIdLandingNotificationEntity);
			//});
		});

		tIdLandingNotificationJpaRepository.save(tIdLandingNotificationEntityList);
	}

	/*@Override
	public boolean shareInfoValid(ShareInfoBean shareInfoBean) {
		boolean val = false;
		List<Long> dataRefKey = new ArrayList<Long>();
		if(shareInfoBean.getDataRefKey()!=null) {
			dataRefKey.add(shareInfoBean.getDataRefKey());
		}		
		if(!ALL.equals(shareInfoBean.getMenuType())) {
			return shareInfoValidateWizard(dataRefKey, shareInfoBean.getMenuType(), shareInfoBean.getFieldType(), shareInfoBean);
	
		} else {
			for(String menuType : MENU_TYPE_LIST) {
				val = shareInfoValidateWizard(dataRefKey, menuType, shareInfoBean.getFieldType(), shareInfoBean);
				if(val) {
					return val;
				}
			}
			for(String fieldType: HEADER_LIST) {
				val = shareInfoValidateWizard(dataRefKey, HEADER_INFO, fieldType, shareInfoBean);
				if(val) {
					return val;
				}
			}

			return val;
		}
	}*/
	
	public boolean shareInfoValidateWizard(List<Long> dataRefKey,String menuType,String fieldType,ShareInfoBean shareInfoBean){
		int count;
		List<String> filedTypeList = new ArrayList<String>();
		switch(menuType) {
		 
		case HEADER_INFO:
			count = tIdPersonalInfoAccessJpaRepository.getPiecPinKeyAndPiaFieldTypeAndCreatedBy(shareInfoBean.getPinKey(), fieldType, shareInfoBean.getCreatedBy());
			if(count>0) {
				return true;
			}
			break;
		case PERSONAL_INFO:
			if("".equals(fieldType)) {
				filedTypeList.addAll(PERSONAL_INFO_TYPE_LIST);
			} else {
				filedTypeList.add(fieldType);
			}
			
			for(String fieldTypeInfo : filedTypeList) {
				count = tIdPersonalInfoAccessJpaRepository.getPiecPinKeyAndPiaFieldTypeAndCreatedBy(shareInfoBean.getPinKey(), fieldTypeInfo, shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case PERSONAL_RELATIONSHIP:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdRelationshipInfoLinkJpaRepository.findPrlkFromPinKeyAndRelationType(shareInfoBean.getPinKey(),"Personal"));
			}
			if(dataRefKey.size()>0) {
				count = tIdRelationshipInfoAccessJpaRepository.getRiaPrlkKeyInAndRiaRelationTypeAndCreatedBy(dataRefKey, menuType, shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case PROFESSIONAL_RELATIONSHIP:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdRelationshipInfoLinkJpaRepository.findPrlkFromPinKeyAndRelationType(shareInfoBean.getPinKey(),"Professional"));
			}
			if(dataRefKey.size()>0) {
				count = tIdRelationshipInfoAccessJpaRepository.getRiaPrlkKeyInAndRiaRelationTypeAndCreatedBy(dataRefKey, menuType, shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case DISCUSSION_DETAILS:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdVisitInformationJpaRepository.findPivPinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count = tIdVisitInformationAccessJpaRepository.getPivKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case BUSINESS_POTENTIAL:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdBusinessPotentialInfoJpaRepository.findBpiPinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count = tIdBusinessPotentialInfoAccessJpaRepository.getBpiaBpiKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case ADD_POTENTIAL:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdAddPotentialServicesJpaRepository.findApsPinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count = tIdAddPotentialServicesAccessJpaRepository.getApsaApsKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case RECREATION:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdRecreationInfoJpaRepository.findReiPinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count = tIdRecreationInfoAccessJpaRepository.getRiaReiKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
			
		case PERSONAL_INTEREST:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdPersonalInterestsJpaRepository.findPeriPinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count = tIdPersonalInterestsAccessJpaRepository.getPiaPeriKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case PROFESSIONAL_INTEREST:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdProfessionalInterestsJpaRepository.findPriPinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count = tIdProfessionalInterestsAccessJpaRepository.getPiaPriKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case PERSONAL_PRIORITIES:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdPersonalPrioritiesJpaRepository.findPerpPinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count = tIdPersonalPrioritiesAccessJpaRepository.getPpaPerpKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case EXPERIENCE:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdExperienceInformationJpaRepository.findPexPinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count = tIdExperienceInformationAccessJpaRepository.getEiaPexKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case EDUCATION:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdEducationalInformationJpaRepository.findPeiPinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count = tIdEducationalInformationAccessJpaRepository.getEiaPeiKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case PROJ_EXECUTED:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdProjectsInformationJpaRepository.findPipPinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count = tIdProjectsInformationAccessJpaRepository.getPiaPipKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case PROF_EXPERTISE:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdProfessionalExpertiseJpaRepository.findPpePinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count = tIdProfessionalExpertiseAccessJpaRepository.getPeaPpeKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		case AWARDS_RECOG:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdAwardsInformationJpaRepository.findPiaPinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count  = tIdAwardsInformationAccessJpaRepository.getAiaPiaKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}				
			break;
			case ADD_INFORMATION:
			if(shareInfoBean.getDataRefKey()==null) {
				dataRefKey.clear();
				dataRefKey.addAll(tIdAdditionalInformationJpaRepository.findPiadPinKey(shareInfoBean.getPinKey()));
			}
			if(dataRefKey.size()>0) {
				count = tIdAdditionalInformationAccessJpaRepository.getAiaPiadKeyInAndCreatedBy(dataRefKey,shareInfoBean.getCreatedBy());
				if(count>0) {
					return true;
				}
			}
			break;
		}
		
		return false;
	}
	
	

	@Override
	public boolean chkShareInfoDtls(Long loginPinKey, Long propertyKey, Long propertyCreatedBy, Long contactPinKey, String menuType, String fieldType) {
		boolean boxPropertyAccessGranted = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, propertyCreatedBy, contactPinKey, menuType, fieldType);
		if(boxPropertyAccessGranted) {
			return true;
		}else {
			int  count = 0;
			switch(menuType) {
				case BUSINESS_POTENTIAL:
					count = tIdBusinessPotentialInfoAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					if(count>0) {
						return true;
					}else {
						count = tIdBusinessPotentialInfoAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						return count>0;
					}
				case ADD_POTENTIAL:
					 count = tIdAddPotentialServicesAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdAddPotentialServicesAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
				case HEADER_INFO:
					count = tIdPersonalInfoAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, fieldType, ONE_TO_ONE);
					if(count>0) {
						return true;
					} else {
						count = tIdPersonalInfoAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, fieldType, GROUP);
						if(count>0) {
							return true;
						}
					}
				case PERSONAL_INFO:
					count = tIdPersonalInfoAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, fieldType, ONE_TO_ONE);
					if(count>0) {
						return true;
					} else {
						count = tIdPersonalInfoAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, fieldType, GROUP);
						if(count>0) {
							return true;
						}
					}
				case PERSONAL_RELATIONSHIP:
					 count = tIdRelationshipInfoAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, menuType, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdRelationshipInfoAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, menuType, GROUP);
						 if(count>0) {
							 return true;
						 }
					 }
				case PROFESSIONAL_RELATIONSHIP:
					 count = tIdRelationshipInfoAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, menuType, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdRelationshipInfoAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, menuType, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
				case DISCUSSION_DETAILS:
					 count = tIdVisitInformationAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdVisitInformationAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
				case RECREATION:
					 count = tIdRecreationInfoAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdRecreationInfoAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
				case PERSONAL_INTEREST:
					 count = tIdPersonalInterestsAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdPersonalInterestsAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
					break;
				case PROFESSIONAL_INTEREST:
					 count = tIdProfessionalInterestsAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdProfessionalInterestsAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
					break;
				case PERSONAL_PRIORITIES:
					 count = tIdPersonalPrioritiesAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdPersonalPrioritiesAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
					break;
				case EXPERIENCE:
					 count = tIdExperienceInformationAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdExperienceInformationAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
					break;
				case EDUCATION:
					 count = tIdEducationalInformationAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdEducationalInformationAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
					break;
				case PROJ_EXECUTED:
					 count = tIdProjectsInformationAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdProjectsInformationAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
					break;
				case PROF_EXPERTISE:
					 count = tIdProfessionalExpertiseAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdProfessionalExpertiseAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
					break;
				case AWARDS_RECOG:
					 count = tIdAwardsInformationAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdAwardsInformationAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
					break;
				case ADD_INFORMATION:
					 count = tIdAdditionalInformationAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
					 if(count>0) {
						 return true;
					 }else {
						 count = tIdAdditionalInformationAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
						 if(count>0) {
							 return true;
						 }							 
					 }
			}
		}
		return false;
	}
	
	@Override
	public boolean chkShareInfoDtls(Long loginPinKey, Long propertyKey, Long contactPinKey, String menuType, String fieldType) {
		int count;
		boolean hasBoxAccess=false;
		switch(menuType) {
			case HEADER_INFO:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				count = tIdPersonalInfoAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, fieldType, ONE_TO_ONE);
				if(count>0) {
					return true;
				} else {
					count = tIdPersonalInfoAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, fieldType, GROUP);
					if(count>0) {
						return true;
					}
				}
				break;
			case PERSONAL_INFO:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				count = tIdPersonalInfoAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, fieldType, ONE_TO_ONE);
				if(count>0) {
					return true;
				} else {
					count = tIdPersonalInfoAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, fieldType, GROUP);
					if(count>0) {
						return true;
					}
				}
				break;	
			case PERSONAL_RELATIONSHIP:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdRelationshipInfoAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, menuType, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdRelationshipInfoAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, menuType, GROUP);
					 if(count>0) {
						 return true;
					 }
				 }
				break;
			case PROFESSIONAL_RELATIONSHIP:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdRelationshipInfoAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, menuType, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdRelationshipInfoAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, menuType, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case DISCUSSION_DETAILS:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdVisitInformationAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdVisitInformationAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case BUSINESS_POTENTIAL:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdBusinessPotentialInfoAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdBusinessPotentialInfoAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case ADD_POTENTIAL:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdAddPotentialServicesAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdAddPotentialServicesAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case RECREATION:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdRecreationInfoAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdRecreationInfoAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case PERSONAL_INTEREST:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdPersonalInterestsAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdPersonalInterestsAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case PROFESSIONAL_INTEREST:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdProfessionalInterestsAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdProfessionalInterestsAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case PERSONAL_PRIORITIES:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdPersonalPrioritiesAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdPersonalPrioritiesAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case EXPERIENCE:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdExperienceInformationAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdExperienceInformationAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case EDUCATION:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdEducationalInformationAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdEducationalInformationAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case PROJ_EXECUTED:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdProjectsInformationAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdProjectsInformationAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case PROF_EXPERTISE:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdProfessionalExpertiseAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdProfessionalExpertiseAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case AWARDS_RECOG:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdAwardsInformationAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdAwardsInformationAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
			case ADD_INFORMATION:
				hasBoxAccess = boxTypeAccessService.hasBoxAccess(loginPinKey, propertyKey, contactPinKey, menuType, fieldType);
				if(hasBoxAccess) {
					return true;
				}
				 count = tIdAdditionalInformationAccessJpaRepository.getOneToOneCount(loginPinKey,propertyKey, ONE_TO_ONE);
				 if(count>0) {
					 return true;
				 }else {
					 count = tIdAdditionalInformationAccessJpaRepository.getGroupCount(loginPinKey,propertyKey, GROUP);
					 if(count>0) {
						 return true;
					 }							 
				 }
				break;
					
			}
		return false;
	}
	
	@Override
	public boolean shareInfoValid(ShareInfoBean shareInfoBean) {
		boolean fullShare = ALL.equals(shareInfoBean.getMenuType());
		boolean boxShare = false;
		boolean propertyShare = false;
		shareInfoBean.setFullShare(fullShare);
		if(fullShare){
			MENU_TYPE_LIST.forEach(menuType ->  retrieveShareInfoWizard(menuType, shareInfoBean.getFieldType(), shareInfoBean));
			HEADER_LIST.forEach(fieldType ->   retrieveShareInfoWizard(HEADER_INFO, fieldType, shareInfoBean));
		}else {
			if (shareInfoBean.getDataRefKey()==null) {
				boxShare = true;
				shareInfoBean.setBoxShare(boxShare);
			}else {
				propertyShare = true;
				shareInfoBean.setPropertyShare(propertyShare);
			}
			if(PHONE_NO.equals(shareInfoBean.getMenuType())) {
				retrieveShareInfoWizard(HEADER_INFO, LANDLINE_NUMBER, shareInfoBean);
				retrieveShareInfoWizard(HEADER_INFO, MOBILE_NUMBER, shareInfoBean);
			} else {
				retrieveShareInfoWizard(shareInfoBean.getMenuType(),shareInfoBean.getFieldType(), shareInfoBean);
			}
		}
		if(shareInfoBean.isRecall() || propertyShare) {
			Set<SelectListBean> recallInfoBeanList = new HashSet<SelectListBean>();
			recallInfoBeanList.addAll(getProfileDtls(shareInfoBean.getOneToOneList(), ONE_TO_ONE));
			recallInfoBeanList.addAll(getProfileDtls(shareInfoBean.getBoxOneToOneList(), ONE_TO_ONE));
			recallInfoBeanList.addAll(getProfileDtls(shareInfoBean.getFullOneToOneList(), ONE_TO_ONE));
			recallInfoBeanList.addAll(getGroupDtls(shareInfoBean.getGroupList(), GROUP));
			recallInfoBeanList.addAll(getGroupDtls(shareInfoBean.getBoxGroupList(), GROUP));
			recallInfoBeanList.addAll(getGroupDtls(shareInfoBean.getFullGroupList(), GROUP));
			shareInfoBean.setRecallList(recallInfoBeanList);
			return recallInfoBeanList.size()>0;
		}else {
			if(boxShare) {
				Set<SelectListBean> boxRecallInfoBeanList = new HashSet<SelectListBean>();
				boxRecallInfoBeanList.addAll(getProfileDtls(shareInfoBean.getBoxOneToOneList(), ONE_TO_ONE));
				boxRecallInfoBeanList.addAll(getGroupDtls(shareInfoBean.getBoxGroupList(), GROUP));
				shareInfoBean.setRecallList(boxRecallInfoBeanList);
				return boxRecallInfoBeanList.size()>0;
			}else {//fullshare
				Set<SelectListBean> alreadySharedKeys = new HashSet<SelectListBean>();
				if(shareInfoBean.getFullOneToOneList().size()>0) {
					List<Long> fillteredSharedOneToOnePinKeys = new ArrayList<Long>(); 
					for(Long pinKey: shareInfoBean.getFullOneToOneList()) {
						int count = tIdBoxTypeAccessJpaRepository.getBoxShareCount(pinKey,shareInfoBean.getPinKey(),ONE_TO_ONE);
						if(count>21) {//If All Boxes are shared then its full share
							fillteredSharedOneToOnePinKeys.add(pinKey);
						}
					}
					alreadySharedKeys.addAll(getProfileDtls(fillteredSharedOneToOnePinKeys, ONE_TO_ONE));
				}
				if(shareInfoBean.getFullGroupList().size()>0) {
					List<Long> filteredSharedGroupKeys = new ArrayList<Long>();
					for(Long pinKey: shareInfoBean.getFullGroupList()) {
						int count = tIdBoxTypeAccessJpaRepository.getBoxShareCount(pinKey,shareInfoBean.getPinKey(),GROUP);
						if(count>21) {//If All Boxes are shared then its full share
							filteredSharedGroupKeys.add(pinKey);
						}
					}
					alreadySharedKeys.addAll(getGroupDtls(filteredSharedGroupKeys, GROUP));
				}
				shareInfoBean.setRecallList(alreadySharedKeys);
				return alreadySharedKeys.size()>0;
			}
		}
	}
	
	public List<SelectListBean> getGroupDtls(List<Long> groupList, String shareType) {
		List<SelectListBean> selectListBeanList = new ArrayList<SelectListBean>();
		if(groupList.size()>0) {
			selectListBeanList = tIdGroupHeaderJpaRepository.getGroupDtls(groupList);
			selectListBeanList.stream().forEach(f->f.setCode(shareType));
		}
		return selectListBeanList;
	}
	
	public Set<SelectListBean> getProfileDtls(List<Long> profileList, String shareType) {
		Set<SelectListBean> recallInfoBeanList = new HashSet<SelectListBean>();
		if(profileList.size()>0) {
			SelectListBean selectListBean = null;
			List<PersonIndividualExperienceViewEntity> personIndividualExperienceViewEntityList = (List<PersonIndividualExperienceViewEntity>)
					personIndividualExperienceViewJpaRepository.findByPinKeyIn(profileList);
			String lastName, designation,  functionArea, role, company;
			for(PersonIndividualExperienceViewEntity PersonIndividualExperienceViewEntity : personIndividualExperienceViewEntityList) {
				selectListBean = new SelectListBean();
				selectListBean.setId(PersonIndividualExperienceViewEntity.getPinKey());
				selectListBean.setCode(shareType);
				
				lastName = PersonIndividualExperienceViewEntity.getPinLastName()!=null?" "+PersonIndividualExperienceViewEntity.getPinLastName():"";
				designation = PersonIndividualExperienceViewEntity.getDesignation()!=null?" - "+PersonIndividualExperienceViewEntity.getDesignation():"";
				functionArea = PersonIndividualExperienceViewEntity.getFunctionalArea()!=null?" - "+PersonIndividualExperienceViewEntity.getFunctionalArea():"";
				role = PersonIndividualExperienceViewEntity.getRole()!=null?" - "+PersonIndividualExperienceViewEntity.getRole():"";
				company = PersonIndividualExperienceViewEntity.getCompany()!=null?" - "+PersonIndividualExperienceViewEntity.getCompany():"";
				
				selectListBean.setName(PersonIndividualExperienceViewEntity.getPinFirstName()+lastName+designation+functionArea+role+company);
				recallInfoBeanList.add(selectListBean);
			}
		}
		return recallInfoBeanList;
	}
	
	public void retrieveShareInfoWizard(String menuType, String fieldType, ShareInfoBean shareInfoBean) {
		if(HEADER_INFO.equals(menuType)) {
			boxTypeAccessService.checkBoxAccess(HEADER_INFO, shareInfoBean, fieldType);
			List<TIdPersonalInfoAccessEntity> tIdPersonalInfoAccessEntityList = tIdPersonalInfoAccessJpaRepository.findByPiaPinKeyAndPiaFieldTypeAndCreatedBy(shareInfoBean.getPinKey(), fieldType, shareInfoBean.getCreatedBy());
			tIdPersonalInfoAccessEntityList.forEach(tIdPersonalInfoAccessEntity -> checkAccessInfoList(tIdPersonalInfoAccessEntity.getPiaShareType(),tIdPersonalInfoAccessEntity.getPiaAccessInfo(),shareInfoBean));
		}else if(PERSONAL_INFO.equals(menuType)) {
			List<String> filedTypeList = new ArrayList<String>();
			if("".equals(fieldType)) {
				filedTypeList.addAll(PERSONAL_INFO_TYPE_LIST);
			} else {
				filedTypeList.add(fieldType);
			}
			filedTypeList.forEach(fieldTypeInfo ->{
				boxTypeAccessService.checkBoxAccess(PERSONAL_INFO,  shareInfoBean, fieldTypeInfo);
				List<TIdPersonalInfoAccessEntity>  tIdPersonalInfoAccessEntityList = tIdPersonalInfoAccessJpaRepository.findByPiaPinKeyAndPiaFieldTypeAndCreatedBy(shareInfoBean.getPinKey(), fieldTypeInfo, shareInfoBean.getCreatedBy());
				tIdPersonalInfoAccessEntityList.forEach(tIdPersonalInfoAccessEntity -> {
					checkAccessInfoList(tIdPersonalInfoAccessEntity.getPiaShareType(),tIdPersonalInfoAccessEntity.getPiaAccessInfo(),shareInfoBean);
				});
			});
		}else {
			List<Long> sharedOneToOnePinKeys =  tIdBoxTypeAccessJpaRepository.getBoxShareCount(menuType, shareInfoBean.getPinKey(),ONE_TO_ONE);
			List<Long> sharedGroupKeys =  tIdBoxTypeAccessJpaRepository.getBoxShareCount(menuType, shareInfoBean.getPinKey(),GROUP);
			if(ALL.equals(shareInfoBean.getMenuType())){
				shareInfoBean.getFullOneToOneList().addAll(sharedOneToOnePinKeys);
				shareInfoBean.getFullGroupList().addAll(sharedGroupKeys);
			}else {//Not  Full Share
				if(shareInfoBean.getDataRefKey()==null) {
					shareInfoBean.getBoxOneToOneList().addAll(sharedOneToOnePinKeys);
					shareInfoBean.getBoxGroupList().addAll(sharedGroupKeys);
				} 
			}
			checkAccessInfoList(sharedOneToOnePinKeys.size()>0 || sharedGroupKeys.size()>0,  menuType, shareInfoBean);
		}
	}
		
	/**
	 * This method will return all Property Keys  of the Given Pin Keys (Created by This User, Created by another user)
	 * @param menuType
	 * @param pinKey
	 * @return
	 */
	private List<Long> getDataRefKeys(String menuType, Long pinKey) {
		List<Long> dataRefKeys = new ArrayList<>();
		switch(menuType) {
			case PERSONAL_RELATIONSHIP:
				dataRefKeys.addAll(tIdRelationshipInfoLinkJpaRepository.findPrlkFromPinKeyAndRelationType(pinKey,"Personal"));
				break;
			case PROFESSIONAL_RELATIONSHIP:
				dataRefKeys.addAll(tIdRelationshipInfoLinkJpaRepository.findPrlkFromPinKeyAndRelationType(pinKey,"Professional"));
				break;
			case DISCUSSION_DETAILS://1
				dataRefKeys.addAll(tIdVisitInformationJpaRepository.findPivPinKey(pinKey));
				break;
			case BUSINESS_POTENTIAL://2
				dataRefKeys.addAll(tIdBusinessPotentialInfoJpaRepository.findBpiPinKey(pinKey));
				break;
			case ADD_POTENTIAL://3
				dataRefKeys.addAll(tIdAddPotentialServicesJpaRepository.findApsPinKey(pinKey));
				break;
			case RECREATION://4
				dataRefKeys.addAll(tIdRecreationInfoJpaRepository.findReiPinKey(pinKey));
				break;
			case PROFESSIONAL_INTEREST://6
				dataRefKeys.addAll(tIdProfessionalInterestsJpaRepository.findPriPinKey(pinKey));
				break;
			case PERSONAL_INTEREST://7
				dataRefKeys.addAll(tIdPersonalInterestsJpaRepository.findPeriPinKey(pinKey));
				break;
			case PERSONAL_PRIORITIES://8
				dataRefKeys.addAll(tIdPersonalPrioritiesJpaRepository.findPerpPinKey(pinKey));
				break;
			case EXPERIENCE://9
				dataRefKeys.addAll(tIdExperienceInformationJpaRepository.findPexPinKey(pinKey));
				break;
			case EDUCATION://10
				dataRefKeys.addAll(tIdEducationalInformationJpaRepository.findPeiPinKey(pinKey));
				break;
			case PROJ_EXECUTED://11
				dataRefKeys.addAll(tIdProjectsInformationJpaRepository.findPipPinKey(pinKey));
				break;
			case PROF_EXPERTISE://12
				dataRefKeys.addAll(tIdProfessionalExpertiseJpaRepository.findPpePinKey(pinKey));
				break;
			case AWARDS_RECOG://13
				dataRefKeys.addAll(tIdAwardsInformationJpaRepository.findPiaPinKey(pinKey));
				break;
			case ADD_INFORMATION://14
				dataRefKeys.addAll(tIdAdditionalInformationJpaRepository.findPiadPinKey(pinKey));
				break;
			}
			return dataRefKeys;
		}
	
	public void checkAccessInfoList(boolean hasBoxAccess, String menuType, ShareInfoBean shareInfoBean) {
		List<Long> dataRefKeys = new ArrayList<>();
		if(shareInfoBean.getDataRefKey()!=null) {
			dataRefKeys.add(shareInfoBean.getDataRefKey());
		}else {
			dataRefKeys = getDataRefKeys(menuType, shareInfoBean.getPinKey());
		}
		for(Long key : dataRefKeys) {
			if(hasBoxAccess) {
				boxTypeAccessService.checkBoxAccess(menuType, shareInfoBean, key);
			}
			switch (menuType) {
				case PERSONAL_RELATIONSHIP:
					List<TIdRelationshipInfoAccessEntity> tIdPersonalRelationshipInfoAccessEntityList = tIdRelationshipInfoAccessJpaRepository.findByRiaPrlkKeyAndRiaRelationTypeAndCreatedBy(key, menuType, shareInfoBean.getCreatedBy());
					tIdPersonalRelationshipInfoAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getRiaShareType(),dataAccessGranted.getRiaAccessInfo(),shareInfoBean));
					break;
				case PROFESSIONAL_RELATIONSHIP:
					List<TIdRelationshipInfoAccessEntity> tIdProfessionalRelationshipInfoAccessEntityList = tIdRelationshipInfoAccessJpaRepository.findByRiaPrlkKeyAndRiaRelationTypeAndCreatedBy(key, menuType, shareInfoBean.getCreatedBy());
					tIdProfessionalRelationshipInfoAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getRiaShareType(),dataAccessGranted.getRiaAccessInfo(),shareInfoBean));
					break;
				case DISCUSSION_DETAILS://1
					List<TIdVisitInformationAccessEntity> tIdVisitInformationAccessEntityList = tIdVisitInformationAccessJpaRepository.findByViaPivKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdVisitInformationAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getViaAccessInfo(),shareInfoBean));
					break;
				case BUSINESS_POTENTIAL://2
					List<TIdBusinessPotentialInfoAccessEntity> tIdBusinessPotentialInfoAccessEntityList = tIdBusinessPotentialInfoAccessJpaRepository.findByBpiaBpiKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdBusinessPotentialInfoAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getBpiaAccessInfo(),shareInfoBean));
					break;
				case ADD_POTENTIAL://3
					List<TIdAddPotentialServicesAccessEntity> tIdAddPotentialServicesAccessEntityList = tIdAddPotentialServicesAccessJpaRepository.findByApsaApsKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdAddPotentialServicesAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getApsaAccessInfo(),shareInfoBean));
					break;
				case RECREATION://4
					List<TIdRecreationInfoAccessEntity> tIdRecreationInfoAccessEntityList = tIdRecreationInfoAccessJpaRepository.findByRiaReiKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdRecreationInfoAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getRiaAccessInfo(),shareInfoBean));
					break;
				case PROFESSIONAL_INTEREST://6
					List<TIdProfessionalInterestsAccessEntity> tIdProfessionalInterestsAccessEntityList = tIdProfessionalInterestsAccessJpaRepository.findByPiaPriKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdProfessionalInterestsAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getPiaAccessInfo(),shareInfoBean));
					break;
				case PERSONAL_INTEREST://7
					List<TIdPersonalInterestsAccessEntity> tIdPersonalInterestsAccessEntityList = tIdPersonalInterestsAccessJpaRepository.findByPiaPeriKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdPersonalInterestsAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getPiaAccessInfo(),shareInfoBean));
					break;
				case PERSONAL_PRIORITIES://8
					List<TIdPersonalPrioritiesAccessEntity> tIdPersonalPrioritiesAccessEntityList = tIdPersonalPrioritiesAccessJpaRepository.findByPpaPerpKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdPersonalPrioritiesAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getPpaAccessInfo(),shareInfoBean));
					break;
				case EXPERIENCE://9
					List<TIdExperienceInformationAccessEntity> tIdExperienceInformationAccessEntityList = tIdExperienceInformationAccessJpaRepository.findByEiaPexKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdExperienceInformationAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getEiaAccessInfo(),shareInfoBean));
					break;
				case EDUCATION://11
					List<TIdEducationalInformationAccessEntity> tIdEducationalInformationAccessEntityList = tIdEducationalInformationAccessJpaRepository.findByEiaPeiKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdEducationalInformationAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getEiaAccessInfo(),shareInfoBean));
					break;
				case PROJ_EXECUTED://11
					List<TIdProjectsInformationAccessEntity> tIdProjectsInformationAccessEntityList = tIdProjectsInformationAccessJpaRepository.findByPiaPipKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdProjectsInformationAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getPiaAccessInfo(),shareInfoBean));
					break;
				case PROF_EXPERTISE:
					List<TIdProfessionalExpertiseAccessEntity> tIdProfessionalExpertiseAccessEntityList = tIdProfessionalExpertiseAccessJpaRepository.findByPeaPpeKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdProfessionalExpertiseAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getPeaAccessInfo(),shareInfoBean));
					break;
				case AWARDS_RECOG:
					List<TIdAwardsInformationAccessEntity> tIdAwardsInformationAccessEntityList = tIdAwardsInformationAccessJpaRepository.findByAiaPiaKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdAwardsInformationAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getAiaAccessInfo(),shareInfoBean));
					break;
				case ADD_INFORMATION:
					List<TIdAdditionalInformationAccessEntity> tIdAdditionalInformationAccessEntityList = tIdAdditionalInformationAccessJpaRepository.findByAiaPiadKeyAndCreatedBy(key,shareInfoBean.getCreatedBy());
					tIdAdditionalInformationAccessEntityList.forEach(dataAccessGranted-> checkAccessInfoList(dataAccessGranted.getShareType(),dataAccessGranted.getAiaAccessInfo(),shareInfoBean));
					break;
			}
		}
	}
	
	public void checkAccessInfoList(String shareType, String accessInfo,ShareInfoBean shareInfoBean) {
		if(accessInfo!=null && !accessInfo.trim().isEmpty()) {
			List<Long> listOfValues = Arrays.asList(accessInfo.replace("\"", "").split(","))
							.stream().map(s -> Long.valueOf(s.trim())).collect(Collectors.toList());
			if(listOfValues.size()>0) {
				 if(ONE_TO_ONE.equals(shareType)) {
					 shareInfoBean.getOneToOneList().addAll(listOfValues);
				 }  else if(GROUP.equals(shareType)) {
					 shareInfoBean.getGroupList().addAll(listOfValues);
				 }
			} 	
		}
	}

	@Override
	public List<SelectListBean> getCreatorName() {
		return personIndividualExperienceViewJpaRepository.getCustInfo();
	}

	@Override
	public SelectListBean findCreator(Long pinKey) {
		String lastName, designation,  functionArea, role, company;
		PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(pinKey);
		SelectListBean selectListBean = new SelectListBean();
		selectListBean.setId(personIndividualExperienceViewEntity.getPinKey());
		
		if(personIndividualExperienceViewEntity.getPinCreatorKey()!=null && personIndividualExperienceViewEntity.getPinCreatorKey()!=0) {
			personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(personIndividualExperienceViewEntity.getPinCreatorKey());
		}
		
		lastName = personIndividualExperienceViewEntity.getPinLastName()!=null?" "+personIndividualExperienceViewEntity.getPinLastName():"";
		designation = personIndividualExperienceViewEntity.getDesignation()!=null?" - "+personIndividualExperienceViewEntity.getDesignation():"";
		functionArea = personIndividualExperienceViewEntity.getFunctionalArea()!=null?" - "+personIndividualExperienceViewEntity.getFunctionalArea():"";
		role = personIndividualExperienceViewEntity.getRole()!=null?" - "+personIndividualExperienceViewEntity.getRole():"";
		company = personIndividualExperienceViewEntity.getCompany()!=null?" - "+personIndividualExperienceViewEntity.getCompany():"";

		selectListBean.setCode(personIndividualExperienceViewEntity.getPinKey().toString());
		selectListBean.setName(personIndividualExperienceViewEntity.getPinFirstName()+lastName+designation+functionArea+role+company);
		
		return selectListBean;
	}

	@Override
	public String saveShareNotification(TIdLandingNotification tIdLandingNotification) {
		
		if(tIdLandingNotification.getLdAppRejFlag()==2){
			
			tIdLandingNotificationJpaRepository.updateAppRejectFlag(tIdLandingNotification.getLdAppRejFlag(), tIdLandingNotification.getLdKey());
		} else {
		
			TIdLandingNotificationEntity tIdLandingNotificationEntity = new TIdLandingNotificationEntity();
			tIdLandingNotificationEntity.setLdUserPinKey(tIdLandingNotification.getLdUserPinKey());
			PersonIndividualExperienceViewEntity personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(tIdLandingNotification.getLdUserPinKey());
			if(personIndividualExperienceViewEntity != null) {
				tIdLandingNotificationEntity.setLdUserTitle(tIdReferenceCodesDetailJpaRepository.getTitleValue(Long.valueOf(personIndividualExperienceViewEntity.getPinTitle())));
				tIdLandingNotificationEntity.setLdUserName(personIndividualExperienceViewEntity.getPinFirstName()+" "+personIndividualExperienceViewEntity.getPinLastName());
			}
			tIdLandingNotificationEntity.setLdContactPinKey(tIdLandingNotification.getLdContactPinKey());
			personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(tIdLandingNotification.getLdContactPinKey());
			if(personIndividualExperienceViewEntity != null) {
				tIdLandingNotificationEntity.setLdContactTitle(tIdReferenceCodesDetailJpaRepository.getTitleValue(Long.valueOf(personIndividualExperienceViewEntity.getPinTitle())));
				tIdLandingNotificationEntity.setLdContactName(personIndividualExperienceViewEntity.getPinFirstName()+" "+personIndividualExperienceViewEntity.getPinLastName());
				tIdLandingNotificationEntity.setLdCompany(personIndividualExperienceViewEntity.getCompany());
				tIdLandingNotificationEntity.setLdIndustry(tIdCompanyIndustryLinkViewJpaRepository.getName(personIndividualExperienceViewEntity.getPexKey()));
				tIdLandingNotificationEntity.setLdCountry(personIndividualExperienceViewEntity.getPinCountryName());
			}
			tIdLandingNotificationEntity.setLdBoxName(tIdLandingNotification.getLdBoxName());
			tIdLandingNotificationEntity.setLdFieldName(tIdLandingNotification.getLdFieldName());
			
			if(tIdLandingNotification.getLdAppRejFlag()==0) {
				tIdLandingNotificationEntity.setLdLatestUpdate("View Request, click here to Approve/Reject");
				tIdLandingNotificationEntity.setLdAppRejFlag(0L);
			} else if(tIdLandingNotification.getLdAppRejFlag()==1) {
				
				tIdLandingNotificationJpaRepository.updateAppRejectFlag(tIdLandingNotification.getLdAppRejFlag(), tIdLandingNotification.getLdKey());
				
				tIdLandingNotificationEntity.setLdLatestUpdate("View Request Approved");	
				tIdLandingNotificationEntity.setLdAppRejFlag(1L);
				
				ShareInfoBean shareInfoBean = new ShareInfoBean();
				shareInfoBean.setMenuType(tIdLandingNotification.getLdBoxName());
				shareInfoBean.setFieldType(tIdLandingNotification.getLdFieldName());
				shareInfoBean.setPinKey(tIdLandingNotification.getLdContactPinKey());
				shareInfoBean.setShareType(ONE_TO_ONE);
				shareInfoBean.setAccessType(VIEW);
				shareInfoBean.setDataRefKey(tIdLandingNotification.getLdUpdateKey());
				shareInfoBean.setAccessInfo(tIdLandingNotification.getLdToPinKey().toString());
				shareInfoBean.setCreatedBy(tIdLandingNotification.getLdUserPinKey());
				shareInfoBean.setApprove(true);
				saveShareInfoDtls(shareInfoBean);
			}
			
			tIdLandingNotificationEntity.setLdUpdateKey(tIdLandingNotification.getLdUpdateKey());
			tIdLandingNotificationEntity.setLdToPinKey(tIdLandingNotification.getLdToPinKey());
			personIndividualExperienceViewEntity = personIndividualExperienceViewJpaRepository.findOne(tIdLandingNotification.getLdToPinKey());
			if(personIndividualExperienceViewEntity != null) {
				tIdLandingNotificationEntity.setLdToTitle(tIdReferenceCodesDetailJpaRepository.getTitleValue(Long.valueOf(personIndividualExperienceViewEntity.getPinTitle())));
				tIdLandingNotificationEntity.setLdToName(personIndividualExperienceViewEntity.getPinFirstName()+" "+personIndividualExperienceViewEntity.getPinLastName());
			}
			tIdLandingNotificationEntity.setLdReadFlag(false);
			tIdLandingNotificationEntity.setLockKey(1L);
			tIdLandingNotificationEntity.setProfileKey(1L);
			tIdLandingNotificationEntity.setCreatedOn(new Date());
			tIdLandingNotificationEntity.setLdRequest(false);
			tIdLandingNotificationJpaRepository.save(tIdLandingNotificationEntity);		
		}
		return "Success";
	}
	
	
	
}
