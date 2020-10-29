package com.apple.developer.dao;

import com.apple.developer.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public interface IAdminDao {
    public List<Admin> listAll() throws SQLException;
}
