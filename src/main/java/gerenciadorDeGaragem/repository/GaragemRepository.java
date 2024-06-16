package gerenciadorDeGaragem.repository;

import gerenciadorDeGaragem.model.GaragemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GaragemRepository extends JpaRepository<GaragemModel, Long> {
}
