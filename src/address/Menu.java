package address;
import address.data.AddressBook;
import address.data.AddressEntry;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu{ public static void menuList() {
        System.out.println("-------------------------------------");
        System.out.println("Please enter in your menu selection");
        System.out.println("a) Loading From File");
        System.out.println("b) Add an Entry");
        System.out.println("c) Remove an Entry");
        System.out.println("d) Find an Entry");
        System.out.println("e) Listing all Entry");
        System.out.println("f) Quit");
        System.out.println("-------------------------------------");
        System.out.print('>');
    }

    public static void loadingFromFile(AddressBook ab, Scanner input) throws FileNotFoundException {
        System.out.println("Enter in file name:");
        System.out.print('>');
        String fileName = input.next();
        try {
            //this holds how many address(es) has been read in
            int addressCounter = AddressBookApplication.init(fileName, ab);
            System.out.println("Read in " + addressCounter + " new Address(es), successfully loaded, currently " + ab.getAddressCount());
        } catch (FileNotFoundException e) {
            System.out.println("There is no file found with the name of: " + fileName);
        }
    }
    public static void addition(AddressBook ab, Scanner input) {

        AddressEntry newAdd = new AddressEntry(prompt_FirstName(input), prompt_LastName(input),
                prompt_Street(input), prompt_City(input), prompt_State(input), prompt_Zip(input),
                prompt_Telephone(input), prompt_Email(input));

        ab.add(newAdd);
        System.out.println("The following content has been added to your address Book:");
        System.out.println(newAdd.toString());
    }
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
                        System.out.println("Hit y to remove the following entry or n to return to main menu: ");
                        System.out.println(removeOption.getAE(removeNum).toString());
                        System.out.print('>');
                        /** user enter confirmation
                         *
                         */
                        char confirmation = Character.toUpperCase(input.next().charAt(0));
                        switch (confirmation) {
                            case 'Y': {
                                ab.removal(removeOption.getAE(removeNum));
                                System.out.println("You have successfully removed the " + removeOption.getAE(removeNum).getFirstName() + " " + removeOption.getAE(removeNum).getLastName() + " contact");
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
                        System.out.println("Invalid number entry, abort method back to menu");
                    }
                } else {
                    System.out.println("Invalid number entry, abort method back to menu");
                }
            } else {
                System.out.println("No matching Name Found");
            }
        }
    }

    public static void findEntry(AddressBook ab, Scanner input) {
        if (ab.getAddressCount() == 0) {
            System.out.println("There are current no items in the Address book");
        } else {
            System.out.println("Enter in the beginning of the Last Name (or full) of contact you wish to find");
            System.out.print('>');
            /**a string that holds the beginning of name of the entry that user wishes to find
             * */
            String lastName = input.next();
            /**a temporary addressbook array that holds found entires
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
                System.out.println("The following " + foundEntries.getAddressCount() + " entries were found in the address book for a last name starting with: " + lastName);
                foundEntries.list();
            }
            else{
                System.out.println("No Matching Entry Found");
            }
        }
    }

    public static void displayList(AddressBook ab) {
        System.out.println("Current Address Book contains:");
        ab.list();
    }

    public static boolean exitProgram() {
        System.out.println("GoodBye");
        return true;
    }

    public static String prompt_FirstName(Scanner input) {
        System.out.println("First Name: ");
        System.out.print('>');
        String firstName = input.next();
        return firstName;
    }

    public static String prompt_LastName(Scanner input) {
        System.out.println("Last Name");
        System.out.print('>');
        String lastName = input.next();
        return lastName;
    }
    public static String prompt_Street(Scanner input) {
        System.out.println("Street: ");
        System.out.print('>');
        String street = input.next();
        return street;
    }

    public static String prompt_City(Scanner input) {
        System.out.println("City: ");
        System.out.print('>');
        String city = input.next();
        return city;
    }
    public static String prompt_State(Scanner input) {
        System.out.println("State: ");
        System.out.print('>');
        String state = input.next();
        return state;
    }
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

    public static String prompt_Telephone(Scanner input) {
        System.out.println("Phone: xxx-aaa-bbbb");
        System.out.print('>');
        String phone = input.next();
        return phone;
    }

    public static String prompt_Email(Scanner input) {
        System.out.println("Email: ");
        System.out.print('>');
        String email = input.next();
        return email;
    }
}
