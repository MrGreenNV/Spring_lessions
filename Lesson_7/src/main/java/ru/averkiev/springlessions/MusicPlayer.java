package ru.averkiev.springlessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private Music classicalMusic;
    private Music rockMusic;
    private Music tranceMusic;

    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic") Music classicalMusic,
                       @Qualifier("rockMusic") Music rockMusic,
                       @Qualifier("tranceMusic") Music tranceMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.tranceMusic = tranceMusic;
    }

    //IoC
    public String playMusic(Enum song) {
        if (song == Songs.ROCK) {
            return "Playing: " + rockMusic.getSong();
        }
        if (song == Songs.CLASSICAL) {
            return "Playing: " + classicalMusic.getSong();
        }
        if (song == Songs.TRANCE) {
            return "Playing: " + tranceMusic.getSong();
        }
        return "Err";
    }
}