package com.main.service;

import com.main.model.Parents;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParentService {

  Mono<Parents> createParents(Parents parents);

  Mono<Void> deleteById(String id);

  Mono<Parents> findById(String id);

  Flux<Parents> findByIdfamily(String idfamily);

  Flux<Parents> findByIdstudent(String idstudent);

  Flux<Parents> getAll();

  Mono<Parents> Modifyparents(String id, Parents parents);
}
