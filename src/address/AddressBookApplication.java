package address; // Package was refactor to be called address
import address.data.AddressBook; //need to import address book class
import address.data.AddressEntry; //need to import address entry class

import java.io.File; //to open file
import java.io.FileNotFoundException; //to say that there is no file
import java.util.Scanner; //


public class AddressBookApplication {
    /**
     * This function contains all of the interactive options for the menu
     * @param args
     * @throws FileNotFoundException
     */

    public static void main(String[] args) throws FileNotFoundException {
        /**
         * have an empty array
         */

        AddressBook addressBook = new AddressBook();
        /**
         * bool to see not allow loop to exit
         */

        boolean quit = false;
        /**
         * To read the user option input
         */

        Scanner input = new Scanner(System.in);
        /**
         * A while loop, while is not in quit mode have the follwoing options
         */

        while (!quit) {
            Menu.menuList();
            /**
             * Stores input but just tempotarly
             */

            String temp = input.next();
            /**
             * Variable char for case A-F, allows user to put capital A-F and navigate through options
             */

            char option = Character.toUpperCase(temp.charAt(0));

            switch (option) {
                case 'A': {
                    Menu.loadingFromFile(addressBook, input);
                    break;
                }
                /**
                 * option to load a file
                 */
                case 'B': {
                    Menu.addition(addressBook, input);
                    break;
                }
                /**
                 * option to add a entry
                 */
                case 'C': {
                    Menu.removal(addressBook, input);
                    break;
                }
                /**
                 * option to remove entry
                 */
                case 'D': {
                    Menu.findEntry(addressBook, input);
                    break;
                }
                /**
                 * option to find entry from file
                 */
                case 'E': {
                    Menu.displayList(addressBook);
                    break;
                }
                /**
                 * options to show all entries from the file
                 */
                case 'F': {
                    quit = Menu.exitProgram();
                    break;
                }
                /**
                 * to exit out
                 */
                default: {
                    System.out.println("Invalid input");
                    /**
                     * incase the info input is incorrect - case handling
                     */
                }
            }
        }

    }


    /**
     * Iniialize objects
     * @param fileName
     * @param ab
     * @return - entries
     * @throws FileNotFoundException error handeling for no file
     */
    public static int init(String fileName, AddressBook ab) throws FileNotFoundException {

        /**
         * Open the file, named mine addressData from professor
         * website, created text file under addressbook application
         * files, will later read the file and we have a variable
         * integer named countData to keep up with the address entries
         * found and will be initialized to 0
         */
        File reading = new File("addressData.txt");
        Scanner sc = new Scanner(reading);
        int countData = 0;

        /**
         * While loop that will perform as follows, if the file has been
         * opened correctly, all of the data that is inside will
         * be read in the order below. But string for all other expect
         * for zip code that will be an integer variable. And our counter
         * countData will keep up with the count and keep track. File will close and counter will
         * return
         */
        while (sc.hasNextLine()) {
            String firstName, lastName, street, city, state, phone, email;
            int zip;
            firstName = sc.nextLine();
            lastName = sc.nextLine();
            street = sc.nextLine();
            city = sc.nextLine();
            state = sc.nextLine();
            zip = Integer.parseInt(sc.nextLine());
            email = sc.nextLine();
            phone = sc.nextLine();
            AddressEntry readinEntry = new AddressEntry(firstName, lastName,
                    street, city, state,
                    zip, email, phone);
            ab.add(readinEntry);
            countData++;
        }
        sc.close();
        return countData;
    }
}


/* some of the first code I did, will keep here for my own learning of java
public class AddressBookApplication {
 */
   /* static AddressBook add = new AddressBook();

    print static void main(String[] args){
        init("entries.txt");
        ab.list();
    }

    public static void init(String filename){
        try{
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            //counter number of entries processed
            int count = 0;
            //local variables
            String fn, ln, street, city, state, email, phone;
            int zip;
            //read form file
            while((line = br.readLine()) != null){
                fn = line;
                ln = br.readLine();
                street = br.readLine();
                city = br.readLine();
                state = br.readLine();
                zip = Integer.parseInt(br.readLine());
                email = br.readLine();
                phone = br.readLine();
                ab.add(new AddressEntry(fn, ln, street, city, state, zip, email, phone));
                count ++;
            }
            System.out.println("\nProcessed" + count + "New Address Entries");
        }
        catch (FileNotFoundException e){
            //print out message for file not found
            System.out.println(e.getMessage());
        }
        catch(IOException ex){
            //print out stack for other exceptions
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        initAddressBookExercise(addressBook);
    }

    static void initAddressBookExercise (AddressBook ab){ // me and my moms entry info
        AddressEntry newAddressEntry = new AddressEntry("Andrea", "Labra Orozco", "20420 Almeda",
                "Castro Valley", "CA", 94546, "5108991771", "andrealabra21@gmail.com");
        AddressEntry newAddEntry = new AddressEntry("Alejandra", "Labra Orozco", "20420 Almeda",
                "Castro Valley", "CA", 94546, "9258178906", "alalabra21@gmail.com");


        //add the AddressEntry objects to the AddressBook's addressEntryList
        ab.add(newAddressEntry);
        ab.add(newAddEntry);

        //print the address book
        ab.list();

    }

} */
