package com.ncs.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ncs.web.vo.MemberVO;

@Mapper
public interface MemberDAO {
	
	public List<MemberVO> selectAllMembers();
	
	public MemberVO selectById(int id);
	
	public void insert(MemberVO member);
	
	public void update(MemberVO member);
	
	public void delete(int id);
}