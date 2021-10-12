package com.te.DesignPattren.hibernate.Service;

import java.util.Scanner;

import com.te.DesignPattren.hibernate.DTO.DesignPattren.Employee;

public class EmployeeDriver {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("***********************Please enter your choice********************");
		boolean b = false;
	 {
			System.out.println("1.Hibernate\n2.JDBC");
			int key = sc.nextInt();
			switch (key) {
			case 1:
				EmployeeDriver.hibernate();
				break;

			case 2:
				EmployeeDriver.Jdbc();
				break;

			default:
				System.out.println("Enter the valid choice!!!");
			}

//			System.out.println("If you want to Continue");
//			char c = sc.next().charAt(0);
//			if (c == 'y' || c == 'Y') {
//				b = false;
//			} else
//				b = true;
		}
	}

	public static void hibernate() {
		System.out.println("Youre Choice is Hibernate Please follow the steps for Furthur Procedure");
		ValidationImp employeeValidation = new ValidationImp();
		System.out.println("1.insert \n2.update\n3.delete");
		int input = sc.nextInt();
		switch (input) {

		case 1:
			Employee employee = new Employee();
			employeeValidation.insert(employee);

			break;
		case 2:
			employeeValidation.update();
			break;

		case 3:
			employeeValidation.delete();
			break;

		default:
			System.out.println("invalid input");
			break;
		}

	}

	public static void Jdbc() {
		System.out.println("Youre Choice is JDBC Please follow the steps for Furthur Procedure");
		JDBCValidtion jdbcValidtion = new JDBCValidtion();
		System.out.println("1.insert \n2.update\n3.delete");
		int input = sc.nextInt();
		switch (input) {

		case 1:
			Employee employee = new Employee();
			jdbcValidtion.insert(employee);

			break;
		case 2:
			jdbcValidtion.update();
			break;

		case 3:
			jdbcValidtion.delete();
			break;

		default:
			System.out.println("invalid input");
			break;
		}

	}
}
