package com.study.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.member.vo.MemberVO;

public class MemberDaoOracle implements IMemberDao {

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		Connection conn = null; // 커넥션 티켓
		PreparedStatement pstmt = null; // SQL선언문
		ResultSet rs = null; // 질의 결과
		StringBuilder sb = new StringBuilder();

		try {

			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");

			sb.append(" select member.mem_id	");
			sb.append("	, member.mem_name		");
			sb.append("	, member.mem_add1		");
			sb.append("	, member.mem_add2		");
			sb.append("	, member.mem_job		");
			sb.append("	, comm_code.comm_nm as mem_likenm		");
			sb.append("	, c.comm_nm as mem_jobnm	");
			sb.append("	, member.mem_mileage		");
			sb.append("FROM member,comm_code,comm_code c	");
			sb.append("where member.mem_like = comm_code.comm_cd	");
			sb.append("and member.mem_job = c.comm_cd	");
			sb.append("ORDER BY mem_id ASC ");
			System.out.println(sb.toString());
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			List<MemberVO> list = new ArrayList<MemberVO>();
			MemberVO member = null;
			while (rs.next()) {
				member = new MemberVO();
				member.setMemId(rs.getString("mem_id"));
				member.setMemName(rs.getString("mem_name"));
				member.setMemAdd1(rs.getString("mem_add1"));
				member.setMemAdd2(rs.getString("mem_add2"));
				member.setMemJobnm(rs.getString("mem_jobnm"));
				member.setMemMileage(rs.getInt("mem_mileage"));
				list.add(member);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}

		}

	}

	@Override
	public MemberVO getMember(String memId) throws SQLException {
		Connection conn = null; // 커넥션 티켓
		PreparedStatement pstmt = null; // SQL선언문
		ResultSet rs = null; // 질의 결과
		StringBuilder sb = new StringBuilder();

		try {

			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");

			sb.append("	SELECT  ");
			sb.append("    mem_id, mem_pass, mem_name,  ");
			sb.append("    mem_regno1, mem_regno2, mem_bir,  ");
			sb.append("    mem_zip, mem_add1, mem_add2,  ");
			sb.append("    mem_hp, mem_mail,  ");
			sb.append("    mem_job,  ");
			sb.append("    (SELECT comm_nm FROM comm_code WHERE comm_cd = mem_job) as mem_job_nm,  ");
			sb.append("    mem_like,  ");
			sb.append("    (SELECT comm_nm FROM comm_code WHERE comm_cd = mem_like) as mem_like_nm,  ");
			sb.append("    mem_mileage,  ");
			sb.append("    mem_del_yn  ");
			sb.append("  FROM member  ");
			sb.append("  WHERE mem_id = ?  ");
			sb.append("  and mem_del_yn = 'N'  ");
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, memId);
			System.out.println(memId);
System.out.println(sb.toString());
			rs = pstmt.executeQuery();
			MemberVO member = null;
			while (rs.next()) {
				member = new MemberVO();
				member.setMemId(rs.getString("mem_id"));
				member.setMemPass(rs.getString("mem_pass"));
				member.setMemName(rs.getString("mem_name"));
				member.setMemRegno1(rs.getString("mem_regno1"));
				member.setMemRegno2(rs.getString("mem_regno2"));
				member.setMemBir(rs.getString("mem_bir"));
				member.setMemAdd1(rs.getString("mem_add1"));
				member.setMemAdd2(rs.getString("mem_add2"));
				member.setMemJobnm(rs.getString("mem_job_nm"));
				member.setMemLikenm(rs.getString("mem_like_nm"));
				member.setMemMileage(rs.getInt("mem_mileage"));
			}
			return member;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}

		}
	}

	@Override
	public int insertMember(MemberVO member) throws SQLException {
		Connection conn = null; // 커넥션 티켓
		PreparedStatement pstmt = null; // SQL선언문
		ResultSet rs = null; // 질의 결과
		StringBuilder sb = new StringBuilder();

		try {

			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");

			sb.append("			INSERT INTO member (");
			sb.append("				  mem_id, mem_pass, mem_name, ");
			sb.append("				  mem_regno1, mem_regno2, mem_bir, ");
			sb.append("				  mem_zip, mem_add1, mem_add2, ");
			sb.append("				  mem_hp, mem_mail, mem_job, ");
			sb.append("				  mem_like, mem_mileage, mem_del_yn ");
			sb.append("			) VALUES (");
			sb.append("				  ?, ?, ?, ");
			sb.append("				  ?, ?, ?, ");
			sb.append("				  ?, ?, ?, ");
			sb.append("				  ?, ?, ?, ");
			sb.append("				  ?, 0, 'N' ");
			sb.append("				)");

			System.out.println(sb.toString());
			pstmt = conn.prepareStatement(sb.toString());

			int idx = 0;
			pstmt.setString(1, member.getMemId());
			pstmt.setString(2, member.getMemPass());
			pstmt.setString(3, member.getMemName());
			pstmt.setString(4, member.getMemRegno1());
			pstmt.setString(5, member.getMemRegno2());
			pstmt.setString(6, member.getMemBir());
			pstmt.setString(7, member.getMemZip());
			pstmt.setString(8, member.getMemAdd1());
			pstmt.setString(9, member.getMemAdd2());
			pstmt.setString(10, member.getMemHp());
			pstmt.setString(11, member.getMemMail());
			pstmt.setString(12, member.getMemJob());
			pstmt.setString(13, member.getMemLike());
			System.out.println(sb.toString());

			int cnt = pstmt.executeUpdate();

			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}

		}
	}

	@Override
	public int updateMember(MemberVO member) throws SQLException {
		Connection conn = null; // 커넥션 티켓
		PreparedStatement pstmt = null; // SQL선언문
		ResultSet rs = null; // 질의 결과
		StringBuilder sb = new StringBuilder();

		try {

			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			pstmt = conn.prepareStatement(sb.toString());

			int cnt = pstmt.executeUpdate();

			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}

		}

	}

	@Override
	public int deleteMember(MemberVO member) throws SQLException {
		Connection conn = null; // 커넥션 티켓
		PreparedStatement pstmt = null; // SQL선언문
		ResultSet rs = null; // 질의 결과
		StringBuilder sb = new StringBuilder();

		try {

			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			pstmt = conn.prepareStatement(sb.toString());

			int cnt = pstmt.executeUpdate();

			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}

		}

	}

}
