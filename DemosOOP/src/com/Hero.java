package com;

import java.util.ArrayList;

public class Hero extends Person {

    private String secretIdentity;
    private String backStory;
    private HeroSide isGood;
    private ArrayList<String> listOfPowers;

    public Hero(String name, int weight, Gender gender, String secretIdentity, String backStory, HeroSide isGood) {
        super(name,weight,gender);

        this.secretIdentity = secretIdentity;
        this.backStory = backStory;
        this.isGood = isGood;
        listOfPowers = new ArrayList<>();
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public String getBackStory() {
        return backStory;
    }

    public void setBackStory(String backStory) {
        this.backStory = backStory;
    }

    public HeroSide getIsGood() {
        return isGood;
    }

    public void setIsGood(HeroSide isGood) {
        this.isGood = isGood;
    }

    public void addPower(String power){
        listOfPowers.add(power);
    }

    public void canFly(){
        System.out.println("Yes, he can!");
    }
}
