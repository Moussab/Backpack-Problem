/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp1_tpgo;

/**
 *
 * @author golden Boy
 */

public class ObjectImage {
    private String valeur;
    private String poid;
    private String id;
    private int i;
    private int j;

    public ObjectImage(String valeur, String poid, int i, int j) {
        this.valeur = valeur;
        this.poid = poid;
        this.i = i;
        this.j = j;
    }

    public ObjectImage(String valeur, String poid, String id, int i, int j) {
        this.valeur = valeur;
        this.poid = poid;
        this.id = id;
        this.i = i;
        this.j = j;
    }

    public ObjectImage(String valeur, String poid, String id) {
        this.valeur = valeur;
        this.poid = poid;
        this.id = id;
    }

    public String getValeur() {
        return valeur;
    }

    public String getPoid() {
        return poid;
    }

    public String getId() {
        return id;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public void setPoid(String poid) {
        this.poid = poid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
}
