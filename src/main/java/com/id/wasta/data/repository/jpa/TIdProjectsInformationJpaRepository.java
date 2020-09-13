package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProjectsInformationEntity;

/**
 * Repository : TIdProjectsInformation.
 */
public interface TIdProjectsInformationJpaRepository extends BaseRepository<TIdProjectsInformationEntity, Long> {

	@Query("select e.pipKey from TIdProjectsInformationEntity as e where e.pipPinKey=?1 and e.activeStatus='A' ")
	List<Long> findPipPinKey(Long pinKey);
	
	@Query("select e.pipProjectName from TIdProjectsInformationEntity as e where e.pipKey=?1")
	String findPipProjectName(Long key);

	@Query("select count(e) from TIdProjectsInformationEntity as e where e.pipCreatedBy=?1 and e.createdOn <?2")
	long getTotalProjects(Long userPinKey, Date yesterDayDate);
	
}
