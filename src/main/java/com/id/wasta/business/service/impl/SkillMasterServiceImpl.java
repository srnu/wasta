package com.id.wasta.business.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.wasta.bean.jpa.TIdSkillMasterViewEntity;
import com.id.wasta.business.service.SkillMasterService;
import com.id.wasta.data.repository.jpa.TIdSkillMasterViewJpaRepository;

@Service
@Transactional
public class SkillMasterServiceImpl implements SkillMasterService {
	
	@Resource
	private TIdSkillMasterViewJpaRepository tIdSkillMasterViewJpaRepository;

	@Override
	public List<TIdSkillMasterViewEntity> getSkillMasterInfo(Long skillCategory,String activeStatus) {
		return tIdSkillMasterViewJpaRepository.getSkillMaster(skillCategory, activeStatus);
	}
	
}