package gerenciadorDeGaragem.repository;

import gerenciadorDeGaragem.model.Garagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GaragemRepository extends JpaRepository<Garagem, Long> {
}
