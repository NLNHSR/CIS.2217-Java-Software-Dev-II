package edu.institution.actions.asn10;

import edu.institution.asn2.LinkedInUser;

public class UndoProfile {
	public int action; public LinkedInUser user;

	public UndoProfile(int action, LinkedInUser user) {
		this.action = action;
		this.user = user;
	}
}
