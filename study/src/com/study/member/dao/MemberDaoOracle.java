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

			
			sb.append("select member.mem_id");
			sb.append(", member.mem_name");
			sb.append(", member.mem_add1");
			sb.append(", member.mem_add2");
			sb.append(", member.mem_job");
			sb.append(", comm_code.comm_nm");
			sb.append(", c.comm_nm as mem_jobs");
			sb.append(", member.mem_mileage");
			sb.append("FROM member,comm_code,comm_code c");
			sb.append("where member.mem_like = comm_code.comm_cd");
			sb.append("and member.mem_job = c.comm_cd");			
			
			
			
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			List<MemberVO> list = new ArrayList<MemberVO>();
			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setMemId(rs.getString("mem_id"));
				member.setMemName(rs.getString("mem_name"));
				member.setMemAdd1(rs.getString("mem_add1"));
				member.setMemAdd2(rs.getString("mem_add2"));
				member.setMemJob(rs.getString("mem_jobs"));
				member.setMemMileage(rs.getInt("mem_mileage"));
				list.add(member);
			}
			return list;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {

			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (conn != null) try { conn.close();} catch (Exception e) {}

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
			pstmt = conn.prepareStatement(sb.toString());

			return null;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {

			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (conn != null) try { conn.close();} catch (Exception e) {}

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
			pstmt = conn.prepareStatement(sb.toString());

			return 0;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {

			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (conn != null) try { conn.close();} catch (Exception e) {}

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

			return 0;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {

			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (conn != null) try { conn.close();} catch (Exception e) {}

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

			return 0;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		} finally {

			if (rs != null) try {rs.close();} catch (Exception e) {}
			if (pstmt != null) try { pstmt.close();} catch (Exception e) {}
			if (conn != null) try { conn.close();} catch (Exception e) {}

		}

	}

}
