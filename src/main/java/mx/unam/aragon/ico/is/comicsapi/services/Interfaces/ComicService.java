package mx.unam.aragon.ico.is.comicsapi.services.Interfaces;

import mx.unam.aragon.ico.is.comicsapi.entities.Comic;

import java.util.Optional;

public interface ComicService {
    public abstract Comic crear(Comic comic);
    public abstract Iterable<Comic> listarTodas();
    public abstract Optional<Comic> buscarPorId(Integer clave);
    public abstract Comic actualizar(Integer clave, Comic comic);
    public abstract void eliminar(Integer clave);
}
