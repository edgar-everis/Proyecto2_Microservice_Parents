package com.main.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Parents;

import reactor.core.publisher.Flux;

@Repository
public interface ParentsRepository extends ReactiveMongoRepository<Parents, String>{

	Flux<Parents> findByIdstudent(String idstudent);
	
	
	Flux<Parents> findByIdfamily(String  idfamily);
}
