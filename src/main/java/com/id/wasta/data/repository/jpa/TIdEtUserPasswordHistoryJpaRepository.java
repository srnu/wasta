package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdEtUserPasswordHistoryEntity;

/**
 * Repository : TIdEtUserPasswordHistory.
 */
public interface TIdEtUserPasswordHistoryJpaRepository extends BaseRepository<TIdEtUserPasswordHistoryEntity, Long> {

	TIdEtUserPasswordHistoryEntity findByUphUserIdAndUphPasswordHash(Long userKey, String userPassword);

	public List<TIdEtUserPasswordHistoryEntity> findByUphUserId(Long userKey);

}
