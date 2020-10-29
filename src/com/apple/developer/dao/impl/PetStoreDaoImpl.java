package com.apple.developer.dao.impl;

import com.apple.developer.dao.IObjectMapper;
import com.apple.developer.dao.IPetStoreDao;
import com.apple.developer.entity.PetStore;
import com.apple.developer.util.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author air
 */
public class PetStoreDaoImpl implements IPetStoreDao {
    @Override
    public List<PetStore> listAll() throws SQLException {
        List<PetStore> list= JdbcTemplate.executeQuery("select ps_id,ps_name from tb_petstore", new IObjectMapper() {
            @Override
            public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                PetStore petStore=new PetStore();
                petStore.setPs_id(resultSet.getInt("ps_id"));
                petStore.setPs_name(resultSet.getString("ps_name"));
                return petStore;
            }
        },null);
        return list;
    }

    @Override
    public int insertPetStore(PetStore petStore) throws SQLException {
        return JdbcTemplate.executeUpdate("insert into tb_petstore (ps_name) values (?) ",petStore.getPs_name());
    }

    @Override
    public String findNameByid(int ps_id) throws SQLException {
//        System.out.println(ps_id);
//        System.exit(0);

        List<PetStore> list=JdbcTemplate.executeQuery("select ps_id,ps_name from tb_petstore where ps_id=?", new IObjectMapper() {
            @Override
            public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException {
                PetStore petStore=new PetStore();
                petStore.setPs_id(resultSet.getInt("ps_id"));
                petStore.setPs_name(resultSet.getString("ps_name"));
                return petStore;
            }
        },ps_id);
//        List<String> nameList=new ArrayList<>();
//        for(PetStore petStore:list){
//            nameList.add(petStore.getPs_name());
//        }
//        String nameReturn=list.get(0).getPs_name();
        return list.get(0).getPs_name();
    }
}
