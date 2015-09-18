package layers.kwic.main;

/**
 * Created by luisburgos on 17/08/15.
 */
public enum Words {

    LACASAAZUL("La casa azul"),
    LACASAVERDE("La casa verde"),
    RANDOM("Una frase muy dummy"),
    BIGSTRING("Esta es una frase con muchos inicios diferentes");

    private final String text;

    Words(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
