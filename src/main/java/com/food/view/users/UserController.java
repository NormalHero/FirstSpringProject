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
		System.out.println("회원가입 처리 컨트롤러");
		
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
		System.out.println("로그인 컨트롤러");
		
		
		if(vo.getId()==null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디가 입력되지 않았습니다.");
			
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
			 
			
			System.out.println("로그인성공");
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
		System.out.println("로그인화면을 서비스하는 메서드동작함");
		
		vo.setId("a");
		vo.setPassword("a");
		
		return "mainpage.jsp";
	}
	*/
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 컨트롤러");

		session.invalidate();

		return "index.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/idChk.do", method = RequestMethod.POST)
	public int idChk(UsersVO vo) {
		System.out.println("아이디 중복확인 호출");
		int result = usersService.idChk(vo);
		System.out.println(result);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/logfail.do",method=RequestMethod.POST)
	public String logfail() {
			
		return "<script >alert(\"로그인실패 - 아이디나 비밀번호를 확인하세요 !\");"
				+ "location.href='login.jsp'</script>";
	}
	
	
}
