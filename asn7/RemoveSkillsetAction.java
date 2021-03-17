package edu.institution.actions.asn7;

import java.util.Scanner;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class RemoveSkillsetAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		// TODO Auto-generated method stub
		System.out.println("What skill would you like to remove?: ");
		String skill = scanner.nextLine();
		if (loggedInUser.getSkillsets().contains(skill)) {
			loggedInUser.removeSkillset(skill);
			ApplicationHelper.decrementSkillsetCount(skill);
			
		} else {
			return true;
		}
		
		return true;
	}

}
