/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import DTO.DTOPet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entitys.Pet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Hassuni
 */
public class DataFacade {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public static EntityManager getManager() {
        return emf.createEntityManager();
    }

    public List<DTOPet> getAllAlivePets() {
        EntityManager em = getManager();
        try {
            List<Pet> pets = em.createQuery("SELECT p FROM Pet p").getResultList();
            List<DTOPet> dtoPets = new ArrayList();

            for (Pet p : pets) {
                if (p.getDeath() == null) {
                    DTOPet dp = new DTOPet(p);
                    dtoPets.add(dp);
                }
            }
            return dtoPets;
        } finally {
            em.close();
        }
    }
    
    public static List<DTOPet> getAllPetsEventOnDay() {
        EntityManager em = getManager();
        try {
            List<Pet> pets = em.createQuery("SELECT p FROM Pet p").getResultList();
           // List<DTOPet> dtoPets = em.createQuery("SELECT NEW DTO.DTOPet(p) FROM Person p").getResultList();
           //  List<DTOPet> dtoPets = em.createQuery("SELECT NEW DTO.DTOPet(p.id, p.name, p.owner, p.evet) FROM Person p").getResultList();
            List<DTOPet> dtoPets = new ArrayList();

            for (Pet p : pets) {
                DTOPet dp = new DTOPet(p);
                dtoPets.add(dp);
            }
            return dtoPets;
        } finally {
            em.close();
        }
    }
    

    public List<DTOPet> getAllPets() {
        EntityManager em = getManager();
        try {
            List<Pet> pets = em.createQuery("SELECT p FROM Pet p").getResultList();
            List<DTOPet> dtoPets = new ArrayList();

            for (Pet p : pets) {
                DTOPet dp = new DTOPet(p);
                dtoPets.add(dp);
            }
            return dtoPets;
        } finally {
            em.close();
        }
    }
    
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {

//        System.out.println(getAllPets());
//        System.out.println(getAllPets().size());

    }

}
