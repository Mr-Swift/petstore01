package com.apple.developer.dao;

import com.apple.developer.entity.Pet;

import java.sql.SQLException;
import java.util.List;

public interface IPetDao {
    public List<Pet> listAll() throws SQLException;
    public int insertPet(Pet pet) throws SQLException;
    public int updatePet(Pet pet) throws SQLException;
    public int deletePet(int p_id) throws SQLException;
    public List<Pet> listByAddress(String p_name) throws SQLException;
}
