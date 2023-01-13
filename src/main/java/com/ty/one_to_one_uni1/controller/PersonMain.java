package com.ty.one_to_one_uni1.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.ty.one_to_one_uni1.dao.PanCarddao;
import com.ty.one_to_one_uni1.dao.Persondao;
import com.ty.one_to_one_uni1.dto.PanCard;
import com.ty.one_to_one_uni1.dto.Person;

public class PersonMain {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	boolean repeat=true;
	Person person=new Person();
	PanCard pancard=new PanCard();
	Persondao dao=new Persondao();
	PanCarddao dao1=new PanCarddao();
	do{
		System.out.println(" 1 :save person \n 2 :update person \n 3 :delete person \n 4 :get person by id \n 5 :get all person");
		System.out.println(" 6 :save pancard \n 7 :update pancard \n 8 :delete pancard \n 9 :get pancard by id \n 10:get all pancard");
		System.out.println("****************************************");
		System.out.println("enter your choice");
		int choice=scanner.nextInt();
		switch(choice){
		case 1:{
			System.out.println("enter the id");
			int id=scanner.nextInt();
			System.out.println("enter the name ");
			String name=scanner.next();
			System.out.println("enter the phone");
			long phone=scanner.nextLong();
			System.out.println("enter the address");
			String address=scanner.next();
			System.out.println("enter the father name");
			String fathername=scanner.next();
			
			
			person.setId(id);
			person.setName(name);
			person.setPhone(phone);
			person.setAddress(address);
			person.setFathername(fathername);
			
			System.out.println("enter the pid");
			int pid=scanner.nextInt();
			System.out.println("enter the pname");
			String pname1=scanner.next();
			System.out.println("enter the paddress");
			String paddress1=scanner.next();
			
			
			person.setPancard(pancard);
			pancard.setPid(pid);
			pancard.setPname(pname1);
			pancard.setPaddress(paddress1);
			
			dao.savePerson(person);
			System.out.println("saved successfully");
		}
		break;
		case 2:{
			System.out.println("enter the id");
			int id=scanner.nextInt();
			System.out.println("enter the address to be update");
			String address=scanner.next();
			person.setAddress(address);
			EntityManager entityManager =dao.getEntityManager();
			dao.updatePerson(id,address);
			System.out.println("Updated successfully");
		}
		break;
		case 3:{
			System.out.println("enter the id");
			int id=scanner.nextInt();
			EntityManager entityManager=dao.getEntityManager();
			person.setId(id);
			dao.deletePerson(id);
			System.out.println("deleted");
		}
		break;
		case 4:{
			System.out.println("enter the id");
			int id=scanner.nextInt();
			EntityManager entityManager=dao.getEntityManager();
			person.setId(id);
			Person person1=dao.getPersonById(id);
			System.out.println(person1);
		}
		break;
		case 5:{
			EntityManager entityManager=dao.getEntityManager();
			List<Person>list=dao.getAllPerson();
			System.out.println(list);
		}
		break;
		case 6:{
			System.out.println("enter the pid");
			int pid=scanner.nextInt();
			System.out.println("enter the pname");
			String pname1=scanner.next();
			System.out.println("enter the paddress");
			String paddress1=scanner.next();
			
			
			person.setPancard(pancard);
			pancard.setPid(pid);
			pancard.setPname(pname1);
			pancard.setPaddress(paddress1);
			
			dao1.savePancard(pancard);
			System.out.println("saved successfully");
		}
		break;
		case 7:{
			System.out.println("enter the pid to be updated");
			int pid=scanner.nextInt();
			System.out.println("enter the paddress to be update");
			String paddress=scanner.next();
			pancard.setPaddress(paddress);
			EntityManager entityManager =dao1.getEntityManager();
			dao1.updatePancard(pid, paddress);
			System.out.println("Updated");
		}
		break;
		case 8:{
			System.out.println("enter the pid to be deleted");
			int pid=scanner.nextInt();
			EntityManager entityManager=dao1.getEntityManager();
			pancard.setPid(pid);
			dao1.deletePancard(pid);
			System.out.println("deleted");
		}
		break;
		case 9:{
			System.out.println("enter the pid");
			int pid=scanner.nextInt();
			pancard.setPid(pid);
			PanCard pancard1=dao1.getPancardById(pid);
			System.out.println(pancard1);
		}
		break;
		case 10:{
			EntityManager entityManager=dao1.getEntityManager();
			List<PanCard>list=dao1.getAllPancard();
			System.out.println(list);
		}
		break;
		default:{
			System.out.println("thank you");
		}
		}
	}while(repeat);
}
}
