package br.com.gof.builder;

public enum HairColor {
    WHITE,
    BLOND,
    RED,
    BROWN,
    BLACK;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
