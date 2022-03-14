package dev.saariselka.inlol;

public class Summoner {
    private String name;
    private String tier;
    private String position;

    public Summoner() {
    }

    public Summoner(String name) {
        this.name = name;
        this.tier = "Platinum";
        this.position = "Jungle";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Summoner{" +
                "name='" + name + '\'' +
                ", tier='" + tier + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
