package edu.institution.actions.asn7;

import java.util.Scanner;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class AddSkillsetAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		// TODO Auto-generated method stub
		System.out.println("What skill would you like to add?: ");
		String skill = scanner.nextLine();
		skill = "HI";
		loggedInUser.addSkillset(skill);
		System.out.println(skill + " has been added to your skillsets.");
		ApplicationHelper.incrementSkillsetCount(skill);
		
		return true;
	}

}
