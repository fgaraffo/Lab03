package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

	private List <String> dictionary;
	
	public Model ()
	{
		dictionary = new ArrayList <String> ();
		this.dictionary();
		System.out.println(dictionary.toString());
	}

	public void dictionary () {
		
		try 
		{
			Reader r = new FileReader("rsc/English.txt");
			BufferedReader br = new BufferedReader(r);
			
/*			while(br.readLine() != null)
			{
				String s = br.readLine();
				dictionary.add(s);
				br.
			}*/
		
			String line = null;
			while ((line = br.readLine()) != null) 
			{
				if (!dictionary.contains(line.toLowerCase()))
				{
					dictionary.add(line.toLowerCase());
				}	
				
			}
			
			br.close();
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> controllo(String[] parole)
	{
//		for (int i = 0; i<parole.length;i++)
//		{
//			System.out.println(parole[i]);
//		}
		
		String [] s = new String ([]);
		ArrayList <String> res = new ArrayList<String>();
		for (int i=0;i<parole.length;i++)
		{
			
			if (!dictionary.contains(parole[i]))
			{
				res.add(parole[i]);
			}
		}
		return res;
	}
	
	
}
