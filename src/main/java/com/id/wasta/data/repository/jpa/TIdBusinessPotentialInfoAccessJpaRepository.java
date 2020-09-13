package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdBusinessPotentialInfoAccessEntity;

/**
 * Repository : TIdBusinessPotentialInfoAccess.
 */
public interface TIdBusinessPotentialInfoAccessJpaRepository extends PagingAndSortingRepository<TIdBusinessPotentialInfoAccessEntity, Long> {
	
	public List<TIdBusinessPotentialInfoAccessEntity> findByBpiaBpiKeyAndCreatedBy(Long pivKey, Long createdBy);
	
	public TIdBusinessPotentialInfoAccessEntity findByBpiaBpiKeyAndCreatedByAndShareType(Long pivKey, Long createdBy,String shareType);
	
	void deleteByBpiaBpiKeyIn(List<Long> bpiaBpiKey);
	
	void deleteByBpiaBpiKeyInAndCreatedByAndAccessType(List<Long> pivKey, Long createdBy, String accessType);
	
	void deleteByBpiaBpiKeyInAndCreatedBy(List<Long> pivKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_business_potential_info_access WHERE bpia_bpi_key in (?1) AND created_by=?2", nativeQuery=true)
	int getBpiaBpiKeyInAndCreatedBy(List<Long> bpiaBpiKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_business_potential_info_access WHERE bpia_bpi_key=?2 AND bpia_share_type = ?3 AND FIND_IN_SET( ?1, bpia_access_info)", nativeQuery=true)
	int getOneToOneCount(Long loginPinKey, Long currentPinKey, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE FIND_IN_SET (gl_gh_key, " + 
			"(SELECT GROUP_CONCAT(bpia_access_info) FROM t_id_business_potential_info_access WHERE bpia_bpi_key=?2 AND bpia_share_type = ?3 )) AND gl_pin_key = ?1", nativeQuery=true)
	int getGroupCount(Long loginPinKey, Long currentPinKey, String shareType);

}
