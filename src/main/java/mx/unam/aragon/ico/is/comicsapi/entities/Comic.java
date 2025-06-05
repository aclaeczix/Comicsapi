package mx.unam.aragon.ico.is.comicsapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "comics")

public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clave;


    @Column(name = "titulo", nullable = false, length = 50)
    @NotBlank (message = "El campo no debe tener solo espacios en blanco")
    @NotNull(message = "No debe de ser nulo")
    private String titulo;

    @Column(name = "editorial",
            columnDefinition = "VARCHAR(50) not null")
    private String editorial;

    @Column(name = "url_foto",
            nullable = true,
            insertable = false,
            columnDefinition = "VARCHAR(500) DEFAULT 'https://extensions.typo3.org/typo3temp/assets/tx_terfe2/images/placeholder_images_1.1.0.png'"
    ) //'https://extensions.typo3.org/typo3temp/assets/tx_terfe2/images/placeholder_images_1.1.0.png'
    private String foto;

    @Column(name = "publicacion", nullable = true)
    private Integer publicacion;

    public Comic() {
    }

    public Comic(Integer clave, String titulo, String editorial, String foto, Integer publicacion) {
        this.clave = clave;
        this.titulo = titulo;
        this.editorial = editorial;
        this.foto = foto;
        this.publicacion = publicacion;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Integer publicacion) {
        this.publicacion = publicacion;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Comic that = (Comic) o;
        return clave == that.clave && Objects.equals(titulo, that.titulo) && Objects.equals(editorial, that.editorial)
                && Objects.equals(foto, that.foto) && Objects.equals(publicacion, that.publicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clave, titulo, editorial, foto, publicacion);
    }

    @Override
    public String toString() {
        return "Comic{" +
                "clave=" + clave +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", foto='" + foto + '\'' +
                ", publicacion=" + publicacion +
                '}';
    }
}