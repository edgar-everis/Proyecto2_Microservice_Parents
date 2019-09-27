package com.main.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.Parents;
import com.main.service.ParentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/API/Parents")
public class ParentsController {

  @Autowired private ParentService service;

  // Crea un nuevo pariente
  @PostMapping("/Parents/create")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Parents> createParents(@RequestBody Parents parents) {
    return service.createParents(parents);
  }

  // Elimina un pariente
  @DeleteMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteParents(@PathVariable String id) {

    return service.deleteById(id);
  }

  // Lista los estudiantes por familia
  @GetMapping("/family/{fam}")
  public Flux<Parents> findbyfamily(@PathVariable String fam) {
    return service.findByIdfamily(fam);
  }

  // Busqueda por id de parientes
  @GetMapping("/FindParents/{id}")
  public Mono<Parents> findbyid(@PathVariable String id) {
    return service.findById(id);
  }

  // Lista los estudiantes por nombre
  @GetMapping("/idstudent/{id}")
  public Flux<Parents> findbyname(@PathVariable String id) {
    return service.findByIdstudent(id);
  }

  @GetMapping
  public Flux<Parents> getall() {
    return service.getAll();
  }

  // Actualiza un pariente
  @PutMapping("/update/{id}")
  public Mono<Parents> updateParents(@PathVariable String id, @RequestBody Parents parents) {
    return service.Modifyparents(id, parents);
  }
}
