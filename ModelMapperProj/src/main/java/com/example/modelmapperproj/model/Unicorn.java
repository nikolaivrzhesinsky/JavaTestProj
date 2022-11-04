package com.example.modelmapperproj.model;


import com.example.modelmapperproj.enums.Color;
import lombok.*;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="unicorns")
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Unicorn extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "unicorn")
    private List<Wizard> wizardList;

    @Column(name="color")
    private Color color;

}
