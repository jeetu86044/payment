package paymentmicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Summary {
    @Id
    private int cartId;
    private String modOfPayment;
    private String transactionId;
    private boolean isSuccess;
    private float amount;
    public  Summary(){}
    public Summary(int cartId, String modOfPayment, String transactionId, boolean isSuccess, float amount) {
        this.cartId = cartId;
        this.modOfPayment = modOfPayment;
        this.transactionId = transactionId;
        this.isSuccess = isSuccess;
        this.amount = amount;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getModOfPayment() {
        return modOfPayment;
    }

    public void setModOfPayment(String modOfPayment) {
        this.modOfPayment = modOfPayment;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
