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
import spms.vo.Script;

/**
 * Servlet implementation class JoinServlet
 */

public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/auth/join.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		ServletContext sc = request.getServletContext();
		MemberDao memberDao = (MemberDao)sc.getAttribute("member");
		String mangoUrl = "/mangoBlog";
		String joinUrl = "/auth/join";
		
		try {
			
			Member member = new Member().setEmail(request.getParameter("email"))
					.setName(request.getParameter("name")).setPassword(request.getParameter("password"))
					.setPasswordCheck(request.getParameter("passwordCheck"));
			
			int result = memberDao.joinMember(member);
			
			if(result > 0) {
				out.println(Script.scriptOut("회원가입이 완료되었습니다.", mangoUrl));
			} else if (result == -1) {
				out.println(Script.scriptOut("중복된 이메일이 존재합니다.", mangoUrl + joinUrl));
			} else if (result == -2) {
				out.println(Script.scriptOut("이메일 형식이 잘못되었습니다.", mangoUrl + joinUrl));
			} else if (result == -3) {
				out.println(Script.scriptOut("이름이 잘못되었습니다. 형식에 맞게 입력하세요.", mangoUrl + joinUrl));
			} else if (result == -4) {
				out.println(Script.scriptOut("비밀번호 형식이 잘못되었습니다.", mangoUrl + joinUrl));
			} else {
				System.out.println(result);
				out.println(Script.scriptOut("비밀번호와 비밀번호 확인이 일치하지 않습니다.", mangoUrl + joinUrl));
			}
			
		} catch (Exception e) {
			out.println(Script.scriptOut("입력 정보가 잘못되었습니다.", mangoUrl + joinUrl));
		} finally {
			out.close();
		}
		
		response.setContentType("text/html; charset=UTF-8");
	}

}
