package com.example.modelmapperproj.repository;

import com.example.modelmapperproj.model.Unicorn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnicornRepository extends JpaRepository<Unicorn,Long> {
}
