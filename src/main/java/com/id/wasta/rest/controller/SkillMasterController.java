package com.id.wasta.rest.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.id.util.StringUtil;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.business.service.SkillMasterService;

@Controller
public class SkillMasterController {

	private static final Logger logger = Logger.getLogger(SkillMasterController.class);

	@Autowired
	private SkillMasterService skillMasterService;

	@RequestMapping(value = "/getSkillMasterView", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse retrieveFile(@RequestParam(value = "skillCategory") Long skillCategory, @RequestParam(value = "activeStatus") String activeStatus)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call skill master  method -->");
		try {
			return new JsonResponse(skillMasterService.getSkillMasterInfo(skillCategory, activeStatus), MessageTypeEnum.SUCCESS.getValue(), "retrieve.success", "skill master info retrieved successfully", true);
		} catch (Exception e) {
			logger.info("Retrieve skill master exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "skillmaster.failure", "unable to retrieve", false);
	}
	
}
