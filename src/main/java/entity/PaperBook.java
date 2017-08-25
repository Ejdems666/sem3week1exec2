package entity;

import javax.persistence.Entity;

/**
 * Created by adam on 8/25/2017.
 */
@Entity
public class PaperBook extends Book {
    private double shippingWeight;

    private int inStock;

    public double getShippingWeight() {
        return shippingWeight;
    }

    public void setShippingWeight(double shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
