package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdRelationshipInfoAccessEntity;

public interface TIdRelationshipInfoAccessJpaRepository extends CrudRepository<TIdRelationshipInfoAccessEntity, Long>{
	
	void deleteByRiaPrlkKeyIn(List<Long> prlkKey);
	
	void deleteByRiaPrlkKeyInAndCreatedBy(List<Long> prlkKey, Long createdBy);
	
	TIdRelationshipInfoAccessEntity findByRiaPrlkKeyAndCreatedByAndRiaShareType(Long prlkKey, Long createdBy, String shareType);

	@Query(value="SELECT COUNT(*) FROM t_id_relationship_info_access WHERE ria_prlk_key in (?1) AND ria_relation_type=?2 AND created_by=?3", nativeQuery=true)
	int getRiaPrlkKeyInAndRiaRelationTypeAndCreatedBy(List<Long> prlkKey, String menuType, Long createdBy);
	
	List<TIdRelationshipInfoAccessEntity> findByRiaPrlkKeyAndRiaRelationTypeAndCreatedBy(Long prlkKey, String menuType, Long createdBy);
	
	@Query(value="SELECT COUNT(*) FROM t_id_relationship_info_access WHERE ria_prlk_key=?2 AND ria_share_type = ?4 AND ria_relation_type=?3 AND FIND_IN_SET( ?1, ria_access_info)", nativeQuery=true)
	int getOneToOneCount(Long loginPinKey, Long currentPinKey, String menuType, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE FIND_IN_SET (gl_gh_key, " + 
			"(SELECT GROUP_CONCAT(ria_access_info) FROM t_id_relationship_info_access WHERE ria_prlk_key=?2 AND ria_share_type = ?4 AND ria_relation_type=?3 )) AND gl_pin_key = ?1", nativeQuery=true)
	int getGroupCount(Long loginPinKey, Long currentPinKey, String menuType, String shareType);
	
}
