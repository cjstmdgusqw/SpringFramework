package com.kosta.board.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kosta.board.DAO.MemberDAO;
import com.kosta.board.DTO.MemberDTO;

public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;

	@Override
	public int memberAdd(MemberDTO dto) throws Exception {
		int n = dao.memberAdd(dto); 
		return n;
	}

}
