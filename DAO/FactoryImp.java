package com.te.DesignPattren.hibernate.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.DesignPattren.hibernate.DTO.DesignPattren.Employee;

public class FactoryImp implements FactroryEmployes{
	
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	Scanner sc = new Scanner(System.in);
	@Override
	public void insert(Employee employee) {
		
		try {
			boolean b = false;
				while(!b) {
				
				System.out.print("Enter the employee Name: ");
				String name = sc.next().toLowerCase().trim();
				
				System.out.print("Enter the employee id: ");
				int eid= sc.nextInt();
				
				System.out.print("Enter the employee sal: ");
				double sal = sc.nextDouble();
				
				System.out.print("Enter the Phone number: ");
				long phno = sc.nextLong();
				
				employee.setEname(name);
				employee.setEid(eid);
				employee.setSal(sal);
				employee.setPh_no(phno);
				
				
				 factory = Persistence.createEntityManagerFactory("emp");
				 manager = factory.createEntityManager();
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
				
				
				manager.persist(employee);
				transaction.commit();
				
				System.out.println("If you want to continue: y/Y");
				char c= sc.next().charAt(0);
				if (c == 'y' || c=='Y')
				{
					b= false;
			}
				else
				b= true;
			
				}
			}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			manager.close();
			System.out.println("Thank you!");
		}
		
	}

	@Override
	public void update() {
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();
			System.out.println("Enter your Selection\n1.UpdateName\n2.Updatephno\n3.Updatesal");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter the name: ");
				String ename = sc.next().trim().toLowerCase();
				System.out.print("Enter eid-No: ");
				int eid = sc.nextInt();
				String update = "update Employee set ename = :ename  where eid = :eid";
				Query query = manager.createQuery(update);
				query.setParameter("ename", ename);
				query.setParameter("eid", eid);
				 query.executeUpdate();
				transaction.commit();
				break;
			
				
			case 2:
				System.out.print("Enter the Phone  new number: ");
				long phno = sc.nextLong();
				System.out.print("Enter Roll-No: ");
				int eid1 = sc.nextInt();
				String update1 = "update Employee set ph_no = :phno  where eid = :eid";
				Query query1 = manager.createQuery(update1);
				query1.setParameter("phno", phno);
				query1.setParameter("eid", eid1);
				 query1.executeUpdate();
				transaction.commit();
				break;
			
			case 3:
				System.out.print("Enter Sal: ");
				double sal = sc.nextDouble();
				System.out.print("Enter Roll-No: ");
				int eid2 = sc.nextInt();
				String update2 = "update Employee set sal = :sal  where eid = :eid";
				Query query2 = manager.createQuery(update2);
				query2.setParameter("sal", sal);
				query2.setParameter("eid", eid2);
				 query2.executeUpdate();
				transaction.commit();
				break;
			default:
				break;
			}

			
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}	
	}

	@Override
	public void delete() {
		try {
			
			System.out.print("Enter the id to be Delete: ");
			int id = sc.nextInt();
			 factory = Persistence.createEntityManagerFactory("emp");
			 manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();

			String delete = "Delete from Employee where eid = :eid";
			
			Query query = manager.createQuery(delete);
			
			query.setParameter("eid", id);
		
			int result = query.executeUpdate();
			
			if (result == 0) 
			{
				throw new InvaildIdException("Enter proper Id");
			}
			
			transaction.commit();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
