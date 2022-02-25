package address;
import address.data.AddressBook;
import address.data.AddressEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddressBookApplication {

    public static void main(String[] args) throws FileNotFoundException {

        AddressBook addressBook = new AddressBook();

        boolean quit = false;

        Scanner input = new Scanner(System.in);

        while (!quit) {
            Menu.menuList();

            String temp = input.next();

            char option = Character.toUpperCase(temp.charAt(0));

            switch (option) {
                case 'A': {
                    Menu.loadingFromFile(addressBook, input);
                    break;
                }
                case 'B': {
                    Menu.addition(addressBook, input);
                    break;
                }
                case 'C': {
                    Menu.removal(addressBook, input);
                    break;
                }
                case 'D': {
                    Menu.findEntry(addressBook, input);
                    break;
                }
                case 'E': {
                    Menu.displayList(addressBook);
                    break;
                }
                case 'F': {
                    quit = Menu.exitProgram();
                    break;
                }
                default: {
                    System.out.println("Invalid input");
                }
            }
        }

    }

    public static int init(String fileName, AddressBook ab) throws FileNotFoundException {

        File reading = new File("addressData.txt");
        Scanner sc = new Scanner(reading);

        int readingCounter = 0;

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
            AddressEntry readinEntry = new AddressEntry(firstName, lastName, street, city, state, zip, email, phone);
            ab.add(readinEntry);
            readingCounter++;
        }
        sc.close();
        return readingCounter;
    }
}


/* public class AddressBookApplication {
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

    static void initAddressBookExercise (AddressBook ab){
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
