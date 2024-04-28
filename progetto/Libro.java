package progetto;

import java.io.Serializable;

public class Libro extends ElementoCatalogo implements Serializable {
    private String autore;
    private String genere;

    public Libro(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codiceISBN='" + getCodiceISBN() + '\'' +
                ", titolo='" + getTitolo() + '\'' +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }

    // Getters and setters
    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }
}
