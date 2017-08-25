package org.lanqiao.junit;


import org.junit.Test;
import org.lanqiao.util.ConnectDB;

public class TestConnectDB {

	@Test
	public void testgetDB() {
		String db = ConnectDB.getDB();
		System.out.println(db);
		String pagesize = ConnectDB.getPageSize();
		System.out.println(pagesize);
	}
	
	@Test
	public void testGetConnection(){
		System.out.println(ConnectDB.getConnection());
		
		
	}
	
	@Test
	public void testCeshi(){
		/*String s2 = "abc";
		s2.concat("123");
		System.out.println(s2);
	*/
		
		Integer s = new Integer(9);
		System.out.println(s.equals(9));
	
		
		
		
	}

}
