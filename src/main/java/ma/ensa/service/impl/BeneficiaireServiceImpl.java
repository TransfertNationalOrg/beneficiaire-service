package ma.ensa.service.impl;

import lombok.Data;
import ma.ensa.exception.DuplicatedException;
import ma.ensa.exception.NotFoundException;
import ma.ensa.model.Beneficiaire;
import ma.ensa.repository.BeneficiaireRepository;
import ma.ensa.service.BeneficiaireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class BeneficiaireServiceImpl implements BeneficiaireService {
    final BeneficiaireRepository beneficiaireRepository;

    @Override
    public Beneficiaire save(Beneficiaire client) throws DuplicatedException {
        Beneficiaire clientFromDB = beneficiaireRepository.findById(client.getId()).orElse(null);
        if (clientFromDB != null)
            throw new DuplicatedException(client.getId());
        return beneficiaireRepository.save(client);
    }

    @Override
    public Beneficiaire update(Beneficiaire client) throws NotFoundException {
        Beneficiaire clientFromDB = beneficiaireRepository.findById(client.getId()).orElse(null);
        if (clientFromDB == null)
            throw new NotFoundException(client.getId());
        client.setId(clientFromDB.getId());
        return beneficiaireRepository.save(client);
    }

    @Override
    public Long delete(Long id) throws NotFoundException {
        Beneficiaire clientFromDB = beneficiaireRepository.findById(id).orElse(null);
        if (clientFromDB == null)
            throw new NotFoundException(id);
        beneficiaireRepository.delete(clientFromDB);
        return id;
    }

    @Override
    public List<Beneficiaire> findAll() {
        return beneficiaireRepository.findAll();
    }
}
