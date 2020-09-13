package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdAdditionalInformationAccessEntity;

/**
 * Repository : TIdAdditionalInformationAccess.
 */
public interface TIdAdditionalInformationAccessJpaRepository extends PagingAndSortingRepository<TIdAdditionalInformationAccessEntity, Long> {
	
	public List<TIdAdditionalInformationAccessEntity> findByAiaPiadKeyAndCreatedBy(Long aiaPiadKey, Long createdBy);
	
	void deleteByAiaPiadKeyIn(List<Long> aiaPiaKey);
	
	public TIdAdditionalInformationAccessEntity findByAiaPiadKeyAndCreatedByAndShareType(Long aiaPiadKey, Long createdBy,String shareType);
	
	void deleteByAiaPiadKeyInAndCreatedByAndAccessType(List<Long> pivKey, Long createdBy, String accessType);
	
	void deleteByAiaPiadKeyInAndCreatedBy(List<Long> pivKey, Long createdBy);

	@Query(value="SELECT COUNT(*) FROM t_id_additional_information_access WHERE aia_piad_key in (?1) AND created_by=?2", nativeQuery=true)
	int getAiaPiadKeyInAndCreatedBy(List<Long> aiaPiadKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_additional_information_access WHERE aia_piad_key=?2 AND aia_share_type = ?3 AND FIND_IN_SET( ?1, aia_access_info)", nativeQuery=true)
	int getOneToOneCount(Long loginPinKey, Long currentPinKey, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE FIND_IN_SET (gl_gh_key, " + 
			"(SELECT GROUP_CONCAT(aia_access_info) FROM t_id_additional_information_access WHERE aia_piad_key=?2 AND aia_share_type = ?3 )) AND gl_pin_key = ?1", nativeQuery=true)
	int getGroupCount(Long loginPinKey, Long currentPinKey, String shareType);
}
