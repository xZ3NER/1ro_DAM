package juegoSonidos;

public abstract class pokemon {

    private String name;
    private String image;

    public pokemon(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    protected abstract void startSound();
}
