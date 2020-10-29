package com.apple.developer.test;

import com.apple.developer.dao.IAdminDao;
import com.apple.developer.dao.impl.AdminDaoImpl;
import com.apple.developer.entity.Admin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AdminDaoImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAll() throws SQLException {
        IAdminDao dao=new AdminDaoImpl();
        List<Admin> list=dao.listAll();
        for(Admin admin:list){
            System.out.println(admin);
        }
    }
}