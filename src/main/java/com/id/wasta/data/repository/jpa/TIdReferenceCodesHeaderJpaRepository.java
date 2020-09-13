package com.id.wasta.data.repository.jpa;

import org.springframework.data.jpa.repository.Query;

import com.id.util.data.repository.jpa.BaseRepository;
import com.id.wasta.bean.jpa.TIdReferenceCodesDetailEntity;
import com.id.wasta.bean.jpa.TIdReferenceCodesHeaderEntity;

/**
 * Repository : TIdReferenceCodesHeader.
 */
public interface TIdReferenceCodesHeaderJpaRepository extends BaseRepository<TIdReferenceCodesHeaderEntity, Long> {
	
	public TIdReferenceCodesHeaderEntity findByRchDomainName(String title);

	public TIdReferenceCodesDetailEntity findByRchDomainNameAndRchHeaderKeyNotIn(String rchDomainName, Long pexKey);

	public TIdReferenceCodesHeaderEntity findByRchHeaderKey(Long pexKey);
	
	@Query("select e.rchHeaderKey from TIdReferenceCodesHeaderEntity as e where e.rchDomainName = 'Role'")
	public Long getRoleHeaderKey();
	

}
