package com.id.wasta.data.repository.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntitySearch;

/**
 * Repository : TIdPersonalInformation.
 */
public interface TIdPersonalInformationSearchJpaRepository extends BaseRepository<TIdPersonalInformationEntitySearch, Long> {

	TIdPersonalInformationEntitySearch findByPinKey(Long pinKey);
	
	@Modifying
	@Transactional
    @Query("update TIdPersonalInformationEntitySearch pie set pie.activeStatus = ?2 where pie.pinKey = ?1")
	int updateActiveStatus(Long pinKey, String inactive);
	
	@Modifying
	@Transactional
    @Query("update TIdPersonalInformationEntitySearch pie set pie.activeStatus = ?2, pie.pinParentKey=?3, pie.pinPreviousStatus=?4  where pie.pinKey = ?1")
	int updateActiveStatusParentKey(Long pinKey, String inactive,Long parentKey, String pinPreviousStatus);

	@Query("select new com.id.util.bean.common.SelectListBean (e.pinKey , e.pinFirstName ,e.pinFirstName||' '||e.pinLastName) from TIdPersonalInformationEntitySearch as e where e.pinParentKey is not null")
	List<SelectListBean> findByPinParentKey();	
}
