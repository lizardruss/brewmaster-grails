package org.brewmaster

class User {

    String userName;
    String password;
    String firstName;
    String lastName;

    static constraints = {
        userName nullable: false, blank: false
        password password: true
        firstName nullable: false, blank: false
        lastName nullable: false, blank: false
    }
}
