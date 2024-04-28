package progetto;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creazione di un catalogo manager
        CatalogoManager catalogoManager = new CatalogoManager();

        // Aggiunta di alcuni elementi al catalogo
        catalogoManager.aggiungiElemento(new Libro("1234567890", "Il signore degli anelli", 1954, 1178, "J.R.R. Tolkien", "Fantasy"));
        catalogoManager.aggiungiElemento(new Libro("9876543210", "1984", 1949, 328, "George Orwell", "Distopia"));
        catalogoManager.aggiungiElemento(new Rivista("1112223334", "National Geographic", 2021, 100, Periodicita.MENSILE));

        // Ricerca per ISBN
        System.out.println("Ricerca per ISBN:");
        catalogoManager.cercaPerISBN("1234567890").ifPresent(System.out::println);

        // Ricerca per anno di pubblicazione
        System.out.println("\nRicerca per anno di pubblicazione:");
        catalogoManager.cercaPerAnnoPubblicazione(1954).forEach(System.out::println);

        // Ricerca per autore
        System.out.println("\nRicerca per autore:");
        catalogoManager.cercaPerAutore("George Orwell").forEach(System.out::println);

        // Salvataggio su disco
        try {
            catalogoManager.salvaCatalogoSuDisco("catalogo.dat");
            System.out.println("\nCatalogo salvato su disco.");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del catalogo su disco: " + e.getMessage());
        }

        // Caricamento da disco
        try {
            List<ElementoCatalogo> catalogoCaricato = catalogoManager.caricaCatalogoDaDisco("catalogo.dat");
            System.out.println("\nCatalogo caricato da disco:");
            catalogoCaricato.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Errore durante il caricamento del catalogo da disco: " + e.getMessage());
        }
    }
}
