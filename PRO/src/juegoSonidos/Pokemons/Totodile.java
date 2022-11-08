package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Totodile extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/totodile.wav";

    public Totodile() {
        super("Totodile","./images/totodile.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
