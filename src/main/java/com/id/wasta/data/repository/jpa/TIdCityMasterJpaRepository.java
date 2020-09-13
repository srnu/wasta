package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdCityMasterEntity;

/**
 * Repository : TIdCityMaster.
 */
public interface TIdCityMasterJpaRepository extends BaseRepository<TIdCityMasterEntity, Long> {

	List<TIdCityMasterEntity> findByName(String otherCityName);
	
	@Query("select cm from TIdCityMasterEntity cm where cm.name=?1 and cm.activeStatus='A'  ")
	TIdCityMasterEntity findByCity(String cityName);
	
	@Query("select e.name from TIdCityMasterEntity e where e.key=:commCityKey")
	public String getCityName(@Param("commCityKey") Long commCityKey);

	public List<TIdCityMasterEntity> findByNameAndKeyNotIn(String otherCityName, Long piadCityKey);

	public TIdCityMasterEntity findByKey(Long piadCityKey);

	//void findByCityNameLike(String cityName);
	
/*	
	@Query("select cm from TIdCityMasterEntity cm where cm.name like ?1 and cm.activeStatus='A'  ")
	public List<TIdCityMasterEntity> findByNameLike(String name);	
*/
	

}

