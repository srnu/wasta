package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdEtUserPasswordResetLinkEntity;

/**
 * Repository : TIdEtUserPasswordResetLink.
 */
public interface TIdEtUserPasswordResetLinkJpaRepository extends BaseRepository<TIdEtUserPasswordResetLinkEntity, Long> {

	List<TIdEtUserPasswordResetLinkEntity> findByUprlUserIdAndUprlLinkActive(Long userId,Boolean status);
	
	@Query("select e from TIdEtUserPasswordResetLinkEntity as e where e.uprlUserId=:userId AND e.uprlLinkActive=:linkActive")
	TIdEtUserPasswordResetLinkEntity findByUprlUserId(@Param("userId")Long userId,@Param("linkActive") Boolean linkActive);
}
