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
    
    Stanza Stanze[];
    Proprietario Proprietari[];
            
    public Appartamento(int numPiano, int numProp, int numInterno, int numeroStanze, int vol, int sup, int supDisp, int supDispN) {
    this.numPiano = numPiano;
    this.numProp = numProp;
    this.numInterno = numInterno;
    this.numeroStanze = numeroStanze;
    this.vol=vol;
    this.sup=sup;
    this.supDisp=supDisp;
    this.supDispN=supDispN;
    Stanze = new Stanza[numeroStanze];
    Proprietari = new Proprietario[numProp];
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
        
    Proprietario P1=new Proprietario("","","");
    Proprietario P2=new Proprietario("","","");
    
    
    public void settaProprietari(int numProp) {
        for (int i=0; i<numProp; i++) {
            Proprietari[i]=P1;
        }
        for (int i=0; i<numProp; i++) {
            Proprietari[i].chiediDatiProp();
        }
        
    
    }
    
    public void addStanza(Stanza st) {
    
    	int var=0;
        for (int i=0; i<6; i++) {
            if (Stanze[i]==null){
            	if (var==0) {
            		Stanze[i]=st;
                        System.out.println("");
            		System.out.println("Stanza aggiunta: "+Stanze[i].getNome()+" al piano "+getNumPiano()+", con numero interno: "+getNumInterno());
            		this.setVol(this.getVol() + Stanze[i].calcolaVolume());
            		this.setSup(this.getSup() + Stanze[i].calcolaSupTot());
            		this.setSupDisp(this.getSupDisp() + Stanze[i].supDisperdenteLorda());
            		this.setSupDispN(this.getSupDispN() + Stanze[i].supDisperdenteNetta());
            		var++;
            	}
                else i=5;
            }
        }
     }
    
    
    public void chiediDatiAppartamenti (){
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
        System.out.println("Ok, i dati di questo appartamento sono finiti"+"\n");
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
