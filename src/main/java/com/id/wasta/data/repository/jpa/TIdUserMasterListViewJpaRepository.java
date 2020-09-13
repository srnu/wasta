package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdUserMasterListViewEntity;

public interface TIdUserMasterListViewJpaRepository extends BaseRepository<TIdUserMasterListViewEntity, Long>{

	List<TIdUserMasterListViewEntity> findByUserCode(String userCode);

}
