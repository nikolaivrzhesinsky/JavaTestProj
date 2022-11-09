package com.example.modelmapperproj.controller;

import com.example.modelmapperproj.dto.WizardDTO;
import com.example.modelmapperproj.service.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/wizard")
@RestController
public class WizardController {

    private final WizardService wizardService;

    @Autowired
    public WizardController(WizardService wizardService) {
        this.wizardService = wizardService;
    }

    @PostMapping("/save")
    public ResponseEntity<WizardDTO> saveWizard(@RequestBody WizardDTO dto){

        return new ResponseEntity<>(wizardService.save(dto), HttpStatus.OK);
    }

    @GetMapping("/getOne/{id}")
    public  ResponseEntity<WizardDTO> getOne(@PathVariable Long id){

        return new ResponseEntity<>(wizardService.get(id), HttpStatus.OK);
    }

    @PostMapping("/addUnicorn/{unicornId}/to/{wizardId}")
    public ResponseEntity<WizardDTO> addUnicornToWizard(@PathVariable Long unicornId,
                                                        @PathVariable Long wizardId){

        WizardDTO wizardDTO=wizardService.addUnicornToWizard(unicornId, wizardId);
        return new ResponseEntity<>(wizardDTO,HttpStatus.OK);
    }


}
