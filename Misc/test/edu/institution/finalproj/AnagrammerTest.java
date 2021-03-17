package edu.institution.finalproj;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class AnagrammerTest {
	
	@Test
	public void anagrammerTest() {
		// Anagrammer -nf & --no-filter -a DOG
		AnagramEvaluatorImpl evaluator = new AnagramEvaluatorImpl();
		List<String> anagrams = new ArrayList<String>(evaluator.evaluate("DOG", ""));
		List<String> expected = Arrays.asList("DGO", "DOG", "GDO", "GOD", "ODG", "OGD");
		assertTrue(anagrams.equals(expected));

		// Anagrammer -nf & --no-filter -a DOG
		List<String> anagrams2 = new ArrayList<String>(evaluator.evaluate("DOG", "words"));
		List<String> expected2 = Arrays.asList("DOG","GOD");
		assertTrue(anagrams.equals(expected));
		
		
		Anagrammer anagrammer = new Anagrammer();
		String[] input4 = new String[] {"-help"};
		anagrammer.main(input4);
		String[] input = new String[] {"-nf", "-a", "DOG"};
		anagrammer.main(input);
		String[] input2 = new String[] {"-words", "-anagram", "DOG"};
		anagrammer.main(input2);
		String[] input3 = new String[] {"--filter-words"};
		anagrammer.main(input3);

		
	}
	
}
