package board.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.boarddao.Boarddao;
import board.boarddto.Boarddto;
import util.Action;

public class MainAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 List<Boarddto> list = new ArrayList<Boarddto>();
		 Boarddao dao = Boarddao.getInstance();
		 list = dao.AllBoard();
		 request.setAttribute("boardList", list);
		
	}
	
	

}
