package com.tvn.elements;

public class Row {
    private String firstName;
    private String lastName;
    private String email;
    private String due;
    private String website;

    public Row(String firstName, String lastName, String email, String due, String website) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.due = due;
        this.website = website;
    }

    public String getName(){
        return String.format("%s %s",this.firstName,this.lastName);
    }

    public void info(){
        System.out.printf("firstName: %s\n",this.firstName);
        System.out.printf("lastName: %s\n",this.lastName);
        System.out.printf("email: %s\n",this.email);
        System.out.printf("due: %s\n",this.getDue());
        System.out.printf("website: %s\n",this.website);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public double getDue() {
        return Double.parseDouble(this.due.replace("$",""));
    }

    public String getWebsite() {
        return website;
    }
}
