package ru.averkiev.springlessons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicPlayer {

    private List<Music> musicList = new ArrayList<>();
//    {
//        musicList.add(new ClassicalMusic());
//        musicList.add(new TranceMusic());
//        musicList.add(new RockMusic());
//    }
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    //IoC
    public String playMusic() {
        return "Playing: " + musicList.get(new Random().nextInt(musicList.size())).getSong();
    }
}