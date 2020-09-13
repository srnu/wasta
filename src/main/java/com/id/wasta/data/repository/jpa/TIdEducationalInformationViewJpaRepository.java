package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdEducationalInformationViewEntity;

/**
 * Repository : TIdEducationalInformation.
 * @param <EducationanInformationEntity>
 */
public interface TIdEducationalInformationViewJpaRepository extends BaseRepository<TIdEducationalInformationViewEntity, Long> {

	List<TIdEducationalInformationViewEntity> findByPeiPinKeyAndActiveStatusOrderByPeiKeyDesc(Long pinKey,String status);
	
	@Query("select new com.id.util.bean.common.SelectListBean (e.peiEduInstituteKey,'EDU',e.institutes) from TIdEducationalInformationViewEntity as e"
			+ " where e.peiPinKey = :peiPinKey and e.peiEduInstituteKey!=null GROUP BY e.peiEduInstituteKey ORDER BY e.peiEduInstituteKey")
	public List<SelectListBean> getRetrieveProvidedBy(@Param("peiPinKey") Long peiPinKey);
	
	@Query("select e.qualification from TIdEducationalInformationViewEntity as e where e.peiKey=?1")
	String findQualification(Long key);
	
}
