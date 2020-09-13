package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdPersonalInfoAccessEntity;

public interface TIdPersonalInfoAccessJpaRepository extends CrudRepository<TIdPersonalInfoAccessEntity, Long>{
	
	void deleteByPiaPinKeyAndPiaFieldType(Long pinKey, String fieldType);
	
	void deleteByPiaPinKeyAndPiaFieldTypeAndCreatedBy(Long pinKey, String fieldType, Long createdBy);
	
	TIdPersonalInfoAccessEntity findByPiaPinKeyAndPiaFieldTypeAndCreatedByAndPiaShareType(Long pinKey, String fieldType, Long createdBy,String piaShareType);

	@Query(value="SELECT COUNT(*) FROM t_id_personal_info_access WHERE pia_pin_key=?2 AND pia_share_type = ?4 AND pia_field_type=?3 AND FIND_IN_SET( ?1, pia_access_info)", nativeQuery=true)
	int getOneToOneCount(Long loginPinKey, Long currentPinKey, String fieldType, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_group_link WHERE FIND_IN_SET (gl_gh_key, " + 
			"(SELECT GROUP_CONCAT(pia_access_info) FROM t_id_personal_info_access WHERE pia_pin_key=?2 AND pia_share_type = ?4 AND pia_field_type=?3)) AND gl_pin_key = ?1", nativeQuery=true)
	int getGroupCount(Long loginPinKey, Long currentPinKey, String fieldType, String shareType);
	
	@Query(value="SELECT COUNT(*) FROM t_id_personal_info_access WHERE pia_pin_key=?1 AND pia_field_type=?2 AND created_by=?3", nativeQuery=true)
	int getPiecPinKeyAndPiaFieldTypeAndCreatedBy(Long pinKey, String fieldType, Long createdBy);
	
	List<TIdPersonalInfoAccessEntity> findByPiaPinKeyAndPiaFieldTypeAndCreatedBy(Long pinKey, String fieldType, Long createdBy);
	
}
