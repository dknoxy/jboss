

package org.redhat.tomcat7.tests.http_session_tracker;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletConfig;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;


public class SessionTrackerServlet
	extends HttpServlet
{
	private Log log = LogFactory.getLog(getClass().getName());

	@Override
	public void init()
	{
		log.info("Session Tracker Servlet initialized");
	}


	@Override
	public void service(
		HttpServletRequest req,
		HttpServletResponse resp) throws ServletException
	{
		resp.setContentType("text/html");
		try {
			log.info("Session Tracker Servlet service request");
			PrintWriter out = resp.getWriter();
			out.print("<!DOCTYPE html><html><body>");
			out.print("<h1>Session Tracking</h1>");
			out.print("<div id=\"div1\"> Session Values </div>");
			out.print("<script language=\"JavaScript\">");
			out.print("Response.Write(\"Client Side ========= \");");
			out.print( "for ( s = new Enumerator(Session.Contents);"); 
		   out.print( "!s.atEnd();");
			out.print( "s.moveNext(); ) {");
			out.print( "Response.Write(s.item() + \" :: \");"); 
			out.print( "Response.Write(Session(s.item());"); 
			out.print( "Response.Write(\"<br>\");");
			out.print( "}</script>");

			HttpSession session = req.getSession(true);

			out.println("SessionTrackerServlet =========");
			String obj = null;
			for (Enumeration e = session.getAttributeNames();
				 e.hasMoreElements() ; 
				 obj = e.nextElement().toString()) 
			{
				out.println("Key: "+ obj + " :: " + 
					session.getAttribute(obj));
			}
			out.print("</body></html>");

		} catch(IOException iox) {
			throw new ServletException("caught: ", iox);
		}
	}
}
