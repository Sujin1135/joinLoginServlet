package spms.listeners;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import spms.dao.MemberDao;

public class ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		InitialContext initial;
		try {
			ServletContext sc = event.getServletContext();
			initial = new InitialContext();
			DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/jointest");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setDataSource(ds);
			sc.setAttribute("member", memberDao);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
