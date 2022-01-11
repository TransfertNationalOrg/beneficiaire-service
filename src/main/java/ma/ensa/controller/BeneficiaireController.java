package ma.ensa.controller;

import lombok.Data;
import ma.ensa.Transfert.TransfertDTO;
import ma.ensa.Transfert.TransfertFeign;
import ma.ensa.converter.BeneficiaireConverter;
import ma.ensa.dto.BeneficiaireDTO;
import ma.ensa.repository.BeneficiaireRepository;
import ma.ensa.service.BeneficiaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("beneficiaire")
@Data
public class BeneficiaireController {
    final BeneficiaireService beneficiaireService;
    final BeneficiaireConverter beneficiaireConverter;
    final TransfertFeign transfertFeign;

    final BeneficiaireRepository beneficiaireRepository;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody BeneficiaireDTO beneficiaireDTO) throws Exception {
        if (beneficiaireDTO == null)
            return ResponseEntity.badRequest().body("The provided beneficiaire is not valid");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(beneficiaireConverter.convertToDTO(beneficiaireService.save(beneficiaireConverter.convertToDM(beneficiaireDTO))));
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody BeneficiaireDTO beneficiaireDTO) throws Exception {
        if (beneficiaireDTO == null)
            return ResponseEntity.badRequest().body("The provided beneficiaire is not valid");
        return ResponseEntity
                .ok().body(beneficiaireConverter.convertToDTO(beneficiaireService.update(beneficiaireConverter.convertToDM(beneficiaireDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        if(id == null)
            return ResponseEntity.badRequest().body("The provided beneficiaire's id is not valid");
        return ResponseEntity.ok().body("Client [" + beneficiaireService.delete(id) + "] deleted successfully.");
    }

    @GetMapping("/")
    public ResponseEntity<List<BeneficiaireDTO>> findAll() {
        return ResponseEntity.ok().body(beneficiaireConverter.convertToDTOs(beneficiaireService.findAll()));
    }

    //Get all transferts by beneficiaire from transfert-service
    @GetMapping("/allTransferts/idBeneficiaire")
    public List<TransfertDTO> getAllTransfertsByBeneficiaire(@PathVariable("idBeneficiaire") Long idBeneficiaire){
        return transfertFeign.getTransfertsBybeneficiaire(idBeneficiaire);
    }

    //Get beneficiaire by id
    @GetMapping("{id}")
    public BeneficiaireDTO getBeneficiaireById(@PathVariable("id") Long id){
        return beneficiaireConverter.convertToDTO(beneficiaireRepository.getById(id));
    }
}
