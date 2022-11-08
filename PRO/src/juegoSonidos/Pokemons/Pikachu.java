package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Pikachu extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/pikachu.wav";

    public Pikachu() {
        super("Pikachu","./images/pikachu.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
