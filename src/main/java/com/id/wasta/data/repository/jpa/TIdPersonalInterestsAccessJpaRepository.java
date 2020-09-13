package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdPersonalInterestsAccessEntity;

/**
 * Repository : TIdPersonalInterestsAccess.
 */
public interface TIdPersonalInterestsAccessJpaRepository extends PagingAndSortingRepository<TIdPersonalInterestsAccessEntity, Long> {

	public List<TIdPersonalInterestsAccessEntity> findByPiaPeriKeyAndCreatedBy(Long pivKey, Long createdBy);
	
	void deleteByPiaPeriKeyIn(List<Long> apsaApsKey);
	
	public TIdPersonalInterestsAccessEntity findByPiaPeriKeyAndCreatedByAndShareType(Long piaPeriKey, Long createdBy, String shareType);
	
	void deleteByPiaPeriKeyInAndCreatedByAndAccessType(List<Long> pivKey, Long createdBy, String accessType);
	
	void deleteByPiaPeriKeyInAndCreatedBy(List<Long> pivKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_personal_interests_access WHERE pia_peri_key in (?1) AND created_by=?2", nativeQuery=true)
	int getPiaPeriKeyInAndCreatedBy(List<Long> piaPeriKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_personal_interests_access WHERE pia_peri_key=?2 AND pia_share_type = ?3 AND FIND_IN_SET( ?1, pia_access_info)", nativeQuery=true)
	int getOneToOneCount(Long loginPinKey, Long currentPinKey, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE FIND_IN_SET (gl_gh_key, " + 
			"(SELECT GROUP_CONCAT(pia_access_info) FROM t_id_personal_interests_access WHERE pia_peri_key=?2 AND pia_share_type = ?3 )) AND gl_pin_key = ?1", nativeQuery=true)
	int getGroupCount(Long loginPinKey, Long currentPinKey, String shareType);
}
