package br.com.tech4me.musicas.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.musicas.model.Musica;
import br.com.tech4me.musicas.shared.MusicaDto;


public interface MusicaRepository extends MongoRepository<Musica, String> {

    MusicaDto save(MusicaDto musicaCadastro);
 }
    

