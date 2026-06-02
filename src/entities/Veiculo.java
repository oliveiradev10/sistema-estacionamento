package entities;


import enums.CategoriaVeiculo;

public class Veiculo {
    private String placa;
    private String modelo;
    private CategoriaVeiculo categoria;

    public Veiculo(String placa, String modelo, CategoriaVeiculo categoria) {
        this.placa = placa;
        this.modelo = modelo;
        this.categoria = categoria;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public CategoriaVeiculo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaVeiculo categoria) {
        this.categoria = categoria;
    }
}

