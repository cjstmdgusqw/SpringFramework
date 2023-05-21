package com.kosta.board.DAO;

import com.kosta.board.DTO.MemberDTO;

public interface MemberDAO {
	public int memberAdd(MemberDTO dto) throws Exception;
}
