public class Student {
    private String EnrollID;
    private String Firstname;
    private String LastName;
    private int Age;

    public Student() {
    }

    public Student(String enrollID, String firstname, String lastName, int age) {
        EnrollID = enrollID;
        Firstname = firstname;
        LastName = lastName;
        Age = age;
    }

    public int getAge() {

        return Age;
    }

    public String getEnrollID() {
        return EnrollID;
    }

    public void setEnrollID(String enrollID) {
        this.EnrollID = enrollID;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public void setAge(int age) {
        this.Age = age;
    }

}
