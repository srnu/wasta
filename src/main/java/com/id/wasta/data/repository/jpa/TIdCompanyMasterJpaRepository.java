package com.id.wasta.data.repository.jpa;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdCompanyMasterEntity;

/**
 * Repository : TIdCompanyMaster.
 */
public interface TIdCompanyMasterJpaRepository extends BaseRepository<TIdCompanyMasterEntity, Long> {

	@Query("select new com.id.util.bean.common.SelectListBean (e.key, e.code,e.name) from TIdCompanyMasterEntity as e where e.profileKey = :profileKey and :currentDate BETWEEN e.activeFrom AND e.activeTo and e.activeStatus = :activeStatus and e.companyGroup='Y' and e.name like :searchString")
	public List<SelectListBean> getGroupCompanies(@Param("activeStatus") String activeStatus,@Param("searchString") String searchString,@Param("profileKey") Long profileKey,@Param("currentDate") Date currentDate);
	
	@Query("select new com.id.util.bean.common.SelectListBean (e.key, e.code,e.name) from TIdCompanyMasterEntity as e where e.profileKey = :profileKey and :currentDate >= e.activeFrom and (e.activeTo is null or :currentDate <= e.activeTo) and e.activeStatus = :activeStatus and e.companyGroup='Y'")
	public List<SelectListBean> getGroupCompany(@Param("activeStatus") String activeStatus,@Param("profileKey") Long profileKey,@Param("currentDate") Date currentDate);
	
	@Query("select cm from TIdCompanyMasterEntity cm where cm.name=?1 and cm.activeStatus='A'  ")
	TIdCompanyMasterEntity findByCompany(String companyName);
	
	@Query("select e.name from TIdCompanyMasterEntity e where e.key=?1 and e.activeStatus in ('A','P')")
	String getCompanyName(Long key);
	
	@Query("select new com.id.util.bean.common.SelectListBean (e.key, e.code,e.name) from TIdCompanyMasterEntity as e where e.activeStatus in('A','P') and e.profileKey=?1 and e.name like %?2%")
	public List<SelectListBean> getAllData(Long profileKey,String searchString);
	
	@Query("select e.name from TIdCompanyMasterEntity e where e.activeStatus in('A','P') and e.profileKey=?1")
	List<String> getAllData1(Long key);
	
}
