package address.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class AddressBook {
    private ArrayList<AddressEntry> addressEntryList;

    public int addressCount;

    public AddressBook() {
        addressEntryList = new ArrayList<AddressEntry>();
        addressCount = 0;
    }

    public void list() {

        Iterator it = addressEntryList.iterator();
        if (addressCount == 0) {
            System.out.println("Nothing");
        }

        int index = 1;
        while (it.hasNext()) {
            System.out.println(index + ": " + it.next().toString());
            index++;
        }
    }

    public void add(AddressEntry ae) {
        addressEntryList.add(ae);
        addressCount++;
     //   Collections.sort(addressEntryList,AddressEntry.firstNameComp);
    }

    public int getAddressCount() {
        return addressCount;
    }

    public void removal(AddressEntry ae) {
        addressEntryList.remove(ae);
        addressCount--;
    }

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
