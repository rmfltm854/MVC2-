package board.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.boarddao.Boarddao;
import board.boarddto.Boarddto;
import util.Action;

public class ShowAction  implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Boarddto dto = new Boarddto();
		Boarddao dao = Boarddao.getInstance();
		
		HttpSession session = request.getSession();
		
		int bnum = Integer.parseInt((String)session.getAttribute("bnum"));
		dto = dao.showBoard(bnum);
		
		request.setAttribute("dto", dto);
	}
	
	

}
