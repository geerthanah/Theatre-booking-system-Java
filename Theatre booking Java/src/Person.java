public class Person {
    private String name;                                                                //adding attributes
    private String surname;
    private String email;

    public Person(String name, String surname, String email){                           //Defining a constructor
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // getters for the attributes
    public String getName() {
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getEmail(){
        return email;
    }

}
