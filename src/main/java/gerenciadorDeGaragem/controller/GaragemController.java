package gerenciadorDeGaragem.controller;

import gerenciadorDeGaragem.exceptions.GaragemNotFoundException;
import gerenciadorDeGaragem.model.Garagem;
import gerenciadorDeGaragem.service.GaragemService;
import gerenciadorDeGaragem.service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/garagem")
public class GaragemController {

    @Autowired
    GaragemService garagemService;

    @GetMapping
    public ResponseEntity<List<Garagem>> mostrarTodasGaragens() throws ResourceNotFoundException {
        List<Garagem> listarGaragem = garagemService.mostrarTodasAsGaragens();
        return ResponseEntity.ok().body(listarGaragem);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Garagem> buscarGaragemPorId(@PathVariable Long id){
        Garagem garagem = garagemService.buscarGaragemPorId(id)
                .orElseThrow(() -> new GaragemNotFoundException("Garagem não encontrada"));
        return ResponseEntity.ok().body(garagem);
    }

    @PostMapping
    public Garagem cadastrarGaragem (@RequestBody Garagem garagem){
        return garagemService.cadastrarGaragem(garagem);
    }
}
