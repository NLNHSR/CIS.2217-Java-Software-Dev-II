package edu.institution.actions.asn6;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListUserByTypeAction implements MenuAction, Comparator<LinkedInUser> {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		// TODO Auto-generated method stub
		Collections.sort(userRepository.retrieveAll(), new ListUserByTypeAction());
		for(LinkedInUser user : userRepository.retrieveAll()) {
			System.out.println(user.getUsername() + "; type = " + user.getType());
		}
		return true; 
	}

	@Override
	public int compare(LinkedInUser o1, LinkedInUser o2) {
		// TODO Auto-generated method stub
		int compare = o1.getType().compareToIgnoreCase(o2.getType());
		return (compare == 0) ? o1.compareTo(o2) : compare;

	}

}
