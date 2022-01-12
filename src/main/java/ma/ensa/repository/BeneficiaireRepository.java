package ma.ensa.repository;
import ma.ensa.model.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Long> {

}
