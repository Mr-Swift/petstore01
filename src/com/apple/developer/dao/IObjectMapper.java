package com.apple.developer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IObjectMapper {
    public Object getObjectFromResultSet(ResultSet resultSet) throws SQLException;
}
