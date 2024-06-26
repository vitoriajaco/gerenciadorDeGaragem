package gerenciadorDeGaragem.service;

import gerenciadorDeGaragem.model.Garagem;
import gerenciadorDeGaragem.repository.GaragemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GaragemService {

    @Autowired
    private GaragemRepository garagemRepository;

    public List<Garagem> mostrarTodasAsGaragens() throws ResourceNotFoundException {
        List<Garagem> garagens = garagemRepository.findAll();
        if (garagens.isEmpty()){
            throw new ResourceNotFoundException("Ainda não há garagem cadastrada");
        }
        return garagens;
    }

    public Optional<Garagem> buscarGaragemPorId(Long id) {
        validaSeGaragemExiste(id);
        return garagemRepository.findById(id);
       }

    public void validaSeGaragemExiste(Long id){
        if (!garagemRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Garagem com id " + id + " não encontrada");
        }
    }

    public Garagem cadastrarGaragem(Garagem garagem) {
        return garagemRepository.save(garagem);
    }

    public Garagem alterarGaragem (Garagem garagem, Long id) throws GaragemSameIdException {
        if (!(garagem.getId().equals(id))){
            throw new GaragemSameIdException("Id de garagem não são iguais!");
        }
        validaSeGaragemExiste(id);
        return garagemRepository.save(garagem);
    }

    public void deletarGaragem(Long id){
        validaSeGaragemExiste(id);
        garagemRepository.deleteById(id);
    }
}
