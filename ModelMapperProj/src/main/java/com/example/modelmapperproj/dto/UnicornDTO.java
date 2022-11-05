package com.example.modelmapperproj.dto;


import com.example.modelmapperproj.model.Wizard;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UnicornDTO extends AbstractDTO {

    private  String name;
    private List<WizardDTO> wizardDTOList;
    private String color;
}
