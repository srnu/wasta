package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdVisitInformationAccessEntity;

/**
 * Repository : TIdVisitInformationAccess.
 */
public interface TIdVisitInformationAccessJpaRepository extends PagingAndSortingRepository<TIdVisitInformationAccessEntity, Long> {

	TIdVisitInformationAccessEntity findByViaPivKeyAndCreatedByAndShareType(Long pivKey, Long createdBy, String shareType);
	
	void deleteByViaPivKeyIn(List<Long> pivKey);
	
	void deleteByViaPivKeyInAndCreatedBy(List<Long> pivKey, Long createdBy);
	
	List<TIdVisitInformationAccessEntity> findByViaPivKeyAndCreatedBy(Long pivKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_visit_information_access WHERE via_piv_key in (?1) AND created_by=?2", nativeQuery=true)
	int getPivKeyInAndCreatedBy(List<Long> pivKey, Long createdBy);
	
	void deleteByViaPivKeyInAndCreatedByAndAccessType(List<Long> pivKey, Long createdBy, String accessType);
	
	
	@Query(value="SELECT COUNT(*) FROM t_id_visit_information_access WHERE via_piv_key=?2 AND via_share_type = ?3 AND FIND_IN_SET( ?1, via_access_info)", nativeQuery=true)
	int getOneToOneCount(Long loginPinKey, Long currentPinKey, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE FIND_IN_SET (gl_gh_key, " + 
			"(SELECT GROUP_CONCAT(via_access_info) FROM t_id_visit_information_access WHERE via_piv_key=?2 AND via_share_type = ?3 )) AND gl_pin_key = ?1", nativeQuery=true)
	int getGroupCount(Long loginPinKey, Long currentPinKey, String shareType);
}
