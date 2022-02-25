package address.data; //will refactor package to be named address and it will be under data

/**
 * Below we have the public class that hold the objects
 */
public class AddressEntry {

    /**
     * will hold value for first name
     */
    private String firstName;

    /**
     * will hold value for last name
     */
    private String lastName;

    /**
     * will hold value for street
     */
    private String street;

    /**
     * will hold value for city
     */
    private String city;

    /**
     * will hold value for state
     */
    private String state;

    /**
     * will hold value integet value for zip
     */
    private int zip;

    /**
     * will hold value for phone number
     */
    private String phone;

    /**
     * will hold value for email
     */
    private String email;


    /**
     *
     */
    public AddressEntry(){
        firstName = " ";
        lastName = " ";
        street = " ";
        city = " ";
        state = " ";
        zip = 0;
        phone = " ";
        email = " ";
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param street
     * @param city
     * @param state
     * @param zip
     * @param phone
     * @param email
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, int zip, String phone, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email =email;
    }

    public String toString(){
        return firstName + " " + lastName + " " + "\n" +
                street + "\n" + city + ", " +
                state + " " + zip + "\n" + email
                + " \n" + phone + "\n\n";
    }

    //Setters
    public void setFirstName(String firstName){
        this.firstName = firstName;

    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setZip(int zip){
        this.zip = zip;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setEmail(String email){
        this.email = email;
    }


    //getters
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getStreet(){
        return street;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public int getZip(){
        return zip;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }
}
