package com.bridgelabz.program;

import java.util.ArrayList;

import com.bridgelabz.utility.Utility;

public class DeckOfCardsQueue 
{
	public static void main(String[] args) 
	{
		ArrayList<String[]> arraylist = Utility.cardsInSequence();
		Utility.printCardsOfPlayers(arraylist);

	}
}
