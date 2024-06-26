package gerenciadorDeGaragem.controller;

import gerenciadorDeGaragem.exceptions.GaragemNotFoundException;
import gerenciadorDeGaragem.model.Garagem;
import gerenciadorDeGaragem.service.GaragemSameIdException;
import gerenciadorDeGaragem.service.GaragemService;
import gerenciadorDeGaragem.service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Garagem> cadastrarGaragem (@RequestBody Garagem garagem){
       garagem = garagemService.cadastrarGaragem(garagem);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(garagem.getId()).toUri(); // Cria uma URI para o novo recurso criado.
        // A URI é baseada na requisição atual e inclui o ID da garagem recém-criada.
        // Isso é útil para seguir a prática RESTful de retornar a localização do novo recurso no cabeçalho Location da resposta.
        return ResponseEntity.created(uri).body(garagem);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Garagem> alterarGaragem (@PathVariable Long id, @RequestBody Garagem garagem) throws GaragemSameIdException {
        Garagem garagemAlterada = garagemService.alterarGaragem(garagem, id);
        return ResponseEntity.ok(garagemAlterada);
    }

    public ResponseEntity<Void>deletarGaragem (@PathVariable Long id){
        garagemService.deletarGaragem(id);
        return ResponseEntity.noContent().build();
    }
}
