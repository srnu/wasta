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
import com.id.wasta.bean.CustomerInfoBean;
import com.id.wasta.bean.DashBoardRequestBean;
import com.id.wasta.business.service.CustomerInfoService;
import com.id.wasta.exception.HandledException;

@Controller
public class CustomerInfoController {
	
	private static final Logger logger = Logger.getLogger(CustomerInfoController.class);

	@Autowired
	private CustomerInfoService customerInfoService;

	@RequestMapping(value = "/customerInfo/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse createCustomer(@RequestBody CustomerInfoBean customerInfoBean) {
		logger.info("Call customer info without image method -->");
		String split[];
		try {
			String message = null;
			if(customerInfoBean.getPinKey()!=null) {
				message = "Successfully updated the record";
			} else {
				message = "Successfully save the record";
			}
			return new JsonResponse(customerInfoService.saveCustomerInfo(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", message, true);
		} catch (Exception e) {
			if(e instanceof HandledException) {
				 if(e.getMessage().contains("::")){
					 split= e.getMessage().split("::");
					 return new JsonResponse(null, split[0], "duplicate.profile", split[1] , false);
				 }else
					 return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(),"customerInfo.failure" , e.getMessage(), false);
			}
			logger.info("Create customer info without image method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "customerInfo.failure", "unable to save", false);
	}
	
	@RequestMapping(value = "/customerInfo/retrieve", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse viewCustomer(@RequestBody DashBoardRequestBean dashBoardRequestBean) {
		logger.info("Call customer info without image method -->");
		try {
			return new JsonResponse(customerInfoService.viewCustomerInfo(dashBoardRequestBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "record retrieved", true);
		} catch (Exception e) {
			if(e instanceof HandledException) {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "customerInfo.failure", e.getMessage(), false);
			}
			logger.info("View customer info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "customerInfo.failure", "unable to retrieve", false);
	}
	
	@RequestMapping(value = "/getCustomerDtls", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getCustomerDtls() {
		logger.info("Call get customer details method -->");
		try {
			return new JsonResponse(customerInfoService.getCustomerDtls(), MessageTypeEnum.SUCCESS.getValue(), "customerDtls.success", "record retrieved", true);
		} catch (Exception e) {
			if(e instanceof HandledException) {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "customerDtls.failure", e.getMessage(), false);
			}
			logger.info("get customer details method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "customerDtls.failure", "unable to retrieve", false);
	}
	
	@RequestMapping(value = "/initialValidation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse initialValidation(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call initialValidation method -->");
		try {
			return new JsonResponse(customerInfoService.initialValidation(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("InitialValidation method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "Error",e.getMessage() , false);
		}
	}
	
	@RequestMapping(value = "/emailInitialVal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse emailInitialVal(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call emailInitialVal method -->");
		try {
			return new JsonResponse(customerInfoService.emailInitialVal(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("emailInitialVal method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "Error",e.getMessage() , false);
		}
	}
	
	@RequestMapping(value = "/mobileInitialVal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse mobileInitialVal(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call mobileInitialVal method -->");
		try {
			return new JsonResponse(customerInfoService.mobileInitialVal(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("mobileInitialVal method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "Error",e.getMessage() , false);
		}
	}
	
	@RequestMapping(value = "/landlineInitialVal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse landlineInitialVal(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call landlineInitialVal method -->");
		try {
			return new JsonResponse(customerInfoService.landlineInitialVal(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("landlineInitialVal method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "Error",e.getMessage() , false);
		}
	}

	@RequestMapping(value = "/listOfDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse listOfDetails(){
		logger.info("Call initialValidation method -->");
		try {
			return new JsonResponse(customerInfoService.listOfDetails(), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("InitialValidation method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "Error",e.getMessage() , false);
		}
	}
	

	@RequestMapping(value = "/listOfExistingUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse listOfExistingUser(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call listOfExistingUser method -->");
		try {
			return new JsonResponse(customerInfoService.listOfExistingUser(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("listOfExistingUser method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "Error",e.getMessage() , false);
		}
	}
	
	@RequestMapping(value = "/listOfExisEmailUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse listOfExisEmailUser(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call listOfExisEmailUser method -->");
		try {
			return new JsonResponse(customerInfoService.listOfExisEmailUser(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("listOfExisEmailUser method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "Error",e.getMessage() , false);
		}
	}
	
	@RequestMapping(value = "/listOfExisMobileUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse listOfExisMobileUser(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call listOfExisMobileUser method -->");
		try {
			return new JsonResponse(customerInfoService.listOfExisMobileUser(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("listOfExisMobileUser method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "Error",e.getMessage() , false);
		}
	}
	
	@RequestMapping(value = "/listOfExisLandLineUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse listOfExisLandLineUser(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call listOfExisLandLineUser method -->");
		try {
			return new JsonResponse(customerInfoService.listOfExisLandLineUser(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "record retrieved", true);
		} catch (Exception e) {
			logger.info("listOfExisLandLineUser method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "Error",e.getMessage() , false);
		}
	}
	
	@RequestMapping(value = "/updateCreator", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse updateCreator(@RequestParam("pinKey") Long pinKey, @RequestParam("creatorPinKey") Long creatorPinKey) {
		try {
			logger.info("call updateCreator method");
			return new JsonResponse(customerInfoService.updateCreator(pinKey, creatorPinKey), MessageTypeEnum.SUCCESS.getValue(), "updateCreator.rel.success", "updateCreator Successful", true);			
		} catch (Exception e) {  
	            logger.info("updateCreator method throws Exception"+StringUtil.stack2string(e));		
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "updateCreator.rel.failure", "updateCreator failed", false);	
	}
	
	@RequestMapping(value = "/changeCreator", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse changeCreator(@RequestBody CustomerInfoBean customerInfoBean) {
		try {
			logger.info("call changeCreator method");
			return new JsonResponse(customerInfoService.changeCreator(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "changeCreator.rel.success", "changeCreator Successful", true);			
		} catch (Exception e) {  
	            logger.info("changeCreator method throws Exception"+StringUtil.stack2string(e));		
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "changeCreator.rel.failure", "changeCreator failed", false);	
	}
	
	@RequestMapping(value = "/checkProfile", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse checkProfile(@RequestParam("loginPinKey") Long loginPinKey, @RequestParam("currentPinKey") Long currentPinKey) {
		try {
			logger.info("call checkProfile method");
			return new JsonResponse(customerInfoService.checkProfile(loginPinKey, currentPinKey), MessageTypeEnum.SUCCESS.getValue(), "checkProfile.rel.success", "checkProfile Successful", true);			
		} catch (Exception e) {  
	            logger.info("checkProfile method throws Exception"+StringUtil.stack2string(e));		
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "checkProfile.rel.failure", "checkProfile failed", false);	
	}
	
	@RequestMapping(value = "/getEmployeeList", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getEmployeeList(@RequestParam("activeStatus") String activeStatus) {
		try {
			logger.info("call getEmployeeList method");
			return new JsonResponse(customerInfoService.getEmployeeList(activeStatus), MessageTypeEnum.SUCCESS.getValue(), "getEmployeeList.rel.success", "getEmployeeList Successful", true);			
		} catch (Exception e) {  
	            logger.info("getEmployeeList method throws Exception"+StringUtil.stack2string(e));		
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getEmployeeList.rel.failure", "getEmployeeList failed", false);	
	}
	
	@RequestMapping(value = "/getContactsList", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getContactsList(@RequestParam("pinCreatorKey") Long pinCreatorKey) {
		try {
			logger.info("call getContactsList method");
			return new JsonResponse(customerInfoService.getContactsList(pinCreatorKey), MessageTypeEnum.SUCCESS.getValue(), "getContactsList.rel.success", "getContactsList Successful", true);			
		} catch (Exception e) {  
	            logger.info("getContactsList method throws Exception"+StringUtil.stack2string(e));		
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getContactsList.rel.failure", "getContactsList failed", false);	
	}
	
	@RequestMapping(value = "/customerInfo/nameDtls", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveNameDtls(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call saveNameDtls method -->");
		String split[];
		try {
			return new JsonResponse(customerInfoService.saveNameDtls(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "Successfully updated the record", true);
		} catch (Exception e) {
			if(e instanceof HandledException) {
				 if(e.getMessage().contains("::")){
					 split= e.getMessage().split("::");
					 return new JsonResponse(null, split[0], "duplicate.profile", split[1] , false);
				 }else
					 return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(),"customerInfo.failure" , e.getMessage(), false);
			}
			logger.info("saveNameDtls method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "customerInfo.failure", "unable to save", false);
	}
	
	@RequestMapping(value = "/customerInfo/relationShipDtls", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveRelationShipDtls(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call saveRelationShipDtls method -->");
		String split[];
		try {
			return new JsonResponse(customerInfoService.saveRelationShipDtls(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "Successfully updated the record", true);
		} catch (Exception e) {
			if(e instanceof HandledException) {
				 if(e.getMessage().contains("::")){
					 split= e.getMessage().split("::");
					 return new JsonResponse(null, split[0], "duplicate.profile", split[1] , false);
				 }else
					 return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(),"customerInfo.failure" , e.getMessage(), false);
			}
			logger.info("saveRelationShipDtls method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "customerInfo.failure", "unable to save", false);
	}
	
	@RequestMapping(value = "/customerInfo/languageDtls", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveLanguageDtls(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call saveLanguageDtls method -->");
		String split[];
		try {
			return new JsonResponse(customerInfoService.saveLanguageDtls(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "Successfully updated the record", true);
		} catch (Exception e) {
			if(e instanceof HandledException) {
				 if(e.getMessage().contains("::")){
					 split= e.getMessage().split("::");
					 return new JsonResponse(null, split[0], "duplicate.profile", split[1] , false);
				 }else
					 return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(),"customerInfo.failure" , e.getMessage(), false);
			}
			logger.info("saveLanguageDtls method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "customerInfo.failure", "unable to save", false);
	}
	
	@RequestMapping(value = "/customerInfo/emailDtls", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveEmailDtls(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call saveEmailDtls method -->");
		String split[];
		try {
			return new JsonResponse(customerInfoService.saveEmailDtls(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "Successfully updated the record", true);
		} catch (Exception e) {
			if(e instanceof HandledException) {
				 if(e.getMessage().contains("::")){
					 split= e.getMessage().split("::");
					 return new JsonResponse(null, split[0], "duplicate.profile", split[1] , false);
				 }else
					 return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(),"customerInfo.failure" , e.getMessage(), false);
			}
			logger.info("saveEmailDtls method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "customerInfo.failure", "unable to save", false);
	}
	
	@RequestMapping(value = "/customerInfo/phoneNoDtls", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse savePhoneNoDtls(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call savePhoneNoDtls method -->");
		String split[];
		try {
			return new JsonResponse(customerInfoService.savePhoneNoDtls(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "Successfully updated the record", true);
		} catch (Exception e) {
			if(e instanceof HandledException) {
				 if(e.getMessage().contains("::")){
					 split= e.getMessage().split("::");
					 return new JsonResponse(null, split[0], "duplicate.profile", split[1] , false);
				 }else
					 return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(),"customerInfo.failure" , e.getMessage(), false);
			}
			logger.info("savePhoneNoDtls method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "customerInfo.failure", "unable to save", false);
	}
	
	@RequestMapping(value = "/customerInfo/personalDtls", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse savePersonalDtls(@RequestBody CustomerInfoBean customerInfoBean){
		logger.info("Call savePersonalDtls method -->");
		String split[];
		try {
			return new JsonResponse(customerInfoService.savePersonalDtls(customerInfoBean), MessageTypeEnum.SUCCESS.getValue(), "customerInfo.success", "Successfully updated the record", true);
		} catch (Exception e) {
			if(e instanceof HandledException) {
				 if(e.getMessage().contains("::")){
					 split= e.getMessage().split("::");
					 return new JsonResponse(null, split[0], "duplicate.profile", split[1] , false);
				 }else
					 return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(),"customerInfo.failure" , e.getMessage(), false);
			}
			logger.info("savePersonalDtls method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "customerInfo.failure", "unable to save", false);
	}
	
	
	
}