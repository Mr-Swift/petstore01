package com.apple.developer.dao.impl;

import com.apple.developer.dao.IAdminDao;
import com.apple.developer.dao.IObjectMapper;
import com.apple.developer.entity.Admin;
import com.apple.developer.util.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements IAdminDao {

    @Override
    public List<Admin> listAll() throws SQLException {
        List<Admin> list= JdbcTemplate.executeQuery("select username,password from tb_admin", new IObjectMapper() {
            @Override
            public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                Admin admin=new Admin();
                admin.setUsername(resultSet.getString("username"));
                admin.setPassword(resultSet.getString("password"));
                return admin;
            }
        },null);
        return list;
    }
}
