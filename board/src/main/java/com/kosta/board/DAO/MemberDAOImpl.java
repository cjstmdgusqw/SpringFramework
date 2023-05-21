package com.kosta.board.DAO;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.kosta.board.DTO.MemberDTO;

public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSessionTemplate sqlsession;
	@Override
	public int memberAdd(MemberDTO dto) throws Exception {
		return sqlsession.insert("Membermapper.memberadd", dto);
	}

}
