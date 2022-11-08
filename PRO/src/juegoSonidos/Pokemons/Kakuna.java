package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Kakuna extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/kakuna.wav";

    public Kakuna() {
        super("Kakuna","./images/kakuna.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
