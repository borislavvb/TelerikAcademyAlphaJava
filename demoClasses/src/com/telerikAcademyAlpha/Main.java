package com.telerikAcademyAlpha;

public class Main {

    public static void main(String[] args) {

        Person[] people = {
                new Person("Gosho",14,"088887273"),
                new Person("Pesho",17,"28939283"),
        };

        people[0].addFriend(people[1]);
        people[0].sayHi(people[1]);

        for (Person person: people){
            person.sayHi();

            person.givePhoneNumber();
            person.listFriends();
        }
    }
}
