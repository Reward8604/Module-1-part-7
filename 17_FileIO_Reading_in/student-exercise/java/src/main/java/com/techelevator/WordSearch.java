package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch
{

	public static void main(String[] args)
	{
		String filePath = getUserInput("What is the file that should be searched? ");
		String word = getUserInput("What is the search word you are looking for?");
		String search = getUserInput("Should the search be case sensitive? (Y\\N)");
		File wordFile = new File(filePath);
		Scanner scanner;
		try
		{
			scanner = new Scanner(wordFile.getAbsoluteFile());
			int counter = 1;
			while (scanner.hasNextLine())
			{
				String wordLine = scanner.nextLine();
				String[] words = wordLine.split(" ");
				for (String searchWord : words)
				{
					if (search.equals("N"))
					{

						if (searchWord.toLowerCase().contains(word.toLowerCase()))
						{
							displayOutput(counter + ")" + wordLine);
						}

					} else if (search.equals("Y"))
					{

						if (searchWord.contains(word))
						{
							displayOutput(counter + ")" + wordLine);
						}
					}
				}
				counter++;
			}
		} catch (FileNotFoundException e)
		{

		}
	}

	public static String getUserInput(String input)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(input);
		String userInput = scanner.nextLine();

		return userInput;

	}

	public static void displayOutput(String output)
	{
		System.out.println(output);
	}

}
