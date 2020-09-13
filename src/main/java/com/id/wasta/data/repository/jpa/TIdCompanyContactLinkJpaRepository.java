package com.id.wasta.data.repository.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdCompanyContactLinkEntity;

/**
 * Repository : TIdCompanyContactLink.
 */
public interface TIdCompanyContactLinkJpaRepository extends BaseRepository<TIdCompanyContactLinkEntity, Long> {
	
	@Query("select e.cclKey from TIdCompanyContactLinkEntity as e where e.cclPinKey=?1")
	public List<Long> getListOfCclKeysByUserKey(Long userKey);
	
	List<TIdCompanyContactLinkEntity> findByCclPinKey(Long pinKey);

	@Modifying
	@Transactional
    @Query("update TIdCompanyContactLinkEntity um set um.cclCompanyRelation = :cclCompanyRelation , um.cclCompanyKey = :cclCompanyKey where um.cclKey = :cclKey")
	public int updateRelationship(@Param("cclCompanyRelation") Long cclCompanyRelation,@Param("cclCompanyKey") Long cclCompanyKey,@Param("cclKey") Long cclKey);

	@Modifying
	@Transactional
    @Query("delete from TIdCompanyContactLinkEntity as e where e.cclKey not in(?1)  and e.cclPinKey=?2")
	public void deleteByPrimaryKeys(List<Long> primaryKeys,Long userKey);
	
	@Modifying
	@Transactional
    @Query("delete from TIdCompanyContactLinkEntity as e where e.cclPinKey=?1")
	public void deleteUserKey(Long userKey);
	
	
}
