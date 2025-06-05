package mx.unam.aragon.ico.is.comicsapi.controllers;

import jakarta.validation.Valid;
import mx.unam.aragon.ico.is.comicsapi.entities.Comic;
import mx.unam.aragon.ico.is.comicsapi.services.Interfaces.ComicService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comics")
public class ComicController {
    @Autowired
    private ComicService comicService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Comic>> getComics() {

        return ResponseEntity.ok().body(comicService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comic> getComic(@PathVariable Integer id) {

        return ResponseEntity.ok(comicService.buscarPorId(id).orElse(null));
    }

    @PostMapping("/")
    public ResponseEntity<Comic> createComic(@Valid @RequestBody Comic comic)
            throws URISyntaxException {

        return ResponseEntity.created
                (new URI("http//localhost:8080/")).body(comicService.crear(comic));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comic> updateComic(@PathVariable Integer id, @RequestBody Comic comic) {
        return ResponseEntity.ok(comicService.actualizar(id, comic));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Comic> patchComic(@PathVariable Integer id, @RequestBody Comic comic) {
        Optional<Comic> tmp = comicService.buscarPorId(id);
        if (tmp.isPresent()) {
            LoggerFactory.getLogger(ComicController.class).info("Comic: actualizado " + comic);
            Comic actual = tmp.get();
            if (comic.getTitulo() != null) actual.setTitulo(comic.getTitulo());
            if (comic.getEditorial() != null) actual.setEditorial(comic.getEditorial());
            if (comic.getPublicacion() != null) actual.setPublicacion(comic.getPublicacion());
            if (comic.getFoto() != null) actual.setFoto(comic.getFoto());
            return ResponseEntity.ok(comicService.actualizar(id, actual));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public void deleteComic(@PathVariable Integer id) {
        comicService.eliminar(id);
    }
}



