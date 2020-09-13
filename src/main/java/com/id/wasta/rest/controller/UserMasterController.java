package com.id.wasta.rest.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.id.util.StringUtil;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.bean.RequestKeyBean;
import com.id.wasta.business.service.UserMasterService;

@RestController
public class UserMasterController {
	private static final Logger logger = Logger.getLogger(UserMasterController.class);

	@Autowired
	private UserMasterService userMasterService;
	
	@RequestMapping(value = "/getUserDtls", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getUserDtls() throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call get user details method -->");
		try {
			return new JsonResponse(userMasterService.getUserDtls(), MessageTypeEnum.SUCCESS.getValue(), "UserDtls.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("get user details method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "UserDtls.failure", "unable to retrieve", false);
	}
	
	@RequestMapping(value = "/getContactDtls", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getContactDtls() throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call get contact details without user method -->");
		try {
			return new JsonResponse(userMasterService.getUsergetContactWithoutUserDtls(), MessageTypeEnum.SUCCESS.getValue(), "UserDtls.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("get contact details without user method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "UserDtls.failure", "unable to retrieve", false);
	}
	
	/*
	 * This method using for emp releaving 
	 */
	@RequestMapping(value = "/userProfileCreation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse userProfileCreation(@RequestBody RequestKeyBean requestKeyBean)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call user info updated method -->");
		try {
			return new JsonResponse(userMasterService.userProfileCreation(requestKeyBean), MessageTypeEnum.SUCCESS.getValue(), "UserInfo.success", "record updated", true);
		} catch (Exception e) {
			logger.info("View user info updated method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "UserInfo.failure", "unable to update existing data", false);
	}
	
	@RequestMapping(value = "/getEmployeeDtls ", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getEmployeeDtls(@RequestParam(required=false, value="pinKey") Long pinKey) throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call get user details method -->");
		try {
			return new JsonResponse(userMasterService.getEmployeeDtls(pinKey), MessageTypeEnum.SUCCESS.getValue(), "UserDtls.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("get user details method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "UserDtls.failure", "unable to retrieve", false);
	}
	
	@RequestMapping(value = "/userCreationMail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse sentMail(@RequestParam("userId") Long userId) throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call userCreationMail method -->");
		try {
			return new JsonResponse(userMasterService.userCreationMail(userId), MessageTypeEnum.SUCCESS.getValue(), "UserDtls.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("get sentMail method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "UserDtls.failure", "unable to retrieve", false);
	}
	
	@RequestMapping(value = "/checkUserRegisteration", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse checkUserRegisteration(@RequestParam("userActivationId") Long userActivationId) {
		try {
			logger.info("call checkUserRegisteration method");
			return new JsonResponse(userMasterService.checkUserRegisteration(userActivationId), MessageTypeEnum.SUCCESS.getValue(), "urlValidation.success", "urlValidation Successful", true);
			
		} catch (Exception e) {
  
	            logger.info("urlValidation method throws Exception"+StringUtil.stack2string(e));		
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "urlValidation.failure", "urlValidation  failed", false);	
	}
	
	@RequestMapping(value = "/updateRelationship", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse updateRelationship(@RequestParam("userKey") Long userKey) {
		try {
			logger.info("call update relationship method");
			return new JsonResponse(userMasterService.updateRelationship(userKey), MessageTypeEnum.SUCCESS.getValue(), "update.rel.success", "updated Successful", true);
			
		} catch (Exception e) {
  
	            logger.info("update relationship method throws Exception"+StringUtil.stack2string(e));		
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "update.rel.failure", "updation failed", false);	
	}
	
}
