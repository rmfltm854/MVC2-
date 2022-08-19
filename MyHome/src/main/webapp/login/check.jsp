<%@page import="member.memberdao.MemberDAO"%>
<%@page import="member.memberdto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	MemberDTO dto = new MemberDTO();
	
	dto.setId(id);
	dto.setPassword(password);
	
	MemberDAO dao = MemberDAO.getInstance();
	
	dto = dao.checkLogin(dto);
	
	boolean check = false;
	String msg = null;
	
	if(dto != null){
		msg = dto.getName() + "님이 로그인 하셨습니다.";
		check = true;
		//로그인처리
		session.setAttribute("login", dto);
		
		//쿠키파일 셋팅
		String ckid = request.getParameter("ckid");
		
		//기존 쿠키파일 읽어오기
		Cookie[] cks = request.getCookies();
		
		Cookie ck = null;
		
		//기존 파일 검색
		if(cks != null){
			for(Cookie c: cks){
				if(c.getName().equals("ckid")){
					ck = c;
					break;
				}
			}
		}
		
		if(ckid != null){
			if(ck == null){
				//쿠키파일 생성
				ck = new Cookie("ckid",dto.getId());
				
				ck.setMaxAge(60*60*24);
				
				response.addCookie(ck);
			}else{
				if(!ck.getValue().equals(dto.getId())) {
					ck.setValue(id);
					response.addCookie(ck);
				}
			}
		}else{
			if(ck != null && ck.getValue().equals(dto.getId())){
				//쿠키파일 삭제
				ck.setMaxAge(0);
				response.addCookie(ck);
			}
		}
		
		
	}else{
		msg = "아이디 혹은 비밀번호가 잘못되었습니다.";
	}
	
	request.setAttribute("check", check);
	request.setAttribute("msg", msg);
	
	pageContext.forward("/login/result.jsp");
%>















