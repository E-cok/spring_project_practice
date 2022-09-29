package com.ncs.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.web.service.MemberService;
import com.ncs.web.vo.MemberVO;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/members/all")
	public List<MemberVO> selectAllMembers() {
		return memberService.selectAllMembers();
	}
	
	@PostMapping("/members/new")
	public List<MemberVO> insertMember(@RequestBody MemberVO member) {
		memberService.insertMember(member);
		return memberService.selectAllMembers();
	}
	
	@PutMapping("/members/{id}")
	public List<MemberVO> updateMember(@PathVariable int id, @RequestBody MemberVO member) {
		memberService.updateMember(id, member);
		return memberService.selectAllMembers();
	}
	
	@DeleteMapping("/members/{id}")
	public List<MemberVO> deleteMember(@PathVariable int id) {
		memberService.deleteMember(id);
		return memberService.selectAllMembers();
	}
}
