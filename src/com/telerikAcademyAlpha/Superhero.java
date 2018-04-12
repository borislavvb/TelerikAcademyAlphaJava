package com.telerikAcademyAlpha;

import java.util.ArrayList;

public class Superhero {
    private String name;
    private String secretIdentity;
    private Alignment alignment;
    private ArrayList<Powers> immunities;
    private ArrayList<Powers> powers;
    private int lifePoints;
    private static final int attackPoints = 10;

    public Superhero(String name, String secretIdentity, Alignment alignment, int lifePoints) {
        this.name = name;
        this.secretIdentity = secretIdentity;
        this.alignment = alignment;
        this.lifePoints = lifePoints;
        this.immunities = new ArrayList<>();
        this.powers = new ArrayList<>();

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.length()<3&&name.length()>60){
            throw new IndexOutOfBoundsException();
        }
        this.name = name;
    }
    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        if (secretIdentity.length()<3&&secretIdentity.length()>60){
            throw new IndexOutOfBoundsException();
        }
        this.secretIdentity = secretIdentity;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {

        this.lifePoints = lifePoints;
    }


    public void addImmunities(Powers power){
        immunities.add(power);
    }

    public void addPowers(Powers power){
        powers.add(power);
    }

    public void attack(Superhero name, Powers power) throws Exception {
        if (!powers.contains(power)){
            throw new Exception("This superhero doesn't have this power!");
        }
        if (name.immunities.contains(power)){
            System.out.printf("%s is immune to %s!",name,power);
        }else{
            name.lifePoints -= 10;
        }
    }

}
