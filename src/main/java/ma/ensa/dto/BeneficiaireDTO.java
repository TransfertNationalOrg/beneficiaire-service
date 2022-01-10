package ma.ensa.dto;

import lombok.Data;
import ma.ensa.model.enumer.PAYS;
import ma.ensa.model.enumer.TITRE;

import java.util.Date;

@Data
public class BeneficiaireDTO {
    private Long id;

    private TITRE titre;
    private String prenom;
    private String nom;
    private PAYS pays;

}
