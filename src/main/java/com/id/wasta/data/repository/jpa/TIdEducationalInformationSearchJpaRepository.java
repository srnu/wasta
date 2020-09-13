package com.id.wasta.data.repository.jpa;


import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdEducationalInformationEntitySearch;

/**
 * Repository : TIdEducationalInformation.
 * @param <EducationanInformationEntity>
 */
public interface TIdEducationalInformationSearchJpaRepository extends BaseRepository<TIdEducationalInformationEntitySearch, Long> {

	@Query(value="delete from t_id_educational_information where peiKey=?",nativeQuery=true)
	int deleteRecord(Long peiKey);

	

}
