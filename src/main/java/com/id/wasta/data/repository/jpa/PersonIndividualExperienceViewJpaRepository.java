package com.id.wasta.data.repository.jpa;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.id.util.bean.common.SelectListBean;
import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.PersonIndividualExperienceViewEntity;

public interface PersonIndividualExperienceViewJpaRepository extends BaseRepository<PersonIndividualExperienceViewEntity,Long>{

	List<PersonIndividualExperienceViewEntity> findByProfileKey(Long profileKey);
	
	@Query("select new com.id.util.bean.common.SelectListBean (e.pinKey , e.pinFirstName ,e.pinFirstName||' '||e.pinLastName) from PersonIndividualExperienceViewEntity as e where e.userKey != '0' ")
	List<SelectListBean> getCustInfo();

	public List<PersonIndividualExperienceViewEntity> findByPinFirstNameAndPinLastNameAndDesignationKeyAndFunctionalAreaKeyAndRoleKeyAndCompanyKeyAndPinKeyNotIn(
			String firstName, String lastName, Long designKey, Long functionKey, Long roleKey, Long companyKey, Long pinKey);
	
	public List<PersonIndividualExperienceViewEntity> findByPinFirstNameAndPinLastNameAndDesignationKeyAndFunctionalAreaKeyAndCompanyKeyAndPinKeyNotIn(
			String firstName, String lastName, Long designKey, Long functionKey, Long companyKey, Long pinKey);
	
	public List<PersonIndividualExperienceViewEntity> findByPinFirstNameAndPinLastNameAndDesignationKeyAndRoleKeyAndCompanyKeyAndPinKeyNotIn(
			String firstName, String lastName, Long designKey, Long roleKey, Long companyKey, Long pinKey);
	
	public List<PersonIndividualExperienceViewEntity> findByPinFirstNameAndPinLastNameAndDesignationKeyAndCompanyKeyAndPinKeyNotIn(
			String firstName, String lastName, Long designKey, Long companyKey, Long pinKey);
	
	List<PersonIndividualExperienceViewEntity> findByPinFirstNameAndPinLastNameAndPinKeyNotInAndActiveStatus(String firstName, String lastName, Long pinKey, String activeStatus);

	List<PersonIndividualExperienceViewEntity> findByUserKeyAndActiveStatusOrderByPinFirstName(Long userKey, String activeStatus);
	
	List<PersonIndividualExperienceViewEntity> findByUserKeyIsNotOrderByPinFirstName(Long userKey);
	
	
	List<PersonIndividualExperienceViewEntity> findByUserKeyIsNotAndPinKeyIsNotOrderByPinFirstNameAsc(Long userKey, Long pinKey);
	
	List<PersonIndividualExperienceViewEntity> findByUserKey(Long userKey);
	
	
	List<PersonIndividualExperienceViewEntity> findByPinKeyInOrderByPinFirstName(List<Long> pinKey);	
	
	@Query("select count(*) from PersonIndividualExperienceViewEntity e where e.userKey !=0 ")
	Long getProfileCount();
	

	List<PersonIndividualExperienceViewEntity> findByPinFirstNameAndPinLastNameAndDesignationAndFunctionalAreaAndRoleAndCompanyAndPinKeyNotIn(
			String firstName, String lastName, String design, String function, String role, String company,
			Long pinKey);

	List<PersonIndividualExperienceViewEntity> findByPinFirstNameAndPinLastNameAndDesignationAndFunctionalAreaAndCompanyAndPinKeyNotIn(
			String firstName, String lastName, String design, String function, String company, Long pinKey);

	List<PersonIndividualExperienceViewEntity> findByPinFirstNameAndPinLastNameAndDesignationAndRoleAndCompanyAndPinKeyNotIn(
			String firstName, String lastName, String design, String role, String company, Long pinKey);

	List<PersonIndividualExperienceViewEntity> findByPinFirstNameAndPinLastNameAndDesignationAndCompanyAndPinKeyNotIn(
			String firstName, String lastName, String design, String company, Long pinKey);

	@Query("select e from PersonIndividualExperienceViewEntity as e where e.pinKey =?1")
	PersonIndividualExperienceViewEntity getPersonalObjByCreatorKey(Long creatorPinKey);

	@Query("select e.pinCreatorKey from PersonIndividualExperienceViewEntity as e where e.pinKey =?1 ")
	Long getCreatorKeyByPinKey(Long long1);

	List<PersonIndividualExperienceViewEntity> findByPinKeyIn(List<Long> pinKeyList);
	
	
	
}