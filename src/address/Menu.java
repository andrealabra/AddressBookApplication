package address; // we refactor the package to be adress
import address.data.AddressBook; //import AddressBook class
import address.data.AddressEntry; //import AddressEntry class

import java.io.FileNotFoundException; // import no file found
import java.util.Scanner; //import scanner


/**
 * This will print out the main menu of the application
 * interactive so that user can input the description of what they wish to do
 */
public class Menu{ public static void menuList() {
        System.out.println("-----------------------");
        System.out.println("Please enter your menu selection");
        System.out.println("a) Loading From File");
        System.out.println("b) Addition");
        System.out.println("c) Removal");
        System.out.println("d) Finder");
        System.out.println("e) Listing");
        System.out.println("f) Quit");
        System.out.println("------------------------");
        System.out.print('>');
}

    /**
     *
     * @param ab i used an array list - used in addressbook (I also adviced to use a B tree
     *  if i plan to expand on this application, leaving this comment for
     *  my own future reference and possible expasion of this project)
     * @param input scan the file for items that was inputed by user
     * @throws FileNotFoundException When the file is not found or there is an error
     */
    public static void loadingFromFile(AddressBook ab, Scanner input) throws FileNotFoundException {
        System.out.println("Enter in file name:");
        System.out.print('>');
        String fileName = input.next();
        try {
            /**
             * this holds how many address(es) has been read in
             */
            int addressCounter = AddressBookApplication.init(fileName, ab);
            System.out.println("Read in " + addressCounter + " new Address(es), successfully loaded, currently " + ab.getAddressCount());
        } catch (FileNotFoundException e) {
            /**
             * error catching
             */
            System.out.println("There is no file found with the name of: " + fileName);
        }
    }

    /**
     * this is where we start to use the adress entries name,last,ect
     * @param ab array list
     * @param input will look for input from user
     */
    public static void addition(AddressBook ab, Scanner input) {

        AddressEntry newAdd = new AddressEntry(prompt_FirstName(input), prompt_LastName(input),
                prompt_Street(input), prompt_City(input), prompt_State(input), prompt_Zip(input),
                prompt_Telephone(input), prompt_Email(input));

        ab.add(newAdd);
        System.out.println("The following content has been added to your address Book:");
        System.out.println(newAdd.toString());
    }

    /**
     * function will be used to remove the options
     * @param ab
     * @param input
     */
    public static void removal(AddressBook ab, Scanner input) {
        if (ab.getAddressCount() == 0) {
            System.out.println("There are current no items in the Address book");
        } else {
            System.out.println("Enter in the Last Name of contact to remove");
            System.out.print('>');
            String lastName = input.next();
            AddressBook removeOption = new AddressBook();
            for (int i = 0; i < ab.addressCount; i++) {
                if (ab.getAE(i).getLastName().length() >= lastName.length()) {
                    if (ab.getAE(i).getLastName().substring(0, lastName.length()).equals(lastName)) {
                        removeOption.add(ab.getAE(i));
                    }
                }
            }
            if (removeOption.getAddressCount() != 0) {
                System.out.println("The following " + removeOption.getAddressCount() + " entries were found in the address book, select number");
                removeOption.list();
                System.out.print('>');

                String inputCheck = input.next();

                int removeNum;
                if (numCheck(inputCheck)) {
                    removeNum = Integer.parseInt(inputCheck);
                    if (removeNum <= removeOption.getAddressCount()) {
                        removeNum--;
                        System.out.println("Hit 'y' to remove the entry or 'n' to return to main menu: ");
                        System.out.println(removeOption.getAE(removeNum).toString());
                        System.out.print('>');
                        /** user enter confirmation
                         *
                         */
                        char confirmation = Character.toUpperCase(input.next().charAt(0));
                        switch (confirmation) {
                            case 'Y': {
                                ab.removal(removeOption.getAE(removeNum));
                                System.out.println("You removed " + removeOption.getAE(removeNum).getFirstName()
                                        + " " + removeOption.getAE(removeNum).getLastName() + " contact");
                                break;
                            }
                            case 'N': {
                                System.out.println("Request Canceled, return to menu");
                                break;
                            }
                            default: {
                                System.out.println("Invalid input, aborts method and returns to menu");
                            }
                        }
                    } else {
                        System.out.println("Invalid entry try another");
                    }
                } else {
                    System.out.println("Invalid number entry, try another ");
                }
            } else {
                System.out.println("No result");
            }
        }
    }

