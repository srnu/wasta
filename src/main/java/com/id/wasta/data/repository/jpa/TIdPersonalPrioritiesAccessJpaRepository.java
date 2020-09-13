package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdPersonalPrioritiesAccessEntity;

/**
 * Repository : TIdPersonalPrioritiesAccess.
 */
public interface TIdPersonalPrioritiesAccessJpaRepository extends PagingAndSortingRepository<TIdPersonalPrioritiesAccessEntity, Long> {
	
	public List<TIdPersonalPrioritiesAccessEntity> findByPpaPerpKeyAndCreatedBy(Long pivKey, Long createdBy);
	
	void deleteByPpaPerpKeyIn(List<Long> apsaApsKey);
	
	public TIdPersonalPrioritiesAccessEntity findByPpaPerpKeyAndCreatedByAndShareType(Long ppaPerpKey,Long createdBy,String shareType);
	
	void deleteByPpaPerpKeyInAndCreatedByAndAccessType(List<Long> pivKey, Long createdBy, String accessType);
	
	void deleteByPpaPerpKeyInAndCreatedBy(List<Long> pivKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_personal_priorities_access WHERE ppa_perp_key in (?1) AND created_by=?2", nativeQuery=true)
	int getPpaPerpKeyInAndCreatedBy(List<Long> ppaPerpKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_personal_priorities_access WHERE ppa_perp_key=?2 AND ppa_share_type = ?3 AND FIND_IN_SET( ?1, ppa_access_info)", nativeQuery=true)
	int getOneToOneCount(Long loginPinKey, Long currentPinKey, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE FIND_IN_SET (gl_gh_key, " + 
			"(SELECT GROUP_CONCAT(ppa_access_info) FROM t_id_personal_priorities_access WHERE ppa_perp_key=?2 AND ppa_share_type = ?3 )) AND gl_pin_key = ?1", nativeQuery=true)
	int getGroupCount(Long loginPinKey, Long currentPinKey, String shareType);
}
