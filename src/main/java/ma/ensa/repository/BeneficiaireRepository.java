package ma.ensa.repository;
import ma.ensa.model.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Long> {

}
