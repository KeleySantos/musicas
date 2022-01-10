package br.com.tech4me.musicas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.musicas.model.Musica;
import br.com.tech4me.musicas.repository.MusicaRepository;
import br.com.tech4me.musicas.shared.MusicaDto;

@Service
public class MusicaServiceImpl implements MusicaService{

    @Autowired
    private MusicaRepository repo;

    @Override 
    public List<MusicaDto> obterTodos(){
        List<Musica> musicas = repo.findAll();
        
        return musicas.stream()
        .map( c -> new ModelMapper().map(c, MusicaDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public MusicaDto cadastrarMusica(MusicaDto musica){
        MusicaDto musicaCadastro = new ModelMapper().map(musica, MusicaDto.class);
        musicaCadastro = repo.save(musicaCadastro);
        return new ModelMapper().map(musicaCadastro, MusicaDto.class);
    }

    @Override
    public Optional<MusicaDto> obterMusicasPorId(String id){
        Optional<Musica> buscarMusica = repo.findById(id);
        return Optional.of(new ModelMapper().map(buscarMusica.get(), MusicaDto.class));
    }
    
    @Override
    public void removerMusica(String id){
        repo.deleteById(id);
    }


    @Override
    public MusicaDto atualizarMusica(String id, MusicaDto novaMusica) {
        Musica musicaPersistencia = new ModelMapper().map(novaMusica, Musica.class);
        musicaPersistencia.setId(id);
        musicaPersistencia = repo.save(musicaPersistencia);
        return new ModelMapper().map(musicaPersistencia, MusicaDto.class);
    }


}
