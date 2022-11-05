package com.example.modelmapperproj.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WizardDTO extends AbstractDTO{

    private String name;
    private List<SlavesDTO> slavesDTOList;
    private Long unicornId;
    private Boolean alive;
}
