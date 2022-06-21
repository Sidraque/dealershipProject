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

    public void setNumNote(String numNote){
        this.numNote = this.numNote;
    }

    public float getTotalValue(){
        return totalValue;
    }

    public void setTotalValue(float totalValue){
        this.totalValue = this.totalValue;
    }

    public String getPaymentMethod(){
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = this.paymentMethod;
    }
}
