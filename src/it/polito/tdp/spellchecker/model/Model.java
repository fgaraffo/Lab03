package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

	private List <String> dictionary;
	
	public Model ()
	{
		dictionary = new ArrayList <String> ();
		this.loadDictionary("English");
	}

	public void loadDictionary (String language) {
		
		try 
		{
			Reader r = new FileReader("rsc/"+language+".txt");
			BufferedReader br = new BufferedReader(r);
			
			String line = null;
			while ((line = br.readLine()) != null) 
			{
				dictionary.add(line.toLowerCase());
			}
			
			br.close();
			
		} 
		catch (IOException e)
		{
			System.out.println("ERRORE: apertura file non riuscita.");
		}
		
	}
	
	public ArrayList <Word> controllo(ArrayList <Word> parole)
	{
			
		for (Word w : parole)
		{
			if (dictionary.contains(w.getWord()))
			{
				parole.remove(w);
			}
			
		}
		return parole;
	}
	
	
}
