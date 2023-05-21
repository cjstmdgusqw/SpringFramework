package com.kosta.board.DAO;


import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.board.DTO.MemberDTO;
@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertMember(MemberDTO dto) throws Exception {
		sqlSession.insert("mapper.member.insertmember", dto);
	}

	@Override
	public MemberDTO selectMember(String id) throws Exception {
		return sqlSession.selectOne("mapper.member.selectmember", id);
	}

}
