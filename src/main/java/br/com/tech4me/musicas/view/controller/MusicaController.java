package br.com.tech4me.musicas.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.musicas.service.MusicaService;
import br.com.tech4me.musicas.shared.MusicaDto;
import br.com.tech4me.musicas.view.model.MusicaModeloRequest;
import br.com.tech4me.musicas.view.model.MusicaModeloResponse;
import br.com.tech4me.musicas.view.model.MusicaResponsePorId;

@RestController
@RequestMapping("/api/techmusic")
public class MusicaController {
    @Autowired
    private MusicaService servico;
   
    @GetMapping
    public ResponseEntity<List<MusicaModeloResponse>> obterMusicas() {
        List<MusicaDto> musicasDto = servico.obterTodos();
        List<MusicaModeloResponse> musicasResponse = musicasDto.stream()
        .map(c -> new ModelMapper().map(c, MusicaModeloResponse.class))
        .collect(Collectors.toList());

        return new ResponseEntity<>(musicasResponse, HttpStatus.FOUND);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<MusicaResponsePorId> obterMusicaPorId(@PathVariable String id) {
        Optional<MusicaDto> musica = servico.obterMusicasPorId(id);

        if (musica.isPresent()){
            MusicaResponsePorId musicaResposta = new ModelMapper().map(musica.get(), MusicaResponsePorId.class);
          return new ResponseEntity<>(musicaResposta, HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @PostMapping()
    public ResponseEntity<MusicaModeloResponse> cadastrarMusica(@RequestBody MusicaModeloRequest musica) {
        MusicaDto musicaCadastro = new ModelMapper().map(musica, MusicaDto.class);
        musicaCadastro = servico.cadastrarMusica(musicaCadastro);
        MusicaModeloResponse musicaResponse = new ModelMapper().map(musicaCadastro, MusicaModeloResponse.class);
        return new ResponseEntity<>(musicaResponse, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirMusica(@PathVariable String id) {
        servico.removerMusica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MusicaDto> atualizarMusica(@PathVariable String id, @RequestBody MusicaDto novaMusica){
        Optional<MusicaDto> musica = servico.obterMusicasPorId(id);

        if (musica.isPresent()){
        return new ResponseEntity<>(servico.atualizarMusica(id, novaMusica), HttpStatus.ACCEPTED);
        }

        return new  ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
