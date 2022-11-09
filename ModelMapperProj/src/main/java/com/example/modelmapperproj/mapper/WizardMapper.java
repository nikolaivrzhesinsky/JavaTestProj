package com.example.modelmapperproj.mapper;

import com.example.modelmapperproj.dto.WizardDTO;
import com.example.modelmapperproj.model.Wizard;
import com.example.modelmapperproj.repository.UnicornRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class WizardMapper extends AbstractMapper<Wizard, WizardDTO> {

    private final ModelMapper mapper;
    private final UnicornRepository unicornRepository;

    @Autowired
    public WizardMapper(ModelMapper mapper, UnicornRepository unicornRepository) {
        super(Wizard.class, WizardDTO.class);
        this.mapper = mapper;
        this.unicornRepository = unicornRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Wizard.class, WizardDTO.class)
                .addMappings(m -> m.skip(WizardDTO::setUnicornId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(WizardDTO.class, Wizard.class)
                .addMappings(m -> m.skip(Wizard::setUnicorn)).setPostConverter(toEntityConverter());
    }

    @Override
    public void mapSpecificFields(Wizard source, WizardDTO destination) {

        if(getId(source)!=null){
            destination.setUnicornId(getId(source));
        }
        else {
            destination.setUnicornId(null);
        }
    }

    private Long getId(Wizard source) {
        return Objects.isNull(source) || Objects.isNull(source.getId())|| source.getUnicorn()==null
                ? null : source.getUnicorn().getId();
    }

    @Override
    void mapSpecificFields(WizardDTO source, Wizard destination) {
        if(source.getUnicornId()!=null) {
            destination.setUnicorn(unicornRepository.findById(source.getUnicornId()).orElse(null));
        }
        else {
            destination.setUnicorn(null);
        }
    }
}