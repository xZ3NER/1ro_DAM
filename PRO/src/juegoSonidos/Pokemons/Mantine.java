package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class Mantine extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/mantine.wav";

    public Mantine() {
        super("Mantine","./images/mantine.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
