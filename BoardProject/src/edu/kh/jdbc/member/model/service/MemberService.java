package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	/** 회원 목록 조회 서비스
	 * @return memberList
	 */
	public List<Member> selectMemberList() throws Exception {
		
		Connection conn = getConnection();
		
		List<Member> memberList = dao.selectMemberList(conn);
		
		close(conn);
		
		return memberList;
	}

	
	/** 회원 정보 수정 서비스
	 * @param memberName
	 * @param memberGender
	 * @param memberNo
	 * @return result
	 */
	public int updateMember(String memberName, String memberGender, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, memberName, memberGender, memberNo);
		
		// 트랜젝션 처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}


	
	/** 비밀번호 변경 서비스
	 * @param memberPw
	 * @param string
	 * @return
	 */
	public int updatePassword(String newMemberPw, String memberPw, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updatePassword(conn, newMemberPw, memberPw, memberNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
}
