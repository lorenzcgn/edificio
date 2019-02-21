package edificio;
import java.util.*;


/**
 *
 * @author Cagni Lorenzo
 */

public class Edificio {


    public static void main(String[] args) {
    int numeroPiani=7;
    int numProp[];
    numProp = new int[14];
    Scanner s= new Scanner(System.in);
    
    /* chiedo il numero dei piani */
    
    System.out.println("Inserisci il numero di piani (un piano corrisponde ad un appartamento): ");
    do{
        numeroPiani=s.nextInt();
    }while(numeroPiani<1 || numeroPiani>2);
    
    
    /* array di oggetti per l'intero edificio, che contiene più appartamenti, in base alla richiesta */
    
    Appartamento Appartamenti[]= new Appartamento[numeroPiani];
    
    
    for (int i=0;i<numeroPiani;i++) {
    System.out.println("Inserisci il numero dei proprietari (max 2) dell'appartamento "+(i+1));
    do{
        numProp[i]=s.nextInt();
    }while(numProp[i]<1 || numProp[i]>2);
   
    
    }
    
    /* istanzio gli appartamenti e chiedo i dati dei loro proprietari
     * gli argomenti dell'appartamento sono in ordine:
	numero del piano, numero dei proprietari (1 o 2), numero interno e numero stanza (max 7) */
    
    Appartamento a1 = new Appartamento(1,numProp[0],1,7);
    Appartamento a2 = new Appartamento(2,numProp[1],2,7);
    Appartamenti[0]=a1;
    Appartamenti[1]=a2;
    
    
    /* chiedo i dati dei proprietari */
    
    System.out.println("Inserisci i dati del proprietario 1");
    a1.settaProprietari(numProp[0]);
    System.out.println("Ok, ora inserisci i dati del proprietario 2");
    a2.settaProprietari(numProp[1]);
       
    
    /* In ordine per istanziare una stanza servono i seguenti input:
     * nome, lunghezza, larghezza, altezza, superficie finestre ed infine, in boolean bisogna inserire se le pareti sono disperdenti,
     * nel seguente ordine: nord, sud, est, ovest, pavimento, soffitto     
     * ancora non ci serve la cucina quindi bisogna aggiungere sempre "false" in coda */
    
    Stanza A = new Stanza("Salotto", 30, 10, 10, 10, true, false, true, false, false, true, false);
    Stanza B = new Stanza("Camera1", 20, 10, 10, 10, true, false, true, false,true,false,false);
    
    /* aggiungo le stanze agli appartamenti */

    a1.addStanza(A);
    a1.addStanza(B);
    
    a2.addStanza(A);
    a2.addStanza(B);
    
    
    /* calcoli dei singoli appartamenti */
    
    System.out.println("\n"+"Vuoi sapere i dati dei singoli appartamenti? Scrivi SI o NO");
    String scelta1;
    scelta1=s.next();
    if (scelta1.equals("SI")){
    	a1.ouputDatiAppartamenti();
    	a2.ouputDatiAppartamenti();
    }

    
    /* calcoli totali dell'edificio */
    
    int volumi=0;
    int superfici=0;
    int disperdenteLorda=0;
    int disperdenteNetta=0;
    
    
    for (int i=0; i<numeroPiani; i++) {
        volumi+=Appartamenti[i].getVol();
        superfici+=Appartamenti[i].getSup();
        disperdenteLorda+=Appartamenti[i].getSupDisp();
        disperdenteNetta+=Appartamenti[i].getSupDispN();
    }

    System.out.println("\n"+"Vuoi anche sapere i dati dell'intero edificio? Scrivi SI o NO");
    String scelta2;
    scelta2=s.next();
    if (scelta2.equals("SI")){
    
    System.out.println(
            "\n"+
            "Di seguito ecco i dati dell'intero edificio: "+"\n"+
    		"Volumi totali: "+volumi+"\n"+
    		"Superfici totali: "+superfici+"\n"+
    		"Superfici disperdenti lorde: "+disperdenteLorda+"\n"+
    		"Superfici disperdenti nette: "+disperdenteNetta
    );
    
    }
    
    /* output dati proprietari degli appartamenti */
    
    System.out.println("\n"+"Vuoi anche sapere chi sono i proprietari degli appartamenti? Scrivi SI o NO");
    String scelta3;
    scelta3=s.next();
    if (scelta3.equals("SI")){
    	for (int i=0; i<numeroPiani; i++) { 
    			System.out.println("L'appartamento al piano "+Appartamenti[i].getNumPiano()+", con "+ Appartamenti[i].getNumeroStanze()+" stanze, il cui numero interno e' "+Appartamenti[i].getNumInterno()+" ha "+Appartamenti[i].getNumProp()+"\n"+
    	                " proprietari: "+Appartamenti[i].P1.getNome()+" "+Appartamenti[i].P1.getCognome()+", con codice fiscale: "+Appartamenti[i].P1.getCf());
    	}
    	System.out.println("Ok, grazie per aver usato questo programma");
    }
    else System.out.println("Ok, grazie per aver usato questo programma");
    

}}