package com.main.serviceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;

import com.main.model.Parents;

import com.main.repository.ParentsRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ParentServiceImplTest {

  @Mock private ParentsRepository Repository;

  @InjectMocks private ParentServiceImpl Service;

  @Test
  public void testCreateParents() {
    LocalDate birthday = LocalDate.parse("1987-05-02");
    Parents parent = new Parents();
    parent.setId("4");
    parent.setFullname("Neo");
    parent.setBirthdate(birthday);
    parent.setGender("m");
    parent.setIdfamily("Crespo");
    parent.setIdstudent("5");
    parent.setTypedoc("dni");
    parent.setDocument("333333");

    when(Repository.save(parent)).thenReturn(Mono.just(parent));
    Mono<Parents> actual = Service.createParents(parent);
    assertResults(actual, parent);
  }

  @Test
  public void testDeleteById() {
    LocalDate birthday = LocalDate.parse("1987-05-02");
    Parents parent = new Parents();
    parent.setId("1");
    parent.setFullname("Jorge");
    parent.setBirthdate(birthday);
    parent.setIdfamily("Romero");
    parent.setTypedoc("dni");
    parent.setGender("M");
    parent.setIdstudent("1");
    parent.setDocument("666666");
    when(Repository.delete(parent)).thenReturn(Mono.empty());
  }

  @Test
  public void testFindById() {
    LocalDate birthday = LocalDate.parse("1987-05-02");
    Parents parent = new Parents();
    parent.setId("2");
    parent.setFullname("Morfeo");
    parent.setBirthdate(birthday);
    parent.setGender("M");
    parent.setIdstudent("1");
    parent.setIdfamily("Romero");
    parent.setTypedoc("dni");
    parent.setDocument("44782165");

    when(Repository.findById("2")).thenReturn(Mono.just(parent));
    Mono<Parents> actual = Service.findById("2");
    assertResults(actual, parent);
    System.out.println(actual);
    System.out.println(parent.getFullname());
  }

  @Test
  public void testFindByIdfamily() {
    LocalDate birthday = LocalDate.parse("1987-05-02");
    Parents parent = new Parents();
    parent.setId("1");
    parent.setFullname("Marcos");
    parent.setBirthdate(birthday);
    parent.setGender("m");
    parent.setIdstudent("1");
    parent.setIdfamily("Ospina");
    parent.setTypedoc("dni");
    parent.setDocument("6666666");

    when(Repository.findByIdfamily("Ospina")).thenReturn(Flux.just(parent));
    Flux<Parents> actual = Service.findByIdfamily("Ospina");
    assertResults(actual, parent);
    System.out.println(actual);
    System.out.println(parent.getFullname());
  }

  @Test
  public void testFindByIdstudent() {
    LocalDate birthday = LocalDate.parse("1987-05-02");
    Parents parent = new Parents();
    parent.setId("1");
    parent.setFullname("Marcos");
    parent.setBirthdate(birthday);
    parent.setGender("m");
    parent.setIdstudent("1");
    parent.setIdfamily("Romero");
    parent.setTypedoc("dni");
    parent.setDocument("6666666");

    when(Repository.findByIdstudent("1")).thenReturn(Flux.just(parent));
    Flux<Parents> actual = Service.findByIdstudent("1");
    assertResults(actual, parent);
    System.out.println(actual);
    System.out.println(parent.getFullname());
  }

  @Test
  public void testGetAll() {
    LocalDate date = LocalDate.parse("2018-05-05");
    Parents stu = new Parents();
    stu.setId("1");
    stu.setFullname("Andres");
    stu.setGender("M");
    stu.setBirthdate(date);
    stu.setTypedoc("dni");
    stu.setDocument("555555");
    when(Service.getAll()).thenReturn(Flux.just(stu));
    Flux<Parents> actual = Service.getAll();
    assertResults(actual, stu);
  }

  private void assertResults(Publisher<Parents> publisher, Parents... expectedProducts) {
    StepVerifier.create(publisher).expectNext(expectedProducts).verifyComplete();
  }
}
