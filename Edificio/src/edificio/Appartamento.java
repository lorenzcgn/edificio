package edificio;
import java.util.*;



public class Appartamento {
    Scanner s = new Scanner(System.in);
    private int numPiano;
    private int numProp;
    private int numInterno;
    private int numeroStanze;
    public double vol;
    public double sup;
    public double supDisp;
    public double supDispN;
    
    Stanza Stanze[];
    Proprietario Proprietari[];
    
    
            
    public Appartamento(int numPiano, int numProp, int numInterno, int numeroStanze) {
    this.numPiano = numPiano;
    this.numProp = numProp;
    this.numInterno = numInterno;
    this.numeroStanze=numeroStanze;
    this.vol=0;
    this.sup=0;
    this.supDisp=0;
    this.supDispN=0;
    
    /* creo, nel costruttore, quindi per ogni appartamento,
     * un array di stanze e di proprietari, in base al numero passato dal main */
    
    Stanze = new Stanza[numeroStanze];
    Proprietari = new Proprietario[numProp];

    for (int i=0; i<numeroStanze; i++) {
        Stanze[i]=null;
    }
    
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
    
    public void setVol(double vol) {
    	this.vol=vol;
    }
    
    public double getVol() {
    	return vol;
    }
    
    public void setSup(double sup) {
    	this.sup=sup;
    }
    
    public double getSup() {
    	return sup;
    }
    
    public void setSupDisp(double supDisp) {
    	this.supDisp=supDisp;
    }
    
    public double getSupDisp() {
    	return supDisp;
    }
    
    public void setSupDispN(double supDispN) {
    	this.supDispN=supDispN;
    }
    
    public double getSupDispN() {
    	return supDispN;
    }
    
    /* creo un proprietario vuoto da assegnare di default ad ogni stanza prima di chiedere i dati, altrimenti non posso passarglieli */
        
    Proprietario P1=new Proprietario("","",""); 
    
    public void settaProprietari() {
        for (int i=0; i<numProp; i++) {
            Proprietari[i]=P1;
        }
        for (int i=0; i<numProp; i++) {
            Proprietari[i].chiediDatiProp();
        }
    }
    
    /* metodo per aggiugere la stanza all'array di stanze dell'appartamento,
     * che mi permette di sapere non solo i calcoli delle singole stanze, ma anche degli appartamenti,
     * e dal main mi serviranno per calcolare i dati complessivi dell'edificio */
    
    public void addStanza(Stanza st) {
    
    	int var=0;
        for (int i=0; i<(numeroStanze); i++) {
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
            }
        }
     }
    
    /* metodo per l'output dei dati di tutte le stanze dell'appartamento */
    
    public void ouputDatiAppartamenti() {
    	System.out.println(
            "\n"+
            "Di seguito ecco i dati dell'appartamento al piano "+this.getNumPiano()+" con numero intero "+this.getNumInterno()+"\n"+
    		"Volumi totali: "+this.getVol()+"\n"+
    		"Superfici totali: "+this.getSup()+"\n"+
    		"Superfici disperdenti lorde: "+this.getSupDisp()+"\n"+
    		"Superfici disperdenti nette: "+this.getSupDispN()
    );
    }
    
    
    /* chiedo i dati dell'appartamento */
    
    public void chiediDatiAppartamenti (){
        System.out.println("Inserisci il numero del piano dell'appartamento:");
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
    	
   
    
    /* Metodo per chiedere in input i dati delle stanza (al momento inusato) */
    
    /*
    
    public void chiediDatiStanze() {
    
    int numeroSt;
    System.out.println("Inserisci il numero delle stanze dell'appartamento");
    
    do{
        numeroSt=s.nextInt();
    }while(numeroSt<0 || numeroSt>7);    
    }                                        */
   


}
