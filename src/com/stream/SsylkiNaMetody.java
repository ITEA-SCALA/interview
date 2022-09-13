package com.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @see https://vertex-academy.com/tutorials/ru/java-8-ssylki-na-metody
 */
public class SsylkiNaMetody {

    public static void main(String[] args) {
        // 1.
        UserFactory userFactory = User::new;

        // 2.
        Function<String, String> trim = String::trim;
        String str = trim
                .andThen(String::toLowerCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply(" ABCDEFG ");
        System.out.println("Output " + str); // Output gfedcba

        // 3.
        List<User> users = new ArrayList<>();
        users.add(new User("Nick", "Boll"));
        users.add(new User("Jan", "Nicky"));
        users.add(new User("Bot", "Smart"));

        users.sort(Comparator.comparing(User::getName));
        users.forEach(System.out::println);

    }
}

class User {
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

interface UserFactory {
    User create(String name, String surname);
}
