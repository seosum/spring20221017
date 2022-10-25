package org.zerock.controller.lecture.p06jdbc;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex27")
public class Controller27 {
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("sub01")
	public void method1() throws Exception {
		String sql1 = "UPDATE Bank "
				+ "SET balance = balance - 100 "
				+ "WHERE customerId = 2";
		String sql2 = "UPDATE Bank SET balance = balance + 100 "
				+ "WHERE customerId = 1";
		
		try (Connection con = dataSource.getConnection()) {
			
			try {
				// autocommit : disabled
				con.setAutoCommit(false);
				
				Statement stmt1 = con.createStatement();
				stmt1.executeUpdate(sql1);
				
//				int a = 0;
//				int b = 3 / a; // ArithmeticException;
				
				Statement stmt2 = con.createStatement();
				stmt2.executeUpdate(sql2);
				
				con.commit();
				
			} catch (Exception e) {
				con.rollback();
			}
		}
	}
	
	@GetMapping("sub02")
	public void method2() {
		
	}
	
	@PostMapping("sub02")
	public void method3() {
		// EMPLOYEE 테이블 insert 쿼리 실행
		// salary 테이블  insert 쿼리 실행
		
		// 위 두 쿼리가 모두 실행되거나
		// 				모두 실패할 수 있는 코드 작성
		
		@Autowired
		private DataSource dataSource;
		
		@RequestMapping("sub02")
		public void method4() throws Exception {
			String sql1 = "INSERT EMPLOYEE " 
					+ "INSERT SALARY ";
			
		try (Connection con = dataSource.getConnection()) {
			
			try {
				con.setAutoCommit(false);
				
				Statement stmt1 = con.createStatement();
				stmt1.executeInsert(sql1);
				
				con.commit();
			}
			Catch (Exception e) {
				con.rollback();
			}
		}
		}
	}
}
