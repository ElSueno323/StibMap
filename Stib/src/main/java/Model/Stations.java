/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author <@Gabriel.espinosa>
 */
public class Stations {

    private int idStations;
    private String name;

    public Stations(int id,String name) {
        idStations=id;
        this.name=name;
    }

    public int getIdStations() {
        return idStations;
    }

    public void setIdStations(int idStations) {
        this.idStations = idStations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stations other = (Stations) obj;
        if (this.idStations != other.idStations) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
}







