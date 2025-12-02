import java.io*
import java.util*

public class Conference {
    //add scanner for registratin input later
    Scanner registerScan = new Scanner(System.in)
    //add private cars for later use, keeping track of the comapny stuff and tables
    private int numTables
    private int numCompanies
    private int companiesNumber
    private String companiesName

    //attendee has 150 bc may be more in file, only 100 in
    private Attendee[] attendeeArray = new Attendee[150]

    //company seat counter
    //companySeats[c][t], chekc idf company c(20 diff companies allowed) is alrdy at table t
    private int[][] companySeats = new int[20][10]

    //initialize the vars
    public Conference(int nC, int nT, int cNum, String cName) {
        numCompanies = nC
        numTables = nT
        companiesNumber = cNum
        companiesName = cName
    }

    //getters for toString
    public int getnumCompanies() {
        return numCompanies
    }

    public int getnumTables() {
        return numTables
    }

    public int getcompaniesNumber() {
        return companiesNumber
    }

    public String getcompaniesName() {
        return companiesName
    }

    //scans the file and loads the data into the memory will have less attendees on the file than what i put in tge array
    //because of registration later so I will have to insert the new people into the file
    //then we can randomize who gets in as the limit is 100, so pre-registered will always be first to get in
    //then randomly choose the other last few people who registered
    //loads both files

    //loads data from file
    private void loadData() throws IOException {

        File file = new File("confGuests.txt")
        Scanner scan = new Scanner(file)

        if (scan.hasNext()) {
            scan.nextLine()
        }

        //loops through file and attendees and assigns which part of the array indicates what
        int i = 0
        while (scan.hasNext() && i < attendeeArray.length) {
            //reads entire line 
            String line = scan.nextLine()
            //comma split
            String[] parts = line.split(",")

            String lN = parts[0]     // list number stays as String
            String nL = parts[1]     // last name
            String nF = parts[2]     // first name
            String cN = parts[3]     // company number stays as String

            //creates a new Attendee with the information inside of it
            attendeeArray[i] = new Attendee(lN, nL, nF, cN)
            i++
        }

        //debugging purposes
        scan.close()
        System.out.println(i + " Attendees loaded")

        //checks for only 100 ppl
        if (i > 100) {
            System.out.println("Keeping only first 100")
        }
    }

    //Need to make a method or two to place them into their seats now
    //since i have the attendees and their information I can probably randomize them and make sure the cN is not equal to eachother
    //make 5 tables maybe
    //10 people per table make sure their cN isnt the same and that they arent the same person

    //ask user if they want to add if less than 100 ppl
    private void fillTo100() {
        int count = countAttendees()

        while (count < 100) {

            System.out.println("currently " + count + " attendees")
            System.out.println("want to add another attendee yes or no")

            String ans = registerScan.nextLine()
            //makes sures that anyrthing other than yes will not be accepted
            if (!ans.equals("yes")) {
                break
            }

            System.out.println("Enter last name")
            String nL = registerScan.nextLine()

            System.out.println("Enter first name")
            String nF = registerScan.nextLine()

            System.out.println("Enter company number")
            String cN = registerScan.nextLine()

            System.out.println("Enter list number")
            String lN = registerScan.nextLine()

            attendeeArray[count] = new Attendee(lN, nL, nF, cN)
            count++
        }
    }

    //counts amy of valid attendees currently ie nothing has empty things or incomplete info
    private int countAttendees() {
        int count = 0
        while (count < attendeeArray.length && attendeeArray[count] != null) {
            count++
        }
        return count
    }

    //seay placement is like 10 tables w 10 seats
    //2d seating chary
    //each element hold 1 attendee or is null if empty 
    public void seatPlacement() {

        //10 tables w 10 seats
        Attendee[][] seating = new Attendee[10][10]

        //gets the amt of attendees that was pulled oin
        int total = countAttendees()

        //in case theres more than 100 ppl
        if (total > 100) {
            System.out.println("too msny ppl remv0ving ppl after 100")
            total = 100
        }

        System.out.println("Seating " + total + " people")

        //loop through each attendee
        //1 by 1 place each attendee at a valid table
        //valid = empty sear and no same company in table
        for (int i = 0; i < total; i++) {

            Attendee a = attendeeArray[i]
			//bruh found this too late https://www.w3schools.com/jsref/jsref_parseint.asp
            int comp = Integer.parseInt(a.getcompanyNum())

            boolean seated = false //if found chair then turn into true for now we assume it is all false

            //try tables 0-9
            for (int t = 0; t < 10 && !seated; t++) {

                //check if company is already seated at this table
                //skip this table then try next if it
                if (companySeats[comp][t] == 0) {

                    //only run seating scan if company NOT already seated at this table
                    for (int s = 0; s < 10 && !seated; s++) {

                        if (seating[t][s] == null) {

                            //seats attendee
                            seating[t][s] = a

                            //states that this company is at thi stable now          
                            companySeats[comp][t] = 1

                            //stops the search
                            seated = true
                        }
                    }
                }
            }

            if (!seated) {
                System.out.println("couldnt seat " + a.getnameFirst() + " " + a.getnameLast() + " because company " + comp + " already full at all tables")
            }
        }

        //print out seating chart
        //loops through the 10 tables
        for (int t = 0; t < 10; t++) {

            //shows what table is being printed
            System.out.println("table " + (t + 1))

            //loops through the 10 seats in the table
            for (int s = 0; s < 10; s++) {

                //grab attendee in this seat
                //if not assigned then null
                Attendee a = seating[t][s]

                //tell user is seat is empty
                if (a == null) {
                    System.out.println("Seat " + (s + 1) + " is empty")
                }

                //if somneone in seat print all info
                else {
                    System.out.println("Seat " + (s + 1) + " " + a.getnameFirst() + " " + a.getnameLast() + " Company " + a.getcompanyNum())
                }
            }
        }
    }
}

