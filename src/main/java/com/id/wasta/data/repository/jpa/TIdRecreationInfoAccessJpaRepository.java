package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdRecreationInfoAccessEntity;

/**
 * Repository : TIdRecreationInfoAccess.
 */
public interface TIdRecreationInfoAccessJpaRepository extends PagingAndSortingRepository<TIdRecreationInfoAccessEntity, Long> {
	
	public List<TIdRecreationInfoAccessEntity> findByRiaReiKeyAndCreatedBy(Long pivKey, Long createdBy);
	
	void deleteByRiaReiKeyIn(List<Long> apsaApsKey);
	
	public TIdRecreationInfoAccessEntity findByRiaReiKeyAndCreatedByAndShareType(Long riaReiKey,Long createdBy,String shareType);
	
	void deleteByRiaReiKeyInAndCreatedByAndAccessType(List<Long> pivKey, Long createdBy, String accessType);
	
	void deleteByRiaReiKeyInAndCreatedBy(List<Long> pivKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_recreation_info_access WHERE ria_rei_key in (?1) AND created_by=?2", nativeQuery=true)
	int getRiaReiKeyInAndCreatedBy(List<Long> riaReiKey, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_recreation_info_access WHERE ria_rei_key=?2 AND ria_share_type = ?3 AND FIND_IN_SET( ?1, ria_access_info)", nativeQuery=true)
	int getOneToOneCount(Long loginPinKey, Long currentPinKey, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE FIND_IN_SET (gl_gh_key, " + 
			"(SELECT GROUP_CONCAT(ria_access_info) FROM t_id_recreation_info_access WHERE ria_rei_key=?2 AND ria_share_type = ?3 )) AND gl_pin_key = ?1", nativeQuery=true)
	int getGroupCount(Long loginPinKey, Long currentPinKey, String shareType);

}
