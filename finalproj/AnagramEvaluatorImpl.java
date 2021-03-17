package edu.institution.finalproj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnagramEvaluatorImpl implements AnagramEvaluator {
	List<String> anagrams = new ArrayList<String>();
	List<String> realAnagrams = new ArrayList<String>();
	
	public List<String> evaluate(String anagram, String option) {
		// TODO Auto-generated method stub
	
		AnagramDataReaderImpl word = new AnagramDataReaderImpl();
	    List<String> words = new ArrayList<String>(word.readData()); 
		anagram = anagram.toUpperCase();
		anagrams("", anagram);
		
		for (String a : anagrams) {
			if (words.contains(a)) {
				realAnagrams.add(a);
			}
		}
		
		Collections.sort(anagrams);
		Collections.sort(realAnagrams);
		
		int count = 0;
		if (option.equalsIgnoreCase("words")) {
			for (String a : realAnagrams) {
				count++;
				System.out.println(a);
			}
			System.out.println("\n-- " + count + " value(s) found");
			return realAnagrams;
		} else {
			for (String a : anagrams) {
				count++;
				System.out.println(a);
			}
			System.out.println("\n-- " + count + " value(s) found");
			return anagrams;
		}

	}
	
	/*
	* The class Anagrams inputs a word and generates its anagrams
	* @author : www.guideforschool.com
	* @Program Type : BlueJ Program - Java
	* http://www.guideforschool.com/2469083-java-program-to-find-all-the-anagrams-of-a-word/
	* This implementation works by recursively working through the provided word to create each possible 
	* anagram through cutting it up into varying sizes of substrings and a base case when the string length
	* is less than 1. I chose this as it was very easy to implement into my code and short, also since it
	* used a programming concept I was familiar with(recursion) and could follow to see how it actually 
	* worked. 
	*/
	 
	void anagrams(String s1, String s2)
    {
        if(s2.length()<=1)
        {
        	anagrams.add(s1 + s2);
        }
        else
        {
            for(int i=0; i<s2.length(); i++)
            {
                String x = s2.substring(i, i+1);
                String y = s2.substring(0, i);
                String z = s2.substring(i+1);
                anagrams(s1+x, y+z);
            }
        }
    }

}
