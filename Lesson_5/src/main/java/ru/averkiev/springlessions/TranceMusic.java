package ru.averkiev.springlessions;

public class TranceMusic implements Music {

    private TranceMusic() {

    }

    public static TranceMusic getTranceMusic() {
        return new TranceMusic();
    }
    public void doMyInit() {
        System.out.println("Initialisation");
    }

    public void doMyDestroy() {
        System.out.println("Destruction");
    }
    @Override
    public String getSong() {
        return "Till the Sky";
    }
}
