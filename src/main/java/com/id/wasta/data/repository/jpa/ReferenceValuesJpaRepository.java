package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdReferenceCodesDetailViewEntity;

/**
 * Repository : TIdLanguageInformation.
 */
public interface ReferenceValuesJpaRepository extends BaseRepository<TIdReferenceCodesDetailViewEntity, Long> {

	@Query("select new com.id.util.bean.common.SelectListBean (e.detailKey, e.code,e.value) from TIdReferenceCodesDetailViewEntity as e where e.profileKey = :profileKey and e.domainName=:domainName and e.activeStatus = :activeStatus and e.value like :searchString")
	public List<SelectListBean> getReferenceValues(@Param("activeStatus") String activeStatus,@Param("searchString") String searchString,@Param("profileKey") Long profileKey,@Param("domainName") String  domainName);

	@Query("select new com.id.util.bean.common.SelectListBean (e.detailKey, e.code,e.value) from TIdReferenceCodesDetailViewEntity as e where e.profileKey = :profileKey and e.domainName=:domainName and e.activeStatus = :activeStatus")
	public List<SelectListBean> getReferenceValues(@Param("activeStatus") String activeStatus,@Param("profileKey") Long profileKey,@Param("domainName") String  domainName);
}
