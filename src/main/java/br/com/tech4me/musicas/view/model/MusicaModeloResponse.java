package br.com.tech4me.musicas.view.model;

public class MusicaModeloResponse {

    private String id;
    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private int dataL;
    private String compositor;
    
   
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
