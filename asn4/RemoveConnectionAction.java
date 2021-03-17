package edu.institution.actions.asn4;

import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn10.UndoProfile;
import edu.institution.actions.asn10.UndoAction;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class RemoveConnectionAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		// TODO Auto-generated method stub
		System.out.println("Enter username to remove connection with: ");
		String username = scanner.nextLine();
		if(userRepository.retrieve(username) == null) {System.out.println("Ther is no user with that user name"); return true;}
		LinkedInUser user = userRepository.retrieve(username);
		try {
			loggedInUser.removeConnection(user);
			System.out.println("The connection was removed successfully");
			UndoAction.history.push(new UndoProfile(2,user));
			
		} catch (LinkedInException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			
		}
		
		return true;
	}

}
