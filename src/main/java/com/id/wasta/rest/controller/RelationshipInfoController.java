package com.id.wasta.rest.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import com.id.wasta.bean.TIdRelationshipInformation;
import com.id.wasta.business.service.RelationshipInfoService;

@Controller
public class RelationshipInfoController {

	private static final Logger logger = Logger.getLogger(RelationshipInfoController.class);

	@Autowired
	private RelationshipInfoService relationshipInfoService;

	@RequestMapping(value = "/relationshipInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse realtionshipSave(@RequestBody TIdRelationshipInformation tIdRelationshipInformation)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call save file method -->");
		try {
			String message = null;
			if(tIdRelationshipInformation.getPrlKey()!=null) {
				message = "Successfully  updated the record";
			} else {
				message = "Successfully save the record";
			}
			return new JsonResponse(relationshipInfoService.saveRelationshipDtls(tIdRelationshipInformation), MessageTypeEnum.SUCCESS.getValue(), "relation.success", message, true);
		} catch (Exception e) {
			if(e instanceof DataIntegrityViolationException)
			{
				return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"Relationship Information save .failure",e.getMessage(),false);
			}
			logger.error("Save file method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "relation.failure", "unable to save", false);
	}
	
	@RequestMapping(value = "/shadowCntRetrieve", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse shadowContactRetrieve(@RequestParam("relationId")Long relationId)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call retrieve file method -->");
		try {
			return new JsonResponse(relationshipInfoService.relationViewDtls(relationId), MessageTypeEnum.SUCCESS.getValue(), "relation.success", "record retrieved", true);
		} catch (Exception e) {
			logger.error("Retrieve file method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "relation.failure", "unable to save", false);
	}
	
	@RequestMapping(value = "/chkRelationStatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse chkRelationStatus(@RequestParam("fromPinKey")Long fromPinKey, @RequestParam("toPinKey")Long toPinKey)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call chk relation status method -->");
		try {
			return new JsonResponse(relationshipInfoService.chkRelationStatus(fromPinKey, toPinKey), MessageTypeEnum.SUCCESS.getValue(), "relation.success", "check status", true);
		} catch (Exception e) {
			logger.error("Check relation status method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "relation.failure", "unable to check", false);
	}
	
}
