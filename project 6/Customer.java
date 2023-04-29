/*
 * Class: CMSC203
 * Instructor: Gary Thai
 * Description: Represents a Customer
 * Due: 05/05/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Alim Saidkhodjaev M21111105
 */
public class Customer {

    /** The name of the customer. */
    private String name;

    /** The age of the customer. */
    private int age;

    /**
     * Constructs a new customer object with the given name and age.
     * 
     * @param name the name of the customer
     * @param age the age of the customer
     */
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Constructs a new customer object that is a copy of the specified customer.
     * 
     * @param c the customer to copy
     */
    public Customer(Customer c) {
        this.name = c.getName();
        this.age = c.getAge();
    }

    /**
     * Returns the age of the customer.
     * 
     * @return the age of the customer
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the customer.
     * 
     * @param age the new age of the customer
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns the name of the customer.
     * 
     * @return the name of the customer
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     * 
     * @param name the new name of the customer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the customer, including their name and age.
     * 
     * @return a string representation of the customer
     */
    @Override
    public String toString() {
        return "Customer [name=" + name + ", age=" + age + "]";
    }
}
