package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Buizel extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/buizel.wav";

    public Buizel() {
        super("Buizel","./images/buizel.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
