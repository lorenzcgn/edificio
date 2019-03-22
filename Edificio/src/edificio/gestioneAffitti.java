/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edificio;

/**
 *
 * @author Lorenzo
 */
public class gestioneAffitti {
    private String nApp;
    private int nGiorni;
    private double dn;
    private double fin;
    
    public gestioneAffitti(String nApp, int nGiorni, double dn, double fin) {
        this.dn=dn;
        this.fin=fin-dn;
        this.nApp=nApp;
        this.nGiorni=nGiorni;
    }
    
    affittuario mario=new affittuario("Mario", "MR001");

    public String getnApp() {
        return nApp;
    }

    public void setnApp(String nApp) {
        this.nApp = nApp;
    }

    public int getnGiorni() {
        return nGiorni;
    }

    public void setnGiorni(int nGiorni) {
        this.nGiorni = nGiorni;
    }

    public double getDn() {
        return dn;
    }

    public void setDn(int dn) {
        this.dn = dn;
    }

    public double getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
    
    public double calcolaCosti (){
        double costo=(double) (nGiorni*((0.5*dn)+(0.8*fin)));
        System.out.println("\n"+"Il costo complessivo per l'affittuario "+mario.getNome()+" con codice "+mario.getCodice()+" e' di: "+costo);
        return costo;
    }
}
