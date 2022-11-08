package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Shinx extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/shinx.wav";

    public Shinx() {
        super("Shinx","./images/shinx.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
