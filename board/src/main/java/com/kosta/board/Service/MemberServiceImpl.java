package com.kosta.board.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.board.DAO.MemberDAO;
import com.kosta.board.DTO.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;

	@Override
	public void join(MemberDTO dto) throws Exception {
		dao.insertMember(dto); 
	}

	@Override
	public void login(String id, String password) throws Exception {
		MemberDTO memberDTO = dao.selectMember(id);
		if(memberDTO==null) throw new Exception("아이디 오류");
		if(memberDTO.getPassword().equals(password)==false) {
			throw new Exception("비밀번호 오류");
		}
		
		
	}

}
