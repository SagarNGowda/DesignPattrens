package com.te.DesignPattren.hibernate.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.te.DesignPattren.hibernate.DTO.DesignPattren.Employee;


public class JDBCImplementation implements FactroryEmployes {
	Scanner sc = new Scanner(System.in);
	@Override
	public void insert(Employee emp) {
		Connection con = null;

		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demployee", "root", "root");
			String insert = "INSERT INTO `Employee` (`eid`, `ename`,'ph_no' `sal`) VALUES (?,?,?,?);";
			PreparedStatement st = con.prepareStatement(insert);

			st.setInt(1, emp.getEid());
			st.setString(2, emp.getEname());
			st.setLong(3, emp.getPh_no());
			st.setDouble(4, emp.getSal());

			st.execute();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void update() {
		Scanner sc = new Scanner(System.in);
		Connection con = null;

		try {
			System.out.println("Enter the id to be Updated");
			int eid = sc.nextInt();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demployee", "root", "root");

			System.out.println("do toy want to update the name (y/n)");
			char yes_no = sc.next().charAt(0);
			if (yes_no == 'y' || yes_no == 'Y') {
				String update = "update Employee set ename = ? where eid = ?";
				PreparedStatement st = con.prepareStatement(update);
				System.out.println("enter the name");
				String name = sc.next();
				st.setString(1, name);

				st.setInt(2, eid);

				st.executeUpdate();
			}

			System.out.println("do toy want to update the designation (y/n)");
			yes_no = sc.next().charAt(0);
			if (yes_no == 'y' || yes_no == 'Y') {
				System.out.println("enter the designation");
				String des = sc.next();
				String update = "update Employee set ename = ? where eid = ?";
				PreparedStatement st = con.prepareStatement(update);
				st.setString(1, des);

				st.setInt(2, eid);

				st.executeUpdate();

			}

			System.out.println("do toy want to update the Salary (y/n)");
			yes_no = sc.next().charAt(0);
			if (yes_no == 'y' || yes_no == 'Y') {
				System.out.println("enter the salary");
				double salary = sc.nextDouble();
				String update = "update Employee set ename = ? where eid = ?";
				PreparedStatement st = con.prepareStatement(update);
				System.out.println("enter the name");
				String name = sc.next();
				st.setDouble(1, salary);

				st.setInt(2, eid);

				st.executeUpdate();

			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null)
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

		try {
			System.out.println("Enter the id to delete");
			int eid = sc.nextInt();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demployee", "root", "root");
			String delete = "DELETE FROM employee WHERE eid = ?";
			PreparedStatement st = con.prepareStatement(delete);

			st.setInt(1, eid);

			st.executeUpdate();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
