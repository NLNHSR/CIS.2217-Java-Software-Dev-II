package edu.institution.actions.asn3;

import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn10.UndoAction;
import edu.institution.actions.asn10.UndoProfile;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class AddUserAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Enter a username");	
			String username = scanner.nextLine();
			System.out.println("\nEnter a password");
			String password = scanner.nextLine();
			System.out.println("Enter the type of user (P or S)");
			String type = scanner.nextLine();
			
			LinkedInUser user = new LinkedInUser(username, password);
			user.setType(type);
			
			userRepository.add(user);
			UndoAction.history.push(new UndoProfile(4, user));
		} catch(LinkedInException e) {
			System.out.println(e.getMessage());
			
		}
		
		return true;
	}

}
