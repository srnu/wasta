package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdUserCategoryLinkEntity;

/**
 * Repository : TIdUserCategoryLink.
 */
public interface TIdUserCategoryLinkJpaRepository extends BaseRepository<TIdUserCategoryLinkEntity, Long> {
	
	public List<TIdUserCategoryLinkEntity> findByUsclUserKey(Long userKey);

}
