package com.id.wasta.business.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.apache.lucene.search.Query;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.id.wasta.bean.TIdPersonalInformationSearch;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntitySearch;
import com.id.wasta.business.service.FilterService;
import com.id.wasta.business.service.SearchInfoService;
import com.id.wasta.util.action.CommonConstants;

@Service
@Transactional
public class SearchInfoServiceImpl implements SearchInfoService {

	private static final Logger logger = Logger.getLogger(SearchInfoService.class); 

	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private FilterService filterService;
	
	private static final String[] onFields={"pinFirstName","pinLastName","pinNickName","pinGender","pinEmail","pinAddress","pinRemarks","pinDobStr", 
			"listOfTIdCompanyContactLink.tIdReferenceCodesDetail.rcdValue","listOfTIdCompanyContactLink.tIdReferenceCodesDetail.rcdAbbreviation","listOfTIdCompanyContactLink.tIdCompanyMaster.name",
			"listOfTIdEducationalInformation.peiFromMonth","listOfTIdEducationalInformation.peiToMonth","listOfTIdEducationalInformation.listOfTIdSpecializationInformation.tIdSpecializationMaster.name","listOfTIdEducationalInformation.peiRemarks",
			"listOfTIdEducationalInformation.tIdEducationalInstitutes.name","listOfTIdEducationalInformation.tIdQualificationMaster.name",
			"listOfTIdExperienceInformation.pexFromMonth","listOfTIdExperienceInformation.pexToMonth","listOfTIdExperienceInformation.pexCurrentlyWorking","listOfTIdExperienceInformation.pexRemarks",
			"listOfTIdExperienceInformation.tIdDesignationMaster.name",
			"listOfTIdExperienceInformation.listOfTIdCompanyIndustryLinkEntitySearch.tIdBusinessTypeMasterEntitySearch.name",
			"listOfTIdExperienceInformation.tIdCompanyMaster.name",
			"listOfTIdExperienceInformation.tIdFunctionalAreaMaster.name",
			"listOfTIdVisitInformation.listOfVisitRemarks.pivrVisitNotes","listOfTIdVisitInformation.pivVisitPriority","listOfTIdVisitInformation.pivVisitNotes",
			"listOfTIdRelationshipInformation.prlFirstName","listOfTIdRelationshipInformation.prlLastName",
			"listOfTIdExperienceInformation.tIdCityMasterSearch.name","listOfTIdRelationshipInfoLink.prlkRelationType",
			"listOfTIdExperienceInformation.tIdCountryMasterSearch.name","listOfTIdExperienceInformation.tIdCountryMasterSearch.countryAbbreviation",
			"listOfTIdExperienceInformation.tIdStateMasterSearch.name","listOfTIdExperienceInformation.tIdStateMasterSearch.stateAbbreviation",
			"tIdNationalityMasterSearch.name",
			"listOfTIdAwardsInformation.piaAwardName","listOfTIdAwardsInformation.piaDescription",
			"listOfTIdProjectsInformation.pipProjectName","listOfTIdProjectsInformation.tIdCompanyMaster.name","listOfTIdProjectsInformation.pipDescription",
			"listOfTIdAdditionalInformation.piadPosition","listOfTIdAdditionalInformation.piadOrganization","listOfTIdAdditionalInformation.piadDescription",
			"listOfTIdLanguageInformation.tIdLanguageMaster.name","listOfTIdLanguageInformation.tIdLanguageMaster.languageDescriptionNative",
			"listOfTIdProfessionalExpertise.tIdSkillMaster.name","listOfTIdProfessionalInterests.tIdSkillMaster.name","listOfTIdPersonalInterests.tIdSkillMaster.name",
			"listOfTIdBusinessPotentialInfo.tIdSkillMaster.name","listOfTIdBusinessPotentialInfo.bpiRemarks",
			"listOfTIdAddPotentialServices.tIdSkillMaster.name","listOfTIdAddPotentialServices.apsRemarks",
			"listOfTIdPersonalPriorities.perpInfo","listOfTIdRecreationInfo.tIdRecreationMaster.name",
			"listOfTIdProfileAddressDetails.padAddressLine1","listOfTIdProfileAddressDetails.padAddressLine2","listOfTIdProfileAddressDetails.tIdCityMasterSearch.name",
			"listOfTIdProfileAddressDetails.tIdStateMasterSearch.name","listOfTIdProfileAddressDetails.tIdCountryMasterSearch.name","listOfTIdProfileAddressDetails.padPinzip",
			"listOfTIdProfileAddressDetails.tIdReferenceCodesDetail.rcdValue","listOfTIdProfileAddressDetails.tIdReferenceCodesDetail.rcdAbbreviation",
			"listOfTIdCommunicationInformation.pcmDescription","listOfTIdSocialMediaInformation.psmId",
			"tIdReferenceCodesDetail.rcdValue","tIdReferenceCodesDetail.rcdAbbreviation","listOfTIdBusinessPotentialInfo.tIdCountryMasterSearch.name","listOfTIdAddPotentialServices.tIdCountryMasterSearch.name"};
	
		
	@Autowired
	public void SomeService(EntityManagerFactory factory) {
		this.entityManagerFactory = factory;
		SessionFactory sessionFactory = factory.unwrap(SessionFactory.class);
	    org.hibernate.Session session=sessionFactory.openSession();
	    FullTextSession fullTextSession = Search.getFullTextSession(session);
		fullTextSession.setFlushMode(FlushMode.MANUAL);
		fullTextSession.setCacheMode(CacheMode.IGNORE);
		Transaction transaction = fullTextSession.beginTransaction();
		ScrollableResults results = fullTextSession.createCriteria(TIdPersonalInformationEntitySearch.class).scroll( ScrollMode.FORWARD_ONLY );
		int index = 0;
		while( results.next() ) {
		    index++;
		    fullTextSession.index( results.get(0) ); //index each element
		    if (index % 100 == 0) {
		        fullTextSession.flushToIndexes(); //apply changes to indexes
		        fullTextSession.clear(); //free memory since the queue is processed
		    }
		}
		transaction.commit();
	}
	
