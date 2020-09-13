package com.id.wasta.rest.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.business.service.GetcrdfService;

@Controller
public class GetcrdfController {
	
	@Autowired
	private GetcrdfService getcrdfService;
	
	private static final Logger logger = Logger.getLogger(GetcrdfController.class);
	
	@RequestMapping(value = "/getCompanyNames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getCompanyNames(@RequestParam Long profileKey,@RequestParam String companyVal){
		logger.info("Call getCompanyNames method -->");
			if(companyVal!=null) {
				return new JsonResponse(getcrdfService.getCompany(profileKey, companyVal), MessageTypeEnum.SUCCESS.getValue(), "getCompanyNames.success", "Successfully Getting Records", true);
			}
			else {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(),"ValidateController.failure" , "Enter At Least Three Charecters", false);
			}
	}
	
	@RequestMapping(value = "/getRoleNames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getRoleNames(@RequestParam Long profileKey,@RequestParam String roleVal){
		logger.info("Call getCompanyNames method -->");
				return new JsonResponse(getcrdfService.getRoles(profileKey, roleVal), MessageTypeEnum.SUCCESS.getValue(), "getRoleNames.success", "Successfully Getting Records", true);
			
	}
	
	@RequestMapping(value = "/getDesignationNames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getDesignationNames(@RequestParam Long profileKey,@RequestParam String desgVal){
		logger.info("Call getDesignationNames method -->");
				return new JsonResponse(getcrdfService.getDesignation(profileKey, desgVal), MessageTypeEnum.SUCCESS.getValue(), "getDesignationNames.success", "Successfully Getting Records", true);
			
	}
	
	@RequestMapping(value = "/getFunctionalAreaNames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getFunctionalAreaNames(@RequestParam Long profileKey,@RequestParam String funVal){
		logger.info("Call getFunctionalAreaNames method -->");
				return new JsonResponse(getcrdfService.getFunctionalArea(profileKey, funVal), MessageTypeEnum.SUCCESS.getValue(), "getDesignationNames.success", "Successfully Getting Records", true);
			
	}

}
