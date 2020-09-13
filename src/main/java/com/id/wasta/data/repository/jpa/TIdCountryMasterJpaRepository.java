package com.id.wasta.data.repository.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdCountryMasterEntity;

/**
 * Repository : TIdCountryMaster.
 */
public interface TIdCountryMasterJpaRepository extends BaseRepository<TIdCountryMasterEntity, Long> {

	@Query("select cm from TIdCountryMasterEntity cm where cm.name=?1 and cm.activeStatus='A'  ")
	TIdCountryMasterEntity findByCountry(String countryName);
	
	@Query("select e.name from TIdCountryMasterEntity e where e.key=:commCountryKey")
	public String getCountryName(@Param("commCountryKey") Long commCountryKey);	
}
