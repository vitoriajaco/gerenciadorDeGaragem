package gerenciadorDeGaragem.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private  String cpf;
    private  String email;
    private  String telefone;


    //Um proprietario pode ter muitos veiculos entao do lado de cá da classe é um para muitos, ja do lado de veiculos
    // é o contrario para veiculos, sendo lá many to one
    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Veiculo> veiculos;
}
