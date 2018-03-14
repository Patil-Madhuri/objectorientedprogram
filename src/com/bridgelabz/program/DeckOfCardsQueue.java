package com.bridgelabz.program;

import com.bridgelabz.utility.Utility;

public class DeckOfCardsQueue 
{
	public static void main(String[] args) 
	{
		String suits[] = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String rank[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"};
		Utility.deckOfCardsQueue(suits,rank);
	}
}
