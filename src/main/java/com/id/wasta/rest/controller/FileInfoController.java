package com.id.wasta.rest.controller;

import java.io.IOException;
import java.util.List;

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

import com.id.util.StringUtil;
import com.id.util.bean.common.JsonResponse;
import com.id.util.enums.MessageTypeEnum;
import com.id.wasta.bean.FileInfoBean;
import com.id.wasta.business.service.FileInfoService;

@Controller
public class FileInfoController {

	private static final Logger logger = Logger.getLogger(FileInfoController.class);

	@Autowired
	private FileInfoService fileInfoService;

	@RequestMapping(value = "/fileUpload/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveFile(@RequestBody FileInfoBean fileInfoBean)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call save file method -->");
		try {
			if (fileInfoService.saveFileDtls(fileInfoBean)) {
				return new JsonResponse(null, MessageTypeEnum.SUCCESS.getValue(), "file.success", "file saved successfully", true);
			}
		} catch (Exception e) {
			logger.info("Save file method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "file.failure", "unable to save", false);
	}
	
	//For multiple file upload.
	@RequestMapping(value = "/fileUpload/save1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveFile1(@RequestBody List<FileInfoBean> listOfFileInfoBean)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call save file method -->");
		try {
			if (fileInfoService.saveFileDtls1(listOfFileInfoBean)) {
				return new JsonResponse(null, MessageTypeEnum.SUCCESS.getValue(), "file.success", "file saved successfully", true);
			}
		} catch (Exception e) {
			logger.info("Save file method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "file.failure", "unable to save", false);
	}
	
	@RequestMapping(value = "/fileRetrieve", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse retrieveFile(@RequestParam(value = "referenceKey") Long referenceKey, @RequestParam(value = "referenceType") String referenceType, @RequestParam(value = "fileType") String fileType)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("Call retrieve file method -->");
		try {
			return new JsonResponse(fileInfoService.retrieveFile(referenceKey, referenceType, fileType), MessageTypeEnum.SUCCESS.getValue(), "retrieve.success", "file retrieved successfully", true);
		} catch (Exception e) {
			logger.info("Retrieve file method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "retrieve.failure", "unable to retrieve", false);
	}
	
}
