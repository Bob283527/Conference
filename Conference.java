import java.io.*;
import java.util.*;

public class Conference {
	//add scanner for registratin input later
	Scanner registerScan = new Scanner(System.in);
	//add private cars for later use
	private int numTables;
	//initialize the vars
	public Conference(int nC, int nT) {
		numTables = nT;
		numCompanies = nC;
	}  
	    // Add any getters and toString methods that you need
	
	public String getnumCompanies() {
		return companyNum;
	}
	public int getnumTables() {
		return numTables; 
	}
	//scans the file and loads the data into the memory will have less attendees on the file than what i put in tge array
	//because of registration later so I will have to insert the new people into the file
	//then we can randomize who gets in as the limit is 100, so pre-registered will always be first to get in
	//then randomly choose the other last few people who registered
	//loads both files
	private Attendee[] attendeeArray = new Attendee[150];
	private Companies companiesArray[] = new Companies[20];

	private void loadData() throws IOException {
        File file = new File("confGuests.txt");
        File fileC = new File("companies.txt");
        
        Scanner scan = new Scanner(file);
        Scanner scan = new Scanner(fileC);
        
        if (scan.hasNext()) {
            scan.nextLine();
        }
	//loops through file and attendees and assigns which part of the array indicates what
		int i = 0;
		while (scan.hasNext() && i < attendeeArray.length) {
			//splits the information into parts 
			String line = scan.nextLine();
			String[] parts = line.split(",");
			int[] parts2 = line.split(",");
			
			int lN = parts[0];
			int cN = parts[3];

			String nL = parts[1];
			String nF = parts[2];  
		      //creates a new Attendee with the information inside of it
			attendeeArray[i] = new Attendee(lN, nL, nF, cN);
			i++;
		}
		//debugging purposes
		scan.close();
		System.out.println(i + "Attendees loaded");
	}
	//Need to make a method or two to place them into their seats now
	//since i have the attendees and their information I can probably randomize them and make sure the cN is not equal to eachother
	//make 5 tables maybe?
	//10 people per table make sure their cN isnt the same and that they arent the same person
	public seatPlacement() {

}
	
    

