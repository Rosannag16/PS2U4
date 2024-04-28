package progetto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CatalogoManager {
    private List<ElementoCatalogo> catalogo = new ArrayList<>();

    public void aggiungiElemento(ElementoCatalogo elemento) {
        catalogo.add(elemento);
    }

    public void rimuoviElemento(String codiceISBN) {
        catalogo.removeIf(elem -> elem.getCodiceISBN().equals(codiceISBN));
    }

    public Optional<ElementoCatalogo> cercaPerISBN(String codiceISBN) {
        return catalogo.stream().filter(elem -> elem.getCodiceISBN().equals(codiceISBN)).findFirst();
    }

    public List<ElementoCatalogo> cercaPerAnnoPubblicazione(int anno) {
        return catalogo.stream().filter(elem -> elem.getAnnoPubblicazione() == anno).collect(Collectors.toList());
    }

    public List<ElementoCatalogo> cercaPerAutore(String autore) {
        return catalogo.stream()
                .filter(elem -> elem instanceof Libro && ((Libro) elem).getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    public void salvaCatalogoSuDisco(String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(catalogo);
        }
    }

    @SuppressWarnings("unchecked")
    public List<ElementoCatalogo> caricaCatalogoDaDisco(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<ElementoCatalogo>) inputStream.readObject();
        }
    }
}
