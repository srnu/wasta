package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProgAccessBlocksMasterEntity;

/**
 * Repository : TIdProgAccessBlocksMaster.
 */
public interface TIdProgAccessBlocksMasterJpaRepository extends BaseRepository<TIdProgAccessBlocksMasterEntity, Long> {


	@Query("select new com.id.util.bean.common.SelectListBean(e.pabmKey,e.pabmBlockName,e.pabmBlockName) from TIdProgAccessBlocksMasterEntity as e where e.profileKey=:profileKey and e.activeStatus='A'")
	public List<SelectListBean> getAccessBlkMasters(@Param("profileKey")Long profileKey);
}
