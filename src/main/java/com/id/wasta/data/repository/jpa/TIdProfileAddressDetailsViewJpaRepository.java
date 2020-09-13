package com.id.wasta.data.repository.jpa;

import java.util.List;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdProfileAddressDetailsViewEntity;

public interface TIdProfileAddressDetailsViewJpaRepository extends BaseRepository<TIdProfileAddressDetailsViewEntity,Long> {

	List<TIdProfileAddressDetailsViewEntity> findByPadPinKeyOrderByPadAddressType(Long pinKey);
	
	List<TIdProfileAddressDetailsViewEntity> findByPadPinKeyAndAddressTypeAbbreviation(Long pinKey, String AddressTypeAbbreviation);

}

