package com.example.modelmapperproj.model;


import com.example.modelmapperproj.enums.Filling;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="cupcakes")
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Slaves extends AbstractEntity {

    @Column(name="filling")
    private Filling filling;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wizard_id")
    private Wizard wizard;

    public Slaves(Filling filling){
        this.filling=filling;
    }


}
