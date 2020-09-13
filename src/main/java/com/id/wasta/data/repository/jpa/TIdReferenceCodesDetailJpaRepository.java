package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdReferenceCodesDetailEntity;

/**
 * Repository : TIdReferenceCodesDetail.
 */
public interface TIdReferenceCodesDetailJpaRepository extends BaseRepository<TIdReferenceCodesDetailEntity, Long> {

	
	
	@Query(value="(SELECT rcd_abbreviation FROM t_id_reference_codes_detail WHERE `rcd_detail_key`= "
			+ "(SELECT ccl_company_relation FROM t_id_company_contact_link WHERE `ccl_pin_key`=:pinKey))",nativeQuery=true)
	public String getRelation(@Param("pinKey") Long pinKey );
	
	@Query("select e.rcdValue from TIdReferenceCodesDetailEntity e where e.rcdDetailKey=?1")
	public String getTitleValue(Long rcdDetailKey);
	
	public TIdReferenceCodesDetailEntity findByRcdHeaderKeyAndRcdValue(Long rcdHeaderKey, String otherVisitModeName);

	public TIdReferenceCodesDetailEntity findByRcdHeaderKeyAndRcdValueAndRcdDetailKeyNotIn(Long rchHeaderKey,String otherVisitModeName, Long pivVisitMode);

	@Query("select e from TIdReferenceCodesDetailEntity as e where e.activeStatus in('A','P') and e.profileKey=?1 and e.rcdValue like %?2% and e.rcdHeaderKey = ?3")
	public List<TIdReferenceCodesDetailEntity> getAllData(Long profileKey, String searchString,Long headerKey);

	@Query("select e.rcdValue from TIdReferenceCodesDetailEntity as e where e.rcdDetailKey =?1 and e.activeStatus in ('A','P')") 
	public String getRoleName(Long roleKey);
}



