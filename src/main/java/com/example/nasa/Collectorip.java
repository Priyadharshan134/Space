package com.example.nasa;

public class Collectorip {
    String name,gender,age,hypnotic,alertness,chronobiology;

    public Collectorip() {
    }

    public Collectorip(String name, String gender, String age, String hypnotic, String alertness, String chronobiology) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.hypnotic = hypnotic;
        this.alertness = alertness;
        this.chronobiology = chronobiology;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHypnotic() {
        return hypnotic;
    }

    public void setHypnotic(String hypnotic) {
        this.hypnotic = hypnotic;
    }

    public String getAlertness() {
        return alertness;
    }

    public void setAlertness(String alertness) {
        this.alertness = alertness;
    }

    public String getChronobiology() {
        return chronobiology;
    }

    public void setChronobiology(String chronobiology) {
        this.chronobiology = chronobiology;
    }
}
