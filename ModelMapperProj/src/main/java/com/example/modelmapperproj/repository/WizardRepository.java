package com.example.modelmapperproj.repository;

import com.example.modelmapperproj.model.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WizardRepository extends JpaRepository<Wizard,Long> {
}
