import java.util.Scanner;                                                               //importing the packages
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class Theatre {
    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre");                                   //displaying welcome message Part A - Task 1)

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();                                //array list

        int[] row1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};                                  //Adding 3 arrays for each row
        int[] row2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] row3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


        boolean start = true;
        while (start) {                                                                     //creating while loop
            System.out.println("---------------------------------------------------");      //Adding a menu in main method Part A - Task 2)
            System.out.println("Please select an option: ");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("     0) Quit");
            System.out.println("---------------------------------------------------");
            try {                                                                           //try catch block for get valid integer input
                Scanner input = new Scanner(System.in);                                     //creating a scanner
                System.out.print("Enter option: ");
                int option = input.nextInt();
                switch (option) {                                                           //using switch statement
                    case 0:
                        System.out.println("Thank you for using the Theatre program.");     //display thank you message for using this program
                        start = false;
                        break;
                    case 1:                                                                 //for Part A - Task 3)
                        buy_ticket(row1, row2, row3, tickets);                              //method call for buy_ticket
                        break;
                    case 2:                                                                 //for Part A - Task 4)
                        System.out.println("       ***********");
                        System.out.println("       *  STAGE  *");
                        System.out.println("       ***********");
                        print_seating_area(row1);                                            //method call for print_seating_area
                        print_seating_area(row2);
                        print_seating_area(row3);
                        System.out.print("Please press Enter button to back to menu ");      //asking user to press enter button to back to menu
                        System.in.read();
                        break;
                    case 3:                                                                  //for Part A - Task 5)
                        cancel_ticket(row1, row2, row3, tickets);                            //method call for cancel_ticket
                        break;
                    case 4:                                                                  //for Part A - Task 6)
                        show_available(row1, 1);                                     //method call for show_available
                        show_available(row2, 2);
                        show_available(row3, 3);
                        System.out.print("Please press Enter button to back to menu ");
                        System.in.read();
                        break;
                    case 5:                                                                  //for Part A - Task 7)
                        try {
                            FileWriter file = new FileWriter("Seats.txt");           //open and write to the file
                        } catch (IOException e) {
                            System.out.println("File not created");
                        }
                        save(row1);                                                          //method call for save
                        save(row2);
                        save(row3);
                        System.out.println("Successfully saved to the file.");
                        System.out.print("Please press Enter button to back to menu ");
                        System.in.read();
                        break;
                    case 6:                                                                  //for Part A - Task 8)
                        load(row1, row2, row3);                                              //method call for load
                        System.out.print("Please press Enter button to back to menu ");
                        System.in.read();
                        break;
                    case 7:                                                                   //for Part B - Task 13)
                        show_tickets_info(tickets);                                           //method call for show_tickets_info
                        System.out.print("Please press Enter button to back to menu ");
                        System.in.read();
                        break;
                    case 8:                                                                   //for Part B - Task 14)
                        sort_tickets(tickets);                                                //method call for sort_tickets
                        show_tickets_info(tickets);                                           //method call for print the sorted information
                        System.out.print("Please press Enter button to back to menu ");
                        System.in.read();
                        break;
                    default:
                        System.out.println("Invalid option selected. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");                     //proper message display for invalid input
            }
        }
    }


    //Part A - Task 3)

    /**
     * Getting the inputs and check the conditions for buy tickets
     * @param row01 the row 1 array in theatre
     * @param row02 the row 2 array in theatre
     * @param row03 the row 3 array in theatre
     * @param information the Array list
     */
    public static void buy_ticket(int[] row01, int[] row02, int[] row03, ArrayList information) {
        boolean x = true;
        while (x) {
            try {                                                                                                  //using try catch block
                Scanner input = new Scanner(System.in);

                System.out.print("Enter your name: ");                                                             //name input Part B - Task 12)
                String name = input.next();                                                                        //storing user entered nane

                System.out.print("Enter your surname: ");                                                          //surname input Part B - Task 12)
                String surname = input.next();                                                                     //storing user entered surname

                System.out.print("Enter your email: ");                                                            //email input Part B - Task 12)
                String email = input.next();                                                                       //storing user entered email

                System.out.print("Enter the Row number(1-3): ");                                                   //row number input
                int row = input.nextInt();                                                                         //storing user entered row number into row variable

                if (row < 1 || row > 3) {                                                                         //condition for proper row input
                    System.out.println("This row number does not exist. Please select 1-3. Try again");           //proper message display for invalid input
                    continue;
                }

                System.out.print("Enter the Seat number: ");                                                       //seat number input
                int seat = input.nextInt();                                                                        //storing user entered seat number into seat variable

                int price = 0;                                                                                     //Initializing price to 0

                if (row == 1) {                                                                                    //condition for row 1
                    if (seat >= 1 && seat <= 12) {                                                                 //condition for seat
                        if (row01[seat - 1] == 1) {
                            System.out.println("Seat already booked.Try again with the menu");
                            break;

                        } else {
                            row01[seat - 1] = 1;
                            System.out.println("Your seat successfully booked.");
                            price = 10;                                                                             //assigning the price for row 1 as 10£
                        }
                    } else {
                        System.out.println("Invalid seat number.Try again with the menu");
                        break;
                    }

                } else if (row == 2) {                                                                              //condition for row 2
                    if (seat >= 1 && seat <= 16) {                                                                  //condition for seat
                        if (row02[seat - 1] == 1) {
                            System.out.println("Seat already booked.Try again with the menu");
                            break;

                        } else {
                            row02[seat - 1] = 1;
                            System.out.println("Your seat successfully booked.");
                            price = 20;                                                                             //assigning the price for row 2 as 20£
                        }
                    } else {
                        System.out.println("Invalid seat number.Try again with the menu");
                        break;
                    }

                } else if (row == 3) {                                                                              //condition for row 3
                    if (seat >= 1 && seat <= 20) {                                                                  //condition for seat
                        if (row03[seat - 1] == 1) {
                            System.out.println("Seat already booked.Try again with the menu");
                            break;

                        } else {
                            row03[seat - 1] = 1;
                            System.out.println("Your seat successfully booked.");
                            price = 30;                                                                           //assigning the price for row 3 as 30£
                        }
                    } else {
                        System.out.println("Invalid seat number.Try again with the menu");
                        break;
                    }

                } else {
                    System.out.println("Invalid input. Please try again");                          //proper message display for invalid input
                    break;
                }

                Person details = new Person(name, surname, email);                                  //Extending buy_ticket method for Part B - Task 12) creating object for Person class
                Ticket ticket = new Ticket(details, row, seat, price);                              //creating object for ticket class
                information.add(ticket);                                                            //adding object to array list


                System.out.print("Do you want to book another seat (yes/no): ");                    //get an input to continue or back to menu
                String ask1 = input.next();
                String lower_case1 = ask1.toLowerCase();                                            //converting to lower case letters

                if (lower_case1.equals("yes")) {
                    continue;
                } else if (lower_case1.equals("no")) {
                    break;
                } else {
                    System.out.println("Invalid input. Try again");
                    break;
                }

            } catch (Exception e) {
                System.out.println("Invalid Input. Please try again");                              //proper message display for invalid input
                continue;
            }
        }
    }

    //Part A - Task 4)

    /**
     * Print out the seating area
     * @param array_name the theatre row array
     */
    public static void print_seating_area(int[] array_name) {
        if (array_name.length == 12) {                                              //conditions for alignments
            System.out.print("      ");
        } else if (array_name.length == 16) {
            System.out.print("    ");
        } else {
            System.out.print("  ");
        }

        for (int i = 0; i < array_name.length; i++) {                               //using for loop. variable i for index within the array
            if (array_name[i] == 1) {
                System.out.print("X");
            } else {
                System.out.print("O");
            }
            if ((i + 1) == array_name.length / 2) {                                 //condition for middle space
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    //Part A - Task 5)

    /**
     * Getting the inputs and check the conditions for cancel tickets
     * @param row01 the row 1 array in theatre
     * @param row02 the row 2 array in theatre
     * @param row03 the row 3 array in theatre
     * @param ticket the Array list
     */
    public static void cancel_ticket(int[] row01, int[] row02, int[] row03, ArrayList<Ticket> ticket) {
        boolean y = true;
        while (y) {
            try {                                                                                           //using try catch block
                Scanner input = new Scanner(System.in);

                System.out.print("Enter the row number(1-3): ");                                           //row number input
                int row = input.nextInt();

                if (row < 1 || row > 3) {                                                                  //condition for proper row input
                    System.out.println("This row number does not exist. Please select 1-3.");              //proper message display for invalid input
                    continue;
                }

                System.out.print("Enter the seat number: ");                                               //seat number input
                int seat = input.nextInt();

                if (row == 1) {                                                                           //condition for row 1
                    if (seat >= 1 && seat <= 12) {                                                         //condition for seat
                        if (row01[seat - 1] == 0) {
                            System.out.println("Seat is available. Try again");

                        } else {
                            row01[seat - 1] = 0;
                            System.out.println("Your seat successfully cancelled.");

                            for (Ticket details : ticket) {                                                //using enhanced for loop to remove the ticket from the array list
                                if (details.row == 1 && details.seat == seat) {                            //Part B - Task 12)
                                    ticket.remove(details);
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid seat number");
                    }

                } else if (row == 2) {                                                                      //condition for row 2
                    if (seat >= 1 && seat <= 16) {                                                          //condition for seat
                        if (row02[seat - 1] == 0) {
                            System.out.println("Seat is available. Try again");

                        } else {
                            row02[seat - 1] = 0;
                            System.out.println("Your seat successfully cancelled.");

                            for (Ticket details : ticket) {                                                 //using enhanced for loop to remove the ticket from the array list
                                if (details.row == 2 && details.seat == seat) {                             //Part B - Task 12)
                                    ticket.remove(details);
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid seat number");
                    }

                } else if (row == 3) {                                                                      //condition for row 3
                    if (seat >= 1 && seat <= 20) {                                                          //condition for seat
                        if (row03[seat - 1] == 0) {
                            System.out.println("Seat is available. Try again");

                        } else {
                            row03[seat - 1] = 0;
                            System.out.println("Your seat successfully cancelled.");

                            for (Ticket details : ticket) {                                                 //using enhanced for loop to remove the ticket from the array list
                                if (details.row == 3 && details.seat == seat) {                             //Part B - Task 12)
                                    ticket.remove(details);
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid seat number");
                    }

                } else {
                    System.out.println("Invalid input. Please try again");                                  //proper message display for invalid input
                    break;
                }

                System.out.print("Do you want to cancel another seat (yes/no): ");                          //get an input to continue or back to menu
                String ask2 = input.next();
                String lower_case2 = ask2.toLowerCase();                                                    //converting to lower case letters

                if (lower_case2.equals("yes")) {
                    continue;
                } else if (lower_case2.equals("no")) {
                    break;
                } else {
                    System.out.println("Invalid input. Try again");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input. Please try again");                                      //proper message display for invalid input
                continue;
            }
        }
    }

    //Part A - Task 6)

    /**
     * Print out the available seats in the theatre
     * @param array_name the theatre row array
     * @param row_num the row number
     */
    public static void show_available(int[] array_name, int row_num) {
        System.out.print("Seats available in row " + row_num + ": ");
        for (int i = 0; i < array_name.length; i++) {                                          //using for loop. variable i for index within the array
            if (array_name[i] == 0) {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();
    }

    //Part A - Task 7)

    /**
     * Save the theatre rows and seats to the file
     * @param array_name the theatre row array
     */
    public static void save(int[] array_name) {
        try {                                                                                //using try catch block
            FileWriter myWriter = new FileWriter("Seats.txt", true);          //specify the filename. set second parameter for append to the existing content
            for (int i = 0; i < array_name.length; i++) {                                    //using for loop. variable i for index within the array
                if (array_name[i] == 0) {
                    myWriter.write("0");

                } else {
                    myWriter.write("1");
                }
            }
            myWriter.write("\n");
            myWriter.close();                                                                //close the file

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    //Part A - Task 8)

    /**
     * Load from the file restores the 3 arrays and display the arrays
     * @param row01 the row 1 array in theatre
     * @param row02 the row 2 array in theatre
     * @param row03 the row 3 array in theatre
     */
    public static void load(int[] row01, int[] row02, int[] row03) {
        try {                                                                                //using try catch block
            File file = new File("Seats.txt");                                      //Specify the filename
            Scanner file_reader = new Scanner(file);

            int count = 0;                                                                   //Initializing count to 0
            while (file_reader.hasNextLine()) {                                              //using while loop to restore the 3 arrays with the row's information
                count = count + 1;
                String text = file_reader.nextLine();

                for (int i = 0; i < text.length(); i++) {
                    int seat = Integer.parseInt(String.valueOf(text.charAt(i)));            //read character by character and type cast to int
                    if (count == 1) {
                        if (seat == 1) {
                            row01[i] = 1;
                        } else {
                            row01[i] = 0;
                        }
                    } else if (count == 2) {
                        if (seat == 1) {
                            row02[i] = 1;
                        } else {
                            row02[i] = 0;
                        }
                    } else if (count == 3) {
                        if (seat == 1) {
                            row03[i] = 1;
                        } else {
                            row03[i] = 0;
                        }
                    }
                }
            }
            file_reader.close();                                                    //close the file

            for (int i = 0; i < row01.length; i++) {                               //using for loop to display restored array. variable i for index within the array
                if (row01[i] == 1) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();

            for (int j = 0; j < row02.length; j++) {                               //using for loop to display restored array. variable j for index within the array
                if (row02[j] == 1) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();

            for (int k = 0; k < row03.length; k++) {                               //using for loop to display restored array. variable k for index within the array
                if (row03[k] == 1) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Error while reading a file.");
        }
    }

    //Part B - Task 13)

    /**
     * Prints all the information and shows the total price of all tickets
     * @param ticket Array list
     */
    public static void show_tickets_info(ArrayList<Ticket> ticket) {
        if (ticket.size() > 0) {
            int total_price = 0;

            for (Ticket details : ticket) {                                                 //using enhanced for loop to print the information for all tickets from the array list
                details.print();
                System.out.println();
                total_price += details.price;
            }
            System.out.println("Your total tickets price: " + total_price + "£");           //print the total price of all tickets

        }else{
            System.out.println("No data to show tickets information");
        }
    }
    //Part B - Task 14)

    /**
     * Sort the tickets price in ascending order
     * @param array Array list
     */
    public static void sort_tickets(ArrayList<Ticket> array) {
        if (array.size() > 0) {
            for (int i = 1; i <= array.size(); i++) {                                      //sorting the elements using bubble sort
                for (int j = 1; j <= array.size() - 1; j++) {
                    Ticket tic1 = (Ticket) array.get(j - 1);
                    Ticket tic2 = (Ticket) array.get(j);

                    if ((tic1.price) > (tic2.price)) {
                        array.set(j - 1, tic2);                                            //sets the elements
                        array.set(j, tic1);
                    }
                }
            }
        }else{
            System.out.println("No data to sort");
        }
    }
}
