package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Umbreon extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/umbreon.wav";

    public Umbreon() {
        super("Umbreon","./images/umbreon.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
