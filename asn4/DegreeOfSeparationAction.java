package edu.institution.actions.asn4;

import java.util.List;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class DegreeOfSeparationAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		// TODO Auto-generated method stub
		String output = loggedInUser.getUsername() + " -> ";
		List<LinkedInUser> users = loggedInUser.getConnections();
		System.out.println("What user: ");
		String target = scanner.nextLine();
		System.out.println("There is " + (getConnectionsCount(users, target, output) - 1) + " degrees of seperation between you and " + target);
		return true;
	}
	
	private int getConnectionsCount(List<LinkedInUser> users, String target, String output) {
		int count = 0;
		
		for(LinkedInUser user : users) {
			if(user.getUsername().equals(target)) {
				output += target;
				System.out.println(output);
				return 1;
			}else if(user.getConnections().size() == 0) {
				continue;
			}
			count++;
			output += user.getUsername() + " -> ";
			List<LinkedInUser> subUsers = user.getConnections();
			count += getConnectionsCount(subUsers, target, output);
			
		}
		return count;
		
	}
	
}
