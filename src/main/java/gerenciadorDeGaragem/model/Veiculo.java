package gerenciadorDeGaragem.model;

import gerenciadorDeGaragem.enums.Automovel;
import gerenciadorDeGaragem.enums.Marca;
import jakarta.persistence.*;

public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Como aqui cada proprietario pode ter muitos veiculos do lado de ca da classe fica many to one
    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    @ManyToOne
    @JoinColumn(name = "garagem_id")
    private Garagem garagem;

    @Enumerated
    private Automovel automovel;

    @Enumerated
    private Marca marca;

    private String cor;

    private String modelo;

    private String placa;
    
}
