package com.id.wasta.data.repository.jpa;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProfileFollowDetailsEntity;

public interface TIdProfileFollowDetailsJpaRepository extends BaseRepository<TIdProfileFollowDetailsEntity,Long> {

	TIdProfileFollowDetailsEntity findByPfdPinKeyAndPfdPinFollowbyKey(Long pfdPinKey, Long pfdPinFollowbyKey);

	TIdProfileFollowDetailsEntity findByPfdPinKey(Long pfdPinKey);
	
	@Transactional
	@Modifying
	@Query("delete from TIdProfileFollowDetailsEntity m where m.pfdPinKey = :pfdPinKey and m.pfdPinFollowbyKey = :pfdPinFollowbyKey" )
	int deletebyPfdPinKeyAndPfdPinFollowbyKey(@Param("pfdPinKey")Long pfdPinKey, @Param("pfdPinFollowbyKey")Long pfdPinFollowbyKey);
	
	@Query("select e.pfdPinKey from TIdProfileFollowDetailsEntity e where e.pfdPinFollowbyKey=?1 and e.activeStatus='A' ")
	List<Long> getMyFollowList(Long pinKey);
	
}

