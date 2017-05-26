package DoublyLinkedList;

import java.util.ArrayList;

public class Patient 
{
	public String FirstNameField;
	public String LastNameField;
	public String AgeField;
	public String GenderField;
	public String MobileNumberField;
	public String AddressField;
	public String SymptomsField;
	public int PriorityField;
	public String TreatmentField;
	
	//Making ArrayList of the information contained within fields of Patient class.
	public ArrayList<String> giveInfoAsArrayList()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add(FirstNameField);
		list.add(LastNameField);
		list.add(AgeField);
		list.add(GenderField);
		list.add(MobileNumberField);
		list.add(AddressField);
		list.add(SymptomsField);
		list.add(Integer.toString(PriorityField));
		list.add(TreatmentField);
		return list;
	}
	
	//Blank patient to fix bugs
	public Patient()
	{
	}
	
	//Takes line from CSV file, turns it into a Patient
	public Patient(String csvLine)
	{
		String names[] = csvLine.split(",");
		this.FirstNameField = names[0];
		this.LastNameField = names[1];
		this.AgeField = names[2];
		this.GenderField = names[3];
		this.MobileNumberField = names[4];
		this.AddressField = names[5];
		this.SymptomsField = names[6];
		this.PriorityField = Integer.parseInt(names[7]);
		this.TreatmentField = names[8];
	}
	
	//Takes arguments one by one
	public Patient(String FirstName, String LastName, String Age, String Gender, String MobileNumber,
			String Address, String Symptoms)
	{
		this.FirstNameField = FirstName;
		this.LastNameField = LastName;
		this.AgeField = Age;
		this.MobileNumberField = MobileNumber;
		this.GenderField = Gender;
		this.AddressField = Address;
		this.SymptomsField = Symptoms;
		this.PriorityField = 0;
		this.TreatmentField = "null";
	}
}
