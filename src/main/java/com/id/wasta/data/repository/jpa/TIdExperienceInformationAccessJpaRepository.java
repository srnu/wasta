package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdExperienceInformationAccessEntity;

/**
 * Repository : TIdExperienceInformationAccess.
 */
public interface TIdExperienceInformationAccessJpaRepository extends PagingAndSortingRepository<TIdExperienceInformationAccessEntity, Long> {
	
	public List<TIdExperienceInformationAccessEntity> findByEiaPexKeyAndCreatedBy(Long pivKey, Long createdBy);
	
	void deleteByEiaPexKeyIn(List<Long> eiaPexKey);

	public TIdExperienceInformationAccessEntity findByEiaPexKeyAndCreatedByAndShareType(Long eiaPexKey, Long createdBy, String shareType);
	
	void deleteByEiaPexKeyInAndCreatedByAndAccessType(List<Long> pivKey, Long createdBy, String accessType);
	
	void deleteByEiaPexKeyInAndCreatedBy(List<Long> pivKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_experience_information_access WHERE eia_pex_key in (?1) AND created_by=?2", nativeQuery=true)
	int getEiaPexKeyInAndCreatedBy(List<Long> eiaPexKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_experience_information_access WHERE eia_pex_key=?2 AND eia_share_type = ?3 AND FIND_IN_SET( ?1, eia_access_info)", nativeQuery=true)
	int getOneToOneCount(Long loginPinKey, Long currentPinKey, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE FIND_IN_SET (gl_gh_key, " + 
			"(SELECT GROUP_CONCAT(eia_access_info) FROM t_id_experience_information_access WHERE eia_pex_key=?2 AND eia_share_type = ?3 )) AND gl_pin_key = ?1", nativeQuery=true)
	int getGroupCount(Long loginPinKey, Long currentPinKey, String shareType);
	
}
