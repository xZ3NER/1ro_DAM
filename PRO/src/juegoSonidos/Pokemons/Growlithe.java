package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Growlithe extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/growlithe.wav";

    public Growlithe() {
        super("Growlithe","./images/growlithe.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
