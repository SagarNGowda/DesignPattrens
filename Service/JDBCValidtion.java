package com.te.DesignPattren.hibernate.Service;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.te.DesignPattren.hibernate.DAO.FactoryImp;
import com.te.DesignPattren.hibernate.DTO.DesignPattren.Employee;


public class JDBCValidtion implements validation {
Scanner sc= new Scanner(System.in);
	@Override
	public void insert(Employee emp) {
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demployee", "root", "root");

			ps = con.prepareStatement("select eid from employee where eid = ?");

			ps.setInt(1, emp.getEid());

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				System.out.println("id is allready present");
			} else {
				FactoryImp fe = new FactoryImp();
				fe.insert(emp);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update() {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			System.out.print("Enter the employee id: ");
			
			int eid= sc.nextInt();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demployee", "root", "root");

			ps = con.prepareStatement("select eid from employee where eid = ?");

			ps.setInt(1, eid);

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				FactoryImp fe = new FactoryImp();
				fe.update();

			} else {
				System.out.println("id is not present in employee details");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete() {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			
			System.out.print("Enter the employee id: ");
			
			int eid= sc.nextInt();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demployee", "root", "root");

			ps = con.prepareStatement("select eid from employee where eid = ?");

			ps.setInt(1, eid);

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				FactoryImp fe = new FactoryImp();
				fe.delete();

			} else {
				System.out.println("id is not present in employee details");
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
