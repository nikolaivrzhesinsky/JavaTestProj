package com.example.modelmapperproj.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    Date createdDate;
    @Column(name="updatedData", insertable = false)
    Date updatedDate;

    @PrePersist
    public void toCreat(){
        setCreatedDate(new Date());
    }

    @PreUpdate
    public void toUpdate(){
        setUpdatedDate(new Date());
    }

//    Long id;
//    Date created;
//    Date updated;
//
//    @Id
//    @GeneratedValue
//    public Long getId() {
//        return id;
//    }
//
//    @Column(name = "created", updatable = false)
//    public Date getCreated() {
//        return created;
//    }
//
//    @Column(name = "updated", insertable = false)
//    public Date getUpdated() {
//        return updated;
//    }
//
//    @PrePersist
//    public void toCreate() {
//        setCreated(new Date());
//    }
//
//    @PreUpdate
//    public void toUpdate() {
//        setUpdated(new Date());
//    }


}
