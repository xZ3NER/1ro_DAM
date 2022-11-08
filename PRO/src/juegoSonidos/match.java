package juegoSonidos;

import juegoSonidos.Pokemons.*;

import java.util.ArrayList;

public class match {

    private int points;
    final int max_points = 10;
    ArrayList<pokemon> pokemonList = new ArrayList<>();

    public match() {
        this.points = 0;
        generateMatch();
    }

    private void generateMatch() {
        pokemonList.add(new Magikarp());
        pokemonList.add(new Venusaur());
        pokemonList.add(new Blastoise());
        pokemonList.add(new Buizel());
        pokemonList.add(new Frillish());
        pokemonList.add(new Growlithe());
        pokemonList.add(new Kakuna());
        pokemonList.add(new Lugia());
        pokemonList.add(new Mantine());
        pokemonList.add(new MrMime());
        pokemonList.add(new Pikachu());
        pokemonList.add(new Quagsire());
        pokemonList.add(new Scyther());
        pokemonList.add(new Shinx());
        pokemonList.add(new Totodile());
        pokemonList.add(new Umbreon());
        pokemonList.add(new Victini());
        pokemonList.add(new Weedle());

        for (int i=0;i<panel.buttonsArray.length;i++) {
            panel.buttonsArray[i] = new buttons(pokemonList.get(randomNumber()));
        }

        pokemonList.get(randomNumber()).startSound();
        new frame();
        frame.panelObj.setButtons();
    }

    private int randomNumber() {
        return (int) (Math.random()*18);
    }

    private void generateRandomList() {
        pokemonList.add(new Magikarp());
        pokemonList.add(new Blastoise());
    }
}
