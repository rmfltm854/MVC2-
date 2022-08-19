package join.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import join.action.DeleteAction;
import join.action.JoinAction;
import join.action.UpdateAction;
import util.Action;
import util.ActionForward;

/**
 * Servlet implementation class controller
 */
@WebServlet("*.me")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
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
		int end = requestURL.lastIndexOf(".me");
		
		String path = requestURL.substring(start+1,end);
		
		switch(path) {
		
		case "join" :
			action = new JoinAction();
			actionForward =  new ActionForward("/member/join.jsp", false);
			break;
		case "update" :
			action = new UpdateAction();
			actionForward = new ActionForward("/member/result.jsp",false);
			break;
		case "delete" :
			action = new DeleteAction();
			actionForward = new ActionForward("/member/result.jsp",false);
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
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
