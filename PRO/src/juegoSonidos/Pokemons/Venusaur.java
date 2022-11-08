package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Venusaur extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/venusaur.wav";

    public Venusaur() {
        super("Venusaur","./images/venusaur.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
