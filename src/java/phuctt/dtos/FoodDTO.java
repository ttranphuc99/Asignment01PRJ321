/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.dtos;

import java.io.Serializable;

/**
 *
 * @author Thien Phuc
 */
public class FoodDTO implements Serializable {
    private String foodID, foodName, description, type, status;
    private float price;

    public FoodDTO() {
    }

    public FoodDTO(String foodID, String foodName, String description, String type, String status, float price) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.description = description;
        this.type = type;
        this.status = status;
        this.price = price;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
