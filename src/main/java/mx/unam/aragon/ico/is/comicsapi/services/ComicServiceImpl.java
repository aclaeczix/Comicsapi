package mx.unam.aragon.ico.is.comicsapi.services;

import mx.unam.aragon.ico.is.comicsapi.entities.Comic;
import mx.unam.aragon.ico.is.comicsapi.repositories.ComicRepository;
import mx.unam.aragon.ico.is.comicsapi.services.Interfaces.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComicServiceImpl implements ComicService {
    @Autowired
    private ComicRepository comicRepository;

    @Override
    public Comic crear(Comic comic) {
        return comicRepository.save(comic);
    }

    @Override
    public Iterable<Comic> listarTodas() {
        return comicRepository.findAll();
    }

    @Override
    public Optional<Comic> buscarPorId(Integer clave) {
        return comicRepository.findById(clave);
    }

    @Override
    public Comic actualizar(Integer clave, Comic comic) {
        Optional<Comic> comicActual = comicRepository.findById(clave);
        if (comicActual.isPresent()) {
            Comic tmp = comicActual.get();
            tmp.setTitulo(comic.getTitulo());
            tmp.setClave(comic.getClave());
            tmp.setFoto(comic.getFoto());
            tmp.setEditorial(comic.getEditorial());
            tmp.setPublicacion(comic.getPublicacion());
            return comicRepository.save(tmp);
        }else {
            return null;
        }
    }

    @Override
    public void eliminar(Integer clave) {
         comicRepository.deleteById(clave);
    }
}


