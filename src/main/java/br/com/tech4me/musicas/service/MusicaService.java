package br.com.tech4me.musicas.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.musicas.shared.MusicaDto;

public interface MusicaService {

    MusicaDto cadastrarMusica(MusicaDto musica);
    List<MusicaDto> obterTodos();
    void removerMusica(String id);
    MusicaDto atualizarMusica(String id, MusicaDto novaMusica);
    Optional<MusicaDto> obterMusicasPorId(String id);
    
}
