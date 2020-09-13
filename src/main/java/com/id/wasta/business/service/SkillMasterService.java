package com.id.wasta.business.service;

import java.util.List;

import com.id.wasta.bean.jpa.TIdSkillMasterViewEntity;

public interface SkillMasterService {

	List<TIdSkillMasterViewEntity> getSkillMasterInfo(Long skillCategory,String activeStatus);

	
	
	
}

