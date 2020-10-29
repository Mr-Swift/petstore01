package com.apple.developer.test;

import com.apple.developer.dao.IPetStoreDao;
import com.apple.developer.dao.impl.PetStoreDaoImpl;
import com.apple.developer.entity.PetStore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class PetStoreDaoImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAll() throws SQLException {
        IPetStoreDao dao=new PetStoreDaoImpl();
        List<PetStore> list =null;
        list= dao.listAll();
        for(PetStore petStore:list){
            System.out.println(petStore);
        }
    }

    @Test
    public void insertPetStore() throws SQLException {
        IPetStoreDao dao=new PetStoreDaoImpl();
        dao.insertPetStore(new PetStore("南京禄口宠物商店"));
    }

    @Test
    public void findNameByid() throws SQLException {
        IPetStoreDao dao=new PetStoreDaoImpl();
        System.out.println(dao.findNameByid(3));
    }
}