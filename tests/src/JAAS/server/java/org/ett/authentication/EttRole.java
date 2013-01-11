package org.ett.authentication;

import java.security.Principal;

public class EttRole
	implements java.security.Principal
{
	private String name;

	public boolean equals(Object another)
	{
		if ( !org.ett.authentication.EttRole.class.isInstance(another)) {
			return false;
		}
		if (hashCode() == another.hashCode()) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return getName();
	}

	public int hashCode() {
		return getName().hashCode();
	}
}
