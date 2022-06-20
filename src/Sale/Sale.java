package Sale;

public class Sale {
    private String numNote;
    private float totalValue;
    private String paymentMethod;

    public String getNumNote(){
        return numNote;
    }

    public void setNumNote(){
        this.numNote = numNote;
    }

    public float getTotalValue(){
        return totalValue;
    }

    public void setTotalValue(){
        this.totalValue = totalValue;
    }

    public String getPaymentMethod(){
        return paymentMethod;
    }

    public void setPaymentMethod(){
        this.paymentMethod = paymentMethod;
    }
}
