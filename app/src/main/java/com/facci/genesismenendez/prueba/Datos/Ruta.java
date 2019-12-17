package com.facci.genesismenendez.prueba.Datos;

public class Ruta {
    private String ruta;
    private String origen;
    private String destino;
    private String compania;
    private String email;

    public Ruta(String ruta, String origen, String destino, String compania, String email) {
        this.ruta = ruta;
        this.origen = origen;
        this.destino = destino;
        this.compania = compania;
        this.email = email;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
