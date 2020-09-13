package com.id.wasta.business.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.id.wasta.bean.TIdPersonalInformationSearch;
import com.id.wasta.bean.jpa.TIdAddPotentialServicesEntitySearch;
import com.id.wasta.bean.jpa.TIdAwardsInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdBusinessPotentialInfoEntitySearch;
import com.id.wasta.bean.jpa.TIdCompanyContactLinkEntitySearch;
import com.id.wasta.bean.jpa.TIdCompanyIndustryLinkEntitySearch;
import com.id.wasta.bean.jpa.TIdEducationalInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdExperienceInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdLanguageInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdPersonalInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdPersonalInterestsEntitySearch;
import com.id.wasta.bean.jpa.TIdPersonalPrioritiesEntitySearch;
import com.id.wasta.bean.jpa.TIdProductAttachmentEntity;
import com.id.wasta.bean.jpa.TIdProfessionalExpertiseEntitySearch;
import com.id.wasta.bean.jpa.TIdProfessionalInterestsEntitySearch;
import com.id.wasta.bean.jpa.TIdProjectsInformationEntitySearch;
import com.id.wasta.bean.jpa.TIdRecreationInfoEntitySearch;
import com.id.wasta.bean.jpa.TIdRelationshipInfoLinkEntitySearch;
import com.id.wasta.bean.jpa.TIdVisitInformationEntitySearch;
import com.id.wasta.business.service.FilterService;
import com.id.wasta.business.service.mapper.TIdPersonalInformationServiceSearchMapper;
import com.id.wasta.data.repository.jpa.TIdProductAttachmentJpaRepository;
import com.id.wasta.util.action.StringUtil;

@Service
public class FilterServiceImpl implements FilterService { 
	
	@Resource
	private TIdPersonalInformationServiceSearchMapper tIdPersonalInformationServiceSearchMapper;
	
	@Resource
	private TIdProductAttachmentJpaRepository tIdProductAttachmentJpaRepository;
	
