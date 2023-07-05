package com.oreonk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLTable {

    private MinePotionsCore plugin;
    public SQLTable(MinePotionsCore plugin){
        this.plugin=plugin;
    }

    public void createTable(){
        try {
            Connection connection = plugin.SQL.getConnection();
            PreparedStatement ps;
            ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS anarchy (" +
            "`NAME` VARCHAR NOT NULL," +
            "`UUID` VARCHAR NOT NULL," +
            "`TIME` VARCHAR NOT NULL," +
            "`DONATE` VARCHAR," +
            "PRIMARY KEY (`NAME`)" +
            ");"
            );
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
