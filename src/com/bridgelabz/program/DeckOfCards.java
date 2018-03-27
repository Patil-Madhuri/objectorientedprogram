package com.bridgelabz.program;
import java.util.ArrayList;

/****************************************************************************************************
 * @purpose : This program is used for DeekofCards to initialize deck of cards having suit ("Clubs", 
 * 			  "Diamonds", "Hearts", "Spades") & Rank ("2", "3", "4", "5", "6", "7", "8", "9", "10", 
 * 			  "Jack", "Queen", "King", "Ace"). 
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 14/03/2017
 ****************************************************************************************************/
import com.bridgelabz.utility.Utility;

public class DeckOfCards 
{
	public static void main(String[] args) 
	{
		ArrayList< String[]> arrayList = Utility.deckOfCards();
		Utility.printCardsOfPlayers(arrayList);
	}
}