	public Map<String, Set<Long>> getLocationFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> locationsMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()!=null) {
				for(TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()) {
					String LocString = null;
					if(tIdExperienceInformationEntitySearch.getTIdCityMasterSearch()!=null) {
						LocString = tIdExperienceInformationEntitySearch.getTIdCityMasterSearch().getName();
					}
					if(tIdExperienceInformationEntitySearch.getTIdCountryMasterSearch()!=null) {
						if(LocString!=null) {
							LocString = LocString+","+tIdExperienceInformationEntitySearch.getTIdCountryMasterSearch().getName();
						} else {
							LocString = tIdExperienceInformationEntitySearch.getTIdCountryMasterSearch().getName();
						}
					}
					if(LocString!=null) {
						if(locationsMap.containsKey(LocString)) {
							filterSet = locationsMap.get(LocString);
						} else {
							filterSet = new HashSet<>();
						}
						filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
						if(!StringUtil.isBlank(LocString)) {
							locationsMap.put(LocString.trim(), filterSet);
						}
					}
					/*if(tIdExperienceInformationEntitySearch.getTIdCountryMasterSearch()!=null) {
						if(locationsMap.containsKey(tIdExperienceInformationEntitySearch.getTIdCountryMasterSearch().getName())) {
							filterSet = locationsMap.get(tIdExperienceInformationEntitySearch.getTIdCountryMasterSearch().getName());
						} else {
							filterSet = new HashSet<>();
						}
						filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
						if(!StringUtil.isBlank(tIdExperienceInformationEntitySearch.getTIdCountryMasterSearch().getName())) {
							locationsMap.put(tIdExperienceInformationEntitySearch.getTIdCountryMasterSearch().getName().trim(), filterSet);
						}
					}*/
				}
			}
		}
		return sortValuesByDes(locationsMap);
	}
	
	@Override
	public LinkedHashMap<String, Set<Long>> sortValuesByDes(HashMap<String, Set<Long>> hm) { 
		 	
		 	LinkedHashMap<String, Long> valuesSize = new LinkedHashMap<String, Long>();
		 	LinkedHashMap<String, Set<Long>> sortedMap = new LinkedHashMap<String, Set<Long>>();
	        Iterator<Map.Entry<String, Set<Long>>> itr = hm.entrySet().iterator(); 

	        while(itr.hasNext()) 
	        { 
	             Map.Entry<String, Set<Long>> entry = itr.next(); 
	             valuesSize.put(entry.getKey(), (long) (entry.getValue().size()));
	        } 
	        
	        valuesSize.entrySet()
	        .stream()
	        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
	        .forEachOrdered(x -> sortedMap.put(x.getKey(), hm.get(x.getKey())));
	        return sortedMap; 
	  } 
	
	@Override
	public Map<String, Set<Long>> getCurrentCompanyFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> currentCompanyMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()!=null) {
				for(TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()) {
					if("Y".equals(tIdExperienceInformationEntitySearch.getPexCurrentlyWorking())) {
						if(currentCompanyMap.containsKey(tIdExperienceInformationEntitySearch.getTIdCompanyMaster().getName())) {
							filterSet = currentCompanyMap.get(tIdExperienceInformationEntitySearch.getTIdCompanyMaster().getName());
						} else {
							filterSet = new HashSet<>();
						}
						filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
						if(!StringUtil.isBlank(tIdExperienceInformationEntitySearch.getTIdCompanyMaster().getName())) {
							currentCompanyMap.put(tIdExperienceInformationEntitySearch.getTIdCompanyMaster().getName().trim(), filterSet);
						}
					}
				}
			}
		}
		return sortValuesByDes(currentCompanyMap);
	}

	@Override
	public Map<String, Set<Long>> getPastCompanyFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> pastCompanyMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();

		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()!=null) {
				for(TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()) {
					if(!"Y".equals(tIdExperienceInformationEntitySearch.getPexCurrentlyWorking())) {
						if(pastCompanyMap.containsKey(tIdExperienceInformationEntitySearch.getTIdCompanyMaster().getName())) {
							filterSet = pastCompanyMap.get(tIdExperienceInformationEntitySearch.getTIdCompanyMaster().getName());
						} else {
							filterSet = new HashSet<>();
						}
						filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
						if(!StringUtil.isBlank(tIdExperienceInformationEntitySearch.getTIdCompanyMaster().getName())) {
							pastCompanyMap.put(tIdExperienceInformationEntitySearch.getTIdCompanyMaster().getName().trim(), filterSet);
						}
					}
				}
			}
		}
		return sortValuesByDes(pastCompanyMap);
	}

	@Override
	public Map<String, Set<Long>> getIndustryFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> industryMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()!=null) {
				for(TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()) {
					if(tIdExperienceInformationEntitySearch.getListOfTIdCompanyIndustryLinkEntitySearch()!=null) {
						for(TIdCompanyIndustryLinkEntitySearch tIdCompanyIndustryLinkEntitySearch : tIdExperienceInformationEntitySearch.getListOfTIdCompanyIndustryLinkEntitySearch()) {
							
							if(industryMap.containsKey(tIdCompanyIndustryLinkEntitySearch.gettIdBusinessTypeMasterEntitySearch().getName())) {
								filterSet = industryMap.get(tIdCompanyIndustryLinkEntitySearch.gettIdBusinessTypeMasterEntitySearch().getName());
							} else {
								filterSet = new HashSet<>();
							}
							filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
							if(!StringUtil.isBlank(tIdCompanyIndustryLinkEntitySearch.gettIdBusinessTypeMasterEntitySearch().getName())) {
								industryMap.put(tIdCompanyIndustryLinkEntitySearch.gettIdBusinessTypeMasterEntitySearch().getName().trim(), filterSet);
							}
						}
					}
				}
			}
		}
		return sortValuesByDes(industryMap);
	}

	@Override
	public Map<String, Set<Long>> getCollegeInstituteFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> collegeInstituteMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdEducationalInformation()!=null) {
				for(TIdEducationalInformationEntitySearch tIdEducationalInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdEducationalInformation()) {
					if(tIdEducationalInformationEntitySearch.getTIdEducationalInstitutes()!=null) {
						if(collegeInstituteMap.containsKey(tIdEducationalInformationEntitySearch.getTIdEducationalInstitutes().getName())) {
							filterSet = collegeInstituteMap.get(tIdEducationalInformationEntitySearch.getTIdEducationalInstitutes().getName());
						} else {
							filterSet = new HashSet<>();
						}
						filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
						if(!StringUtil.isBlank(tIdEducationalInformationEntitySearch.getTIdEducationalInstitutes().getName())) {
							collegeInstituteMap.put(tIdEducationalInformationEntitySearch.getTIdEducationalInstitutes().getName().trim(), filterSet);
						}
					}
				}
			}
		}
		return sortValuesByDes(collegeInstituteMap);
	}

	@Override
	public Map<String, Set<Long>> getYearOfExperienceFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> yearOfExperienceMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()!=null) {
				for(TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()) {
					if(tIdExperienceInformationEntitySearch.getPexExperienceYears()!=null) {
						
						if(yearOfExperienceMap.containsKey(tIdExperienceInformationEntitySearch.getPexExperienceYears().toString())) {
							filterSet = yearOfExperienceMap.get(tIdExperienceInformationEntitySearch.getPexExperienceYears().toString());
						} else {
							filterSet = new HashSet<>();
						}
						filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
						if(!StringUtil.isBlank(tIdExperienceInformationEntitySearch.getPexExperienceYears().toString())) {
							yearOfExperienceMap.put(tIdExperienceInformationEntitySearch.getPexExperienceYears().toString().trim(), filterSet);
						}
					}
				}
			}
		}
		
		return sortValuesByDes(yearOfExperienceMap);
	}

	@Override
	public Map<String, Set<Long>> getLanguageFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> languageMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdLanguageInformation()!=null) {
				for(TIdLanguageInformationEntitySearch tIdLanguageInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdLanguageInformation()) {
					if(languageMap.containsKey(tIdLanguageInformationEntitySearch.getTIdLanguageMaster().getName())) {
						filterSet = languageMap.get(tIdLanguageInformationEntitySearch.getTIdLanguageMaster().getName());
					} else {
						filterSet = new HashSet<>();
					}
					filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
					if(!StringUtil.isBlank(tIdLanguageInformationEntitySearch.getTIdLanguageMaster().getName())) {
						languageMap.put(tIdLanguageInformationEntitySearch.getTIdLanguageMaster().getName().trim(), filterSet);
					}
				}
			}
		}
		return sortValuesByDes(languageMap);
	}

	@Override
	public Map<String, Set<Long>> getProjectsExecutedFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> projectsExecutedMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdProjectsInformation()!=null) {
				for(TIdProjectsInformationEntitySearch tIdProjectsInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdProjectsInformation()) {
					if(projectsExecutedMap.containsKey(tIdProjectsInformationEntitySearch.getPipProjectName())) {
						filterSet = projectsExecutedMap.get(tIdProjectsInformationEntitySearch.getPipProjectName());
					} else {
						filterSet = new HashSet<>();
					}
					filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
					if(!StringUtil.isBlank(tIdProjectsInformationEntitySearch.getPipProjectName())) {
						projectsExecutedMap.put(tIdProjectsInformationEntitySearch.getPipProjectName().trim(), filterSet);
					}
				}
			}
		}
		
		return sortValuesByDes(projectsExecutedMap);
	}

	@Override
	public Map<String, Set<Long>> getDegreeFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> degreeMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdEducationalInformation()!=null) {
				for(TIdEducationalInformationEntitySearch tIdEducationalInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdEducationalInformation()) {
					if(tIdEducationalInformationEntitySearch.gettIdQualificationMaster()!=null) {
						if(degreeMap.containsKey(tIdEducationalInformationEntitySearch.gettIdQualificationMaster().getName())) {
							filterSet = degreeMap.get(tIdEducationalInformationEntitySearch.gettIdQualificationMaster().getName());
						} else {
							filterSet = new HashSet<>();
						}
						filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
						if(!StringUtil.isBlank(tIdEducationalInformationEntitySearch.gettIdQualificationMaster().getName())) {
							degreeMap.put(tIdEducationalInformationEntitySearch.gettIdQualificationMaster().getName().trim(), filterSet);
						}
					}
				}	
			}
		}
		
		return sortValuesByDes(degreeMap);
	}

	@Override
	public Map<String, Set<Long>> getDesignationFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> designationMap  = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()!=null) {
				for(TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()) {
					if(tIdExperienceInformationEntitySearch.getTIdDesignationMaster()!=null) {
						
						if(designationMap.containsKey(tIdExperienceInformationEntitySearch.getTIdDesignationMaster().getName())) {
							filterSet = designationMap.get(tIdExperienceInformationEntitySearch.getTIdDesignationMaster().getName());
						} else {
							filterSet = new HashSet<>();
						}
						filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
						if(!StringUtil.isBlank(tIdExperienceInformationEntitySearch.getTIdDesignationMaster().getName())) {
							designationMap.put(tIdExperienceInformationEntitySearch.getTIdDesignationMaster().getName().trim(), filterSet);
						}
					}
				}
			}
		}
		
		return sortValuesByDes(designationMap);
	}

	@Override
	public Map<String, Set<Long>> getAgeFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> ageMap = new LinkedHashMap<>();
		Set<Long> filterSet = new HashSet<>();
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.setTime(new Date());
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getPinDob()!=null) {
			    cal2.setTime(tIdPersonalInformationEntitySearch.getPinDob());
			    int currentAge = cal.get(Calendar.YEAR)-cal2.get(Calendar.YEAR);
			    if(cal.get(Calendar.DAY_OF_YEAR) < cal2.get(Calendar.DAY_OF_YEAR)) {
			    	currentAge--;
			    }
				tIdPersonalInformationEntitySearch.setAge(Long.valueOf(currentAge));
				
				if(ageMap.containsKey(tIdPersonalInformationEntitySearch.getAge().toString())) {
					filterSet = ageMap.get(tIdPersonalInformationEntitySearch.getAge().toString());
				} else {
					filterSet = new HashSet<>();
				}
				filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
				if(tIdPersonalInformationEntitySearch.getAge()!=null) {
					ageMap.put(tIdPersonalInformationEntitySearch.getAge()+"", filterSet);
				}
			}
		}
		return sortValuesByDes(ageMap);
	}

	@Override
	public Map<String, Set<Long>> getYearOfBirthFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> yearOfBirthMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.setTime(new Date());
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getPinDob()!=null) {
			    cal2.setTime(tIdPersonalInformationEntitySearch.getPinDob());
			    tIdPersonalInformationEntitySearch.setYearOfBirth(Long.valueOf(cal2.get(Calendar.YEAR)));
			    
			    if(yearOfBirthMap.containsKey(tIdPersonalInformationEntitySearch.getYearOfBirth())) {
					filterSet = yearOfBirthMap.get(tIdPersonalInformationEntitySearch.getYearOfBirth());
				} else {
					filterSet = new HashSet<>();
				}
				filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
				if(tIdPersonalInformationEntitySearch.getYearOfBirth()!=null) {
					yearOfBirthMap.put(tIdPersonalInformationEntitySearch.getYearOfBirth()+"", filterSet);
				}
			}
		}
		
		return sortValuesByDes(yearOfBirthMap);
	}

	@Override
	public Map<String, Set<Long>> getGenderFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> genderMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(genderMap.containsKey(tIdPersonalInformationEntitySearch.getPinGender())) {
				filterSet = genderMap.get(tIdPersonalInformationEntitySearch.getPinGender());
			} else {
				filterSet = new HashSet<>();
			}
			filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
			if(!StringUtil.isBlank(tIdPersonalInformationEntitySearch.getPinGender())) {
				genderMap.put(tIdPersonalInformationEntitySearch.getPinGender().trim(), filterSet);
			}
		}
		
		return sortValuesByDes(genderMap);
	}

	@Override
	public Map<String, Set<Long>> getRelationshipsFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>>  relationshipsMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdCompanyContactLink()!=null) {
				for(TIdCompanyContactLinkEntitySearch tIdCompanyContactLinkEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdCompanyContactLink()) {
					if(relationshipsMap.containsKey(tIdCompanyContactLinkEntitySearch.getTIdReferenceCodesDetail().getRcdAbbreviation())) {
						filterSet = relationshipsMap.get(tIdCompanyContactLinkEntitySearch.getTIdReferenceCodesDetail().getRcdAbbreviation());
					} else {
						filterSet = new HashSet<>();
					}
					filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
					if(!StringUtil.isBlank(tIdCompanyContactLinkEntitySearch.getTIdReferenceCodesDetail().getRcdAbbreviation())) {
						relationshipsMap.put(tIdCompanyContactLinkEntitySearch.getTIdReferenceCodesDetail().getRcdAbbreviation().trim(), filterSet);
					}
				}
			}
			if(tIdPersonalInformationEntitySearch.getListOfTIdRelationshipInfoLink()!=null) {
				for(TIdRelationshipInfoLinkEntitySearch tIdRelationshipInfoLinkEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdRelationshipInfoLink()) {
					if(tIdRelationshipInfoLinkEntitySearch.getPrlkContact()==1) {
						if(relationshipsMap.containsKey(tIdRelationshipInfoLinkEntitySearch.getPrlkRelationType())) {
							filterSet = relationshipsMap.get(tIdRelationshipInfoLinkEntitySearch.getPrlkRelationType());
						} else {
							filterSet = new HashSet<>();
						}
						filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
						if(!StringUtil.isBlank(tIdRelationshipInfoLinkEntitySearch.getPrlkRelationType())) {
							relationshipsMap.put(tIdRelationshipInfoLinkEntitySearch.getPrlkRelationType().trim(), filterSet);
						}
					}
				}
			}
		}
		return sortValuesByDes(relationshipsMap);
	}

	@Override
	public Map<String, Set<Long>> getBusinessOpportunityFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> businessOpportunityMap  = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdBusinessPotentialInfo()!=null) {
				for(TIdBusinessPotentialInfoEntitySearch tIdBusinessPotentialInfoEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdBusinessPotentialInfo()) {
					if(businessOpportunityMap.containsKey(tIdBusinessPotentialInfoEntitySearch.gettIdSkillMaster().getName())) {
						filterSet = businessOpportunityMap.get(tIdBusinessPotentialInfoEntitySearch.gettIdSkillMaster().getName());
					} else {
						filterSet = new HashSet<>();
					}
					filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
					if(!StringUtil.isBlank(tIdBusinessPotentialInfoEntitySearch.gettIdSkillMaster().getName())) {
						businessOpportunityMap.put(tIdBusinessPotentialInfoEntitySearch.gettIdSkillMaster().getName().trim(), filterSet);
					}
				}
			}
		}
		return sortValuesByDes(businessOpportunityMap);
	}

	@Override
	public Map<String, Set<Long>> getPotentialServicesFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> potentialServicesMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdAddPotentialServices()!=null) {
				for(TIdAddPotentialServicesEntitySearch tIdAddPotentialServicesEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdAddPotentialServices()) {
					if(potentialServicesMap.containsKey(tIdAddPotentialServicesEntitySearch.gettIdSkillMaster().getName())) {
						filterSet = potentialServicesMap.get(tIdAddPotentialServicesEntitySearch.gettIdSkillMaster().getName());
					} else {
						filterSet = new HashSet<>();
					}
					filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
					if(!StringUtil.isBlank(tIdAddPotentialServicesEntitySearch.gettIdSkillMaster().getName())) {
						potentialServicesMap.put(tIdAddPotentialServicesEntitySearch.gettIdSkillMaster().getName().trim(), filterSet);
					}
				}
			}
		}
		return sortValuesByDes(potentialServicesMap);
	}

	@Override
	public Map<String, Set<Long>> getDiscussionDetailsFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> discussionDetailsMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdVisitInformation()!=null) {
				for(TIdVisitInformationEntitySearch tIdVisitInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdVisitInformation()) {
					if(discussionDetailsMap.containsKey(tIdVisitInformationEntitySearch.getTIdReferenceCodesDetail2().getRcdValue())) {
						filterSet = discussionDetailsMap.get(tIdVisitInformationEntitySearch.getTIdReferenceCodesDetail2().getRcdValue());
					} else {
						filterSet = new HashSet<>();
					}
					filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
					if(!StringUtil.isBlank(tIdVisitInformationEntitySearch.getTIdReferenceCodesDetail2().getRcdValue())) {
						discussionDetailsMap.put(tIdVisitInformationEntitySearch.getTIdReferenceCodesDetail2().getRcdValue().trim(), filterSet);
					}
				}
			}
		}
		return sortValuesByDes(discussionDetailsMap);
	}

	@Override
	public Map<String, Set<Long>> getFunctionFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> functionMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()!=null) {
				for(TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()) {
					if(tIdExperienceInformationEntitySearch.getTIdFunctionalAreaMaster()!=null) {
						
						if(functionMap.containsKey(tIdExperienceInformationEntitySearch.getTIdFunctionalAreaMaster().getName())) {
							filterSet = functionMap.get(tIdExperienceInformationEntitySearch.getTIdFunctionalAreaMaster().getName());
						} else {
							filterSet = new HashSet<>();
						}
						filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
						if(!StringUtil.isBlank(tIdExperienceInformationEntitySearch.getTIdFunctionalAreaMaster().getName())) {
							functionMap.put(tIdExperienceInformationEntitySearch.getTIdFunctionalAreaMaster().getName().trim(), filterSet);
						}
					}
				}
			}
		}
		
		return sortValuesByDes(functionMap);
	}

	@Override
	public Map<String, Set<Long>> getRoleFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> roleMap  = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()!=null) {
				for(TIdExperienceInformationEntitySearch tIdExperienceInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdExperienceInformation()) {
					if(tIdExperienceInformationEntitySearch.gettIdReferenceCodesDetail()!=null) {
						
						if(roleMap.containsKey(tIdExperienceInformationEntitySearch.gettIdReferenceCodesDetail().getRcdValue())) {
							filterSet = roleMap.get(tIdExperienceInformationEntitySearch.gettIdReferenceCodesDetail().getRcdValue());
						} else {
							filterSet = new HashSet<>();
						}
						filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
						if(!StringUtil.isBlank(tIdExperienceInformationEntitySearch.gettIdReferenceCodesDetail().getRcdValue())) {
							roleMap.put(tIdExperienceInformationEntitySearch.gettIdReferenceCodesDetail().getRcdValue().trim(), filterSet);
						}
					}
				}
			}
		}
		return sortValuesByDes(roleMap);
	}

	@Override
	public Map<String, Set<Long>> getNationalitiesFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> nationalitiesMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.gettIdNationalityMasterSearch()!=null) {
				if(nationalitiesMap.containsKey(tIdPersonalInformationEntitySearch.gettIdNationalityMasterSearch().getName())) {
					filterSet = nationalitiesMap.get(tIdPersonalInformationEntitySearch.gettIdNationalityMasterSearch().getName());
				} else {
					filterSet = new HashSet<>();
				}
				filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
				if(!StringUtil.isBlank(tIdPersonalInformationEntitySearch.gettIdNationalityMasterSearch().getName())) {
					nationalitiesMap.put(tIdPersonalInformationEntitySearch.gettIdNationalityMasterSearch().getName().trim(), filterSet);
				}
			}
		}
		
		return sortValuesByDes(nationalitiesMap);
	}

	@Override
	public Map<String, Set<Long>> getRecreationFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> recreationMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdRecreationInfo()!=null) {
				for(TIdRecreationInfoEntitySearch tIdRecreationInfoEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdRecreationInfo()) {
					if(recreationMap.containsKey(tIdRecreationInfoEntitySearch.gettIdRecreationMaster().getName())) {
						filterSet = recreationMap.get(tIdRecreationInfoEntitySearch.gettIdRecreationMaster().getName());
					} else {
						filterSet = new HashSet<>();
					}
					filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
					if(!StringUtil.isBlank(tIdRecreationInfoEntitySearch.gettIdRecreationMaster().getName())) {
						recreationMap.put(tIdRecreationInfoEntitySearch.gettIdRecreationMaster().getName().trim(), filterSet);
					}
				}
			}
		}
		
		return sortValuesByDes(recreationMap);
	}

	@Override
	public Map<String, Set<Long>> getProfessionalExpertiseFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> professionalExpertiseMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdProfessionalExpertise()!=null) {
				for(TIdProfessionalExpertiseEntitySearch tIdProfessionalExpertiseEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdProfessionalExpertise()) {
					if(professionalExpertiseMap.containsKey(tIdProfessionalExpertiseEntitySearch.gettIdSkillMaster().getName())) {
						filterSet = professionalExpertiseMap.get(tIdProfessionalExpertiseEntitySearch.gettIdSkillMaster().getName());
					} else {
						filterSet = new HashSet<>();
					}
					filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
					if(!StringUtil.isBlank(tIdProfessionalExpertiseEntitySearch.gettIdSkillMaster().getName())) {
						professionalExpertiseMap.put(tIdProfessionalExpertiseEntitySearch.gettIdSkillMaster().getName().trim(), filterSet);
					}
				}
			}
		}
		
		return sortValuesByDes(professionalExpertiseMap);
	}

	@Override
	public Map<String, Set<Long>> getProfessionalInterestsFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> professionalInterestsMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdProfessionalInterests()!=null) {
				for(TIdProfessionalInterestsEntitySearch tIdProfessionalInterestsEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdProfessionalInterests()) {
					if(professionalInterestsMap.containsKey(tIdProfessionalInterestsEntitySearch.gettIdSkillMaster().getName())) {
						filterSet = professionalInterestsMap.get(tIdProfessionalInterestsEntitySearch.gettIdSkillMaster().getName());
					} else {
						filterSet = new HashSet<>();
					}
					filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
					if(!StringUtil.isBlank(tIdProfessionalInterestsEntitySearch.gettIdSkillMaster().getName())) {
						professionalInterestsMap.put(tIdProfessionalInterestsEntitySearch.gettIdSkillMaster().getName().trim(), filterSet);
					}
				}
			}
		}
	
		return sortValuesByDes(professionalInterestsMap);
	}

	@Override
	public Map<String, Set<Long>> getPersonalInterestsFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> personalInterestsMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdPersonalInterests()!=null) {
				for(TIdPersonalInterestsEntitySearch tIdPersonalInterestsEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdPersonalInterests()) {
					if(personalInterestsMap.containsKey(tIdPersonalInterestsEntitySearch.gettIdSkillMaster().getName())) {
						filterSet = personalInterestsMap.get(tIdPersonalInterestsEntitySearch.gettIdSkillMaster().getName());
					} else {
						filterSet = new HashSet<>();
					}
					filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
					if(!StringUtil.isBlank(tIdPersonalInterestsEntitySearch.gettIdSkillMaster().getName())) {
						personalInterestsMap.put(tIdPersonalInterestsEntitySearch.gettIdSkillMaster().getName().trim(), filterSet);
					}
				}
			}
		}
		
		return sortValuesByDes(personalInterestsMap);
	}

	@Override
	public Map<String, Set<Long>> getPersonalPrioritiesFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>>  personalPrioritiesMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdPersonalPriorities()!=null) {
				for(TIdPersonalPrioritiesEntitySearch tIdPersonalPrioritiesEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdPersonalPriorities()) {
					if(personalPrioritiesMap.containsKey(tIdPersonalPrioritiesEntitySearch.getPerpInfo())) {
						filterSet = personalPrioritiesMap.get(tIdPersonalPrioritiesEntitySearch.getPerpInfo());
					} else {
						filterSet = new HashSet<>();
					}
					filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
					if(!StringUtil.isBlank(tIdPersonalPrioritiesEntitySearch.getPerpInfo())) {
						personalPrioritiesMap.put(tIdPersonalPrioritiesEntitySearch.getPerpInfo().trim(), filterSet);
					}
				}
			}
		}
		
		return sortValuesByDes(personalPrioritiesMap);
	}

	@Override
	public Map<String, Set<Long>> getAwardsAndRecognitionFilter(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		LinkedHashMap<String, Set<Long>> awardsAndRecognitionMap = new LinkedHashMap<String, Set<Long>>();
		Set<Long> filterSet = new HashSet<>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			if(tIdPersonalInformationEntitySearch.getListOfTIdAwardsInformation()!=null) {
				for(TIdAwardsInformationEntitySearch tIdAwardsInformationEntitySearch : tIdPersonalInformationEntitySearch.getListOfTIdAwardsInformation()) {
					if(awardsAndRecognitionMap.containsKey(tIdAwardsInformationEntitySearch.getPiaAwardName())) {
						filterSet = awardsAndRecognitionMap.get(tIdAwardsInformationEntitySearch.getPiaAwardName());
					} else {
						filterSet = new HashSet<>();
					}
					filterSet.add(tIdPersonalInformationEntitySearch.getPinKey());
					if(!StringUtil.isBlank(tIdAwardsInformationEntitySearch.getPiaAwardName())) {
						awardsAndRecognitionMap.put(tIdAwardsInformationEntitySearch.getPiaAwardName().trim(), filterSet);
					}
				}
			}
		}
		
		return sortValuesByDes(awardsAndRecognitionMap);
	}

	@Override
	public List<TIdPersonalInformationSearch> getPersonalInformationSearch(List<TIdPersonalInformationEntitySearch> tIdPersonalInformationEntitySearchList) {
		List<TIdPersonalInformationSearch> tIdPersonalInformationSearchList = new ArrayList<TIdPersonalInformationSearch>();
		for(TIdPersonalInformationEntitySearch tIdPersonalInformationEntitySearch : tIdPersonalInformationEntitySearchList) {
			TIdPersonalInformationSearch tIdPersonalInformationSearch = tIdPersonalInformationServiceSearchMapper
					.mapTIdPersonalInformationEntitySearchToTIdPersonalInformationSearch(tIdPersonalInformationEntitySearch);
			List<TIdProductAttachmentEntity> tIdProductAttachmentEntityList = tIdProductAttachmentJpaRepository.findByRefKeyAndPattRefType(tIdPersonalInformationSearch.getPinKey(),"PersonalInfo_Photo");
			if(tIdProductAttachmentEntityList.size()>0) {
				tIdPersonalInformationSearch.setPattInternalFileName(tIdProductAttachmentEntityList.get(0).getPattInternalFileName());
			}
			tIdPersonalInformationSearchList.add(tIdPersonalInformationSearch);
		}
		return tIdPersonalInformationSearchList;
	}
}
