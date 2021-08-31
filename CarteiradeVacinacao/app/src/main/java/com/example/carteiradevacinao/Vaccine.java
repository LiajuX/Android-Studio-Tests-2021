package com.example.carteiradevacinao;

public class Vaccine {
    private Integer id_vaccine;
    private String name;
    private String date;
    private String clinic;
    private Integer dose;

    public Integer getId_vaccine() {
        return id_vaccine;
    }

    public void setId_vaccine(Integer id_vaccine) {
        this.id_vaccine = id_vaccine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }
}
