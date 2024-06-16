package gerenciadorDeGaragem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Garagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Proprietario proprietario;

    private Veiculo veiculo;

    private int vaga;

    private boolean ocupada;








}
