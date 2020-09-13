package com.id.wasta.business.service;

import java.util.List;

import com.id.util.bean.common.SelectListBean;
import com.id.wasta.bean.RequestKeyBean;
import com.id.wasta.bean.TIdUserMaster;

public interface UserMasterService {

	List<SelectListBean> getUserDtls();

	List<SelectListBean> getUsergetContactWithoutUserDtls();

	Long userProfileCreation(RequestKeyBean requestKeyBean);

	List<SelectListBean> getEmployeeDtls(Long pinKey);

	String userCreationMail(Long userId);

	TIdUserMaster checkUserRegisteration(Long userActivationId) throws Exception;
	
	String updateRelationship(Long userKey);

}
