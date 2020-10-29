package com.apple.developer.test;

import com.apple.developer.dao.IPetDao;
import com.apple.developer.dao.impl.PetDaoImpl;
import com.apple.developer.entity.Pet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PetDaoImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAll() throws SQLException {
        IPetDao dao = new PetDaoImpl();
        List<Pet> list=null;
        list= dao.listAll();
        for(Pet pet:list){
            System.out.println(pet);
        }
    }

    @Test
    public void insertPet() throws SQLException {
        IPetDao dao=new PetDaoImpl();
        int suc=dao.insertPet(new Pet("小黄狗",100,"2020-10-29","南京禄口宠物商店"));
        System.out.println(suc);
    }

    @Test
    public void updatePet() throws SQLException {
        IPetDao dao=new PetDaoImpl();
        dao.updatePet(new Pet(4,"狮子狗",99,"1999-02-18","南京随家仓宠物商店"));
    }

    @Test
    public void deletePet() throws SQLException {
        IPetDao dao=new PetDaoImpl();
        dao.deletePet(4);
    }

    @Test
    public void listByAddress() throws SQLException {
        IPetDao dao=new PetDaoImpl();
        List<Pet> list=null;
        list=dao.listByAddress("南京禄口宠物商店");
        for(Pet pet:list){
            System.out.println(pet);
        }
    }
}