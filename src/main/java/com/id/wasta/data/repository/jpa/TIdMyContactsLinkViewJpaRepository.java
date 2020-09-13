package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdMyContactsLinkViewEntity;

public interface TIdMyContactsLinkViewJpaRepository extends BaseRepository<TIdMyContactsLinkViewEntity,Long> {
	@Query("select e from TIdMyContactsLinkViewEntity as e where e.mclToPinKey = :mclToPinKey and e.activeStatus='A'")
	List<TIdMyContactsLinkViewEntity> getCustInfo(@Param("mclToPinKey") Long mclToPinKey);

}
