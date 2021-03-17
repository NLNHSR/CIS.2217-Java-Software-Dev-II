package edu.institution.actions.asn6;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListUserByConnectionAction implements MenuAction, Comparator<LinkedInUser> {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		// TODO Auto-generated method stub
		Collections.sort(userRepository.retrieveAll(), new ListUserByConnectionAction());
		Collections.reverse(userRepository.retrieveAll());
		for(LinkedInUser user : userRepository.retrieveAll()) {
			System.out.println(user.getUsername() + "; connection size = " + user.getConnections().size());
		}
		return true;
	}

	@Override
	public int compare(LinkedInUser o1, LinkedInUser o2) {
		// TODO Auto-generated method stub
		if(o1.getConnections().size() > o2.getConnections().size()) {return 1;}
		else if(o1.getConnections().size() < o2.getConnections().size()) {return -1;}
		else return 0;

	}

}

