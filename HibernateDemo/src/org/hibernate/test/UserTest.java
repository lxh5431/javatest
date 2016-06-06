package org.hibernate.test;

import org.hibernate.dao.UserDAO;
import org.hibernate.dao.UserDAOImpl;
import org.hibernate.entity.User;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSave() {
		UserDAO userdao=new UserDAOImpl();
		try{
			User u=new User();
			u.setName("zhangsan");
		 u.setPassword("468");
		 u.setType("admin");
		 u.setId(9);
		 userdao.save(u);
		 
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
