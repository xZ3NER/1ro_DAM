package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Blastoise extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/blastoise.wav";

    public Blastoise() {
        super("Blastoise","./images/blastoise.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
