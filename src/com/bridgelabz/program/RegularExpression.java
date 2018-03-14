package com.bridgelabz.program;
/***************************************************************************
 * @purpose : This program is used for replace data with user input
 * 			using Regex
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 14/03/2018
 ***************************************************************************/
import com.bridgelabz.utility.Utility;

public class RegularExpression 
{
		public static void main( String args[] )
		{
			Utility.setFirstName();

			Utility.setLastName();	

			Utility.setMobileNumber();

			Utility. setDate();
			
			String string=Utility.RegexReplace();

			System.out.println(string);


		}
		
	
}
