package com.kosta.board.Service;

import com.kosta.board.DTO.MemberDTO;

public interface MemberService {
	public void join(MemberDTO dto) throws Exception;
	public void login(String id, String password) throws Exception;
}
