/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entitys.Owner;
import entitys.Pet;
import java.util.Date;

/**
 *
 * @author Hassuni
 */
public class DTOPet {
    private Integer id;
    private String name, species;
    private String birth;
    private String owner;
    
    public DTOPet(Pet p){
        this.id = p.getId();
        this.name = p.getName();
        this.species = p.getSpecies();
        this.birth = p.getBirth().toString();
        this.owner = p.getOwnerId().getFirstName() + " " + p.getOwnerId().getLastName();
    }
    
    
    
//      public Pet(Integer id, String name, Date birth, String species) {
//        this.id = id;
//        this.name = name;
//        this.birth = birth;
//        this.species = species;
//    }

    
}
