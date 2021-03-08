package com.cts.esa.repo;

import java.util.ArrayList;
import java.util.List;

import com.cts.esa.model.User;

public class UserRepository {

	public static List<User> USER_REPO = getUserList();

	private static List<User> getUserList() {
		List<User> list = new ArrayList<User>();
		list.add(new User("12345", "Arun", "1234", "Admin"));
		list.add(new User("23456", "Prakash", "1234", "Manager"));
		list.add(new User("34567", "Anand", "1234", "Employee"));
		return list;

	}

	public static User matchPassword(String id, String password) {
		return getUserList().stream()
				.filter(user -> (id.equalsIgnoreCase(user.getId()) && password.equalsIgnoreCase(user.getPassword())))
				.findAny().orElse(null);
	}
}
