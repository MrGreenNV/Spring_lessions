package ru.averkiev.springlessons;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassicalMusic implements Music {

    private List<String> songs = new ArrayList<>();

    {
        songs.add("Hungarian Rhapsody");
        songs.add("Spring");
        songs.add("Symphony №9");
    }

    @Override
    public String getSong() {
        return songs.get(new Random().nextInt(3));
    }
}
