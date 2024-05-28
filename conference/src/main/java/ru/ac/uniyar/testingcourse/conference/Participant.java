package ru.ac.uniyar.testingcourse.conference;


/**
 * Scientist participating in a conference
 */
public class Participant {
    private final String name;
    private final String surname;
    private final String email;

    public Participant(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    /**
     * @return full name: [name] [surname]
     */
    public String getFullName() {
        return String.format("%s %s", getName(), getSurname());
    }
}
