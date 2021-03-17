package edu.institution.asn5;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.institution.actions.asn5.Utilities;
import edu.institution.asn2.LinkedInUser;

public class UtilitiesTest {

	@Test
	public void removeDuplicatesTest() {
		List<String> numbersS = new ArrayList<>();
		numbersS.add("one");
		numbersS.add("two");
		numbersS.add("one");
		Utilities utilities = new Utilities();
		utilities.removeDuplicates(numbersS);
		// the numbers list should contain two records; “one” and “two”
		assertTrue(((numbersS.get(0).equals("one")) && (numbersS.get(1).equals("two"))) && (numbersS.size() == 2));
		
		List<Integer> numbersN = new ArrayList<>();
		numbersN.add(1);
		numbersN.add(1);
		numbersN.add(1);
		utilities.removeDuplicates(numbersN);
		// the numbers list should contain one record; 1.
		assertTrue(((numbersS.get(0).equals(1)) && (numbersS.size() == 1)));
		
		List<LinkedInUser> userTest = new ArrayList<>();
		userTest.add((new LinkedInUser("Bob")));
		userTest.add((new LinkedInUser("John")));
		userTest.add((new LinkedInUser("Bob")));
		utilities.removeDuplicates(userTest);
		assertTrue(((userTest.get(0).getUsername().equals("Bob")) && (userTest.get(1).getUsername().equals("John"))) && (userTest.size() == 2));
		
	}
	
	@Test
	public void linearSearchTest() {
		List<String> numbersS = new ArrayList<>();
		numbersS.add("one");
		numbersS.add("two");
		numbersS.add("Three");
		Utilities utilities = new Utilities();
		String testS = utilities.linearSearch(numbersS, "two");
		assertTrue(testS.equals("two"));
		assertTrue((utilities.linearSearch(numbersS, "Seven")) == null);
		
		List<Integer> numbersN = new ArrayList<>();
		numbersN.add(1);
		numbersN.add(2);
		numbersN.add(3);
		utilities.linearSearch(numbersN, 2);
		int testN = utilities.linearSearch(numbersN, 2);
		assertTrue(testN == 2);
		assertTrue((utilities.linearSearch(numbersN, 7)) == null);
		
	}
	 /*
	 • What if the ArrayList is empty?
	 • What if it contains only one item?
	 • What if your removeDuplicates method is passed an ArrayList in which every item is
	 identical?
	 • What if the arguments to the two methods are null?
	 • And so on.
	*/
}
