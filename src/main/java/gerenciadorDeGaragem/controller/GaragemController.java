package gerenciadorDeGaragem.controller;

import gerenciadorDeGaragem.exceptions.GaragemNotFoundException;
import gerenciadorDeGaragem.model.Garagem;
import gerenciadorDeGaragem.service.GaragemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/garagem")
public class GaragemController {

    @Autowired
    GaragemService garagemService;

    @GetMapping
    public ResponseEntity<List<Garagem>> mostrarTodasGaragens(){
        List<Garagem> listarGaragem = garagemService.mostrarTodasAsGaragens();
        return ResponseEntity.ok().body(listarGaragem);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Garagem> buscarGaragemPorId(@PathVariable Long id){
        Garagem garagem = garagemService.buscarGaragemPorId(id)
                .orElseThrow(() -> new GaragemNotFoundException("Garagem não encontrada"));
        return ResponseEntity.ok().body(garagem);
    }
}
