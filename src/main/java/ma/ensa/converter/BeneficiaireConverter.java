package ma.ensa.converter;

import ma.ensa.dto.BeneficiaireDTO;
import ma.ensa.model.Beneficiaire;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class BeneficiaireConverter extends AbstractConverter<Beneficiaire, BeneficiaireDTO> {
    private final ModelMapper modelMapper;

    public BeneficiaireConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        this.modelMapper = modelMapper;
    }

    @Override
    public Beneficiaire convertToDM(BeneficiaireDTO clientDTO) {
        return modelMapper.map(clientDTO, Beneficiaire.class);
    }

    @Override
    public BeneficiaireDTO convertToDTO(Beneficiaire client) {
        return modelMapper.map(client, BeneficiaireDTO.class);
    }

}
