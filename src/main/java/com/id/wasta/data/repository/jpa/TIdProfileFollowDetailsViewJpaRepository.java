package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProfileFollowDetailsViewEntity;

public interface TIdProfileFollowDetailsViewJpaRepository extends BaseRepository<TIdProfileFollowDetailsViewEntity,Long> {


	List<TIdProfileFollowDetailsViewEntity> findByPfdPinKeyAndActiveStatus(Long pinKey, String string);

	TIdProfileFollowDetailsViewEntity findByPfdPinKeyAndPfdPinFollowbyKeyAndActiveStatus(Long pinKey,Long followedByKey, String string);
	
	List<TIdProfileFollowDetailsViewEntity> findByPfdPinFollowbyKeyAndActiveStatus(Long pinKey, String activeStatus);
}


