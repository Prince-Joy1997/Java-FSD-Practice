package in.stackroute.ust.domain;

public class Item {
    // class used to represent the items in the inventory
    private int item_id;
    private String item_Name;
    private String item_Description;
    private  float item_Price;
    private int item_Quantity;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_Name() {
        return item_Name;
    }

    public void setItem_Name(String item_Name) {
        this.item_Name = item_Name;
    }

    public String getItem_Description() {
        return item_Description;
    }

    public void setItem_Description(String item_Description) {
        this.item_Description = item_Description;
    }

    public float getItem_Price() {
        return item_Price;
    }

    public void setItem_Price(float item_Price) {
        this.item_Price = item_Price;
    }

    public int getItem_Quantity() {
        return item_Quantity;
    }

    public void setItem_Quantity(int item_Quantity) {
        this.item_Quantity = item_Quantity;
    }
}
