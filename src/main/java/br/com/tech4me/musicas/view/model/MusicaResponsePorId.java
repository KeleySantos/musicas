package br.com.tech4me.musicas.view.model;

public class MusicaResponsePorId {
    
    private String id;
    private String titulo;
    private String artista;
   
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
}
