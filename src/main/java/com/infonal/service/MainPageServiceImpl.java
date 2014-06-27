package com.infonal.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.infonal.model.User;

// Service Layer.Database kayýt islemi ve control islemleri icin.

public class MainPageServiceImpl implements MainPageService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	// kullanicilari db' ye kaydeden method
	public boolean insertUser(User myInsertedUser) {

		try {
			mongoTemplate.insert(myInsertedUser);
			System.out.println("insert");
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	// kullanicilari db' den silen method
	public boolean removeUser(String id) {

		try {
			mongoTemplate.remove(new Query(Criteria.where("userId").is(id)),
					User.class);
			System.out.println("delete");
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// kullanicilari db' de güncelleme yapan method
	public boolean updateUser(User user) {

		try {
			Update update = new Update();
			update.set("userName", user.getUserName());
			update.set("userSurname", user.getUserSurname());
			update.set("phoneNo", user.getPhoneNo());
			mongoTemplate.updateFirst(
					new Query(Criteria.where("userId").is(user.getUserId())),
					update, User.class);
			System.out.println("update");
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// kullanicilari listeleyen method, geriye butun kullanicilari iceren liste dondurur.
	public ArrayList<User> getAllUsers() {

		ArrayList<User> savedUser = (ArrayList<User>) mongoTemplate
				.findAll(User.class);

		return savedUser;
	}

}
