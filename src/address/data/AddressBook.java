package address.data; //we refactor the package to be named address and this class is under data

import java.util.ArrayList; //importing array list to have
import java.util.Iterator; //import java iterator

/**
 * This class will add entries to list
 */
public class AddressBook {
    /**
     * variables are stored in this array
     */
    private ArrayList<AddressEntry> addressEntryList;

    /**
     * public adress count that keeps track, used in adressbook application
     */
    public int addressCount;

    /**
     * Constructor for address book
     */
    public AddressBook() {
        addressEntryList = new ArrayList<AddressEntry>();
        addressCount = 0;
    }

    /**
     * This iterator will go through the whole data and display
     */
    public void list() {

        Iterator it = addressEntryList.iterator();
        if (addressCount == 0) {
            System.out.println("Nothing found");
        }

        /**
         * This variable integer call index will keep count of hwere the entry is located
         */
        int index = 1;
        while (it.hasNext()) {
            System.out.println(index + ": " + it.next().toString());
            index++;
        }
    }

    /**
     * This will add a new entry to the entry list
     * @param ae
     */
    public void add(AddressEntry ae) {
        addressEntryList.add(ae);
        addressCount++;
    }

    /**
     * Return new entry
     * @return
     */
    public int getAddressCount() {
        return addressCount;
    }

    /**
     * This will remove a certain entry
     * @param ae
     */
    public void removal(AddressEntry ae) {
        addressEntryList.remove(ae);
        addressCount--;
    }

    /**
     * Returns entry to index
     * @param index
     * @return
     */
    public AddressEntry getAE(int index) {
        return addressEntryList.get(index);
    }
}

/* public class AddressBook {

    private ArrayList<AddressEntry> addressEntryList = new ArrayList <>();

    public void list(){

        for (int i =0; i< addressEntryList.size(); i++){
            System.out.println(addressEntryList.get(i));
        }

    }

    public void add(AddressEntry newEntry){

        //add the newEntry to the addressEntryList
        addressEntryList.add(newEntry);

    }

} */
