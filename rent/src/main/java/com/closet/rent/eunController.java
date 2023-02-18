package com.closet.rent;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.closet.eun.MemberDAO;
import com.closet.eun.MemberDTO;

@Controller
public class eunController {
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("/join.do")
	public String join() {
		return "eun/join"; // join.jsp 濡� �씠�룞 �떆耳쒖��떎
	}
	
	@RequestMapping("/join_form.do") // 
	public void joinForm(MemberDTO dto, HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int check = this.dao.insertMember(dto);
		
		if (check > 0) { 
			out.println("<script>");
			out.println("alert('가입이 완료되었습니다!')");
		    out.println("location.href='/'"); 
		    out.println("</script>"); 
		} else {
		    out.println("<script>"); 
		    out.println("alert('가입중 오류가 발생했습니다.')");
		    out.println("history.back()"); 
		    out.println("</script>"); 
		}
	}
	
	@RequestMapping("/login.do")
	public String login() {
		return "eun/login";
	}
	
	@RequestMapping("/login_form.do") // 
	public void loginForm(@RequestParam("mem_id") String id, @RequestParam("mem_pwd") String pwd, HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		MemberDTO dto = this.dao.getMember(id);	
		
		PrintWriter out = response.getWriter();

		if (dto != null) {
			if (pwd.equals(dto.getMem_pwd())) {
				out.println("<script>");
				out.println("alert('로그인 성공')");
				out.println("location.href='/'");
				out.println("</script>");

				HttpSession session = request.getSession();
				
				session.setAttribute("mem_id", dto.getMem_id());
				session.setAttribute("mem_name", dto.getMem_name());
			}else {
				out.println("<script>");
				out.println("alert(' 비밀번호를 확인해주세요.')");
				out.println("history.back()");
				out.println("</script>");
			}
		}else {
			out.println("<script>");
			out.println("alert('아이디를 확인해주세요.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return "eun/main";
	}
}
