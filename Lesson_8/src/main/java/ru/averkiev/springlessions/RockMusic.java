package ru.averkiev.springlessions;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RockMusic implements Music {
    private List<String> songs = new ArrayList<>();

    {
        songs.add("Nobody");
        songs.add("Kill4Me");
        songs.add("Du hast");
    }

    @Override
    public String getSong() {
        return songs.get(new Random().nextInt(3));
    }
}
