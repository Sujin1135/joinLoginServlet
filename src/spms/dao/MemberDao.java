package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import spms.validators.MemberValidator;
import spms.vo.Member;

public class MemberDao {
	DataSource ds;
	
	public void setDataSource (DataSource ds) {
		this.ds = ds;
	}
	
	public Member loginMember(String email, String password) throws Exception {
	    Connection connection = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
	      connection = ds.getConnection();
	      stmt = connection.prepareStatement(
	          "SELECT MNAME,EMAIL FROM MEMBERS"
	              + " WHERE EMAIL=? AND PWD=?");
	      stmt.setString(1, email);
	      stmt.setString(2, password);
	      rs = stmt.executeQuery();
	      if (rs.next()) {
	        return new Member()
	          .setName(rs.getString("MNAME"))
	          .setEmail(rs.getString("EMAIL"));
	      } else {
	        return null;
	      }
	    } catch (Exception e) {
	      throw e;
	    } finally {
	      try {if (rs != null) rs.close();} catch (Exception e) {}
	      try {if (stmt != null) stmt.close();} catch (Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }
	
	public int joinMember (Member member) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		int result = 1;
		
		try {
			MemberValidator validator = new MemberValidator();
			
			result = this.emailCheck(member.getEmail());
			if(result < 1) {
				return result;
			}
			result = validator.validationCheck(member);
			if (result < 1) {
				return result;
			}
			
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
				"insert into MEMBERS (EMAIL, MNAME, PWD, CRE_DATE, MOD_DATE) "
				+ "values (?, ?, ?, now(), now())"
			);
			
			stmt.setString(1, member.getEmail());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPassword());
			stmt.executeUpdate();
			
			return result;
		} catch (Exception e) {
			throw e; 
			} finally {
		        try {if (stmt != null) stmt.close();} catch (Exception e) {}
		        try {if (connection != null) connection.close();} catch(Exception e) {}
			}
	}
	
	public int emailCheck (String email) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement("select EMAIL from MEMBERS where EMAIL=?");
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString("EMAIL"));
				return -1;
			} else {
			return 1;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (rs != null) rs.close();} catch (Exception e) {}
			try {if (stmt != null) stmt.close();} catch (Exception e) {}
	        try {if (connection != null) connection.close();} catch(Exception e) {}
		}
	}
}
