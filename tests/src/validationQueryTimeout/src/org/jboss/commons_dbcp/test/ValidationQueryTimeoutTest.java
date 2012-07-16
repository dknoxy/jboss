package org.jboss.commons_dbcp.test;


import org.apache.commons.dbcp.BasicDataSource;


public class ValidationQueryTimeoutTest
{
	public static void main(String args[])
	{
		ValidationQueryTimeoutTest vqt = new ValidationQueryTimeoutTest();
	}

	public ValidationQueryTimeoutTest()
	{
		System.out.println("Creating new BasicDataSource");
		BasicDataSource bds = new BasicDataSource();
		System.out.println("Calling setValidationQueryTimeout=5");
		bds.setValidationQueryTimeout(5);
		System.out.println("ValidationQueryTimeout=" + bds.getValidationQueryTimeout());
	}
};
