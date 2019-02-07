
package edificio;
import java.util.*;



public class Appartamento {
    Scanner s = new Scanner(System.in);
    private int numPiano;
    private int numProp;
    private int numInterno;
    private int numeroStanze;
    private int vol;
    private int sup;
    private int supDisp;
    private int supDispN;
    
    Stanza Stanze[]=new Stanza[numeroStanze];
            
    public Appartamento(int numPiano, int numProp, int numInterno, int numeroStanze, int vol, int sup, int supDisp, int supDispN) {
	this.numPiano = numPiano;
	this.numProp = numProp;
	this.numInterno = numInterno;
    this.numeroStanze = numeroStanze;
    this.vol=vol;
    this.sup=sup;
    this.supDisp=supDisp;
    this.supDispN=supDispN;
	}

    public int getNumPiano() {
        return numPiano;
    }

    public void setNumPiano(int numPiano) {
        this.numPiano = numPiano;
    }

    public int getNumProp() {
        return numProp;
    }

    public void setNumProp(int numProp) {
        this.numProp = numProp;
    }

    public int getNumInterno() {
        return numInterno;
    }

    public void setNumInterno(int numInterno) {
        this.numInterno = numInterno;
    }

    public int getNumeroStanze() {
        return numeroStanze;
    }

    public void setNumeroStanze(int numeroStanze) {
        this.numeroStanze = numeroStanze;
    }
    
    public void setVol(int vol) {
    	this.vol=vol;
    }
    
    public int getVol() {
    	return vol;
    }
    
    public void setSup(int sup) {
    	this.sup=sup;
    }
    
    public int getSup() {
    	return sup;
    }
    
    public void setSupDisp(int supDisp) {
    	this.supDisp=supDisp;
    }
    
    public int getSupDisp() {
    	return supDisp;
    }
    
    public void setSupDispN(int supDispN) {
    	this.supDispN=supDispN;
    }
    
    public int getSupDispN() {
    	return supDispN;
    }
    
    
    
    public void chiediDatiAppartamento() {
	  System.out.println("Inserisci il numero del piano:");
	  do{
		  this.setNumPiano(s.nextInt());
	  }while(this.numPiano<1);
	  System.out.println("Inserisci il numero dei proprietari di questo appartamento:");
	  do {
		  this.setNumProp(s.nextInt());
	  }while(this.numProp<1);
	  System.out.println("Inserisci il numero dell'interno");
	  do {
		  this.setNumInterno(s.nextInt());
          }while(this.numInterno<1);
          
    }
    
    int var=0;
    
    public void addStanza(Stanza st) {
    	do {
        for (int i=0; i<7; i++) {
            if (Stanze[i]==null){
                Stanze[i]=st;
                System.out.println("Stanza aggiunta:"+Stanze[i]);
                this.setVol(this.getVol() + Stanze[i].calcolaVolume());
                this.setSup(this.getSup() + Stanze[i].calcolaSupTot());
                this.setSupDisp(this.getSupDisp() + Stanze[i].supDisperdenteLorda());
                this.setSupDispN(this.getSupDispN() + Stanze[i].supDisperdenteNetta());
                var++;
            }
        }
    	}while(var<0);
    }
   
    
    /* Metodo per chiedere in input i dati (al momento inusato) */
    /*
    
    public void chiediDatiStanze() {
    
    int numeroSt;
    System.out.println("Inserisci il numero delle stanze dell'appartamento");
    
    do{
        numeroSt=s.nextInt();
    }while(numeroSt<0 || numeroSt>7);
    }                                        */
   
    
    
      











}
