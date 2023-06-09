package zork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

public class DMain
{
	/* DUNGEON-- MAIN PROGRAM */

	/* COPYRIGHT 1980, INFOCOM COMPUTERS AND COMMUNICATIONS, CAMBRIDGE MA. 02142 */
	/* ALL RIGHTS RESERVED, COMMERCIAL USAGE STRICTLY PROHIBITED */
	/* WRITTEN BY R. M. SUPNIK */
	public static void main(String[] args)			
	{
		Dgame game = new Dgame();

		do
		{		
			Map<String, String> info = game.start();
			System.out.print(info.get("output"));
			System.out.flush();
			System.err.print(info.get("error"));
			System.err.flush();
			
			while(true)
			{
				String action = getInput();
				info = game.step(action);
				System.out.println(info.get("action"));
				System.out.flush();
				System.out.print(info.get("output"));
				System.out.flush();
				System.out.print(info.get("error"));
				System.out.flush();
			}
		}while(true);

	} /* MAIN__ */

	/**
	 * Walkthrough provided by
	 * http://www.deblauweschicht.nl/retrogaming/resources/MainframeZork_walkthrough.txt
	 **/

	private static String[] moves = new String[] {};

	private static int word_index;

	public static BufferedReader words_file = null;
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static String getInput()
	{
		try
		{
			if (words_file == null)
			{
				words_file = new BufferedReader(new FileReader(new File("test.properties")));
		
				if (words_file != null)
				{
					ArrayList<String> words = new ArrayList<String>();
					String buf = "";
					while ((buf = words_file.readLine()) != null)
					{
						if (buf.length() != 0 && buf.charAt(0) != '#')
						{							
							words.add(buf);
						}
					}
					moves = words.toArray(new String[0]);
				}
			}
		}
		catch (FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		String word = "";
		if (word_index < moves.length)
		{
			
			word = moves[word_index];
			word_index++;
		}
		else
		{
			while (word.length() == 0)
			{
				try
				{
					word = reader.readLine();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return word;
	}		 
}
