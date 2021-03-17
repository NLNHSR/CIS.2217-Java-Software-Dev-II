package edu.institution.asn2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LinkedInUser extends UserAccount implements Cloneable, Comparable<LinkedInUser>, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5986881454283124429L;
	/**
	 * 
	 */
	private String type;
	private List<LinkedInUser> connections = new ArrayList<>();
	private TreeSet<String> skillsets;
	
	public TreeSet<String> getSkillsets(){
		
		return skillsets;
		
	}
	
	public void addSkillset(String skillset) {
		
		skillsets.add(skillset);
	}
	
	public void removeSkillset(String skillset) {
		
		skillsets.remove(skillset);
	}
	
	// I needed this so I could make a copy of connections list 
	public LinkedInUser(String username) {
		this(username,"password");
	}
	
	// Eclipse made me add this or it would throw errors, and there was no default constructor in UserAccount class in assignment 1 or 2
	public LinkedInUser(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
		// TODO Auto-generated method stub
	}
	
	public void addConnection(LinkedInUser user) throws LinkedInException{
	
		if (connections.contains(user)) {
			throw new LinkedInException("You are already connected with this user");
		} else {
			connections.add(user);
		}
			
	}

	public void removeConnection(LinkedInUser user) throws LinkedInException{
			
		if (connections.contains(user)) {
			connections.remove(user);
		} else {
			throw new LinkedInException("You are NOT connected with this user");
		}
	}
	
	public List<LinkedInUser> getConnections(){
		List<LinkedInUser> connectionsCopy = new ArrayList<LinkedInUser>(connections);
		return connectionsCopy;
	}
	
	public int compareTo(LinkedInUser user) {
		// TODO Auto-generated method stub
		return this.getUsername().compareToIgnoreCase(user.getUsername());
	}	

}
