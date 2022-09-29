package com.ncs.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.web.dao.MemberDAO;
import com.ncs.web.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public List<MemberVO> selectAllMembers() {
		return memberDao.selectAllMembers();
	}
	
	@Override
	public void insertMember(MemberVO member) {
		memberDao.insert(member);
	}
	
	@Override
	public void updateMember(int id, MemberVO updateMember) {
		MemberVO member = memberDao.selectById(id);
		if(member != null) {
			member.setName(updateMember.getName());
			member.setJob(updateMember.getJob());
			member.setLoc(updateMember.getLoc());
			memberDao.update(member);
		}else {
			throw new IllegalStateException("회원이 존재하지 않습니다.");
		}
	}
	
	@Override
	public void deleteMember(int id) {
		if(memberDao.selectById(id) != null) {
			memberDao.delete(id);
		}else {
			throw new IllegalStateException("회원이 존재하지 않습니다.");
		}
	}
}
