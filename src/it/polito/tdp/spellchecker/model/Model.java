package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

	private List <String> dictionary;
	private String language;
	
	public Model ()
	{
		
	}

	public boolean loadDictionary (String language) {
		
		dictionary = new ArrayList <String> ();
		this.language = language;
		
		try 
		{
			Reader r = new FileReader("rsc/"+language+".txt");
			BufferedReader br = new BufferedReader(r);
						
			String line;
			while ((line = br.readLine()) != null) 
			{
				dictionary.add(line.toLowerCase());
			}
			
			br.close();
			return true;
			
		} 
		catch (IOException e)
		{
			System.out.println("ERRORE: apertura file non riuscita.");
			return false;
		}
		
	}
	
	public List <Word> controllo (List <String> inputText)
	{
		List <Word> res = new ArrayList <Word> ();
		
		for (String s : inputText)
		{
			Word word = new Word(s);
			if (dictionary.contains(s)){
				word.setCorrect(true);
			} else {
				word.setCorrect(false);
			}
			res.add(word);
		}
		
		return res;
	}
	
	
}
