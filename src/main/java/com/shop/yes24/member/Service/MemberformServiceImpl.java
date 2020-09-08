package com.shop.yes24.member.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.yes24.member.DAO.MemberformDAO;
import com.shop.yes24.member.DTO.MemberDTO;

@Service
public class MemberformServiceImpl implements MemberformService {

	@Autowired
	MemberformDAO dao;
	
	@Override                                //memMap�� controller���� requestparam���� �޾ƿ� map
	public void insertMember(MemberDTO dto) throws Exception {
		
		
		dao.insertMember(dto);
	}
	
	@Override
	public int selectMaxId() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectMaxId()+1;
	}
	

	// 2020.08 19 ���̵� �ߺ��˻�
	@Override
	public String selectMemberId(String id) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectMemberId(id);
	}
	
	

}
