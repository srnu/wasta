package com.id.wasta.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.id.util.StringUtil;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.bean.TIdUserMaster;
import com.id.wasta.business.service.LoginService;
@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;
	
	@RequestMapping( value="/loginValidate",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse loginValidation(@RequestBody TIdUserMaster tIdUserMaster) {
		logger.info("Call login validate method -->");
		try {
			return new JsonResponse(loginService.checkValidate(tIdUserMaster),MessageTypeEnum.SUCCESS.getValue(),"login.success","successful login",true);
		} catch (Exception e) {
			logger.info("Login method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"login.failure",e.getLocalizedMessage(),false);
		}		
	}
	
	@RequestMapping( value="/logout",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse logoutInfo(@RequestParam("userCode") String userCode) {
		logger.info("Call logoutInfo method -->");
		try {
			loginService.logoutInfo(userCode);
			return new JsonResponse(true,MessageTypeEnum.SUCCESS.getValue(),"logout.success","successful logout",true);
		} catch (Exception e) {
			logger.info("Logout method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"logout.failure",e.getLocalizedMessage(),false);
		}
	}
	
	
	@RequestMapping(value = "sendResetUrl", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse sendResetUrl(@RequestParam("userEmail") String userEmail) {
		try {
			logger.info("call sendResetUrl method");
			return new JsonResponse(loginService.sendPasswordResetLink(userEmail), MessageTypeEnum.SUCCESS.getValue(), "sendResetUrl.success", "sendResetUrl mail sending Successful", true);
			
		} catch (Exception e) {
	        logger.info("sendResetUrl method throws Exception"+StringUtil.stack2string(e));		
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "sendResetUrl.failure", "sendResetUrl mail sending failed", false);	
	}
	

	@RequestMapping(value = "activaeUrlValidation", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse urlValidation(@RequestParam("userActivationId") Long userActivationId) {
		try {
			logger.info("call urlValidation method");
			return new JsonResponse(loginService.validatePasswordResetLink(userActivationId), MessageTypeEnum.SUCCESS.getValue(), "urlValidation.success", "urlValidation Successful", true);
			
		} catch (Exception e) {
  
	            logger.info("urlValidation method throws Exception"+StringUtil.stack2string(e));		
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "urlValidation.failure", "urlValidation  failed", false);	
	}
	
	
	@RequestMapping(value = "updatePassword", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse updatePassword(@RequestBody TIdUserMaster tIdUserMaster) {
		try {
			logger.info("call updatePassword method");
			
			tIdUserMaster=loginService.updatePassword(tIdUserMaster);
			
			return new JsonResponse(tIdUserMaster, MessageTypeEnum.SUCCESS.getValue(), "updatePassword.success", "updatePassword Successful", true);
			
		} catch (Exception e) {
  
	            logger.info("updatePassword method throws Exception"+StringUtil.stack2string(e));		
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "updatePassword.failure", "updatePassword  failed", false);	
	}

	
	@RequestMapping(value = "validatePasswordAndVerifyCode", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse validatePasswordAndVerifyCode(@RequestBody TIdUserMaster tIdUserMaster) {
		try {
			logger.info("call validatePasswordAndVerifyCode method");
		    return new JsonResponse(loginService.validatePasswordAndVerifyCode(tIdUserMaster), MessageTypeEnum.SUCCESS.getValue(), "validatePasswordAndVerifyCode.success", "ValidatePasswordAndVerifyCode Successful", true);	
		} catch (Exception e) {
	            logger.info("validatePasswordAndVerifyCode method throws Exception"+StringUtil.stack2string(e));		
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "validatePasswordAndVerifyCode.failure", "validatePasswordAndVerifyCode  failed", false);	
	}

}
