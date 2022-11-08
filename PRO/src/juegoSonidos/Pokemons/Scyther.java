package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Scyther extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/scyther.wav";

    public Scyther() {
        super("Scyther","./images/scyther.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
