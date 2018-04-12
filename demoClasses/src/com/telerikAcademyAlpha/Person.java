package com.telerikAcademyAlpha;

import java.util.ArrayList;

public class Person {
    private String name;
    private  int age;
    private String phone;
    private ArrayList<Person> friends;

    public Person(String name, int age, String phone){
        this.name = name;
        this.age = age;
        this.phone = phone;
        friends = new ArrayList<>();
    }

    public void sayHi(){
        System.out.printf("Hi, I'm %s and i am %d years old!!",name,age);
    }
    public void sayHi(Person name){
        System.out.printf("Hi %s, how are you?)",name.name );
    }
    public void givePhoneNumber(){
        System.out.printf("You can contact me at %s\n",phone);
    }
    public void addFriend(Person newFriend){
        friends.add(newFriend);
    }
    public void listFriends(){
        System.out.print("My friends are: ");
        for (Person friend : friends){
            System.out.printf("%s ",friend.name);
        }
        System.out.println();
    }
}
