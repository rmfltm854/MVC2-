package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.CreateAction;
import board.action.EditAction;
import board.action.MainAction;
import join.action.DeleteAction;
import join.action.JoinAction;
import join.action.UpdateAction;
import util.Action;
import util.ActionForward;

/**
 * Servlet implementation class BController
 */
@WebServlet("*.board")
public class BController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = null;
		ActionForward actionForward = null;
		String requestURL = request.getRequestURL().toString();
		
		int start = requestURL.lastIndexOf("/");
		int end = requestURL.lastIndexOf(".board");
		
		String path = requestURL.substring(start+1,end);
		
		switch(path) {
		
		case "create" :
			action = new CreateAction();
			actionForward = new ActionForward("/Board/result.jsp",false);
			break;
		case "edit" :
			action = new EditAction();
			actionForward = new ActionForward("/Board/result.jsp",false);
			break;
		case "main" :
			action  = new MainAction();
			actionForward = new ActionForward("/Board/Main.jsp",false);
			break;
		case "createform" :
			actionForward = new ActionForward("/Board/CreateBoard.jsp",false);
			break;
		
			
		}
		if(action != null) {
			action.execute(request, response);
		}
		
		if(actionForward.isRedirect()) {
			response.sendRedirect(actionForward.getNextPath());
		}else {
			request.getRequestDispatcher(actionForward.getNextPath()).forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
