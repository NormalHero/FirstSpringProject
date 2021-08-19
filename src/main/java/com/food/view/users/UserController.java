package com.food.view.users;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.food.myapp.users.UsersService;
import com.food.myapp.users.UsersVO;
import com.food.myapp.users.impl.UsersDAO;

@Controller
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	
	@RequestMapping("/insertUsers.do")
	public String insertUser(UsersVO vo,Model m) {
		System.out.println("ȸ������ ó�� ��Ʈ�ѷ�");
		
		int result = usersService.idChk(vo);
		System.out.println(result);
		if(result == 1) {
			return "insertUser.jsp";
		}else if(result == 0) {
		
		usersService.insertUsers(vo);
		
		vo=usersService.getUsers(vo);
		
		System.out.println(vo.getName());
		System.out.println(vo.getPassword());
		System.out.println(vo.getRole());
		System.out.println(vo.getName());
		System.out.println(vo.getId());
		m.addAttribute("v", vo);
			return "login.jsp";
		}
		
		
		
		
		
		return "redirect:/";
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(UsersVO vo,UsersDAO dao,HttpSession session) {
		System.out.println("�α��� ��Ʈ�ѷ�");
		
		
		if(vo.getId()==null || vo.getId().equals("")) {
			throw new IllegalArgumentException("���̵� �Էµ��� �ʾҽ��ϴ�.");
			
		}
		
		UsersVO data=usersService.getUsers(vo);
		
	
		
		if(data!=null){
			session.setAttribute("log_info", data.getId());
			
			 String role = data.getRole();
			 boolean roleck;
			 if(role.equals("ADMIN")) {
				 roleck = true;
			 }else {
				 roleck = false;
			 }
			 session.setAttribute("log_Role", roleck);
			 
			
			System.out.println("�α��μ���");
			System.out.println(data.getId());
			return "index.jsp";
		}
		else {
			

			
			return "logfail.do";
		}
	}
	/*
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login2(@ModelAttribute("user")UsersVO vo) {
		System.out.println("�α���ȭ���� �����ϴ� �޼��嵿����");
		
		vo.setId("a");
		vo.setPassword("a");
		
		return "mainpage.jsp";
	}
	*/
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("�α׾ƿ� ��Ʈ�ѷ�");

		session.invalidate();

		return "index.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/idChk.do", method = RequestMethod.POST)
	public int idChk(UsersVO vo) {
		System.out.println("���̵� �ߺ�Ȯ�� ȣ��");
		int result = usersService.idChk(vo);
		System.out.println(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/logfail.do",method=RequestMethod.POST)
	public String logfail() {
			
		return "<script >alert(\"�α��ν��� - ���̵� ��й�ȣ�� Ȯ���ϼ��� !\");"
				+ "location.href='login.jsp'</script>";
	}
	
	
}
