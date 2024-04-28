package progetto;

import java.io.Serializable;

public class Rivista extends ElementoCatalogo implements Serializable {
    private Periodicita periodicita;

    public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    // Getter e setter per l'attributo periodicita
    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    // Metodo toString per la stampa delle informazioni della rivista
    @Override
    public String toString() {
        return "Rivista{" +
                "codiceISBN='" + getCodiceISBN() + '\'' +
                ", titolo='" + getTitolo() + '\'' +
                ", annoPubblicazione=" + getAnnoPubblicazione() +
                ", periodicita=" + periodicita +
                '}';
    }
}
