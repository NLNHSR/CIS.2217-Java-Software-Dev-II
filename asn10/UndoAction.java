package edu.institution.actions.asn10;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class UndoAction implements MenuAction {
	public static Stack<UndoProfile> history = new Stack<UndoProfile>();
	
	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		char choice;
		if(history.isEmpty()) {
			System.out.println("Error: There are no actions to undo");
			return true;
		}
		switch(history.peek().action) {
		case 1: // Add connection 
			System.out.println("The last menu option selected was \"Add Connection\" involving " + history.peek().user.getUsername() + ". Undo(Y/N)");
			choice = scanner.nextLine().charAt(0);
			if (choice == 'Y') {
				try {
					loggedInUser.removeConnection(history.peek().user);
				} catch (LinkedInException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(history.pop().user.getUsername() + " is removed from " + loggedInUser.getUsername() + "'s connection list");
				return true;
			}
			break;
		case 2: // Remove connection
			System.out.println("The last menu option selected was \"Remove Connection\" involving " + history.peek().user.getUsername() + ". Undo(Y/N)");
			choice = scanner.nextLine().charAt(0);
			if (choice == 'Y') {
				try {
					loggedInUser.addConnection(history.peek().user);
				} catch (LinkedInException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(history.pop().user.getUsername() + " is added to " + loggedInUser.getUsername() + "'s connection list");
				return true;
			}
			break;
			
		case 3: // Remove user
			System.out.println("The last menu option selected was \"Remove User\" involving " + history.peek().user.getUsername() + ". Undo(Y/N)");
			choice = scanner.nextLine().charAt(0);
			if (choice == 'Y') {
				try {
					userRepository.add(history.peek().user);
				} catch (LinkedInException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(history.pop().user.getUsername() + " is added to LinkedIn");
				return true;
			}
			break;
			
		case 4: // Add user
			System.out.println("The last menu option selected was \"Add User\" involving " + history.peek().user.getUsername() + ". Undo(Y/N)");
			choice = scanner.nextLine().charAt(0);
			if (choice == 'Y') {
				userRepository.delete(history.peek().user);
				System.out.println(history.pop().user.getUsername() + " is removed to LinkedIn");
				return true;
			}
			break;
			
		}

		return true;
	}

}

