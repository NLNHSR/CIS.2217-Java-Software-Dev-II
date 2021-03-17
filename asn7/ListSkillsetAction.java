package edu.institution.actions.asn7;

import java.util.Scanner;
import java.util.Set;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.actions.MenuAction;
import edu.institution.asn2.LinkedInUser;

public class ListSkillsetAction implements MenuAction {

	@Override
	public boolean process(Scanner scanner, UserRepository userRepository, LinkedInUser loggedInUser) {
		// TODO Auto-generated method stub
		if(loggedInUser.getSkillsets().isEmpty()) {
			System.out.println("You have not entered any skillsets.");
			
		} else {
			System.out.println("Here are you skillsets\n");
			Set<String> skills = loggedInUser.getSkillsets();
			for(String skill : skills) {
				System.out.println(skill + " (" + ApplicationHelper.retrieveSkillsetCount(skill) + " users)");
			}
			
		}
		
		return true;
	}

}