	@Override
	public Map<String, Object> getSearchInfoDtls(String searchKey,boolean admin) throws InterruptedException, ExecutionException {
		EntityManager em = entityManagerFactory.createEntityManager();
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
		QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(TIdPersonalInformationEntitySearch.class).get();
		BooleanJunction<BooleanJunction> booleanJunction= qb.bool();
		String[] searchKeys = searchKey.toLowerCase().split("\\s+");
		for(String key : searchKeys) {
			if(key.contains("@")) {
				key = key.substring(0, key.indexOf("@"));
			}
			booleanJunction.should(qb.keyword().wildcard().onFields(onFields).matching(key+"*").createQuery());
		}
		Query luceneQuery=booleanJunction.createQuery();
		javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, TIdPersonalInformationEntitySearch.class);
		long start = System.currentTimeMillis();
		List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList1 = jpaQuery.getResultList();
        logger.info("Time Taken to search = "+(System.currentTimeMillis()-start));
		if(!admin) {
			tIdPersonalInformationEntitySearchList1 = tIdPersonalInformationEntitySearchList1.stream().filter(p -> p.getActiveStatus().equals(CommonConstants.ACTIVE)).collect(Collectors.toList());
		}
		List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList = tIdPersonalInformationEntitySearchList1;
		Map<String, Object> filtersMap = getFilersMap(tIdPersonalInformationEntitySearchList);
		em.close();
		return filtersMap;
	}	
	
	private Map<String, Object>  getFilersMap(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		long start = System.currentTimeMillis();
		Map<String, Object> filtersMap = new LinkedHashMap <String, Object>();
		filtersMap.put("Locations", 			filterService.getLocationFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Relationship Type", 	filterService.getRelationshipsFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Business Opportunity", 	filterService.getBusinessOpportunityFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Potential Services", 	filterService.getPotentialServicesFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Discussion Details", 	filterService.getDiscussionDetailsFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Industry", 				filterService.getIndustryFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Current Company", 		filterService.getCurrentCompanyFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Past Company", 			filterService.getPastCompanyFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Function", 				filterService.getFunctionFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Role", 					filterService.getRoleFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Designation", 			filterService.getDesignationFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Degree", 				filterService.getDegreeFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("College/Institute", 	filterService.getCollegeInstituteFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Projects Executed", 	filterService.getProjectsExecutedFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Language", 				filterService.getLanguageFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Nationalities", 		filterService.getNationalitiesFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Recreation", 			filterService.getRecreationFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Professional Expertise",filterService.getProfessionalExpertiseFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Professional Interests",filterService.getProfessionalInterestsFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Personal Interests", 	filterService.getPersonalInterestsFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Personal Priorities", 	filterService.getPersonalPrioritiesFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Age", 					filterService.getAgeFilter(tIdPersonalInformationEntitySearchList));
		filtersMap.put("Awards & Recognition", 	filterService.getAwardsAndRecognitionFilter(tIdPersonalInformationEntitySearchList));
		//filtersMap.put("Gender", 				filterService.getGenderFilter(tIdPersonalInformationEntitySearchList));
		//filtersMap.put("Years of Expreience", filterService.getYearOfExperienceFilter(tIdPersonalInformationEntitySearchList));
		//filtersMap.put("Year of Birth", 		filterService.getYearOfBirthFilter(tIdPersonalInformationEntitySearchList));
		logger.info("Time Taken to fill filters = "+(System.currentTimeMillis()-start));
		Map<String, Object> searchMap = new HashMap<String, Object>();
		List<TIdPersonalInformationSearch> tIdPersonalInformationSearchList =  filterService.getPersonalInformationSearch(tIdPersonalInformationEntitySearchList);
		searchMap.put("filters", filtersMap);
		searchMap.put("profiles", tIdPersonalInformationSearchList);
		return searchMap;
	} 
	 
}