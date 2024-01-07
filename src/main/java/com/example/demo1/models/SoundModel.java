package com.example.demo1.models;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class SoundModel extends BaseModel {
    public SoundModel() {
        super(null);
    }

    @Override
    public Object execute() {
        Media sound = new Media(Objects.requireNonNull(getClass().getResource("sound.wav")).toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        return null;
    }
}
