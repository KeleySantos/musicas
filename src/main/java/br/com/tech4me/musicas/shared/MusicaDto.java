package br.com.tech4me.musicas.shared;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class MusicaDto {
    
    private String id;
    @NotBlank(message = "O id não pode estar vázio")
    private String titulo;
    @NotBlank(message = "O titulo não pode estar vázio")
    private String artista;
    @NotBlank(message = "O artista não pode estar vázio")
    private String album;
    @NotBlank(message = "O album não pode estar vázio")
    private String genero;
    @NotBlank(message = "O genero não pode estar vázio")
    private int dataL;
    @Size(message = "A data de lançamento não pode conter menos de 4 números")
    @Positive(message = "A data não pode estar zerada!")
    private String compositor;
    @NotBlank(message = "O compositor não pode estar vázio")
    
    public String getId() {
        return id;
    }
   
    public void setId(String id) {
        this.id = id;
    }
   
    public String getTitulo() {
        return titulo;
    }
  
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
   
    public String getArtista() {
        return artista;
    }
    
    public void setArtista(String artista) {
        this.artista = artista;
    }
   
    public String getAlbum() {
        return album;
    }
   
    public void setAlbum(String album) {
        this.album = album;
    }
   
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
   
    public int getDataL() {
        return dataL;
    }
   
    public void setDataL(int dataL) {
        this.dataL = dataL;
    }
    
    public String getCompositor() {
        return compositor;
    }
   
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    
}
