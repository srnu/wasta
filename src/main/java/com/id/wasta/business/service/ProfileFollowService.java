package com.id.wasta.business.service;

import java.util.List;

import com.id.wasta.bean.TIdProfileFollowDetails;
import com.id.wasta.bean.jpa.TIdProfileFollowDetailsViewEntity;

public interface ProfileFollowService {

	Long saveProfileFollowInfoDtls(TIdProfileFollowDetails tIdProfileFollowDetails);

	boolean saveProfileUnfollowInfoDtls(TIdProfileFollowDetails tIdProfileFollowDetails);

	List<TIdProfileFollowDetailsViewEntity> getProfileFollowInfoDtls(Long pinKey);

	boolean getProfileUniqueFollowInfoDtls(Long pinKey, Long followedByKey);
}



