package com.id.wasta.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
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
import com.id.wasta.bean.DashBoardRequestBean;
import com.id.wasta.bean.TIdAddPotentialServices;
import com.id.wasta.bean.TIdBusinessPotentialInfo;
import com.id.wasta.bean.TIdPersonalInterests;
import com.id.wasta.bean.TIdPersonalPriorities;
import com.id.wasta.bean.TIdProfessionalExpertise;
import com.id.wasta.bean.TIdProfessionalInterests;
import com.id.wasta.bean.TIdRecreationInfo;
import com.id.wasta.business.service.MiscInfoService;
import com.id.wasta.exception.HandledException;

@Controller
public class MiscInfoController {

	private static final Logger logger = Logger.getLogger(MiscInfoController.class);

	@Autowired
	private MiscInfoService miscInfoService;
	
	@RequestMapping( value="/potentialServices", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getPotentialService(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("call potential services  get method !!!");
		try{
			
			return new JsonResponse(miscInfoService.getPotentialServicesInfo(dashBoardRequest),MessageTypeEnum.SUCCESS.getValue(),"potentialInfo.success","record retrieved successfully", true);
		}catch(Exception e)
		{
			logger.info("call potential services get method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"potential services.failure","invalid data",false);
	}	
	
	
	@RequestMapping( value="/getPersonalPriorities", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getPersonalPriorities(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("call personal priorities  get method !!!");
		try{
			
			return new JsonResponse(miscInfoService.getPersonalPrioritiesInfo(dashBoardRequest),MessageTypeEnum.SUCCESS.getValue(),"personalPriorities.success","record retrieved successfully", true);
		}catch(Exception e)
		{
			logger.info("call personal priorities get method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"personalPriorities.failure","invalid data",false);
	}	
	
	@RequestMapping( value="/businessPotential", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getBusinessPotential(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("call business potential services  get method !!!");
		try{
			
			return new JsonResponse(miscInfoService.getBusinessPotential(dashBoardRequest),MessageTypeEnum.SUCCESS.getValue(),"businesspotentialInfo.success","record retrieved successfully", true);
		}catch(Exception e)
		{
			logger.info("call business  services get method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"business potential services.failure","invalid data",false);
	}
	
	@RequestMapping( value="/personalInterests", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getPersonalInterests(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("call personal interets   get method !!!");
		try{
			
			return new JsonResponse(miscInfoService.getPersonalInterests(dashBoardRequest),MessageTypeEnum.SUCCESS.getValue(),"personal interets.success","record retrieved successfully", true);
		}catch(Exception e)
		{
			logger.info("call personal intersts get method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"peronal interests .failure","invalid data",false);
	}
	
	@RequestMapping( value="/professionalExpertise", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getProfessionalExpertise(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("call professional expertise   get method !!!");
		try{
			
			return new JsonResponse(miscInfoService.getProfessionalExpertise(dashBoardRequest),MessageTypeEnum.SUCCESS.getValue(),"professional expertise.success","record retrieved successfully", true);
		}catch(Exception e)
		{
			logger.info("call professional expertise get method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"professional expertise .failure","invalid data",false);
	}	
	
	@RequestMapping( value="/professionalInterests", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getProfessionalInterests(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("call professional interests   get method !!!");
		try{
			return new JsonResponse(miscInfoService.getProfessionalInterests(dashBoardRequest),MessageTypeEnum.SUCCESS.getValue(),"professional interests.success","record retrieved successfully", true);
		}catch(Exception e)
		{
			logger.info("call professional inetrests get method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"professional interests .failure","invalid data",false);
	}
	@RequestMapping( value="/getRecreationInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse getRecreationInfo(@RequestBody DashBoardRequestBean dashBoardRequest) {
		logger.info("call recreation info   get method !!!");
		try{
			
			return new JsonResponse(miscInfoService.getRecreationInfo(dashBoardRequest),MessageTypeEnum.SUCCESS.getValue(),"recreation info.success","record retrieved successfully", true);
		}catch(Exception e)
		{
			logger.info("call recreation get method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"recreation info .failure","invalid data",false);
	}
	
	
	@RequestMapping( value="/potentialServicesInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse savePotentialService(@RequestBody List<TIdAddPotentialServices> tIdAddPotentialServices)
	{
		logger.info("call potential services  save method !!!");
		try{
			String message = null;
			if(tIdAddPotentialServices!=null)
			{
		if(tIdAddPotentialServices.get(0).getKey()!=null) {
			message = "Successfully updated the record";
		} else {
			message = "Successfully save the record";
		}
			}	
			
			return new JsonResponse(miscInfoService.savePotentialServicesInfo(tIdAddPotentialServices),MessageTypeEnum.SUCCESS.getValue(),"potentialInfo.success",message, true);
		}catch(Exception e)
		{
			if(e instanceof HandledException) {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "potential services.failure", e.getMessage(), false);
			}
			
			logger.info("call potential services save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"potential services.failure","invalid data",false);
	}	
	
	

	@RequestMapping( value="/businessPotentialInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveBusinessPotential(@RequestBody List<TIdBusinessPotentialInfo> tIdBusinessPotentialInfo)
	{
		logger.info("call business potential save method !!!");
		try{
			String message = null;
			if(tIdBusinessPotentialInfo!=null)
			{
		if(tIdBusinessPotentialInfo.get(0).getKey()!=null) {
			message = "Successfully updated the record";
		} else {
			message = "Successfully save the record";
		}
			}	
			
			return new JsonResponse(miscInfoService.saveBusinessPotentialInfo(tIdBusinessPotentialInfo),MessageTypeEnum.SUCCESS.getValue(),"businessPotentialInfo.success",message, true);
		}catch(Exception e)
		{
			if(e instanceof HandledException) {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "business potential info.failure", e.getMessage(), false);
			}
			
			logger.info("call business potential  save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"business potential info.failure","invalid data",false);
	}	
	
	
	@RequestMapping( value="/personalInterestsInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse savePersonalInterests(@RequestBody List<TIdPersonalInterests> tIdPersonalInterests)
	{
		logger.info("call personal interests save method !!!");
		try{
			String message = null;
			if(tIdPersonalInterests!=null)
			{
		if(tIdPersonalInterests.get(0).getKey()!=null) {
			message = "Successfully updated the record";
		} else {
			message = "Successfully save the record";
		}
			}	
			
			return new JsonResponse(miscInfoService.savePersonalInterestsInfo(tIdPersonalInterests),MessageTypeEnum.SUCCESS.getValue(),"personalInterestsInfo.success",message, true);
		}catch(Exception e)
		{
			if(e instanceof HandledException) {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "personal interests info.failure", e.getMessage(), false);
			}
			
			logger.info("call  personal interests  save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"personal interests info.failure","invalid data",false);
	}	
	
	@RequestMapping( value="/professionalExpertiseInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveProfessionalExpertise(@RequestBody List<TIdProfessionalExpertise> tIdProfessionalExpertise)
	{
		logger.info("call professional expertise save method !!!");
		try{
			String message = null;
			if(tIdProfessionalExpertise!=null)
			{
		if(tIdProfessionalExpertise.get(0).getKey()!=null) {
			message = "Successfully updated the record";
		} else {
			message = "Successfully save the record";
		}
			}	
			
			return new JsonResponse(miscInfoService.saveProfessionalExpertiseInfo(tIdProfessionalExpertise),MessageTypeEnum.SUCCESS.getValue(),"professionalExpertiseInfo.success",message, true);
		}catch(Exception e)
		{
			if(e instanceof HandledException) {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "professional expertise info.failure", e.getMessage(), false);
			}
			
			logger.info("call  professional expertise  save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"professional expertise info.failure","invalid data",false);
	}	
	
	@RequestMapping( value="/professionalInterestsInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveProfessionalInterests(@RequestBody List<TIdProfessionalInterests> tIdProfessionalInterests)
	{
		logger.info("call professional interests save method !!!");
		try{
			String message = null;
			if(tIdProfessionalInterests!=null)
			{
				if(tIdProfessionalInterests.get(0).getKey()!=null) {
					message = "Successfully updated the record";
				} else {
					message = "Successfully save the record";
				}
			}	
			
			return new JsonResponse(miscInfoService.saveProfessionalInterestsInfo(tIdProfessionalInterests),MessageTypeEnum.SUCCESS.getValue(),"professionalInterestsInfo.success",message, true);
		}catch(Exception e)
		{
			if(e instanceof HandledException) {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "professional interests info.failure", e.getMessage(), false);
			}
			
			logger.info("call  professional interests  save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"professional interests info.failure","invalid data",false);
	}	
	
	@RequestMapping( value="/recreationInfo", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse saveRecreationInfo(@RequestBody List<TIdRecreationInfo> tIdRecreationInfo)
	{
		logger.info("call recreation save method !!!");
		try{
			String message = null;
			if(tIdRecreationInfo!=null)
			{
		if(tIdRecreationInfo.get(0).getKey()!=null) {
			message = "Successfully updated the record";
		} else {
			message = "Successfully save the record";
		}
			}	
			
			return new JsonResponse(miscInfoService.saveRecreationInfo(tIdRecreationInfo),MessageTypeEnum.SUCCESS.getValue(),"recreationInfo.success",message, true);
		}catch(Exception e)
		{
			if(e instanceof HandledException) {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "recreation info.failure", e.getMessage(), false);
			}
			
			logger.info("call  recreation  info save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"recreation info.failure","invalid data",false);
	}	
	
	@RequestMapping( value="/personalPriorities", method =RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse savePersonalPriorities(@RequestBody List<TIdPersonalPriorities> tIdPersonalPriorities)
	{
		logger.info("call recreation save method !!!");
		try{
			String message = null;
			if(tIdPersonalPriorities!=null)
			{
		if(tIdPersonalPriorities.get(0).getKey()!=null) {
			message = "Successfully updated the record";
		} else {
			message = "Successfully save the record";
		}
			}	
			return new JsonResponse(miscInfoService.savePersonalPriorities(tIdPersonalPriorities),MessageTypeEnum.SUCCESS.getValue(),"personalPriorities.success",message, true);
		}catch(Exception e)
		{
			if(e instanceof HandledException) {
				return new JsonResponse(null, MessageTypeEnum.ERROR.getValue(), "personal priorities info.failure", e.getMessage(), false);
			}
			
			logger.info("call  personal priorities save method exception -->"+StringUtil.stack2string(e));
		}
		return new JsonResponse(null,MessageTypeEnum.ERROR.getValue(),"personal priorities info.failure","invalid data",false);
	}	
}


