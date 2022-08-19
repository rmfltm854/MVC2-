package login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.CheckAction;
import login.action.FormAction;
import login.action.LogoutAction;
import util.Action;
import util.ActionForward;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do") // /MyHome/ ......  .do
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
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
		
//		System.out.println(requestURL);
		
		int start = requestURL.lastIndexOf("/");
		int end = requestURL.lastIndexOf(".do");
		
		String path = requestURL.substring(start + 1,end);
		
//		System.out.println(path);
		
		//RequestDispatcher rd = null;
		
		switch(path) {
		case "login":
			action = new FormAction();
			actionForward = new ActionForward("/login/login.jsp", false);

			break;
//			new FormAction().execute(request, response);
//			rd = request.getRequestDispatcher("/login/login.jsp");
//			rd.forward(request, response);
		case "check":
			action = new CheckAction();
			actionForward = new ActionForward("/login/result.jsp", false);
			break;
//			new CheckAction().execute(request, response);
//			rd = request.getRequestDispatcher("/login/result.jsp");
//			rd.forward(request, response);
		case "logout":
			action = new LogoutAction();
			actionForward = new ActionForward("/MyHome/login/logout.jsp", true);
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
