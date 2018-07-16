package emp.dao;

import static fw.DBUtil.close;
import static fw.EmpQuery.*;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

import emp.dto.EmpDTO;
import fw.EmpQuery;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public int insert(EmpDTO user, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(EMP_INSERT);
		
		ptmt.setString(1, user.getId());
		ptmt.setString(2, user.getPass());
		ptmt.setString(3, user.getName());
		ptmt.setString(4, user.getAddr());
		ptmt.setString(5, user.getGrade());
		ptmt.setInt(6, user.getPoint());
		ptmt.setString(7, user.getDeptno());

		result = ptmt.executeUpdate();
		close(ptmt);
		
		return result;
	}

	@Override
	public ArrayList<EmpDTO> getMemberList(Connection con) throws SQLException {
		//user ��ü ����� ���� �ڷᱸ��
		ArrayList<EmpDTO> userlist = new ArrayList<EmpDTO>();
		//System.out.println("dao��û");
		//�ϳ��� user�� ���� ��ü�� ���� - ���ڵ尡 ��ȸ�Ǹ� ���ڵ� �ϳ��� ���� ������ ���̹Ƿ� 
		//						while���ȿ��� �����ؾ� �Ѵ�.
		EmpDTO user = null;
		PreparedStatement ptmt = con.prepareStatement(EMP_LIST);
		ResultSet rs = ptmt.executeQuery();
		
		while (rs.next()) {
			//System.out.println(rs.getString(1));
			//���ڵ� �ϳ��� ���� dto��ü�� ��ȯ�ϴ� �۾�
			user = new EmpDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getDate(5),rs.getString(6),rs.getInt(7),rs.getString(8));
			//��ȯ�� �Ϸ�Ǹ� ArrayList�� �߰�
			userlist.add(user);
		}
		//System.out.println("ArrayList�� ����=>"+userlist.size());
		//System.out.println(userlist);
		close(rs);
		close(ptmt);
		return userlist;
	}

	@Override
	public int delete(String id, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(EMP_DELETE);
		
		ptmt.setString(1, id);
	
		result = ptmt.executeUpdate();
		close(ptmt);
		
		return result;
	}

	@Override
	public EmpDTO read(String id, Connection con) throws SQLException {
		EmpDTO user = null;
		PreparedStatement ptmt = con.prepareStatement(EMP_READ);
		ptmt.setString(1, id);
		ResultSet rs = ptmt.executeQuery();
		
		if(rs.next()){
			user = new EmpDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getDate(5),rs.getString(6),rs.getInt(7),rs.getString(8));
		}
		
		close(rs);
		close(ptmt);
		return user;
	}

	@Override
	public ArrayList<EmpDTO> search(String column, String search, String pass, Connection con) throws SQLException {
		System.out.println(column+","+search);
		ArrayList<EmpDTO> userlist = new ArrayList<EmpDTO>();
		EmpDTO user = null;
		/*String sql = "select * from kitriemp where " + column + " like ?";*/ // �ܼ��� ���� �̷����ص���
		/*String sql = "select * from kitriemp where" + column +"= ? and pass = ?";*/
		/*String sql = "select * from kitriemp where id=? and pass=?";*/
		/*String sql = "select * from kitriemp where "+column+"= '"+search+"' and pass='"+pass+"'";*/
		String sql = "";
		if(column.equals("name")){
			sql=EMP_SEARCH1;
		}else if(column.equals("addr")){
			sql=EMP_SEARCH2;
		}else if(column.equals("id")){
			sql=EMP_SEARCH3;
		}
		
		PreparedStatement ptmt = con.prepareStatement(sql);
		
		ptmt.setString(1, "%"+search+"%");

		ResultSet rs = ptmt.executeQuery();
		
		while (rs.next()) {

			user = new EmpDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getDate(5),rs.getString(6),rs.getInt(7),rs.getString(8));

			userlist.add(user);
		}

		close(rs);
		close(ptmt);
		
		return userlist;
	}

	@Override
	public int update(EmpDTO user, Connection con) throws SQLException {
		int result = 0;
		PreparedStatement ptmt = con.prepareStatement(EMP_UPDATE);
		
		ptmt.setString(1, user.getAddr());
		ptmt.setString(2, user.getGrade());
		ptmt.setInt(3, user.getPoint());
		ptmt.setString(4, user.getId());
	
		result = ptmt.executeUpdate();
		close(ptmt);
		
		return result;
	}

	@Override
	public EmpDTO login(String id, String pass, Connection con) throws SQLException {
		EmpDTO user = null;
		PreparedStatement ptmt = con.prepareStatement(LOGIN);
		ptmt.setString(1, id);
		ptmt.setString(2, pass);
		ResultSet rs = ptmt.executeQuery();
		
		if(rs.next()){
			user = new EmpDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getDate(5),rs.getString(6),rs.getInt(7),rs.getString(8));
		}
		
		close(rs);
		close(ptmt);
		return user;
	}

}