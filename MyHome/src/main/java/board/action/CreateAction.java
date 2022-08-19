package board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.boarddao.Boarddao;
import board.boarddto.Boarddto;
import member.memberdto.MemberDTO;
import util.Action;

public class CreateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		
		
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		Boarddto bdto = new Boarddto();
		bdto.setBcontent(content);
		bdto.setBwriter(writer);
		bdto.setBsubject(title);
		bdto.setBid(dto.getId());
		Boarddao dao = Boarddao.getInstance();
		boolean result = dao.insert(bdto);
		String msg = null;
		String url = null;
		if(result) {
			msg = "글쓰기에 성공하였습니다.";
			url = "/MyHome/index.jsp";
		}else {
			msg = "글쓰기에 실패하였습니다.";
			url = "history.back()";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
	}
	

}
