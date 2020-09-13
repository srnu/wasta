package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProgAccessHeaderEntity;

/**
 * Repository : TIdProgAccessHeader.
 */
public interface TIdProgAccessHeaderJpaRepository extends BaseRepository<TIdProgAccessHeaderEntity, Long> {

	
	@Query("select new com.id.util.bean.common.SelectListBean(e.pahKey,e.pahProgName,e.pahProgName) from TIdProgAccessHeaderEntity as e where e.profileKey=:profileKey and e.activeStatus='A'")
	public List<SelectListBean> getAccessHeaders(@Param("profileKey")Long profileKey);
}
