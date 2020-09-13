package com.id.wasta.business.service;

import java.util.List;

import com.id.util.bean.common.SelectListBean;
import com.id.wasta.bean.AccessBlocks;
import com.id.wasta.bean.CustomerInfoBean;
import com.id.wasta.bean.DashBoardRequestBean;
import com.id.wasta.bean.jpa.PersonIndividualExperienceViewEntity;

public interface CustomerInfoService { 

	Long saveCustomerInfo(CustomerInfoBean customerInfoBean) throws Exception;
	
	Long saveNameDtls(CustomerInfoBean customerInfoBean) throws Exception;
	
	Long saveRelationShipDtls(CustomerInfoBean customerInfoBean);
	
	Long saveLanguageDtls(CustomerInfoBean customerInfoBean) throws Exception;
	
	Long saveEmailDtls(CustomerInfoBean customerInfoBean);
	
	Long savePhoneNoDtls(CustomerInfoBean customerInfoBean);
	
	Long savePersonalDtls(CustomerInfoBean customerInfoBean) throws Exception;
	
	AccessBlocks viewCustomerInfo(DashBoardRequestBean dashBoardRequestBean);
	
	List<SelectListBean> getCustomerDtls();

	boolean initialValidation(CustomerInfoBean customerInfoBean);

	List<PersonIndividualExperienceViewEntity> listOfDetails();

	List<PersonIndividualExperienceViewEntity> listOfExistingUser(CustomerInfoBean customerInfoBean);
	
	List<PersonIndividualExperienceViewEntity> listOfExisEmailUser(CustomerInfoBean customerInfoBean);
	
	List<PersonIndividualExperienceViewEntity> listOfExisMobileUser(CustomerInfoBean customerInfoBean);
	
	List<PersonIndividualExperienceViewEntity> listOfExisLandLineUser(CustomerInfoBean customerInfoBean);	
		
	String updateCreator(Long pinKey, Long creatorPinKey);
	
	String changeCreator(CustomerInfoBean customerInfoBean);
	
	boolean checkProfile(Long loginPinKey, Long currentPinKey);
	
	boolean emailInitialVal(CustomerInfoBean customerInfoBean);
	
	boolean mobileInitialVal(CustomerInfoBean customerInfoBean);
	
	boolean landlineInitialVal(CustomerInfoBean customerInfoBean);
	
	List<SelectListBean> getEmployeeList(String activeStatus);
	
	List<SelectListBean> getContactsList(Long pinCreatorKey);
	
}
