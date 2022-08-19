package join.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;
import util.Action;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberDTO dto = new MemberDTO();
		dto.setId(request.getParameter("id"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setTel1(request.getParameter("tel1"));
		dto.setTel2(request.getParameter("tel2"));
		dto.setTel3(request.getParameter("tel3"));
		dto.setEmail(request.getParameter("email"));
		
		
		
		MemberDAO dao = MemberDAO.getInstance();
		boolean check = dao.insert(dto);
		
		request.setAttribute("check", check);
	}

}
