package edu.institution.actions.asn3;

import java.util.List;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListUserAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		// TODO Auto-generated method stub
		List<LinkedInUser> users = userRepository.retrieveAll();
		for (LinkedInUser user : users) {
			System.out.println(user.getUsername());
		}
		
		return true;
	}

}
