package DoublyLinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


//Contains logic for storing patient information into files.
public class PatientDatabase {
	
	private String FileLocation;

	
	public PatientDatabase(String Location){
		this.FileLocation = Location;
	} 
	
	//Converts file information to DoublyLinkedList
	public DoublyLinkedList FileToDoublyLinkedList(String Location) 
	{
		//Reads file line by line, turns each line into a data node in the list.
		DoublyLinkedList dll = new DoublyLinkedList();
		try {
			BufferedReader br = new BufferedReader(new FileReader(Location));
			String thisLine;
			//Skips header as it is a csv file
			boolean readHeader = false;
			while ((thisLine = br.readLine()) != null)
			{
				if (readHeader)
				{
					dll.addFront(new Patient(thisLine));
				}
				readHeader = true;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return dll;
	}
	
	//Opposite of the above: converts DoublyLinkedList back to file.
	public void DoublyLinkedListToFile(String Location, DoublyLinkedList list)
	{
		int listSize = list.size();
		try
		{
		for (int i = 0; i < listSize; i++)
		{	//grabs last patient, returns it, removes it from the list
			write(list.GetLastPatient().giveInfoAsArrayList(), Location);
		} 
			System.out.println("Patient has been stored.");
		} 
		catch (Exception e) 
		{
		e.printStackTrace();
		}
	}
	
	//Main writer for the files
	public void write(ArrayList<String> list)
	{
		try
		{
		
		FileWriter writer = new FileWriter(FileLocation, true);
		BufferedWriter bwriter = new BufferedWriter(writer);
		BufferedReader br = new BufferedReader(new FileReader(FileLocation));  
		String line;
	
		//Converts ArrayList into a line in the file.
		if ((line = br.readLine()) == null || line.isEmpty())
			{
			bwriter.write("First Name, Last Name, Age, Mobile Number, Gender, Address, Symptoms, Priority, Treatment \n");   
			}	br.close();
		for (int i = 0; i < list.size() -1; i++)
			{
			bwriter.write(list.get(i) + ",");
			} 
			bwriter.write(list.get(list.size() -1)); 
			bwriter.write("\r\n");
			
			System.out.println("Patient has been stored.");
		
			
		bwriter.close();
		writer.close();
		
		
		} catch (Exception e) 
		{
		e.printStackTrace();
		}
	}
	//Writer similar to above but with different location
	public void write(ArrayList<String> list, String Location)
	{
		try
		{
		FileWriter writer = new FileWriter(Location, false);
		BufferedWriter bwriter = new BufferedWriter(writer);  
		bwriter.write("First Name, Last Name, Age, Mobile Number, Gender, Address, Symptoms, Priority, Treatment \r\n");   
		
		//Converts ArrayList into a line in the file.
		for (int i = 0; i < list.size() -1; i++)
			{
			bwriter.write(list.get(i) + "," );
			} 
			bwriter.write(list.get(list.size() -1));
			bwriter.write("\r\n");
			
			System.out.println("Patient has been stored.");
		
			
		bwriter.close();
		writer.close();
		
		
		} catch (Exception e) 
		{
		e.printStackTrace();
		}
	}
}

