package edu.institution.actions.asn4;

import java.util.List;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListConnectionAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		List<LinkedInUser> users = loggedInUser.getConnections();
		if(users.size() == 0) { System.out.println("You have no connections"); return true;}
		for(LinkedInUser user : users) {
			System.out.println(user.getUsername());
		}
		return true;
	}

}
