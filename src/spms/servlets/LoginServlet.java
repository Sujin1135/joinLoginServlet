package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spms.dao.MemberDao;
import spms.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/auth/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		ServletContext sc = request.getServletContext();
		MemberDao memberDao = (MemberDao)sc.getAttribute("member");
		
		try {
			Member member = (Member)memberDao.loginMember(request.getParameter("email"),
							request.getParameter("password"));
			
			if (member != null) {
				response.sendRedirect("../");
			} else {
				PrintWriter out = response.getWriter();
				 
				out.println("<script language='javascript'>");
				out.println("alert('아이디 혹은 비밀번호가 다릅니다.');");
				out.println("location.replace('/mangoBlog/auth/login');");
				out.println("</script>");
				out.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}

}
