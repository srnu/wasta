package com.id.wasta.rest.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.id.util.StringUtil;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.bean.DeleteInfoBean;
import com.id.wasta.business.service.DeleteInfoService;

@Controller
public class DeleteInfoController {

    @Resource
	private DeleteInfoService deleteInfoService;
    
    private static final Logger logger = Logger.getLogger(DeleteInfoController.class);

	@RequestMapping(value = "/deleteInfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse deleteInformation(@RequestBody DeleteInfoBean deleteInfoBean) throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call delete info method -->");
		try {
			if(deleteInfoService.changeStatus(deleteInfoBean)) {
				return new JsonResponse(deleteInfoBean.getKey(), MessageTypeEnum.SUCCESS.getValue(), "delete info.success", "deleted successfully", true);
			}
		} catch (Exception e) {
			logger.info("delete info method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "delete info.failure", "unable to retrieve", false);
	}
	}
	

