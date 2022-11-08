package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Weedle extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/weedle.wav";

    public Weedle() {
        super("Weedle","./images/weedle.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
