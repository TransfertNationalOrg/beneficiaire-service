package ma.ensa.service;

import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import ma.ensa.model.Beneficiaire;

import java.util.List;

public interface BeneficiaireService {
    Beneficiaire save(Beneficiaire client) throws DuplicatedException;
    Beneficiaire update(Beneficiaire client) throws NotFoundException;
    Long delete(Long id) throws NotFoundException;
    List<Beneficiaire> findAll();
}
