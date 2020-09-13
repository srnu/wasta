package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdProfessionalExpertiseAccessEntity;

/**
 * Repository : TIdProfessionalExpertiseAccess.
 */
public interface TIdProfessionalExpertiseAccessJpaRepository extends PagingAndSortingRepository<TIdProfessionalExpertiseAccessEntity, Long> {
	
	public List<TIdProfessionalExpertiseAccessEntity> findByPeaPpeKeyAndCreatedBy(Long pivKey, Long createdBy);
	
	void deleteByPeaPpeKeyIn(List<Long> peaPpeKey);
	
	public TIdProfessionalExpertiseAccessEntity findByPeaPpeKeyAndCreatedByAndShareType(Long peaPpeKey, Long createdBy,String shareType);
	
	void deleteByPeaPpeKeyInAndCreatedByAndAccessType(List<Long> pivKey, Long createdBy, String accessType);
	
	void deleteByPeaPpeKeyInAndCreatedBy(List<Long> pivKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_professional_expertise_access WHERE pea_ppe_key in (?1) AND created_by=?2", nativeQuery=true)
	int getPeaPpeKeyInAndCreatedBy(List<Long> peaPpeKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_professional_expertise_access WHERE pea_ppe_key=?2 AND pea_share_type = ?3 AND FIND_IN_SET( ?1, pea_access_info)", nativeQuery=true)
	int getOneToOneCount(Long loginPinKey, Long currentPinKey, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE FIND_IN_SET (gl_gh_key, " + 
			"(SELECT GROUP_CONCAT(pea_access_info) FROM t_id_professional_expertise_access WHERE pea_ppe_key=?2 AND pea_share_type = ?3 )) AND gl_pin_key = ?1", nativeQuery=true)
	int getGroupCount(Long loginPinKey, Long currentPinKey, String shareType);

}
