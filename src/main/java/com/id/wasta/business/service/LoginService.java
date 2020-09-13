package com.id.wasta.business.service;

import com.id.wasta.bean.TIdUserMaster;
import com.id.wasta.bean.jpa.TIdUserMasterEntity;

/**
 * Business Service Interface for entity TIdUserMaster.
 */
public interface LoginService { 

	TIdUserMasterEntity checkValidate(TIdUserMaster tIdUserMaster) throws Exception ;
	
	public TIdUserMaster validatePasswordResetLink(Long userId);
	
	public String sendPasswordResetLink(String userEmail);
	
	public TIdUserMaster updatePassword(TIdUserMaster tIdUserMaster) throws Exception;
	
	public Void sendUpdateNotificationMail(TIdUserMaster tIdUserMaster);
	
	public boolean validatePasswordAndVerifyCode(TIdUserMaster tIdUserMaster);
	
	public void logoutInfo(String userCode)throws Exception ;
	
	public void scheduleTaskForUpdatePassword();

}
