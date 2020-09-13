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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.id.util.StringUtil;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.bean.ShareInfoBean;
import com.id.wasta.bean.TIdLandingNotification;
import com.id.wasta.business.service.ShareInfoService;

@Controller
public class ShareInfoController {

	private static final Logger logger = Logger.getLogger(ShareInfoController.class);

	@Autowired
	private ShareInfoService shareInfoService;
	
	@Autowired
	private ObjectMapper objectMapper;

	@RequestMapping(value = "/saveShareInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveShareInfo(@RequestBody ShareInfoBean shareInfoBean)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("=========>"+objectMapper.writeValueAsString(shareInfoBean));
		logger.info("Call save ShareInfo method -->");
		try {
			return new JsonResponse(shareInfoService.saveShareInfoDtls(shareInfoBean), MessageTypeEnum.SUCCESS.getValue(), "shareInfo.success", "Successfully save the record", true);
		} catch (Exception e) {
			logger.error("Save ShareInfo exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "shareInfo.failure", "unable to save", false);
		}
	}
	
	@RequestMapping(value = "/shareInfoValid", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse shareInfoValid(@RequestBody ShareInfoBean shareInfoBean)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call share info validation method -->");
		try {
			return new JsonResponse(shareInfoService.shareInfoValid(shareInfoBean), MessageTypeEnum.SUCCESS.getValue(), "shareValid.success", "validate record", true);
		} catch (Exception e) {
			logger.error("share info validate exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "shareValid.failure", "unable to validate", false);
		}
	}
	
	@RequestMapping(value = "/retrieveShare", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse retrieveShareInfo(@RequestBody ShareInfoBean shareInfoBean)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call retrieve share info method -->");
		try {
			shareInfoService.shareInfoValid(shareInfoBean);
			return new JsonResponse(shareInfoBean, MessageTypeEnum.SUCCESS.getValue(), "retrieve.success", "retrieve share", true);
		} catch (Exception e) {
			logger.error("Retrieve share info exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "retrieve.failure", "unable to retrieve", false);
		}
	}
	
	@RequestMapping(value = "/getCreatorName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getCreatorName()
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call getCreatorName method -->");
		try {
			return new JsonResponse(shareInfoService.getCreatorName(), MessageTypeEnum.SUCCESS.getValue(), "getCreatorName.success", "getCreatorName", true);
		} catch (Exception e) {
			logger.error("getCreatorName exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "getCreatorName.failure", "unable to getCreatorName", false);
		}
	}
	
	@RequestMapping(value = "/findCreator", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse findCreator(@RequestParam("pinKey") Long pinKey)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call findCreator method -->");
		try {
			return new JsonResponse(shareInfoService.findCreator(pinKey), MessageTypeEnum.SUCCESS.getValue(), "findCreator.success", "findCreator", true);
		} catch (Exception e) {
			logger.error("findCreator exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "findCreator.failure", "unable to findCreator", false);
		}
	}
	
	@RequestMapping( value="/saveShareNotification",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveShareNotification(@RequestBody TIdLandingNotification tIdLandingNotification) {
		logger.info("Call saveShareNotification method -->");
		try {
			return new JsonResponse(shareInfoService.saveShareNotification(tIdLandingNotification),MessageTypeEnum.SUCCESS.getValue(),"save.share.success","successfully saved",true);
		} catch (Exception e) {
			logger.error("saveShareNotification method exception -->"+StringUtil.stack2string(e));
			return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"save.share.failure","unable to save",false);
		}
	}
	
}
