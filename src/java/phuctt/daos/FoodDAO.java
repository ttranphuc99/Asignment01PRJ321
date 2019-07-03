/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import phuctt.db.DBConnection;
import phuctt.dtos.FoodDTO;

/**
 *
 * @author Thien Phuc
 */
public class FoodDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public boolean insert(FoodDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            conn = DBConnection.getConnection();

            if (conn != null) {
                String sql = "INSERT INTO tbl_Food(FoodID, FoodName, Price, Description, Type, Status) VALUES(?,?,?,?,?,?)";
                
                preStm = conn.prepareStatement(sql);
                
                preStm.setString(1, dto.getFoodID());
                preStm.setString(2, dto.getFoodName());
                preStm.setFloat(3, dto.getPrice());
                preStm.setString(4, dto.getDescription());
                preStm.setString(5, dto.getType());
                preStm.setString(6, dto.getStatus());
                
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<FoodDTO> findByPriceInRange(float minimum, float maximum) throws SQLException, ClassNotFoundException {
        List<FoodDTO> result = null;
        try {
            conn = DBConnection.getConnection();
            
            if (conn != null) {
                String sql = "SELECT FoodID, FoodName, Price, Description, Type, Status FROM tbl_Food WHERE Price >= ? AND Price <= ? AND Status = 'Available'";
                
                preStm = conn.prepareStatement(sql);
                preStm.setFloat(1, minimum);
                preStm.setFloat(2, maximum);
                rs = preStm.executeQuery();
                result = new ArrayList<>();
                
                String foodID, foodName, description, type, status;
                float price;
                FoodDTO dto;
                while (rs.next()) {
                    foodID = rs.getString("FoodID");
                    foodName = rs.getString("FoodName");
                    price = rs.getFloat("Price");
                    description = rs.getString("Description");
                    type = rs.getString("Type");
                    status = rs.getString("Status");
                    
                    dto = new FoodDTO(foodID, foodName, description, type, status, price);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public FoodDTO findByID(String id) throws SQLException, ClassNotFoundException {
        FoodDTO dto = null;
        try {
            conn = DBConnection.getConnection();
            
            if (conn != null) {
                String sql = "SELECT FoodID, FoodName, Price, Description, Type, Status FROM tbl_Food WHERE FoodID = ?";
                
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, id);
                rs = preStm.executeQuery();
                
                if (rs.next()) {
                    String foodID = rs.getString("FoodID");
                    String foodName = rs.getString("FoodName");
                    float price = Float.parseFloat(rs.getString("Price"));
                    String description = rs.getString("Description");
                    String type = rs.getString("Type");
                    String status = rs.getString("Status");
                    
                    dto = new FoodDTO(foodID, foodName, description, type, status, price);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean update(FoodDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            conn = DBConnection.getConnection();
            
            if (conn != null) {
                String sql = "UPDATE tbl_Food SET FoodName = ?, Price = ?, Description = ?, Type = ?, Status = ? WHERE FoodID = ?";
                
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, dto.getFoodName());
                preStm.setFloat(2, dto.getPrice());
                preStm.setString(3, dto.getDescription());
                preStm.setString(4, dto.getType());
                preStm.setString(5, dto.getStatus());
                preStm.setString(6, dto.getFoodID());
                
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            conn = DBConnection.getConnection();
            
            if (conn != null) {
                String sql = "UPDATE tbl_Food SET Status = ? WHERE FoodID = ?";
                
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, "Unavailable");
                preStm.setString(2, id);
                
                check = preStm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }
}
