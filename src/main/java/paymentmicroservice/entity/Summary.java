package paymentmicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Summary {
    @Id
    private String orderId;
    private String modOfPayment;
    private String transactionId;
    private boolean isSuccess;
    private float amount;
    private Date date;
    public  Summary(){}
    public Summary(String orderId, String modOfPayment, String transactionId, boolean isSuccess, float amount, Date date) {
        this.orderId = orderId;
        this.modOfPayment = modOfPayment;
        this.transactionId = transactionId;
        this.isSuccess = isSuccess;
        this.amount = amount;
        this.date = date;
    }

    public String getorderId() {
        return orderId;
    }

    public void setorderId(String orderId) {
        this.orderId = orderId;
    }

    public String getModOfPayment() {
        return modOfPayment;
    }

    public void setModOfPayment(String modOfPayment) {
        this.modOfPayment = modOfPayment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
