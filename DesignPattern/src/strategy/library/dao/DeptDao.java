package strategy.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import strategy.library.vo.Dept;

public class DeptDao {

	//strategy 패턴
	// context + strategy
	// 전체적인 맥락이 구현되어 있는 상황에서
	// 상황에 맞게 전략을 바꿔서 사용하는 패턴
			
	ConnectionMaker connectionMaker;
	
	public DeptDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	

	public void insertDept(Dept dept) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = connectionMaker.getConnection();
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
			conn = connectionMaker.getConnection();
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
