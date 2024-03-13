package edu.kh.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc1.model.vo.EmpP;

public class JDBCPractice2 {

	public static void main(String[] args) {
	
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "kh_ssm";
			String pw = "kh1234";
			
			conn = DriverManager.getConnection(url, user, pw);
			
			String sql = "SELECT NVL(DEPT_ID, '소속없음') DEPT_ID, EMP_ID, EMP_NAME, NVL(DEPT_TITLE, '소속없음') AS DEPT_TITLE, JOB_NAME, HIRE_DATE"
					+ " FROM EMPLOYEE"
					+ " LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)"
					+ " JOIN JOB USING(JOB_CODE)"
					+ " WHERE HIRE_DATE IN (SELECT MIN(HIRE_DATE)"
					+ "										FROM EMPLOYEE"
					+ "										WHERE ENT_YN != 'Y'"
					+ "										GROUP BY DEPT_CODE)"
					+ " ORDER BY 1"; 
					
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			List<EmpP> list = new ArrayList<EmpP>(); 
			
			
			while(rs.next()) {
				
				EmpP emp = new EmpP();
				
				emp.setDeptId(rs.getString("DEPT_ID"));
				emp.setEmpId(rs.getString("EMP_ID"));
				emp.setEmpName(rs.getString("EMP_NAME"));
				emp.setDeptTitle(rs.getString("DEPT_TITLE"));
				emp.setJobName(rs.getString("JOB_NAME"));
				emp.setHireDate(rs.getString("HIRE_DATE"));
								
				list.add(emp);
			}
			
			if(list.isEmpty()) {
				System.out.println("조회 결과 없음");
			} else {
				int index = 1;
				
				for(EmpP emp : list) {
					System.out.printf("[%02d] 부서코드 : %s / 사원번호 : %s / 사원명 : %s / 부서명 : %s / 직급명 : %s / 입사일 : %s\n",
										index, emp.getDeptId(), emp.getEmpId(), emp.getEmpName(), 
										emp.getDeptTitle(), emp.getJobName(), emp.getHireDate() );
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
