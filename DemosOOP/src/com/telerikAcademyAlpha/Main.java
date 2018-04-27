package com.telerikAcademyAlpha;

import com.Gender;
import com.Hero;
import com.HeroSide;

public class Main {

    public static void main(String[] args) {
        Hero batman = new Hero("Batman",85, Gender.MALE,"Bruce Wayne", "Gotham", HeroSide.GOOD);
        Hero wonderWoman = new Hero("WonderWoman",70,Gender.FEMALE,"Maya", "Ozundjovo", HeroSide.GOOD);
        Hero joker = new Hero("Joker",80,Gender.MALE,"Unknown", "Citizen of the world", HeroSide.EVIL);


        batman.addPower("Strenght");


    }
}
