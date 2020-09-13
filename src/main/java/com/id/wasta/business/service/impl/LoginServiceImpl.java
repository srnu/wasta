package com.id.wasta.business.service.impl;



import static com.id.wasta.util.action.CommonConstants.ACTIVE_STATUS;
import static com.id.wasta.util.action.CommonConstants.CHANGE_DEFAULT_PASSWORD;
import static com.id.wasta.util.action.CommonConstants.LINK_ALREADY_USED;
import static com.id.wasta.util.action.CommonConstants.LINK_EXPIRY;
import static com.id.wasta.util.action.CommonConstants.LINK_SUCCESS;
import static com.id.wasta.util.action.CommonConstants.PASSWORDRESET;
import static com.id.wasta.util.action.CommonConstants.PASSWORD_URL_EXPIRY_HRS;
import static com.id.wasta.util.action.CommonConstants.PWDUPDATENOTIFICATION;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.WordUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.util.business.service.mapping.GenericServiceMapper;
import com.id.wasta.bean.TIdUserMaster;
import com.id.wasta.bean.jpa.TIdCommonAddressesEntity;
import com.id.wasta.bean.jpa.TIdEtUserPasswordResetLinkEntity;
import com.id.wasta.bean.jpa.TIdLoginHistoryEntity;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntity;
import com.id.wasta.bean.jpa.TIdUserCategoryLinkEntity;
import com.id.wasta.bean.jpa.TIdUserMasterEntity;
import com.id.wasta.business.service.LoginService;
import com.id.wasta.data.repository.jpa.TIdCityMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCommonAddressesJpaRepository;
import com.id.wasta.data.repository.jpa.TIdCountryMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEtUserPasswordHistoryJpaRepository;
import com.id.wasta.data.repository.jpa.TIdEtUserPasswordResetLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdLoginHistoryJpaRepository;
import com.id.wasta.data.repository.jpa.TIdPersonalInformationJpaRepository;
import com.id.wasta.data.repository.jpa.TIdStateMasterJpaRepository;
import com.id.wasta.data.repository.jpa.TIdTemplateMasterRepository;
import com.id.wasta.data.repository.jpa.TIdUserCategoryLinkJpaRepository;
import com.id.wasta.data.repository.jpa.TIdUserMasterJpaRepository;
import com.id.wasta.exception.HandledException;

