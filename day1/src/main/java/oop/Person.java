package oop;


import java.time.LocalDate;

public class Person {

    private String firstName;
    private String lastName;
    private String cnp;
    private LocalDate localDate;

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        name.split(" ");
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(final String cnp) {
        this.cnp = cnp;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(final LocalDate localDate) {
        this.localDate = localDate;
    }
}
