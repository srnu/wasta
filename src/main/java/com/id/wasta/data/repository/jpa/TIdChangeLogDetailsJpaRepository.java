package com.id.wasta.data.repository.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.id.wasta.bean.jpa.TIdChangeLogDetailsEntity;

public interface TIdChangeLogDetailsJpaRepository  extends CrudRepository<TIdChangeLogDetailsEntity, Long>{

	List<TIdChangeLogDetailsEntity> findByTchgTableNameAndTchgTableKeyColValue1(String screenName, Long primaryKey);	
}
