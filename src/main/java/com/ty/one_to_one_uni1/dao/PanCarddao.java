package com.ty.one_to_one_uni1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_to_one_uni1.dto.PanCard;

public class PanCarddao {
	public EntityManager getEntityManager(){
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void savePancard(PanCard pancard){
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(pancard);
		entityTransaction.commit();
	}
	public void updatePancard(int pid,String paddress){
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		PanCard pancard=entityManager.find(PanCard.class, pid);
		pancard.setPaddress(paddress);
		entityTransaction.begin();
		entityManager.merge(pancard);
		entityTransaction.commit();
	}
	public void deletePancard(int pid){
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		PanCard pancard=entityManager.find(PanCard.class, pid);
		if(pancard!=null)
			entityTransaction.begin();
			entityManager.remove(pancard);
			entityTransaction.commit();
	}
	public PanCard getPancardById(int pid){
		EntityManager entityManager=getEntityManager();
		PanCard pancard=entityManager.find(PanCard.class, pid);
		return pancard;
	}
	public List<PanCard> getAllPancard(){
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select p from PanCard p");
		List<PanCard>list=query.getResultList();
		return list;
	}
}
