package com.id.wasta.business.service;

import com.id.wasta.bean.AccessBlocks;
import com.id.wasta.bean.DashBoardRequestBean;

public interface DashboardEnhanceService {
	
	public AccessBlocks getDashBoardProfile(DashBoardRequestBean dashBoardRequestBean) throws Exception;

	public AccessBlocks getCompleteDashBoardProfile(DashBoardRequestBean dashBoardRequestBean) throws Exception;

}
