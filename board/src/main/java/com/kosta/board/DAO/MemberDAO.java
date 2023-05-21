package com.kosta.board.DAO;

import com.kosta.board.DTO.MemberDTO;

public interface MemberDAO {
	public void insertMember(MemberDTO dto) throws Exception;
	public MemberDTO selectMember(String id) throws Exception;
}
