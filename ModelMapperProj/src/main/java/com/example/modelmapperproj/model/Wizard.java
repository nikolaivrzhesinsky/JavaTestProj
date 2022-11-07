package com.example.modelmapperproj.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "wizards")
@AllArgsConstructor
@NoArgsConstructor
public class Wizard extends AbstractEntity{

    @Column(name="name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unicorn_id")
    private Unicorn unicorn;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "wizard")
    private List<Slaves> slavesList;

    @Column(name="alive")
    private Boolean alive;

    public Wizard(Long id, String name, Unicorn unicorn, Boolean alive) {
        this.name = name;
        this.unicorn = unicorn;
        this.alive = alive;
    }

    public Wizard(Long id, String name, Boolean alive) {
        this.name = name;
        this.alive = alive;
    }
}
