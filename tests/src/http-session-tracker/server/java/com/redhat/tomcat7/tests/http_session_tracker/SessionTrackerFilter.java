

package org.redhat.tomcat7.tests.http_session_tracker;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;


public class SessionTrackerFilter implements Filter {

	private FilterConfig config;
	private Log log = LogFactory.getLog(getClass().getName());

	public SessionTrackerFilter() {}

	public void init(FilterConfig filterConfig)
	 	throws ServletException  {

			log.info("SessionTrackerFilter initialization");
			this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
				FilterChain chain) throws java.io.IOException, ServletException {
		log.info("Session Tracker Filter doFilter");

		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpSession session = request.getSession(true);
		ServletContext context = config.getServletContext();
//		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("SessionTrackerFilter =========");
		String obj = null;
		for (Enumeration e = session.getAttributeNames();
			 e.hasMoreElements() ; 
			 obj = e.nextElement().toString()) 
		{
			out.println("Key: "+ obj + " :: " + 
				session.getAttribute(obj));
		}
		log.info("Session Tracker Filter calling chain");
		chain.doFilter(req, resp);
		log.info("Session Tracker Filter return from chain");
	}

	@Override
	public void destroy() {
		log.debug("SessionTrackerFilter::destroy");
	}

}
