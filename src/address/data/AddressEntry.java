package address.data; //will refactor package to be named address and it will be under data

/**
 * Below we have the public class that hold the objects
 */
public class AddressEntry {

    /**
     * will hold value for first name entry
     */
    private String firstName;

    /**
     * will hold value for last name entry
     */
    private String lastName;

    /**
     * will hold value for street entry
     */
    private String street;

    /**
     * will hold value for city entry
     */
    private String city;

    /**
     * will hold value for state entry
     */
    private String state;

    /**
     * will hold value integet value for zip entry
     */
    private int zip;

    /**
     * will hold value for phone number entry
     */
    private String phone;

    /**
     * will hold value for email entry
     */
    private String email;


    /**
     * Constructor that will initialize all entries below
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
     * This is a different constrctor but for the new values entries
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


    /**
     *
     * @return String vales
     */
    public String toString(){
        return firstName + " " + lastName + " " + "\n" +
                street + "\n" + city + ", " +
                state + " " + zip + "\n" + email
                + " \n" + phone + "\n\n";
    }

    //Setters

    /**
     * Set new first name
     * @param firstName
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;

    }

    /**
     * Set new last name
     * @param lastName
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Set new street
     * @param street
     */
    public void setStreet(String street){
        this.street = street;
    }

    /**
     * Set new city
     * @param city
     */
    public void setCity(String city){
        this.city = city;
    }

    /**
     * Set new state
     * @param state
     */
    public void setState(String state){
        this.state = state;
    }

    /**
     * Set new integer zip code
     * @param zip
     */
    public void setZip(int zip){
        this.zip = zip;
    }

    /**
     * Set new phone number
     * @param phone
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * Set new email
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }


    //getters

    /**
     * Gets first name
     * @return
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Gets last name
     * @return
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Gets street
     * @return
     */
    public String getStreet(){
        return street;
    }

    /**
     * Gets city
     * @return
     */
    public String getCity(){
        return city;
    }

    /**
     * Gets state
     * @return
     */
    public String getState(){
        return state;
    }

    /**
     * Gets integer zip code
     * @return
     */
    public int getZip(){
        return zip;
    }

    /**
     * Gets phone number
     * @return
     */
    public String getPhone(){
        return phone;
    }

    /**
     * Gets email
     * @return
     */
    public String getEmail(){
        return email;
    }
}
