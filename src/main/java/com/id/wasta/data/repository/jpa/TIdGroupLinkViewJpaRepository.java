package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdGroupLinkViewEntity;

public interface TIdGroupLinkViewJpaRepository extends BaseRepository<TIdGroupLinkViewEntity, Long>{
	
	List<TIdGroupLinkViewEntity> findByGlGhKey(Long glGhKey);
	
}
