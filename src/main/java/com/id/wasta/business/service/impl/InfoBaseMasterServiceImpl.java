package com.id.wasta.business.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.wasta.bean.TIdInfoBaseMaster;
import com.id.wasta.bean.jpa.TIdInfoBaseMasterEntity;
import com.id.wasta.business.service.InfoBaseMasterService;
import com.id.wasta.business.service.mapper.TIdInfoBaseMasterServiceMapper;
import com.id.wasta.data.repository.jpa.TIdInfoBaseMasterJpaRepository;

/**
 * Implementation of TIdInfoBaseMasterService
 */
@Service
@Transactional
public class InfoBaseMasterServiceImpl implements InfoBaseMasterService {
	
	@Resource
	private TIdInfoBaseMasterJpaRepository tIdInfoBaseMasterJpaRepository;
	
	@Resource
	private TIdInfoBaseMasterServiceMapper tIdInfoBaseMasterServiceMapper;

	@Override
	public TIdInfoBaseMaster findByIbmTypeAndIbmBaseCode(String ibmType, String ibmBaseCode) {
		TIdInfoBaseMasterEntity tIdInfoBaseMasterEntity = tIdInfoBaseMasterJpaRepository.findByIbmTypeAndIbmBaseCode(ibmType, ibmBaseCode);
		return tIdInfoBaseMasterServiceMapper.mapTIdInfoBaseMasterEntityToTIdInfoBaseMaster(tIdInfoBaseMasterEntity);
	}


}
