package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Frillish extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/frillish.wav";

    public Frillish() {
        super("Frillish","./images/frillish.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
