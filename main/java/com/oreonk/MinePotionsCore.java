package com.oreonk;

import com.oreonk.commands.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.ArrayList;

public class MinePotionsCore extends JavaPlugin {
    public ArrayList<String> priv = new ArrayList<>();
    private static MinePotionsCore instance;
    public MySQL SQL;
    public SQLTable db;

    @Override
    public void onEnable(){
        priv.add("vip");priv.add("vipplus");priv.add("prem");priv.add("premplus");priv.add("luxeplus");priv.add("deluxe");priv.add("deluxeplus");priv.add("sponsor");priv.add("sponsorplus");
        instance = this;
        this.SQL = new MySQL();
        this.db = new SQLTable(this);
        try {
            SQL.connect();
        } catch (ClassNotFoundException e) {
            Bukkit.getServer().shutdown();
            Bukkit.getLogger().info("[CORE] Проблема бд");
        } catch (SQLException e) {
            Bukkit.getServer().shutdown();
            Bukkit.getLogger().info("[CORE] Проблема бд");
        }
        if (SQL.isConnected()){
            Bukkit.getLogger().info("[CORE] БД найдена!");
        }
        db.createTable();
        this.getCommand("mp").setExecutor(new Main());
    }
    public SQLTable getDatabase(){ return this.db; }
    @Override
    public void onDisable(){
        SQL.disconnect();
    }

    public static MinePotionsCore getInstance() {
        return instance;
    }

}
