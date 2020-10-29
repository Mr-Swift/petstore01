package com.apple.developer.dao;

import com.apple.developer.entity.PetStore;

import java.sql.SQLException;
import java.util.List;

public interface IPetStoreDao {
    public List<PetStore> listAll() throws SQLException;
    public int insertPetStore(PetStore petStore) throws SQLException;
    public String findNameByid(int ps_id) throws SQLException;
}
