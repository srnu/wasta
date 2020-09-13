package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdCompanyContactLinkViewEntity;

/**
 * Repository : TIdCompanyContactLink.
 */
public interface TIdCompanyContactLinkViewJpaRepository extends BaseRepository<TIdCompanyContactLinkViewEntity, Long> {
	
	List<TIdCompanyContactLinkViewEntity> findByCclPinKey(Long pinKey);
	
	List<TIdCompanyContactLinkViewEntity> findByCclPinKeyAndCclCompanyRelationValueIn(Long pinKey, List<String> reationValue);
	
	@Query("select new com.id.util.bean.common.SelectListBean (ccl.cclKey,'COMP',ccl.cclCompanyRelationValue||' of '||ccl.cclCompanyName) from TIdCompanyContactLinkViewEntity as ccl"
			+ " where ccl.cclPinKey = :cclPinKey")
	public List<SelectListBean> getRetriveRelationship(@Param("cclPinKey") Long cclPinKey);

}
