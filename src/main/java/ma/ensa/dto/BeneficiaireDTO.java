package ma.ensa.dto;

import lombok.Data;
import ma.ensa.model.enumer.PAYS;
import ma.ensa.model.enumer.TITRE;

import java.util.Date;

@Data
public class BeneficiaireDTO {
    protected Long id;

    protected TITRE titre;
    protected String prenom;
    protected String nom;
    protected PAYS pays;

}
