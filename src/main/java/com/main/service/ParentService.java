package com.main.service;

import com.main.model.Parents;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParentService {

    Flux <Parents> getAll();
	
    Flux<Parents> findByIdstudent(String idstudent);
    
    Mono<Parents> findById(String  id);
	
    Mono<Parents> Modifyparents(String id,Parents parents);
    
	Mono<Parents> createParents( Parents parents);
  
	Mono<Void> deleteById(String id);
	
	Flux<Parents> findByIdfamily(String  idfamily);
}
