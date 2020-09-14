package com.saiyad.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	private List<User> users;

	public UserRepository() {
		users = new ArrayList<User>();
		users.add(new User("USER1","shahnavaz","$2b$10$S.KAYzjiFk4xct9fGNRg6.vwDOyG6y0I.jEX.LoS7GiGNOi.DFmY."));
		users.add(new User("USER2","suez","$2b$10$S.KAYzjiFk4xct9fGNRg6.vwDOyG6y0I.jEX.LoS7GiGNOi.DFmY."));
	}
	
	public User findUserByName(String userName){
		User user = null;
		
		for(User u: users){
			if(u.getUsername().equals(userName)){
				user = u;
				break;
			}
		}
		return user;
	}
}
