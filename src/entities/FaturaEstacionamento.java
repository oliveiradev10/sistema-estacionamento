package entities;

public class FaturaEstacionamento {

    private double valorBase;
    private double taxa;
    private double valorTotal;


    public FaturaEstacionamento(double valorBase, double taxa, double valorTotal) {
        this.valorBase = valorBase;
        this.taxa = taxa;
        this.valorTotal = valorTotal;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
