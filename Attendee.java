public class Attendee {
    //to hold info for each person

    private String listNum;
    private String nameLast;
    private String nameFirst;
    private String companyNum;

    //constructor for info from file or input and load into the object
    public Attendee(String lN, String nL, String nF, String cN) {
        listNum = lN
        nameLast = nL
        nameFirst = nF
        companyNum = cN
    }

    //getters for info later
    public String getnameFirst() {
        return nameFirst
    }

    public String getnameLast() {
        return nameLast
    }

    public String getcompanyNum() {
        return companyNum
    }

    public String getlistNum() {
        return listNum
    }
}
