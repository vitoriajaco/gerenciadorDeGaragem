package gerenciadorDeGaragem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Proprietario {

    @Id
    private Long id;
    private String nome;
    private  String cpf;
    private  String email;
    private  String telefone;
}
