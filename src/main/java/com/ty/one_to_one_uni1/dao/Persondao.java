package com.ty.one_to_one_uni1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_to_one_uni1.dto.PanCard;
import com.ty.one_to_one_uni1.dto.Person;

public class Persondao {
public EntityManager getEntityManager(){
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	return entityManagerFactory.createEntityManager();
}
public void savePerson(Person person){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	PanCard pancard=person.getPancard();
	entityTransaction.begin();
	entityManager.persist(pancard);
	entityManager.persist(person);
	entityTransaction.commit();
}
public void updatePerson(int id,String address){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Person person=entityManager.find(Person.class, id);
	person.setAddress(address);
	entityTransaction.begin();
	entityManager.merge(person);
	entityTransaction.commit();
}
public void deletePerson(int id){
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	Person person=entityManager.find(Person.class, id);
	if(person!=null)
	entityTransaction.begin();
	entityManager.remove(person);
	entityTransaction.commit();
}
public Person getPersonById(int id){
	EntityManager entityManager=getEntityManager();
	Person person=entityManager.find(Person.class, id);
	return person;
}
public List<Person> getAllPerson(){
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select p from Person p");
	List<Person> list=query.getResultList();
	return list;
}
}
