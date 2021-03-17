/*
 Copyright (C) 2020. Doug Estep -- All Rights Reserved.
 Copyright Registration Number: TXU002159309.

 This file is part of the Tag My Code application.

 This application is protected under copyright laws and cannot be used, distributed, or copied without prior written
 consent from Doug Estep.  Unauthorized distribution or use is strictly prohibited and punishable by domestic and
 international law.

 Proprietary and confidential.
 */
package edu.institution;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.institution.asn2.LinkedInUser;

/**
 * Contains static helper methods to aid with the command line user interface.
 */
public class ApplicationHelper {

	/**
	 * Displays the supplied message to the console.
	 * 
	 * @param message the message.
	 */
	// The map collection was chosen since it stores key value pairs 
	public static Map<String, Integer> skillsCount;
	
	public static void showMessage(String message) {
		System.out.println("\n" + message);
	}
	
	public static void incrementSkillsetCount(String skillset) {
		skillsCount.put(skillset, skillsCount.get(skillset) + 1);
	}
	
	public static void decrementSkillsetCount(String skillset) {
		skillsCount.put(skillset, skillsCount.get(skillset) - 1);
	}
	
	public static int retrieveSkillsetCount (String skillset) {
		return skillsCount.get(skillset);
	}
	
	public static void initSkillsetUsages(List<LinkedInUser> users) {
		if ((users.isEmpty())) {
			for (LinkedInUser user : users) {
				Set<String> skills = user.getSkillsets();
				if (!(skills.isEmpty())) {
					for(String skill : skills) {
						incrementSkillsetCount(skill);
					}
				}
				
			}
		}
		
	}
}
