package ma.ensa.model;

import lombok.Data;
import ma.ensa.model.enumer.PAYS;
import ma.ensa.model.enumer.TITRE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

@Data
@Entity
public class Beneficiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private TITRE titre;
    private String prenom;
    private String nom;
    private PAYS pays;

}
