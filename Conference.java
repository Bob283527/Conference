import java.io.*;
import java.util.*;

public class Conference {
	//add scanner for registratin input later
	Scanner registerScan = new Scanner(System.in);
	//add private cars for later use, keeping track of the comapny stuff and tables
	private int numTables;
	private int numCompanies;
    private int companiesNumber;
    private String companiesName;

	//attendee has 150 bc may be more in file, only 100 in
	private Attendee[] attendeeArray = new Attendee[150];

	//company seat counter
	//companySeats[c][t], chekc idf company c(20 diff companies allowed) is alrdy at table t
	private int[][] companySeats = new int[20][10];
	//initialize the vars
	public Conference(int nC, int nT, int cNum, String cName) {
        numCompanies = nC;
        numTables = nT;
        companiesNumber = cNum;
        companiesName = cName;
    }
	//getters for toString
    public int getnumCompanies() {
        return numCompanies;
    }

    public int getnumTables() {
        return numTables;
    }

    public int getcompaniesNumber() {
        return companiesNumber;
    }

    public String getcompaniesName() {
        return companiesName;
    }

	//scans the file and loads the data into the memory will have less attendees on the file than what i put in tge array
	//because of registration later so I will have to insert the new people into the file
	//then we can randomize who gets in as the limit is 100, so pre-registered will always be first to get in
	//then randomly choose the other last few people who registered
	//loads both files

	//loads data from file
	private void loadData() throws IOException {
		
        File file = new File("confGuests.txt");
        Scanner scan = new Scanner(file);
        
        if (scan.hasNext()) {
            scan.nextLine();
        }

	//loops through file and attendees and assigns which part of the array indicates what
		int i = 0;
		while (scan.hasNext() && i < attendeeArray.length) {
			//reads entire line 
			String line = scan.nextLine();
			//comma split
			String[] parts = line.split(",");
			
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
		
		//checks for only 100 ppl
		if(i > 100) {
            System.out.println("Keeping only first 100.");
		}
	}
	//Need to make a method or two to place them into their seats now
	//since i have the attendees and their information I can probably randomize them and make sure the cN is not equal to eachother
	//make 5 tables maybe?
	//10 people per table make sure their cN isnt the same and that they arent the same person
	
	//ask user if they want to add if less than 100 ppl
	private void fillTo100() {
        int count = countAttendees();

        while (count < 100) {

            System.out.println("currently " + count + " attendees.");
            System.out.println("want to add another attendee? (yes or no)");

            String ans = registerScan.nextLine();
		//makes sures that anyrthing other than yes will not be accepted
            if (!ans.equals("yes")) {
                break;
            }

            System.out.println("Enter last name:");
            String nL = registerScan.nextLine();

            System.out.println("Enter first name:");
            String nF = registerScan.nextLine();

            System.out.println("Enter company number:");
            int cN = Integer.valueOf(registerScan.nextLine());

            System.out.println("Enter list number:");
            int lN = Integer.valueOf(registerScan.nextLine());

            attendeeArray[count] = new Attendee(nL, nF, cN, lN);
            count++;
        }
    }
    //counts amy of valid attendees currently ie nothing has empty things or incomplete info
	private int countAttendees() {
        int count = 0;
        while (count < attendeeArray.length && attendeeArray[count] != null) {
            count++;
        }
        return count;
    }
	//seay placement is like 10 tables w 10 seats 
	public seatPlacement() {
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
}
	
    

