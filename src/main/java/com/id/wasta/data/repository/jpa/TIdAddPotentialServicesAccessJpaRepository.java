package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdAddPotentialServicesAccessEntity;

/**
 * Repository : TIdAddPotentialServicesAccess.
 */
public interface TIdAddPotentialServicesAccessJpaRepository extends PagingAndSortingRepository<TIdAddPotentialServicesAccessEntity, Long> {
	
	public List<TIdAddPotentialServicesAccessEntity> findByApsaApsKeyAndCreatedBy(Long pivKey, Long createdBy);
	
	public TIdAddPotentialServicesAccessEntity findByApsaApsKeyAndCreatedByAndShareType(Long pivKey, Long createdBy, String shareType);
	
	void deleteByApsaApsKeyIn(List<Long> apsaApsKey);
	
	void deleteByApsaApsKeyInAndCreatedByAndAccessType(List<Long> pivKey, Long createdBy, String accessType);
	
	void deleteByApsaApsKeyInAndCreatedBy(List<Long> pivKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_add_potential_services_access WHERE apsa_aps_key in (?1) AND created_by=?2", nativeQuery=true)
	int getApsaApsKeyInAndCreatedBy(List<Long> apsaApsKey, Long createdBy);

	@Query(value="SELECT COUNT(*) FROM t_id_add_potential_services_access WHERE apsa_aps_key=?2 AND apsa_share_type = ?3 AND FIND_IN_SET( ?1, apsa_access_info)", nativeQuery=true)
	int getOneToOneCount(Long loginPinKey, Long currentPinKey, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE FIND_IN_SET (gl_gh_key, " + 
			"(SELECT GROUP_CONCAT(apsa_access_info) FROM t_id_add_potential_services_access WHERE apsa_aps_key=?2 AND apsa_share_type = ?3 )) AND gl_pin_key = ?1", nativeQuery=true)
	int getGroupCount(Long loginPinKey, Long currentPinKey, String shareType);
}
