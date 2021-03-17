package edu.institution.actions.asn3;

import java.util.List;
import java.util.Scanner;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.actions.asn10.UndoAction;
import edu.institution.actions.asn10.UndoProfile;
import edu.institution.asn2.LinkedInUser;

public class DeleteUserAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter a username");	
		String username = scanner.nextLine();
		List<LinkedInUser> users = userRepository.retrieveAll();
		for(LinkedInUser user : users) {
			if(user.getUsername().equals(username)) {
				System.out.println("\nEnter a password");
				String password = scanner.nextLine();
				if (user.isPasswordCorrect(password)) {
					userRepository.delete(user);
					UndoAction.history.push(new UndoProfile(3, user));
					return !(loggedInUser.getUsername().equals(username));
				} else {
					System.out.println("The password is incorrect.");
					return true;
				}
			}
			
		}
		System.out.println("This user does not exist");
		return true;
		
	}

}
