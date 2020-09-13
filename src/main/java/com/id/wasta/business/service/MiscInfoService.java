package com.id.wasta.business.service;

import java.util.List;

import com.id.wasta.bean.AccessBlocks;
import com.id.wasta.bean.DashBoardRequestBean;
import com.id.wasta.bean.TIdAddPotentialServices;
import com.id.wasta.bean.TIdBusinessPotentialInfo;
import com.id.wasta.bean.TIdPersonalInterests;
import com.id.wasta.bean.TIdPersonalPriorities;
import com.id.wasta.bean.TIdProfessionalExpertise;
import com.id.wasta.bean.TIdProfessionalInterests;
import com.id.wasta.bean.TIdRecreationInfo;
import com.id.wasta.exception.HandledException;

public interface MiscInfoService {

	List<TIdAddPotentialServices> savePotentialServicesInfo(List<TIdAddPotentialServices> tIdAddPotentialServices) throws Exception;

	List<TIdBusinessPotentialInfo> saveBusinessPotentialInfo(List<TIdBusinessPotentialInfo> tIdBusinessPotentialInfo)throws Exception;

	List<TIdPersonalInterests>  savePersonalInterestsInfo(List<TIdPersonalInterests> tIdPersonalInterests)throws Exception;

	List<TIdProfessionalExpertise> saveProfessionalExpertiseInfo(List<TIdProfessionalExpertise> tIdProfessionalExpertise)throws Exception;

	List<TIdProfessionalInterests> saveProfessionalInterestsInfo(List<TIdProfessionalInterests> tIdProfessionalInterests)throws Exception;

	List<TIdRecreationInfo> saveRecreationInfo(List<TIdRecreationInfo> tIdRecreationInfo)throws Exception;

	AccessBlocks getPotentialServicesInfo(DashBoardRequestBean dashBoardRequest)throws Exception;

	AccessBlocks getBusinessPotential(DashBoardRequestBean dashBoardRequest)throws Exception;

	AccessBlocks getPersonalInterests(DashBoardRequestBean dashBoardRequest)throws Exception;

	AccessBlocks getProfessionalExpertise(DashBoardRequestBean dashBoardRequest)throws Exception;

	AccessBlocks getProfessionalInterests(DashBoardRequestBean dashBoardRequest)throws Exception;

	AccessBlocks getRecreationInfo(DashBoardRequestBean dashBoardRequest)throws Exception;

	List<TIdPersonalPriorities> savePersonalPriorities(List<TIdPersonalPriorities> tIdPersonalPriorities) throws HandledException;

	AccessBlocks getPersonalPrioritiesInfo(DashBoardRequestBean dashBoardRequest); 	
}

