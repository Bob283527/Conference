public class Main {
	
	public static void main (String[] args) {
		
        Conference conf = new Conference(20, 10, 0, "Default");

        try {
            conf.loadData();   //load attendees from file
        } 
        catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
            return;
        }

        //let user add attendees if less than 100
        conf.fillTo100();

        //seat everybody
        conf.seatPlacement();
	}
}

