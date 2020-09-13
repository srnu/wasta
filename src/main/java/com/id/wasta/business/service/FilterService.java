package com.id.wasta.business.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.id.wasta.bean.TIdPersonalInformationSearch;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntitySearch;

public interface FilterService {
	public Map<String, Set<Long>> getLocationFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getCurrentCompanyFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getPastCompanyFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getIndustryFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getCollegeInstituteFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getYearOfExperienceFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getLanguageFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getProjectsExecutedFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getDegreeFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getDesignationFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getAgeFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getYearOfBirthFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getGenderFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getRelationshipsFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getBusinessOpportunityFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getPotentialServicesFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getDiscussionDetailsFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getFunctionFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getRoleFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getNationalitiesFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getRecreationFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getProfessionalExpertiseFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getProfessionalInterestsFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getPersonalInterestsFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getPersonalPrioritiesFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public Map<String, Set<Long>> getAwardsAndRecognitionFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public List<TIdPersonalInformationSearch> getPersonalInformationSearch(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList);
	public LinkedHashMap<String, Set<Long>> sortValuesByDes(HashMap<String, Set<Long>> hm);
}