package ru.averkiev.springlessions;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ClassicalMusic implements Music {

    private static List<String> songs = new ArrayList<>();

    static {
        songs.add("Hungarian Rhapsody");
        songs.add("Spring");
        songs.add("Symphony №9");
    }

    @Override
    public String getSong() {
        return songs.get(new Random().nextInt(3));
    }
}
