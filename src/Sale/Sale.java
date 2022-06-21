package Sale;

public class Sale {
    private int codSale;
    private String numNote;
    private float totalValue;
    private String paymentMethod;

    public int getCodSale() {
        return codSale;
    }

    public void setCodSale(int codSale) {
        this.codSale = codSale;
    }

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
