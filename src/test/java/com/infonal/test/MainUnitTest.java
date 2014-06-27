package com.infonal.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.infonal.model.User;
import com.infonal.service.MainPageService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/applicationContextTest.xml")
public class MainUnitTest {
	@Autowired
	MainPageService mainPageService;

	@Test
	public void mainTest() {

		// insertUser Test
		User myUser = new User();
		myUser.setUserId("21");
		myUser.setUserName("nurullah");
		myUser.setUserSurname("sagdic");
		myUser.setPhoneNo("222-222-22-22");

		System.out.println(mainPageService.insertUser(myUser));

		assertEquals(true, mainPageService.insertUser(myUser));

		// deleteUser Test
		String myUser2 = "21";

		System.out.println(mainPageService.removeUser(myUser2));

		assertEquals(true, mainPageService.removeUser(myUser2));

		// updateUser Test

		User myUser3 = new User();
		myUser3.setUserId("21");
		myUser3.setUserName("ismail");
		myUser3.setUserSurname("artun");
		myUser3.setPhoneNo("222-222-22-22");

		System.out.println(mainPageService.updateUser(myUser3));

		assertEquals(true, mainPageService.updateUser(myUser3));

	}

}
