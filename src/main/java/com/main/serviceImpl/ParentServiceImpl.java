package com.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.main.model.Parents;
import com.main.repository.ParentsRepository;
import com.main.service.ParentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentsRepository repository;
	
	
	@Override
	public Flux<Parents> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Flux<Parents> findByIdstudent(String idstudent) {
		// TODO Auto-generated method stub
		return repository.findByIdstudent(idstudent);
	}



	@Override
	public Mono<Parents> Modifyparents(String id, Parents parents) {
		// TODO Auto-generated method stub
		parents.setId(id);
		return repository.save(parents);
	}

	@Override
	public Mono<Parents> createParents(Parents parents) {
		// TODO Auto-generated method stub
		return repository.save(parents);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		// TODO Auto-generated method stub
		return repository.deleteById(id);
	}

	@Override
	public Flux<Parents> findByIdfamily(String idfamily) {
		// TODO Auto-generated method stub
		return repository.findByIdfamily(idfamily);
	}

	@Override
	public Mono<Parents> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	
    

}
