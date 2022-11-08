package juegoSonidos.Pokemons;

import juegoSonidos.playSound;
import juegoSonidos.pokemon;

public class MrMime extends pokemon {

    private String soundUrl = "PRO/src/juegoSonidos/sounds/mrmime.wav";

    public MrMime() {
        super("MrMime","./images/mrmime.gif");
    }

    @Override
    protected void startSound() {
        new playSound(soundUrl);
    }
}
