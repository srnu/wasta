package com.id.wasta.data.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdLandingAddPotentialLinkEntity;

public interface TIdLandingAddPotentialLinkJpaRepository extends CrudRepository<TIdLandingAddPotentialLinkEntity, Long>{

	TIdLandingAddPotentialLinkEntity findByLlLdKeyAndLlPinKey(Long ldKey, Long loggedPinKey);
}
