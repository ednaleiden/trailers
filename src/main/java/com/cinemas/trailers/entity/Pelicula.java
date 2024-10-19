package com.cinemas.trailers.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pelicula {

    @Id
    @Column(name = "id_pelicula")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String titulo;
    @NotBlank
    private String sinopsis;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaEstreno;

    @NotBlank
    private String youtubeTrailerId;

    private  String rutaPortada;
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "genero_pelicula",joinColumns=@JoinColumn(name = "id_pelicula"),inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private List<Genero> generos;

    @Transient   //guardado temporal
    private MultipartFile portada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank String titulo) {
        this.titulo = titulo;
    }

    public @NotBlank String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(@NotBlank String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public @NotNull LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(@NotNull LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }
    public @NotBlank String getYoutubeTrailerId() {
        return youtubeTrailerId;
    }

    public void setYoutubeTrailerId(@NotBlank String youtubeTrailerId) {
        this.youtubeTrailerId = youtubeTrailerId;
    }

    public String getRutaPortada() {
        return rutaPortada;
    }

    public void setRutaPortada(String rutaPortada) {
        this.rutaPortada = rutaPortada;
    }

    public @NotEmpty List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(@NotEmpty List<Genero> generos) {
        this.generos = generos;
    }

    public MultipartFile getPortada() {
        return portada;
    }

    public void setPortada(MultipartFile portada) {
        this.portada = portada;
    }

    public Pelicula() {
    }

    public Pelicula(Integer id, String titulo, String sinopsis, LocalDate fechaEstreno, String youtebeTrailerId, String rutaPortada, List<Genero> generos, MultipartFile portada) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.fechaEstreno = fechaEstreno;
        this.youtubeTrailerId = youtebeTrailerId;
        this.rutaPortada = rutaPortada;
        this.generos = generos;
        this.portada = portada;
    }

    public Pelicula(String titulo, String sinopsis, LocalDate fechaEstreno, String youtebeTrailerId, String rutaPortada, List<Genero> generos, MultipartFile portada) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.fechaEstreno = fechaEstreno;
        this.youtubeTrailerId = youtebeTrailerId;
        this.rutaPortada = rutaPortada;
        this.generos = generos;
        this.portada = portada;
    }
}
