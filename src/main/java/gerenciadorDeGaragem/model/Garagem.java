package gerenciadorDeGaragem.model;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Entity
public class Garagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    private List<Veiculo> veiculo;

    private int vaga;

    private boolean ocupada = false;




}