    /**
     * To find by last name
     * @param ab
     * @param input
     */
    public static void findEntry(AddressBook ab, Scanner input) {
        if (ab.getAddressCount() == 0) {
            System.out.println("There are current no items in the Address book");
        } else {
            System.out.println("Enter in all or beginning of last name you wish to find");
            System.out.print('>');
            /**
             * a string that holds the beginning of name of the entry that user wishes to find
             * */
            String lastName = input.next();
            /**
             * a temporary addressbook array that holds found entires
             * */
            AddressBook foundEntries = new AddressBook();
            for (int i = 0; i < ab.addressCount; i++) {
                if(ab.getAE(i).getLastName().length()>=lastName.length()) {
                    if (ab.getAE(i).getLastName().substring(0, lastName.length()).equals(lastName)) {
                        foundEntries.add(ab.getAE(i));
                    }
                }
            }
            if(foundEntries.getAddressCount() != 0) {
                System.out.println("The following " + foundEntries.getAddressCount()
                        + " entries were found in the address book for a last name starting with: " + lastName);
                foundEntries.list();
            }
            else{
                System.out.println("No Matching Entry Found");
            }
        }
    }

    /**
     * To display the content
     * @param ab
     */
    public static void displayList(AddressBook ab) {
        System.out.println("Address book contains the following  :");
        ab.list();
    }

    /**
     * Lets know you are closing
     * @return
     */
    public static boolean exitProgram() {
        System.out.println("Quitting.");
        return true;
    }

    /**
     *
     * @param input scanning
     * @return string first name
     */
    public static String prompt_FirstName(Scanner input) {
        System.out.println("First Name: ");
        System.out.print('>');
        String firstName = input.next();
        return firstName;
    }

    /**
     *
     * @param input scanning
     * @return string last name
     */
    public static String prompt_LastName(Scanner input) {
        System.out.println("Last Name");
        System.out.print('>');
        String lastName = input.next();
        return lastName;
    }

    /**
     *
     * @param input scanning
     * @return string street
     */
    public static String prompt_Street(Scanner input) {
        System.out.println("Street: ");
        System.out.print('>');
        String street = input.next();
        return street;
    }

    /**
     *
     * @param input city
     * @return string city
     */
    public static String prompt_City(Scanner input) {
        System.out.println("City: ");
        System.out.print('>');
        String city = input.next();
        return city;
    }

    /**
     *
     * @param input state
     * @return string state
     */
    public static String prompt_State(Scanner input) {
        System.out.println("State: ");
        System.out.print('>');
        String state = input.next();
        return state;
    }

    /**
     * Checks that for the zip code it must be an integer and of is not display an
     * error handling message
     * @param input scanning
     * @return integer zip
     */
    public static int prompt_Zip(Scanner input) {
        boolean valid = false;
        String temp;
        int zip = 0;
        System.out.println("Zip: ");
        System.out.print('>');
        while (!valid) {
            temp = input.next();
            valid = numCheck(temp);
            if (valid) {
                zip = Integer.parseInt(temp);
            } else {
                System.out.println("Invalid Zip code Entry, Please try again: ");
                System.out.print('>');
            }
        }

        return zip;
    }

    /**
     * checking for the zip code if it is a a charcter string or integer
     * @param input
     * @return
     */
    public static boolean numCheck(String input) {
        if (input == null) {
            return false;
        }
        try {
            int test = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param input scanning
     * @return string phone number
     */
    public static String prompt_Telephone(Scanner input) {
        System.out.println("Phone: xxx-aaa-bbbb");
        /***
         * format must be the format above(only accounting for United States telephone format)
         */
        System.out.print('>');
        String phone = input.next();
        return phone;
    }

    /**
     *
     * @param input scanning
     * @return string email
     */
    public static String prompt_Email(Scanner input) {
        System.out.println("Email: ");
        System.out.print('>');
        String email = input.next();
        return email;
    }
}
