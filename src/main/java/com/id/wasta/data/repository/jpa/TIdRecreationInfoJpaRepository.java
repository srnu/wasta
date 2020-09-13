package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdRecreationInfoEntity;

/**
 * Repository : TIdRecreationInfo.
 */
public interface TIdRecreationInfoJpaRepository extends BaseRepository<TIdRecreationInfoEntity, Long> {
	
	@Query("select e.key from TIdRecreationInfoEntity as e where e.reiPinKey=?1 and e.activeStatus='A' ")
	List<Long> findReiPinKey(Long pinKey);

	@Query("select count(e) from TIdRecreationInfoEntity as e where e.reiCreatedBy=?1 and e.createdOn <?2")
	Long getTotalRecreation(Long userPinKey, Date createdDate);


}
