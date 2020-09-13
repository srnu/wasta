package com.id.wasta.rest.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.id.util.StringUtil;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.bean.TIdMyContactsLink;
import com.id.wasta.bean.jpa.TIdMyContactsLinkEntity;
import com.id.wasta.business.service.MyContactInfoService;
import com.id.wasta.exception.HandledException;

@Controller
public class MyContactInfoController {
	
	private static final Logger logger = Logger.getLogger(MyContactInfoController.class);
	
	@Autowired
	private MyContactInfoService  myContactInfoService;
		
	@RequestMapping(value = "/getCustDtlsWithExpInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getCustDtlsWithExpInfo() throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call get custDtlsWithExpInfo details method -->");
		try {
			return new JsonResponse(myContactInfoService.getCustDtlsWithExpInfo(), MessageTypeEnum.SUCCESS.getValue(), "custDtlsWithExpInfo.success", "record retrieved", true);
		} catch (Exception e) {
			if(e instanceof HandledException) {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "custDtlsWithExpInfo.failure", e.getMessage(), false);
			}
			logger.info("get custDtlsWithExpInfo details method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "custDtlsWithExpInfo.failure", "unable to retrieve", false);
	}
	
	
	/*This method for saveMycontact / removeMyContact
     * 
     * @param tIdMyContactsLink
     * 
     */
	@RequestMapping(value="/saveMycontact",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveMycontact(@RequestBody TIdMyContactsLink tIdMyContactsLink){
		try {
			return new JsonResponse(myContactInfoService.saveOrUpdateMycontact(tIdMyContactsLink), MessageTypeEnum.SUCCESS.getValue(), "success","success",true);
		}catch (Exception ex) {
			logger.error("SaveMycontact method service throws Exception"+StringUtil.stack2string(ex));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"error",ex.getMessage(),false);
		}	
	}
	
	@RequestMapping(value="/removeMycontact",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse removeMycontact(@RequestBody TIdMyContactsLink tIdMyContactsLink){
		try {
			return new JsonResponse(myContactInfoService.removeMycontact(tIdMyContactsLink), MessageTypeEnum.SUCCESS.getValue(), "success","success",true);
		}catch (Exception ex) {
			logger.error("RemoveMycontact method service throws Exception"+StringUtil.stack2string(ex));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"error",ex.getMessage(),false);
		}	
	}
	
	/*This method for checkMyContact
     * 
     * @param tIdMyContactsLink
     * 
     */
	@RequestMapping(value="/checkMyContact",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse checkMyContact(@RequestBody TIdMyContactsLink tIdMyContactsLink){
		try {
			TIdMyContactsLinkEntity tIdMyContactsLinkEntity = myContactInfoService.checkMyContact(tIdMyContactsLink);
			if(tIdMyContactsLinkEntity!=null) {
				return new JsonResponse(tIdMyContactsLinkEntity, MessageTypeEnum.SUCCESS.getValue(), "success","success",true);
			} else {
				return new JsonResponse(false, MessageTypeEnum.ERROR.getValue(), "failure","failure",false);
			}
		} catch (Exception ex) {
			logger.error("checkMyContact method service throws Exception"+StringUtil.stack2string(ex));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"error",ex.getMessage(),false);
		}	
	}
	
	/*This method for listOfMyContact
     * 
     * @param tIdMyContactsLink
     * 
     */
	@RequestMapping(value="/listOfMyContact",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse listOfMyContact(@RequestBody TIdMyContactsLink tIdMyContactsLink){
		try {
			return new JsonResponse(myContactInfoService.listOfMyContact(tIdMyContactsLink), MessageTypeEnum.SUCCESS.getValue(), "success","success",true);
		} catch (Exception ex) {
			logger.error("listOfMyContact method service throws Exception"+StringUtil.stack2string(ex));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"error",ex.getMessage(),false);
		}	
	}
	
	/*This method for connectionDtls
     * 
     * @param tIdMyContactsLink
     * 
     */
	@RequestMapping(value="/connectionDtls",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse connectionDtls(@RequestBody TIdMyContactsLink tIdMyContactsLink){
		try {
			return new JsonResponse(myContactInfoService.connectionDtls(tIdMyContactsLink), MessageTypeEnum.SUCCESS.getValue(), "success","success",true);
		} catch (Exception ex) {
			logger.error("connectionDtls method service throws Exception"+StringUtil.stack2string(ex));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"error",ex.getMessage(),false);
		}	
	}
	
	
}
