package ru.averkiev.springlessions;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");


        TranceMusic music = context.getBean("tranceBean", TranceMusic.class);
        TranceMusic music1 = context.getBean("tranceBean", TranceMusic.class);


        System.out.println(music.getSong());
        System.out.println(music1.getSong());
//        Music music = context.getBean("musicBean", Music.class);
//        MusicPlayer musicPlayer = new MusicPlayer(music);

//        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        System.out.println(firstMusicPlayer == secondMusicPlayer);
//        System.out.println(firstMusicPlayer);
//        System.out.println(secondMusicPlayer);
//
//        firstMusicPlayer.setVolume(35);
//        secondMusicPlayer.setVolume(10);
//
//        System.out.println(firstMusicPlayer.getVolume());
//        System.out.println(secondMusicPlayer.getVolume());



//
//        musicPlayer.playMusic();
//
//        System.out.println(musicPlayer.getName() + " " + musicPlayer.getVolume());

        context.close();
    }
}