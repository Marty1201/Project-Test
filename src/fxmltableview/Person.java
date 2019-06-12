package fxmltableview;

import javafx.beans.property.SimpleStringProperty;

/**
 * A person class contain some attributes of a person
 * @author chenxi 创建时间：2019-6-3 16:36:10
 */
public class Person {

    private final SimpleStringProperty firstName = new SimpleStringProperty("");
    private final SimpleStringProperty lastName = new SimpleStringProperty("");
    private final SimpleStringProperty email = new SimpleStringProperty("");

    public Person(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    /**
     * get first name.
     *
     * @return first name.
     */
    public String getFirstName() {
        return firstName.get();
    }

    /**
     * set first name.
     *
     * @param fName.
     */
    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    /**
     * get last name.
     *
     * @return last name.
     */
    public String getLastName() {
        return lastName.get();
    }

    /**
     * set last name.
     *
     * @param lName.
     */
    public void setLastName(String lName) {
        lastName.set(lName);
    }

    /**
     * get email.
     *
     * @return email.
     */
    public String getEmail() {
        return email.get();
    }

    /**
     * set email.
     *
     * @param emailValue.
     */
    public void setEmail(String emailValue) {
        email.set(emailValue);
    }

}
