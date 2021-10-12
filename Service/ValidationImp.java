package com.te.DesignPattren.hibernate.Service;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.DesignPattren.hibernate.DAO.FactoryImp;
import com.te.DesignPattren.hibernate.DTO.DesignPattren.Employee;

public class ValidationImp implements validation{
	
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	Scanner sc = new Scanner(System.in);
	@Override
	public void insert(Employee employee) {
		
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			System.out.print("Enter the employee id: ");
			int eid= sc.nextInt();
			String search_id = "from Employee where eid = :eid";
			Query query = manager.createQuery(search_id);
			
			query.setParameter("eid", eid);

			try {
				Employee employee1 = (Employee) query.getSingleResult();

			} catch (Exception idn) {
				System.out.println("EId is not present in employee");
				FactoryImp fe = new FactoryImp();
				fe.insert(employee);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			manager.close();
		}
	}

	@Override
	public void delete() {
		try {

			factory = Persistence.createEntityManagerFactory("emp");

			manager = factory.createEntityManager();
			
			System.out.print("Enter the employee id: ");
			
			int eid= sc.nextInt();
			
			String find_by_id = "from Employee where eid = :eid";

			Query query = manager.createQuery(find_by_id);

			query.setParameter("eid", eid);

			try {
				Employee employee = (Employee) query.getSingleResult();
				FactoryImp fe = new FactoryImp();
				fe.delete();

			} catch (Exception idn) {

				System.out.println("EId is not present in empoyee");

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		} finally {
			manager.close();

		}

	}

	@Override
	public void update() {
		try {

			factory = Persistence.createEntityManagerFactory("emp");

			manager = factory.createEntityManager();
			System.out.print("Enter the employee id: ");
			
			int eid= sc.nextInt();
			String find_by_id = "from Employee where eid = :eid";

			Query query = manager.createQuery(find_by_id);

			query.setParameter("eid", eid);

			try {
				Employee employee = (Employee) query.getSingleResult();

				FactoryImp fe = new FactoryImp();
				fe.update();

			} catch (Exception idn) {
				System.out.println("EId is not present in employee");

			}

		} catch (Exception e) {

			System.out.println(e.getMessage());

		} finally {
			manager.close();
		}
		
	}

}
