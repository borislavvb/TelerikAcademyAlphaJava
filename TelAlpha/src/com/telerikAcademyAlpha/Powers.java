package com.telerikAcademyAlpha;

public class Powers {
    private String name;
    private PowerType powerType;

    public Powers(String name, PowerType powerType) {
        this.name = name;
        this.powerType = powerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PowerType getPowerType() {
        return powerType;
    }

    public void setPowerType(PowerType powerType) {
        this.powerType = powerType;
    }

}
