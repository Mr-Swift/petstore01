package com.apple.developer.dao.impl;

import com.apple.developer.dao.IObjectMapper;
import com.apple.developer.dao.IPetDao;
import com.apple.developer.entity.Pet;
import com.apple.developer.util.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PetDaoImpl implements IPetDao {
    @Override
    public List<Pet> listAll() throws SQLException {
        List<Pet> list= JdbcTemplate.executeQuery("select p_id,p_name,health,birthday,addr from tb_pet", new IObjectMapper() {
            @Override
            public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                Pet pet = new Pet();
                pet.setP_id(resultSet.getInt("p_id"));
                pet.setP_name(resultSet.getString("p_name"));
                pet.setHealth(resultSet.getInt("health"));
                pet.setBirthday(resultSet.getString("birthday"));
                pet.setAddress(resultSet.getString("addr"));
                return pet;
            }
        },null);
        return list;
    }

    @Override
    public int insertPet(Pet pet) throws SQLException {
        return JdbcTemplate.executeUpdate("insert into tb_pet (p_name,health,birthday,addr) values (?,?,?,?)",pet.getP_name(),pet.getHealth(),pet.getBirthday(),pet.getAddress());
    }

    @Override
    public int updatePet(Pet pet) throws SQLException {
        return JdbcTemplate.executeUpdate("update tb_pet set p_name=?,health=?,birthday=?,addr=? where p_id=?",pet.getP_name(),pet.getHealth(),pet.getBirthday(),pet.getAddress(),pet.getP_id());
    }

    @Override
    public int deletePet(int p_id) throws SQLException {
        return JdbcTemplate.executeUpdate("delete from tb_pet where p_id=?",p_id);
    }

    @Override
    public List<Pet> listByAddress(String p_name) throws SQLException {
        List<Pet> list = JdbcTemplate.executeQuery("select p_id,p_name,health,birthday,addr from tb_pet where addr= ? ", new IObjectMapper() {
            @Override
            public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                Pet pet = new Pet();
                pet.setP_id(resultSet.getInt("p_id"));
                pet.setP_name(resultSet.getString("p_name"));
                pet.setBirthday(resultSet.getString("birthday"));
                pet.setHealth(resultSet.getInt("health"));
                pet.setAddress(resultSet.getString("addr"));
                return pet;
            }
        }, p_name);
        return list;
    }
}
