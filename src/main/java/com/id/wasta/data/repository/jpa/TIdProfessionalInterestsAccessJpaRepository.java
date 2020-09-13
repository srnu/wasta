package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdProfessionalInterestsAccessEntity;

/**
 * Repository : TIdProfessionalInterestsAccess.
 */
public interface TIdProfessionalInterestsAccessJpaRepository extends PagingAndSortingRepository<TIdProfessionalInterestsAccessEntity, Long> {

	public List<TIdProfessionalInterestsAccessEntity> findByPiaPriKeyAndCreatedBy(Long pivKey, Long createdBy);
	
	void deleteByPiaPriKeyIn(List<Long> apsaApsKey);
	
	public TIdProfessionalInterestsAccessEntity findByPiaPriKeyAndCreatedByAndShareType(Long piaPriKey, Long createdBy,String shareType);
	
	void deleteByPiaPriKeyInAndCreatedByAndAccessType(List<Long> pivKey, Long createdBy, String accessType);
	
	void deleteByPiaPriKeyInAndCreatedBy(List<Long> pivKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_professional_interests_access WHERE pia_pri_key in (?1) AND created_by=?2", nativeQuery=true)
	int getPiaPriKeyInAndCreatedBy(List <Long> piaPriKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_professional_interests_access WHERE pia_pri_key=?2 AND pia_share_type = ?3 AND FIND_IN_SET( ?1, pia_access_info)", nativeQuery=true)
	int getOneToOneCount(Long loginPinKey, Long currentPinKey, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE FIND_IN_SET (gl_gh_key, " + 
			"(SELECT GROUP_CONCAT(pia_access_info) FROM t_id_professional_interests_access WHERE pia_pri_key=?2 AND pia_share_type = ?3 )) AND gl_pin_key = ?1", nativeQuery=true)
	int getGroupCount(Long loginPinKey, Long currentPinKey, String shareType);
}
