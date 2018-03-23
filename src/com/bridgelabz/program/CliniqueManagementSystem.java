package com.bridgelabz.program;
/***************************************************************************
 * @purpose : Clinique Management system
 * @author  : Madhuri Chaudhari
 * @version : 1.0
 * @date    : 16/03/2018
 ***************************************************************************/
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.utility.Utility;

public class CliniqueManagementSystem 
{
	public static void main(String[] args) 
	{
	Utility utility = new Utility();
	int lChoice=0;
	do
	{
		System.out.println("Enter your choice");
		System.out.println("1 Add doctor");
		System.out.println("2 Add patient");
		System.out.println("3 Search and book a doctor");
		System.out.println("4 Search patient by name");
		System.out.println("5 Check best doctor of clinic");
		System.out.println("6 See doctor patient relation");
		System.out.println("7. Doctor List");
		System.out.println("8. Patient List");
		System.out.println("9. Exit");
		lChoice = utility.inputInteger();
		
		switch (lChoice) 
		{
		case 1:
			Utility.addDoctor();
			break;
		case 2:
			Utility.addPatients();
			break;
		case 3:
			JSONObject patient=null;
			System.out.println("Enter the patient id");
			String lPatientId = utility.inputString();
			JSONObject jsonObjectpatient = Utility.readFromJsonFile("addPatient.json");
			JSONArray jsonArraypatient = (JSONArray) jsonObjectpatient.get("patients");
			boolean isPatientPresent = false;
			for(int i = 0; i < jsonArraypatient.size();i++)
			{
				 patient = (JSONObject) jsonArraypatient.get(i);
				String id = (String) patient.get("id");
				if(id.equals(lPatientId))
				{
					isPatientPresent = true;
					break;
				}
			}
			if(isPatientPresent)
			{
				Utility.serachAndbookdoctor(patient);
			}
			else
			{
				System.out.println("you are not registered first get registered to available this");
			}
			break;
		case 4:
			Utility.searchPatient();
			break;
		case 5 :
			Utility.bestDoctor();
			break;
		case 6 :
			Utility.doctorPatientList();
			break;
		case 7 :
			Utility.doctorList();
			break;
		case 8:
			Utility.patientList();
			break;
		case 9:
			System.out.println("*****Thanks*****");
			System.exit(0);
		default:
			System.out.println("Invalid choice");
		}
	}
	while(lChoice > 0);	
}
}
