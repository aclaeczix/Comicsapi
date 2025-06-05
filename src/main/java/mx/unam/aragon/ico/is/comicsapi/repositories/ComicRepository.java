package mx.unam.aragon.ico.is.comicsapi.repositories;

import mx.unam.aragon.ico.is.comicsapi.entities.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ComicRepository extends JpaRepository<Comic, Integer> {
    public Comic findComicByClave(Integer clave);
    public Comic deleteByClave(Integer clave);
    }



