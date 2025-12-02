public class Attendee {
	//to hold info for each person

	//priv vars
    private String nameLast;
    private String nameFirst;
    
    
    private int companyNum;
    private int listNum;

//constructor for info from file or the input and load into thh object
    public Attendee(String nL, String nF, int cN, int lN) {
        nameLast = nL;
        nameFirst = nF;
        companyNum = cN;
        listNum = lN;
    }
//getters for info later
    public String getnameFirst() {
        return nameFirst;
    }

    public String getnameLast() {
        return nameLast;
    }

    public int getcompanyNum() {
        return companyNum;
    }

    public int getlistNum() {
        return listNum;
    }

}
