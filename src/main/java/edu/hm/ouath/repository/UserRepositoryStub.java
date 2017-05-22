package edu.hm.ouath.repository;

import java.util.ArrayList;
import java.util.List;

import edu.hm.oauth.model.User;
import edu.hm.oauth.model.UserGroup;

public class UserRepositoryStub implements UserRepository {

	private static int lastID = 0;
	private static final ArrayList<User> REGISTERED_USERS = new ArrayList<>();

	static {
		REGISTERED_USERS.add(new User("Rick Sanchez", "MyMorty", "grandpa@rick.xyz", UserGroup.ADMIN));
		REGISTERED_USERS.add(new User("Otto Waalkes", "Otto", "otto@waalkes.xyz", UserGroup.NORMAL));
		REGISTERED_USERS.add(new User("Robert Lewandowski", "Robercik", "Robert@Robert.xyz", UserGroup.NORMAL));
		REGISTERED_USERS.add(new User("Saul Goodman", "bettercallsaul", "saul@goodman.xyz", UserGroup.NORMAL));
		REGISTERED_USERS.add(new User("Walter White", "knockknock", "walter@white.xyz", UserGroup.NORMAL));
	}

	@Override
	public List<User> getAllUsers() {
		return REGISTERED_USERS;
	}

	@Override
	public boolean createUser(User user) {
		return REGISTERED_USERS.add(user);
	}

	@Override
	public boolean updateUser(String userID, User user) {
		return false;
	}

	public static int getLastID() {
		return lastID;
	}

	public static void setLastID(int lastID) {
		UserRepositoryStub.lastID = lastID;
	}

	@Override
	public User getUser(int userID) {
		// TODO: userID not generated properly yet in User constructor
		return REGISTERED_USERS.get(userID);
	}
}
