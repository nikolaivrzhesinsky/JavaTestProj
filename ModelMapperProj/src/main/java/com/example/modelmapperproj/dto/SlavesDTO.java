package com.example.modelmapperproj.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlavesDTO extends AbstractDTO {

    private String filling;
    private Long wizardId;
}
