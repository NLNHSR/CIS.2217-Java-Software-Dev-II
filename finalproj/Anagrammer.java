package edu.institution.finalproj;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Anagrammer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Options options = new Options();
		options.addOption("a", "anagram", true, "Supplies the anagram to evaluate");
		options.addOption("nf", "no-filter", false, "output all anagram values with no filter");
		options.addOption("words", "filter-words", false, "output only values that are known words");
		options.addOption("h", "help", false, "diplays the help for this program");

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = null;
		try {
			cmd = parser.parse(options, args);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
		if (cmd.hasOption("h")) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("anagrammer" , options);
			return;
		}
		
		String anagram = "";
		if (cmd.hasOption("a")) {anagram = cmd.getOptionValue("a");}
		else if(cmd.hasOption("anagram")) {anagram = cmd.getOptionValue("anagram");}
		else {System.out.println("Missing required option: -a"); return;}
		
		String filter = "";
		if (cmd.hasOption("words") || cmd.hasOption("filter-words")) {
			filter = "words";
		}
		
		AnagramEvaluatorImpl evaluator = new AnagramEvaluatorImpl();
		evaluator.evaluate(anagram, filter);
		
	}

}
