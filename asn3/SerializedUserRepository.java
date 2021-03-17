package edu.institution.actions.asn3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.institution.ApplicationHelper;
import edu.institution.UserRepository;
import edu.institution.asn2.LinkedInException;
import edu.institution.asn2.LinkedInUser;

public class SerializedUserRepository implements UserRepository {

	private String filePath, fileName;
	private List<LinkedInUser> users;
	
	@SuppressWarnings("unchecked")
	@Override
	public void init(String filePath, String fileName) {
		// TODO Auto-generated method stub
		this.filePath = filePath;
		this.fileName = fileName;
		File file = new File(filePath + fileName);
		if (file.exists()) {
			try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)){
				users = (List<LinkedInUser>) ois.readObject();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			users = new ArrayList<LinkedInUser>();
			
		}
		ApplicationHelper.initSkillsetUsages(users);	
	}

	@Override
	public void add(LinkedInUser user) throws LinkedInException {
		// TODO Auto-generated method stub
	
		if(user.getUsername() == null || user.getType() == null || user.getUsername().equals("") || user.getType().equals("")) {
			throw new LinkedInException("The user name and type are required to add a new user.");
		} else if(!(user.getType().equals("P") || user.getType().equals("S"))) {
			throw new LinkedInException("Invalid user type. Valid types are P or S.");
		} else if(users.contains(user)) {
			throw new LinkedInException("A user already exists with that user name.");
		}
		
		users.add(user);
		saveAll();
		
		
	}

	@Override
	public void saveAll() {
		// TODO Auto-generated method stub
		File file = new File(filePath + fileName);
		if(file.exists()) {
			file.delete();
		}
		
		new File(filePath).mkdirs();
		
		try (FileOutputStream fout = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fout)){
			oos.writeObject(users);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(LinkedInUser user) {
		// TODO Auto-generated method stub
		users.remove(user);
		saveAll();
		
	}

	@Override
	public LinkedInUser retrieve(String username) {
		// TODO Auto-generated method stub
		for (LinkedInUser user:users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<LinkedInUser> retrieveAll() {
		// TODO Auto-generated method stub
		return (users.size() == 0) ? new ArrayList<LinkedInUser>() : users;
		
	}

}
