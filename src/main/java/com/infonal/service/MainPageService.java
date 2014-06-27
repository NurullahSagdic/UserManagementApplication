package com.infonal.service;

import java.util.ArrayList;

import com.infonal.model.User;

//CRUD islemleri icin kullanilan interface.Prototip olarak tanimlanan insert-delete-update-list methodlari.

public interface MainPageService {
	
	public boolean insertUser(User myInsertedUser);
	
	public boolean updateUser(User user);
	
	public ArrayList<User> getAllUsers();
	
	public boolean removeUser(String id);

}