/**
 * Implementation of TIdUserMasterService
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger=Logger.getLogger(LoginService.class);

	@Resource
	private TIdUserMasterJpaRepository tIdUserMasterJpaRepository;
	
	@Resource
	private TIdPersonalInformationJpaRepository tIdPersonalInformationJpaRepository;
	
	@Resource
	private TIdUserCategoryLinkJpaRepository tIdUserCategoryLinkJpaRepository;
	
	@Resource
	private TIdTemplateMasterRepository tIdTemplateMasterRepository;
	
	@Resource
	private TIdCountryMasterJpaRepository tIdCountryMasterJpaRepository;
	
	@Resource
	private TIdStateMasterJpaRepository tIdStateMasterJpaRepository;
	
	@Resource
	private TIdCityMasterJpaRepository tIdCityMasterJpaRepository;

	
	@Value("${domain.url}")
	private String domainUrl;
	
	@Value("${companyName}")
	private String companyName;
	
	@Value("${fromEmail}")
	private String fromEmail;
	
	@Autowired
	private com.id.wasta.business.service.TemplateService templateService;
	
	@Resource
	private TIdEtUserPasswordResetLinkJpaRepository tIdEtUserPasswordResetLinkJpaRepository;
	
	@Resource
	private TIdEtUserPasswordHistoryJpaRepository tIdEtUserPasswordHistoryJpaRepository;
	
	@Resource
	private TIdLoginHistoryJpaRepository tIdLoginHistoryJpaRepository;
	
	@Resource
	private TIdCommonAddressesJpaRepository tIdCommonAddressesJpaRepository;
	
	@Resource
	private GenericServiceMapper genericServiceMapper;	
	
	@Override
	public TIdUserMasterEntity checkValidate(TIdUserMaster tIdUserMaster) throws Exception { 
		String pass = md5Algo(tIdUserMaster.getUserPassword());
		List<TIdUserCategoryLinkEntity> tidUserCategoryLinkEntitylist=null;
		List<Long> categoryIds=new ArrayList<Long>();
		String userDob="", defaultPassword="",encodePassword="";
		logger.info("User Trying to Logn -->"+tIdUserMaster.getUserCode());
		TIdUserMasterEntity tIdUserMasterEntity = tIdUserMasterJpaRepository.findByUserCode(tIdUserMaster.getUserCode());
		
		if(tIdUserMasterEntity!=null) {
			
			if((tIdUserMaster.getUserEmail()==null || tIdUserMaster.getUserEmail().isEmpty()) 
				&& tIdUserMasterEntity.getActiveStatus()==0) {
				logger.info("Your account is not active==>"+tIdUserMaster.getUserEmail());
				logger.info("Your account is not active==>"+tIdUserMaster.getActiveStatus());
				throw new HandledException ("Your account is not active, please use verification link");
			}
			
			SimpleDateFormat sdfDestination = new SimpleDateFormat("ddyyyy");
			userDob = sdfDestination.format(tIdUserMasterEntity.getUserDateOfBirth());
			if(tIdUserMasterEntity.getUserFirstName().length()>3) {
				defaultPassword=WordUtils.capitalizeFully(tIdUserMasterEntity.getUserFirstName().substring(0, 4))+userDob;
			} else {
				defaultPassword=WordUtils.capitalizeFully(tIdUserMasterEntity.getUserFirstName())+userDob;
			}
			encodePassword=md5Algo(defaultPassword);
			//logger.info("Encoded Default Password ==>"+encodePassword);
			//logger.info("User Entered Password ==>"+pass);
			
			if(encodePassword.equals(pass) && !tIdUserMasterEntity.getUserPasswordModified().equals("L")){
				logger.info("Default Password not changed ==>"+tIdUserMaster.getActiveStatus());
				logger.info("Default Password not changed ==>"+tIdUserMaster.getUserPasswordModified());
				throw new HandledException("Please change your default password");
			}
			
			/*
			 * if(!encodePassword.equals(pass) ||
			 * tIdUserMasterEntity.getUserPasswordModified().equals("L")) {
			 */
			logger.info("Database sstored Password ==>"+tIdUserMasterEntity.getUserPassword());

			    if(pass.equals(tIdUserMasterEntity.getUserPassword())) {	
			    	logger.info("Password matched");

					if(tIdUserMasterEntity.getUserLockCount()>2) {
						logger.info("Lock count >2");
						throw new HandledException("Your account is locked.Please set the new password by clicking the forget password button");
					}
					
					//else if(tIdUserMasterEntity.getUserLockCount()>0) {
						tIdUserMasterJpaRepository.updateActiveStatusAndLockCount(tIdUserMaster.getUserCode(),1L,0L);
						logger.info("Cleaared lock count on successful login");
					//}
					
				} else {
					tIdUserMasterJpaRepository.updateLockCount(tIdUserMaster.getUserCode(),tIdUserMasterEntity.getUserLockCount()+1);
					logger.info("Incremented lock count on login failure");
					if(tIdUserMasterEntity.getUserLockCount()>=2) {
						throw new HandledException("Your account is locked.Please set the new password by clicking the forget password button");
					}
					
					throw new HandledException ("Invalid login credential");
				}
			/*
			 * } else { throw new HandledException("Please change you default password"); }
			 */
		} else {
			logger.info("User Data not Found in Database -->"+tIdUserMaster.getUserCode());
		    throw new HandledException ("Invalid login credential");
		}
		
		TIdLoginHistoryEntity logoutInfoEntity = tIdLoginHistoryJpaRepository.findLogoutInfo(tIdUserMaster.getUserCode());
		
		if(logoutInfoEntity!=null) {
			tIdUserMasterEntity.setLastLogoutTime(logoutInfoEntity.getLhLogoutTime());
		}
		
		//Login time saving into login_history table
		TIdLoginHistoryEntity tIdLoginHistoryEntity = new TIdLoginHistoryEntity();
		tIdLoginHistoryEntity.setLhUserCode(tIdUserMaster.getUserCode());
		tIdLoginHistoryEntity.setLhLoginTime(new Date());
		tIdLoginHistoryJpaRepository.save(tIdLoginHistoryEntity);

		if(tIdUserMasterEntity.getOnBehalfOf()!=null && tIdUserMasterEntity.getOnBehalfOf()!=0) {
			 tIdUserMasterEntity = tIdUserMasterJpaRepository.findOne(tIdUserMasterEntity.getOnBehalfOf());
		}
		
		if(tIdUserMasterEntity!=null) {
			tIdUserMasterEntity.setCustomerPinKey(tIdUserMasterEntity.getUserPinKey());
			tidUserCategoryLinkEntitylist=tIdUserCategoryLinkJpaRepository.findByUsclUserKey(tIdUserMasterEntity.getUserKey());
			for(TIdUserCategoryLinkEntity TIdUserCategoryLinkEntity:tidUserCategoryLinkEntitylist){
				categoryIds.add(TIdUserCategoryLinkEntity.getUsclCamKey());
			}
			tIdUserMasterEntity.setCustCategoryList(categoryIds);
		}
		TIdCommonAddressesEntity tIdCommonAddressesEntity = null;
		if(tIdUserMasterEntity!=null && tIdUserMasterEntity.getUserAddressLink()!=null) {
			tIdCommonAddressesEntity = tIdCommonAddressesJpaRepository.findByCommAddressKey(tIdUserMasterEntity.getUserAddressLink());
		}
		if(tIdCommonAddressesEntity != null) {
			tIdUserMasterEntity.setCommPhone(tIdCommonAddressesEntity.getCommPhone());
			tIdUserMasterEntity.setCommMobile(tIdCommonAddressesEntity.getCommMobile());
			tIdUserMasterEntity.setCommEmail(tIdCommonAddressesEntity.getCommEmail());
			tIdUserMasterEntity.setCommCountryKey(tIdCommonAddressesEntity.getCommCountryKey());
			if(tIdCommonAddressesEntity.getCommCountryKey()!=null) {
				tIdUserMasterEntity.setCommCountryName(tIdCountryMasterJpaRepository.getCountryName(tIdCommonAddressesEntity.getCommCountryKey()));
			}			
			tIdUserMasterEntity.setCommStateKey(tIdCommonAddressesEntity.getCommStateKey());
			if(tIdCommonAddressesEntity.getCommStateKey() != null) {
				tIdUserMasterEntity.setCommStateName(tIdStateMasterJpaRepository.getStateName(tIdCommonAddressesEntity.getCommStateKey()));
			}
			tIdUserMasterEntity.setCommCityKey(tIdCommonAddressesEntity.getCommCityKey());
			if(tIdCommonAddressesEntity.getCommCityKey() != null) {
				tIdUserMasterEntity.setCommCityName(tIdCityMasterJpaRepository.getCityName(tIdCommonAddressesEntity.getCommCityKey()));
			}
		}
		
		if("moderator".equals(tIdUserMaster.getUserCode())) {
			tIdUserMasterEntity.setAdminRole(true);
		}
		return tIdUserMasterEntity;
	}
	
	//Logout time saving into login_history table
	@Override
	public void logoutInfo(String userCode) {
		TIdLoginHistoryEntity tIdLoginHistoryEntity = tIdLoginHistoryJpaRepository.findLoginInfo(userCode);
		if(tIdLoginHistoryEntity!=null) {
			tIdLoginHistoryEntity.setLhLogoutTime(new Date());
			tIdLoginHistoryJpaRepository.save(tIdLoginHistoryEntity);
		}
	}

	public String md5Algo(String password) throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
	 }
	 
	@Override
	public String sendPasswordResetLink(String userEmail) {
		TIdEtUserPasswordResetLinkEntity tIdEtUserPasswordResetLinkEntity=null;
		String userDob="", defaultPassword="",encodePassword="";
		String[] toAddress=new String[1];	
		Boolean status = true;
		
		TIdUserMasterEntity tIdUserMasterEntity=tIdUserMasterJpaRepository.findByUserCode(userEmail);

		if (tIdUserMasterEntity != null && tIdUserMasterEntity.getActiveStatus() == ACTIVE_STATUS) {	
				Long otp=0L;
				Map<String, Object> vmValues = new HashMap<String, Object>();
				otp=(long)(Math.random()*((999999-100000)+1))+100000;
				vmValues.put("companyName",companyName);
				vmValues.put("activationURL", domainUrl+"Login/ResetPassword?userActivationId="+tIdUserMasterEntity.getUserKey());
				vmValues.put("userName",tIdUserMasterEntity.getUserDisplayName());
				vmValues.put("verificationCode", String.valueOf(otp));
				toAddress[0]=userEmail;
				templateService.createMailTemplateAndSend(PASSWORDRESET,fromEmail, toAddress, vmValues, null);
				List<TIdEtUserPasswordResetLinkEntity> tIdEtUserPasswordResetLinkEntityList = tIdEtUserPasswordResetLinkJpaRepository.findByUprlUserIdAndUprlLinkActive(tIdUserMasterEntity.getUserKey(), status);
				try {
					SimpleDateFormat sdfDestination = new SimpleDateFormat("ddyyyy");
					userDob = sdfDestination.format(tIdUserMasterEntity.getUserDateOfBirth());
					if(tIdUserMasterEntity.getUserFirstName().length()>3) {
						defaultPassword=WordUtils.capitalizeFully(tIdUserMasterEntity.getUserFirstName().substring(0, 4))+userDob;
					} else {
						defaultPassword=WordUtils.capitalizeFully(tIdUserMasterEntity.getUserFirstName())+userDob;
					}
					encodePassword=md5Algo(defaultPassword);
					tIdUserMasterEntity.setUserPassword(encodePassword);
					tIdUserMasterEntity.setUserVerificationCode(otp);
					tIdUserMasterJpaRepository.save(tIdUserMasterEntity);
				} catch (Exception e) {
					logger.error("opps! error occured in sendPasswordResetLink method while saving the records in tIdUserMasterEntity ");
					e.printStackTrace();
				}
				if(tIdEtUserPasswordResetLinkEntityList.size()>0){
					for(TIdEtUserPasswordResetLinkEntity TIdEtUserPasswordResetLinkEntity:tIdEtUserPasswordResetLinkEntityList){
						TIdEtUserPasswordResetLinkEntity.setUprlLinkActive(false);
					}
					tIdEtUserPasswordResetLinkJpaRepository.save(tIdEtUserPasswordResetLinkEntityList);
			     }
				tIdEtUserPasswordResetLinkEntity=new TIdEtUserPasswordResetLinkEntity();
				tIdEtUserPasswordResetLinkEntity.setUprlUserId(tIdUserMasterEntity.getUserKey());
				tIdEtUserPasswordResetLinkEntity.setUprlPasswordLink(domainUrl+"Login/ResetPassword?userActivationId="+tIdUserMasterEntity.getUserKey());
				tIdEtUserPasswordResetLinkEntity.setModifiedOn(new Date());
				tIdEtUserPasswordResetLinkEntity.setActiveStatus(1l);
				tIdEtUserPasswordResetLinkEntity.setLockKey(0l);
				tIdEtUserPasswordResetLinkEntity.setProfileKey(1l);
				tIdEtUserPasswordResetLinkEntity.setUprlLinkActive(true);
				tIdEtUserPasswordResetLinkJpaRepository.save(tIdEtUserPasswordResetLinkEntity);
				
				tIdUserMasterEntity.setUserPasswordModified("R");
				tIdUserMasterJpaRepository.save(tIdUserMasterEntity);
		} else {
				return "failure";
		}
		return "success";
	}

	@Override
	public TIdUserMaster validatePasswordResetLink(Long userId) {
		TIdUserMaster tIdUserMaster = null;
		try {
			TIdEtUserPasswordResetLinkEntity tIdEtUserPasswordResetLinkEntity = tIdEtUserPasswordResetLinkJpaRepository.findByUprlUserId(userId,true);
			TIdUserMasterEntity tIdUserMasterEntity = tIdUserMasterJpaRepository.findOne(userId);
			tIdUserMaster = genericServiceMapper.map(tIdUserMasterEntity,TIdUserMaster.class);
			logger.info(tIdUserMaster.getUserKey()+": user Key");
			
			if (tIdEtUserPasswordResetLinkEntity != null) {
				logger.info("Forget Password Link is Valid");
				/** BUGZILLA-ID-5810-START */
//				long diffMinutes = getHrsDiff(new Date(),tIdEtUserPasswordResetLinkEntity.getModifiedOn(),"minutes");
//				logger.info("validatePasswordResetLink Duration -->" + diffMinutes);
//				logger.info("validatePasswordResetLink PASSWORD_URL_EXPIRY_HRS -->" + PASSWORD_URL_EXPIRY_HRS);
//				if (diffMinutes <= PASSWORD_URL_EXPIRY_HRS * 60) {
					tIdUserMaster.setLinkStatus(LINK_SUCCESS);
					tIdUserMaster.setActiveLink(true);
//				} else {
//					tIdUserMaster.setActiveLink(false);
//					tIdUserMaster.setLinkStatus(LINK_EXPIRY);
//					/*tIdEtUserPasswordResetLinkEntity.setUprlLinkActive(false);
//					tIdEtUserPasswordResetLinkJpaRepository.save(tIdEtUserPasswordResetLinkEntity);*/
//				}*/
				/** BUGZILLA-ID-5810-ENd */
			} else {
				logger.info("Forget Password Link is All Ready Used");
				tIdUserMaster.setActiveLink(false);
				tIdUserMaster.setLinkStatus(LINK_ALREADY_USED);// Link Already
			}
			
			if(tIdUserMasterEntity!=null){
				tIdUserMaster.setUserEmail(tIdUserMasterEntity.getUserCode());
				tIdUserMaster.setUserVerificationCode(null);
			}
			
		} catch (Exception e) {
			logger.error("retrieveUserId:" + e.getMessage());
		}
		return tIdUserMaster;
	}
	
	public  long getHrsDiff(Date fromDate, Date toDate, String returnType){
		if("hour".equals(returnType)){
			long diff = fromDate.getTime() - toDate.getTime();
			return diff / (60 * 60 * 1000);
		}else{//minutes
			long diff = fromDate.getTime() - toDate.getTime();
			return  diff / ( 60 * 1000);
		}
	}

	@Override
	public TIdUserMaster updatePassword(TIdUserMaster tIdUserMaster) throws Exception{
		
		TIdUserMasterEntity tIdUserMasterEntity = tIdUserMasterJpaRepository.findOne(tIdUserMaster.getUserKey());
		tIdUserMasterEntity.setUserPassword(md5Algo(tIdUserMaster.getUserPassword()));
		tIdUserMasterEntity.setUserPasswordModified("Y");
		tIdUserMasterEntity.setUserVerificationCode(null);
		tIdUserMasterEntity.setUserLockCount(0L);
		tIdUserMasterEntity=tIdUserMasterJpaRepository.save(tIdUserMasterEntity);
		tIdUserMaster=genericServiceMapper.map(tIdUserMasterEntity, TIdUserMaster.class);
		TIdEtUserPasswordResetLinkEntity tIdEtUserPasswordResetLinkEntity = tIdEtUserPasswordResetLinkJpaRepository.findByUprlUserId(tIdUserMasterEntity.getUserKey(),true);
		if(tIdEtUserPasswordResetLinkEntity!=null){
		   tIdEtUserPasswordResetLinkEntity.setUprlLinkActive(false);
		   tIdEtUserPasswordResetLinkJpaRepository.save(tIdEtUserPasswordResetLinkEntity);
		}else{
			logger.info("No data Available In tIdEtUserPasswordResetLinkEntity based on UserKey");
		}
		return tIdUserMaster;
	}
 
	@Override
	public Void sendUpdateNotificationMail(TIdUserMaster tIdUserMaster) {
    	String[] toAddress=null;
		Map<String, Object> vmValues = new HashMap<String, Object>();
		vmValues.put("companyName", "wasta");
		vmValues.put("userName", tIdUserMaster.getUserCode());
		
		TIdPersonalInformationEntity tIdPersonalInformationEntity = tIdPersonalInformationJpaRepository.findOne(tIdUserMaster.getUserPinKey());
		toAddress=tIdPersonalInformationEntity.getPinEmail().split(",");
		
		templateService.createMailTemplateAndSend(PWDUPDATENOTIFICATION, fromEmail, toAddress, vmValues, null);
		return null;
	}

	@Override
	public boolean validatePasswordAndVerifyCode(TIdUserMaster tIdUserMaster) {
		TIdUserMasterEntity tIdUserMasterEntity=null;
		String pass;
		try {
			pass = md5Algo(tIdUserMaster.getUserPassword());
			tIdUserMasterEntity=tIdUserMasterJpaRepository.findByUserCodeAndUserPasswordAndUserVerificationCode(tIdUserMaster.getUserCode(),pass,tIdUserMaster.getUserVerificationCode());
			if(tIdUserMasterEntity!=null){
					return true;
			}
		} catch (Exception e) {
			logger.error("Validate user password and verify code :" + e.getMessage());
		}
		return false;
	}

	@Scheduled(cron = "0 0 10 * * ?")
	@Override
	public void scheduleTaskForUpdatePassword() {
		Map<String, Object> vmValues = new HashMap<String, Object>();
			List<TIdUserMasterEntity> listOfTIdUserMasterEntity = tIdUserMasterJpaRepository.getUserMastetList(Arrays.asList(("L,R").split(",")));
			if(listOfTIdUserMasterEntity!=null && listOfTIdUserMasterEntity.size()>0) {
				for (TIdUserMasterEntity tIdUserMasterEntity : listOfTIdUserMasterEntity) {
					vmValues.put("userFirstName", tIdUserMasterEntity.getUserFirstName());
					vmValues.put("userLastName", tIdUserMasterEntity.getUserLastName());
					vmValues.put("toAddress", tIdUserMasterEntity.getUserCode());
					vmValues.put("fromAddress", fromEmail);
					if(tIdUserMasterEntity.getUserPasswordModified().equals("L")) {
						vmValues.put("notificationURL", domainUrl+"Login/NewUser?userActivationId="+tIdUserMasterEntity.getUserKey());
					} else { 
						vmValues.put("notificationURL", domainUrl+"Login/ResetPassword?userActivationId="+tIdUserMasterEntity.getUserKey());
					}
					vmValues.put("templateName", CHANGE_DEFAULT_PASSWORD);
					templateService.sendMailForChangeDefultPassword(vmValues);
				}
			}else {
				logger.info("There is No data Availble with userPasswordModified value L & R in TIdUserMasterEntity");
			}
		
	}
	
}
