package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdCommonAddressesEntity;

public interface TIdCommonAddressesJpaRepository extends BaseRepository<TIdCommonAddressesEntity,Long>  {

	List<TIdCommonAddressesEntity> findByCommEmail(String userEmail);
	
	TIdCommonAddressesEntity findByCommAddressKeyAndCommEmail(Long commAddressKey, String userEmail);
	
	TIdCommonAddressesEntity findByCommAddressKey(Long commAddressKey);
	
}
