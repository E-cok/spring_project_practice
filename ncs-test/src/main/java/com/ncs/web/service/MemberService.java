package com.ncs.web.service;

import java.util.List;

import com.ncs.web.vo.MemberVO;

public interface MemberService {
	
	public List<MemberVO> selectAllMembers();
	void insertMember(MemberVO member);
	void updateMember(int id, MemberVO member);
	void deleteMember(int id);
}
