package mx.unam.aragon.ico.is.comicsapi;

import mx.unam.aragon.ico.is.comicsapi.entities.Comic;
import mx.unam.aragon.ico.is.comicsapi.repositories.ComicRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComicsapiApplicationTests {
    @Autowired
    private ComicRepository comicRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void insertarComic() {
        Comic comic = new Comic(null,"Spiderman: The Night Gwen Stacy Died","MarvelComics",null,1973);
        comicRepository.save(comic);
    }



    @Test
    void leerComic() {
        Integer claveTemp = 2;
        Comic tmp = comicRepository.findComicByClave(claveTemp);
        System.out.println(tmp);
    }

    @Test
    public void eliminarComic() {
        Integer claveTmp = 2;
        comicRepository.deleteById(claveTmp);
    }

    @Test
    public void actualizarComic() {
        Integer claveTmp = 1;
        Comic tmp = comicRepository.findComicByClave(claveTmp);
        if (tmp != null) {
            tmp.setEditorial("DComics");
            comicRepository.save(tmp);
        } else {
            System.out.println("No se encontró el cómic con clave " + claveTmp);
        }
    }

}
