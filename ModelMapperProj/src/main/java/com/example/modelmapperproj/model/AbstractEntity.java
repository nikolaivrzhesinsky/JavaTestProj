package com.example.modelmapperproj.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "createdDate", updatable = false)
    LocalDateTime createdDate;
    @Column(name="updatedData", insertable = false)
    LocalDateTime updatedDate;

    @PrePersist
    public void toCreat(){
        setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    public void toUpdate(){
        setUpdatedDate(LocalDateTime.now());
    }


}
