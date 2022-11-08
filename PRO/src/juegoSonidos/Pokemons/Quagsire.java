package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Quagsire extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/quagsire.wav";

    public Quagsire() {
        super("Quagsire","./images/quagsire.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
