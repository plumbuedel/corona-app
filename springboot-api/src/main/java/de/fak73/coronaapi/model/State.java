package de.fak73.coronaapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

/**
 * State
 */
@Entity
@Getter
@Setter
public class State {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Lob
    private String information;

}