package com.shop.yes24.member.Service;

import com.shop.yes24.member.DTO.MemberDTO;

public interface MemberformService {
	
	public void insertMember(MemberDTO dto) throws Exception;
	public int selectMaxId()throws Exception;
	// 2020.08 19 ���̵� �ߺ��˻�
	public String selectMemberId(String id) throws Exception;
}
