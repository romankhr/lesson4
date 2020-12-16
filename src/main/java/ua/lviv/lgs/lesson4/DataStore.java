package ua.lviv.lgs.lesson4;

import ua.lviv.lgs.lesson4.dao.Journal;
import ua.lviv.lgs.lesson4.dao.Role;
import ua.lviv.lgs.lesson4.dao.User;

import java.util.*;

public class DataStore {

    private static Set<User> users = new HashSet<>(Arrays.asList(
            new User("John", "Doe", "admin", "admin", Role.ADMIN)
    ));
    private static List<Journal> journals = new ArrayList<>(Arrays.asList(
            new Journal("J1", "P1", 2020, 1, 120),
            new Journal("J2", "P2", 2020, 2, 200),
            new Journal("J3", "P3", 2020, 3, 250)
    ));
    private static List<Journal> chosenJournals = new ArrayList<>(Arrays.asList(
            new Journal("J1", "P1", 2020, 1, 120),
            new Journal("J3", "P3", 2020, 3, 250)
    ));

    public static Set<User> getUsers() {
        return users;
    }

    public static Optional<User> getUser(String email, String pass) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(pass))
                .findAny();
    }

    public static Optional<User> getUser(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findAny();
    }

    public static List<Journal> getJournals() {
        return journals;
    }

    public static List<Journal> getChosenJournals() {
        return chosenJournals;
    }
}
