package ru.averkiev.springlessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private Music classicalMusic;
    private Music rockMusic;
    private Music tranceMusic;

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

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music classicalMusic,
                       @Qualifier("rockMusic") Music rockMusic,
                       @Qualifier("tranceMusic") Music tranceMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.tranceMusic = tranceMusic;
    }

    //IoC
    public String playMusic(Songs song) {
        switch (song) {
            case ROCK -> {
                return "Playing: " + rockMusic.getSong();
            }
            case TRANCE -> {
                return "Playing: " + tranceMusic.getSong();
            }
            case CLASSICAL -> {
                return "Playing: " + classicalMusic.getSong();
            }
        }

        return "Err";
    }
}