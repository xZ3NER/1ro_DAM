package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Victini extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/victini.wav";

    public Victini() {
        super("Victini","./images/victini.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}