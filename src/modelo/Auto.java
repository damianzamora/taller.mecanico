package modelo;

public class Auto {

    String placa;
    String marca;
    String modelo;

    public Auto(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Auto [placa=" + placa +
                ", marca=" + marca +
                ", modelo=" + modelo + "]";
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

}