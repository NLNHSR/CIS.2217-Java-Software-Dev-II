package edu.institution.actions.asn6;

import java.util.Collections;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListUserAlphabeticallyAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		Collections.sort(userRepository.retrieveAll());
		// I wasn't sure if/how I should output the alphabetically sorted list
		for(LinkedInUser user : userRepository.retrieveAll()) {
			System.out.println(user.getUsername());
		}
		return true;
	}

}
