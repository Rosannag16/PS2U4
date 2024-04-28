package progetto;

import java.io.Serializable;

public class ElementoCatalogo implements Serializable {
    private String codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public ElementoCatalogo(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }
    public String getTitolo() {
        return titolo;
    }


    // Altri getter e setter per gli altri attributi

}
