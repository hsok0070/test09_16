package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUTIL;
import vo.UserVO;

public class UserDao {
	
	public int insertUser(UserVO user) {
		String sql = "insert into users(id,password,name,role) values(?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = JDBCUTIL.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getRole());

			result = ps.executeUpdate();

			System.out.println("user테이블에 데이터 삽입 완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUTIL.close(con, ps, null);
		}
		return result;
	}
	public int UpdateUser(UserVO user) {
		String sql = "update users set name=? where id = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = JDBCUTIL.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, user.getName());
			ps.setString(2, user.getId());

			result = ps.executeUpdate();

			System.out.println("user테이블에 데이터 업데이트 완료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUTIL.close(con, ps, null);
		}
		return result;
	}
	public UserVO LoginUser(UserVO user) {
		String sql = "select * from users where id = ? and password = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0; 
		boolean a = false;

		UserVO data = null;
		try {
			con = JDBCUTIL.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());

			rs = ps.executeQuery();
			if(rs.next()) {
				data = new UserVO();
				
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUTIL.close(con, ps, rs);
		}
		return data;
	}
}
