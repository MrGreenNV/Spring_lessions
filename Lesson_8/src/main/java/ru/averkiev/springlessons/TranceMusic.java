package ru.averkiev.springlessons;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TranceMusic implements Music {

    private List<String> songs = new ArrayList<>();

    {
        songs.add("Till the Sky");
        songs.add("Invisible Touch");
        songs.add("Let go");
    }

    @PostConstruct
    public void doMyInit() {
        System.out.println("Initialize");
    }

    @PreDestroy
    public void doMyDestruct() {
        System.out.println("Destroy");
    }

    @Override
    public String getSong() {
        return songs.get(new Random().nextInt(3));
    }
}
