

package org.jboss.tomcat.test.jndilookup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.CompositeName;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class JndiLookupServlet
	extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String JNDI_NAME = "java:comp/env/boolean";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

			resp.setContentType("text/plain;UTF-8");
			PrintWriter out = resp.getWriter();

			try {
				Context initCtx = new InitialContext();

				Boolean b1 = (Boolean) initCtx.lookup(JNDI_NAME);
				out.print(b1);
				System.out.println(JNDI_NAME + " " + b1);
				CompositeName cn = new CompositeName(JNDI_NAME);
				System.out.println("CompositeName = " + cn.toString());

				Boolean b2 = (Boolean) initCtx.lookup(cn);
				System.out.println("Composite " +  JNDI_NAME + " " + b2);
				out.print(b2);
			} catch (NamingException ex) {
				throw new ServletException(ex);
			}
		}
	}
