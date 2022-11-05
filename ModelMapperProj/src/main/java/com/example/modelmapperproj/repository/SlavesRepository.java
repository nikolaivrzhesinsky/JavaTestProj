package com.example.modelmapperproj.repository;

import com.example.modelmapperproj.model.Slaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlavesRepository extends JpaRepository<Slaves,Long> {
}
