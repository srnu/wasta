package com.id.wasta.business.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.id.util.business.service.mapping.GenericServiceMapper;
import com.id.wasta.bean.TIdProfileFollowDetails;
import com.id.wasta.bean.jpa.TIdProfileFollowDetailsEntity;
import com.id.wasta.bean.jpa.TIdProfileFollowDetailsViewEntity;
import com.id.wasta.business.service.ProfileFollowService;
import com.id.wasta.data.repository.jpa.TIdProfileFollowDetailsJpaRepository;
import com.id.wasta.data.repository.jpa.TIdProfileFollowDetailsViewJpaRepository;

@Service
public class ProfileFollowServiceImpl implements ProfileFollowService {
	
	@Resource
	private TIdProfileFollowDetailsJpaRepository tIdProfileFollowDetailsJpaRepository;
	
	@Resource
	private TIdProfileFollowDetailsViewJpaRepository tIdProfileFollowDetailsViewJpaRepository;
	
	@Resource
	private GenericServiceMapper genericServiceMapper;

	@Override
	public Long saveProfileFollowInfoDtls(TIdProfileFollowDetails tIdProfileFollowDetails) {
		TIdProfileFollowDetailsEntity tIdProfileFollowDetailsEntity=null;
		tIdProfileFollowDetailsEntity=genericServiceMapper.map(tIdProfileFollowDetails, TIdProfileFollowDetailsEntity.class);
		tIdProfileFollowDetailsEntity.setPfdFollowedDate(new Date());
		tIdProfileFollowDetailsEntity.setActiveStatus("A");
		tIdProfileFollowDetailsEntity=tIdProfileFollowDetailsJpaRepository.save(tIdProfileFollowDetailsEntity);
		tIdProfileFollowDetails.setPfdKey(tIdProfileFollowDetailsEntity.getPfdKey());
		return tIdProfileFollowDetails.getPfdKey();
	}

	@Override
	public boolean saveProfileUnfollowInfoDtls(TIdProfileFollowDetails tIdProfileFollowDetails) {
		
		int keyValue=tIdProfileFollowDetailsJpaRepository.deletebyPfdPinKeyAndPfdPinFollowbyKey(tIdProfileFollowDetails.getPfdPinKey(),tIdProfileFollowDetails.getPfdPinFollowbyKey());
		if(keyValue!=0)
		{
			return true;
		} 
		return false;
	}

	@Override
	public List<TIdProfileFollowDetailsViewEntity> getProfileFollowInfoDtls(Long pinKey) {
		return tIdProfileFollowDetailsViewJpaRepository.findByPfdPinKeyAndActiveStatus(pinKey,"A");
	}

	@Override
	public boolean getProfileUniqueFollowInfoDtls(Long pinKey, Long followedByKey) {
		TIdProfileFollowDetailsViewEntity tIdProfileFollowDetailsViewEntity=null;
		tIdProfileFollowDetailsViewEntity=tIdProfileFollowDetailsViewJpaRepository.findByPfdPinKeyAndPfdPinFollowbyKeyAndActiveStatus(pinKey,followedByKey,"A");
		if(tIdProfileFollowDetailsViewEntity!=null){
			return true;
		}else{
			return false;
		}
	}
}
