
package org.jboss.tomcat5;

import org.apache.catalina.users.MemoryUserDatabase;
import org.apache.catalina.users.MemoryUser;

import java.util.Iterator;

public class UserTest
{
	MemoryUserDatabase db;

	public static void main(String args[]) {
		UserTest ut = new UserTest();
	}

	UserTest() {

		db = new MemoryUserDatabase();
		try {
			db.open();
		} catch (Exception ex) {
			ex.toString();
		}
		Iterator it = db.getUsers();
		while ( it.hasNext()) {
			MemoryUser mu = (MemoryUser)it.next();
			System.out.println("toString");
			System.out.println(mu.toString());
			System.out.println("toXml");
			System.out.println(mu.toXml());

		}
	}

	
}
