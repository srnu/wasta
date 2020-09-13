package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProgAccessFieldsMasterEntity;

public interface TIdProgAccessFieldsMasterJpaRepository extends BaseRepository<TIdProgAccessFieldsMasterEntity, Long>{

	@Query("select new com.id.util.bean.common.SelectListBean(e.key,e.code,e.name) from TIdProgAccessFieldsMasterEntity as e where e.profileKey=:profileKey and e.activeStatus='A'")
	public List<SelectListBean> getAccessFieldsMastersList(@Param("profileKey")Long profileKey);
}
