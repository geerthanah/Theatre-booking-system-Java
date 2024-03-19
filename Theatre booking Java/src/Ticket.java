public class Ticket {
    int row;                                                                                    //adding attributes
    int seat;
    int price;
    Person person;

    public Ticket(Person person, int row, int seat, int price) {                               //Defining a constructor
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }


    //Part B - Task 11)
    public void print() {
        System.out.println("Name: " + person.getName());
        System.out.println("Surname: " + person.getSurname());
        System.out.println("Email: " + person.getEmail());
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " + price);
    }
}
