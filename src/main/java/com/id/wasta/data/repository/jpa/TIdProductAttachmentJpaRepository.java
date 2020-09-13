package com.id.wasta.data.repository.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.id.wasta.bean.jpa.TIdProductAttachmentEntity;

/**
 * Repository : TIdProductAttachment.
 */
public interface TIdProductAttachmentJpaRepository extends PagingAndSortingRepository<TIdProductAttachmentEntity, Long> {

	@Query("select m from TIdProductAttachmentEntity m where m.pattReferenceKey = ?1 and m.pattReferenceType = ?2 and m.activeStatus = 'A'")
	List<TIdProductAttachmentEntity> findByRefKeyAndPattRefType(Long pattReferenceKey, String pattReferenceType);
	
	@Query("select m from TIdProductAttachmentEntity m where m.pattReferenceKey = ?1 and m.pattReferenceType = ?2 and m.pattFileType = ?3 and m.activeStatus = 'A'")
	List<TIdProductAttachmentEntity> findByRefKeyAndPattRefTypeAndPattFileType(Long pattReferenceKey, String pattReferenceType, String pattFileType);
	
	@Modifying 
	@Transactional
	@Query("delete from TIdProductAttachmentEntity m where m.pattReferenceKey = ?1 and m.pattReferenceType = ?2")
	void deletePersonalInfoDtls(Long pattReferenceKey, String pattReferenceType); 
	
	@Query("select e.pattKey from TIdProductAttachmentEntity as e where e.pattReferenceKey = ?1 and e.activeStatus = 'A' and e.pattReferenceType = 'PersonalInfo_Photo'")
	List<Long> getPrimaryKey(Long pattReferenceKey);
	
	@Query("select e from TIdProductAttachmentEntity as e where e.pattReferenceKey = ?1 and e.activeStatus = 'A' and e.pattReferenceType = 'PersonalInfo_Photo'")
	TIdProductAttachmentEntity getPictureObj(Long pattRefKey); 
}
