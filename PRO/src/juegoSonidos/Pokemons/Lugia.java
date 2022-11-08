package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Lugia extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/lugia.wav";

    public Lugia() {
        super("Lugia","./images/lugia.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
