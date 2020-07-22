package templateMethod.libraray.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import templateMethod.libraray.vo.Dept;

public abstract class DeptDao {
	
	//부모클래스에서 기본적인 로직의 흐름을 만들고
	// 그 기능의 일부를 추상메소드로 만들어
	//자식클래스에서 기능을 변경할 수 있도록 하는 패턴
	
	public abstract Connection getConnection();
	

	public void insertDept(Dept dept) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement("INSERT INTO dept(deptno , dname , loc) VALUES(? ,? ,?) ");
			
			
			ps.setInt(1, dept.getDeptno());
			ps.setString(2, dept.getDname());
			ps.setString(3, dept.getLoc());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//end insertDept
	
	
	public Dept selectDept(int deptno) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Dept dept = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement("SELECT * FROM dept where deptno = ? ORDER BY deptno");
			
			ps.setInt(1, deptno);
			
			rs = ps.executeQuery();

			if(rs.next()) {
				dept = new Dept();
				dept.setDeptno(rs.getInt(1));
				dept.setDname(rs.getString(2));
				dept.setLoc(rs.getString(3));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dept;
	}//end selectDept
	
	
	
	
	
	
	
	
}
