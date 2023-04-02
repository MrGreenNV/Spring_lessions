package ru.averkiev.springlessions;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TranceMusic implements Music {

    private static List<String> songs = new ArrayList<>();

    static {
        songs.add("Till the Sky");
        songs.add("Invisible Touch");
        songs.add("Let go");
    }

    @Override
    public String getSong() {
        return songs.get(new Random().nextInt(3));
    }
}
