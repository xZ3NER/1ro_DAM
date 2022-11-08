package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Magikarp extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/magikarp.wav";

    public Magikarp() {
        super(Magikarp.class.getName(),"./images/magikarp.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
