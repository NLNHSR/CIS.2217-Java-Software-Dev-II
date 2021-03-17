package edu.institution.finalproj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AnagramDataReaderImpl implements AnagramDataReader {

	@Override
	public Set<String> readData() {
		// TODO Auto-generated method stub
		Set<String> words = new TreeSet();
		try {
		      File myObj = new File("src\\\\\\\\edu\\\\\\\\institution\\\\\\\\finalproj\\\\\\\\anagram_data.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        words.add(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		return words;
	}
	
}
