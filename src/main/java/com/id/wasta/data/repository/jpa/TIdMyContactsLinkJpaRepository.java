package com.id.wasta.data.repository.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdMyContactsLinkEntity;

/**
 * Repository : TIdMyContactsLinkEntity.
 */
public interface TIdMyContactsLinkJpaRepository extends BaseRepository<TIdMyContactsLinkEntity, Long> {

	TIdMyContactsLinkEntity findByMclFromPinKeyAndMclToPinKey(Long mclFromPinKey, Long mclToPinKey);

	@Modifying
	@Transactional
    @Query("update TIdMyContactsLinkEntity e set e.activeStatus='I' where e.mclFromPinKey = :mclFromPinKey and e.mclToPinKey = :mclToPinKey")
	public int updateActiveStatus(@Param("mclFromPinKey") Long mclFromPinKey, @Param("mclToPinKey") Long mclToPinKey);

	TIdMyContactsLinkEntity findByMclFromPinKeyAndMclToPinKeyAndActiveStatus(Long mclFromPinKey, Long mclToPinKey, String string);

	List<TIdMyContactsLinkEntity> findByMclToPinKeyAndActiveStatus(Long mclToPinKey, String string);

	@Query("select count(e.mclStarRating) from TIdMyContactsLinkEntity e where e.mclToPinKey=?1 and e.activeStatus='A' ")
	long getNoOfRecord(Long mclToPinKey);


	@Query("select sum(e.mclStarRating) from TIdMyContactsLinkEntity e where e.mclToPinKey=?1 and e.activeStatus='A' ")
	long sumOverAllRating(Long mclToPinKey);
	
	@Query("select e.mclToPinKey from TIdMyContactsLinkEntity e where e.mclFromPinKey=?1 and e.activeStatus='A' ")
	List<Long> getMyContactList(Long pinKey);
	
	List<TIdMyContactsLinkEntity> findByMclFromPinKeyAndMclToPinKeyNotInAndActiveStatus(Long fromPinKey, List<Long> toPinKey, String activeStatus);
	
	List<TIdMyContactsLinkEntity> findByMclFromPinKeyAndActiveStatus(Long fromPinKey, String activeStatus);
	
	@Query("select e from TIdMyContactsLinkEntity e where e.mclFromPinKey=?1 and e.mclToPinKey=?2 and e.activeStatus='A' ")
	TIdMyContactsLinkEntity getMyContactsFromAndTo(Long fromPinKey, Long toPinKey);

	@Modifying
	@Transactional
    @Query("delete from TIdMyContactsLinkEntity e where e.mclFromPinKey = :mclFromPinKey and e.mclToPinKey = :mclToPinKey")
	public int removeMyContact(@Param("mclFromPinKey") Long mclFromPinKey, @Param("mclToPinKey") Long mclToPinKey);
	
	@Modifying
	@Transactional
    @Query("delete from TIdMyContactsLinkEntity e where e.mclToPinKey in (:mclToPinKey) ")
	public int removeMclToPinKey(@Param("mclToPinKey") List<Long> mclToPinKey);
	
}
