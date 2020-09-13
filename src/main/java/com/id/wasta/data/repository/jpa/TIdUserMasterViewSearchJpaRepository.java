package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdUserMasterViewSearchEntity;

public interface TIdUserMasterViewSearchJpaRepository extends BaseRepository<TIdUserMasterViewSearchEntity, Long>{

	public List<TIdUserMasterViewSearchEntity> findByKeyIn(List<Long> key);
}
