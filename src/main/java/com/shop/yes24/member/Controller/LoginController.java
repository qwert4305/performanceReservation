package com.shop.yes24.member.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.yes24.member.DAO.LoginDAO;
import com.shop.yes24.member.DTO.MemberDTO;

@Controller
public class LoginController {

	@Autowired
	LoginDAO dao;

	@RequestMapping(value="/member/Login",method={RequestMethod.POST,RequestMethod.GET} )
	public ModelAndView selectid() {
		ModelAndView mav = new ModelAndView("/member/Login");
		//MemberDTO dto = new MemberDTO();
		//System.out.println(dao.selectid((dto)).toString());

		return mav;  
	}

	@RequestMapping(value = "/member/login.do", method = {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView selectsubject(@RequestParam("userid") String id, @RequestParam("userpw") String pw,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		MemberDTO logdto = new MemberDTO();
		logdto.setMem_id(id);
		logdto.setMem_pw(pw); //id,pw�� dto�� ����
		MemberDTO allinfo = dao.selectid_pw(logdto);//sql�� param���� ���� id,pw �־� ���� ����� allinfo�� ���� 
		

		// ���� �˻� �� �α����� ȸ������ memberInfo�� ���� , allinfo�� if ������
		if (allinfo != null && allinfo.getMem_id() != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("isLogOn", true);
			session.setAttribute("memberInfo", allinfo);
			System.out.println("session�� ������ ��"+allinfo.toString());

		}
		
		//�α��� ����,����if��
        //logdto�� param���� ���� id,pw ���õ� dto
		if (allinfo == null || allinfo.toString() == "") {
			mav.addObject("result", "loginFailed");
			mav.setViewName("/member/Login");
		} else {
			mav.setViewName("redirect:/main/main.do");
		}

		return mav;
	}


	@RequestMapping(value = "/logout.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/main/main.do");
		HttpSession session = request.getSession();
		session.setAttribute("isLogOn", false);
		session.removeAttribute("memberInfo"); //���ǿ� ����� ȸ�� ���� ����
		return mav;

	}

}


