package com.telerikAcademyAlpha;

public class Main {

    public static void main(String[] args) throws Exception {


        Superhero batman = new Superhero("Batman","Bruce Wayne",Alignment.GOOD,90);
        Superhero superman = new Superhero("Superman","Clark Kent",Alignment.GOOD,70);

        Powers strength = new Powers("Strength",PowerType.OTHER);
        Powers kryptonite = new Powers("Kryptonite",PowerType.OTHER);
        batman.addPowers(kryptonite);
        superman.addPowers(strength);
        System.out.println(superman.getLifePoints());
        batman.attack(superman,kryptonite);
        System.out.println(superman.getLifePoints());
        batman.attack(superman,kryptonite);
        if (check(superman)){
            System.out.println("He is dead!");
        }else {
        System.out.println(superman.getLifePoints());
        }

    }

    public static boolean check(Superhero name){
        return name.getLifePoints()<=0;
    }
}
