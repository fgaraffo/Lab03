package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {

	private List <String> dictionary;
	private String language;
	
	public Model ()
	{
		
	}

	public boolean loadDictionary (String language) {
		
		if (dictionary != null && this.language.equals(language)) {
			return true;
		}
		
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
			
			Collections.sort(dictionary);
			
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
	
	public List <Word> spellCheckTextLinear (List <String> inputText){
		
		List <Word> res = new ArrayList <Word> ();
		
		for (String s: inputText)
		{
			Word word = new Word(s);
			
			boolean found = false;
			for (String s1 : dictionary) {
				if (s1.equalsIgnoreCase(s)) {
					found = true;
					break;
				}
			}
			
			if (found) {
				word.setCorrect(true);	
			} else {
				word.setCorrect(false);
			}

			res.add(word);
		}
		
		return res;
	}
	
	public List <Word> spellCheckTextDichotomic (List <String> inputText){
		
		List <Word> res = new ArrayList <Word> ();

		return res;
	}
	
}
