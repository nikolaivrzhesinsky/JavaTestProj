package com.example.modelmapperproj.controller;


import com.example.modelmapperproj.dto.UnicornDTO;
import com.example.modelmapperproj.service.UnicornService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/unicorn")
@RestController
public class UnicornController {

    private final UnicornService unicornService;

    @Autowired
    public UnicornController(UnicornService unicornService) {
        this.unicornService = unicornService;
    }

    @PostMapping("/save")
    public ResponseEntity<UnicornDTO> saveUnicorn(@RequestBody UnicornDTO unicornDTO){

        return ResponseEntity.ok(unicornService.save(unicornDTO));
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<UnicornDTO> getOne(@PathVariable Long id){

        return ResponseEntity.ok(unicornService.get(id));
    }


}
