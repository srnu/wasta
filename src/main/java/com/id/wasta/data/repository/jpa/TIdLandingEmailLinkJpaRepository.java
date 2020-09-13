package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingEmailLinkEntity;

public interface TIdLandingEmailLinkJpaRepository extends CrudRepository<TIdLandingEmailLinkEntity, Long>{

	TIdLandingEmailLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);
}
