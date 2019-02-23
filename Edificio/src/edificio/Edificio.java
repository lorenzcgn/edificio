package edificio;
import java.util.*;


/**
 *
 * @author Cagni Lorenzo
 */

public class Edificio {


    public static void main(String[] args) {
    int numeroApp=6;
    int numProp[];
    numProp = new int[14];
    Scanner s= new Scanner(System.in);
    
    /* chiedo il numero dei piani */
    
    /* System.out.println("Inserisci il numero di piani (un piano corrisponde ad un appartamento): ");
    do{
        numeroApp=s.nextInt();
    }while(numeroApp<1 || numeroApp>6); */
    
    
    /* array di oggetti per l'intero edificio, che contiene piu' appartamenti, in base alla richiesta */
    
    Appartamento Appartamenti[]= new Appartamento[numeroApp];
    
    
    for (int i=0;i<numeroApp;i++) {
    System.out.println("Inserisci il numero dei proprietari (max 2) dell'appartamento "+(i+1));
    do{
        numProp[i]=s.nextInt();
    }while(numProp[i]<1 || numProp[i]>2);
   
    
    }
    
    /* istanzio gli appartamenti e chiedo i dati dei loro proprietari
     * gli argomenti dell'appartamento sono in ordine:
	numero del piano, numero dei proprietari (1 o 2), numero interno e numero stanza (max 7) */
    
    Appartamento a0 = new Appartamento(1,numProp[0],3,3);
    Appartamento a1 = new Appartamento(1,numProp[1],5,4);
    Appartamento a2 = new Appartamento(2,numProp[2],2,3);
    Appartamento a3 = new Appartamento(2,numProp[3],4,4);
    Appartamento a4 = new Appartamento(3,numProp[4],3,2);
    Appartamento a5 = new Appartamento(3,numProp[5],7,2);
    
    Appartamenti[0]=a0;
    Appartamenti[1]=a1;
    Appartamenti[2]=a2;
    Appartamenti[3]=a3;
    Appartamenti[4]=a4;
    Appartamenti[5]=a5;
    
    
    /* chiedo i dati dei proprietari */
    
    
    for (int i=0;i<numeroApp;i++) {
        System.out.println("Inserisci Inserisci i dati dei proprietari dell'appartamento "+(i+1));
        System.out.println("Per questo appartamento ti ricordo che hai scelto "+(numProp[i])+" proprietari.");
        Appartamenti[i].settaProprietari();
    }
       
    
    /* In ordine per istanziare una stanza servono i seguenti input:
     * nome, lunghezza, larghezza, altezza, superficie finestre ed infine, in boolean bisogna inserire se le pareti sono disperdenti,
     * nel seguente ordine: nord, sud, est, ovest, pavimento, soffitto     
     * ancora non ci serve la cucina quindi bisogna aggiungere sempre "false" in coda */
    
    /*                                              lun1,  lar1,  lun2,  lar2,  up,    bottom  -   cucina       */
    Stanza A = new Stanza("A", 5.5, 4.0, 2.7, 5.5,  false, true,  true,  true,  true,  false,      false);
    Stanza B = new Stanza("B", 6.0, 3.5, 2.7, 6.5,  true,  true,  true,  false, false, true,       false);
    Stanza C = new Stanza("C", 3.5, 3.0, 2.7, 1.5,  true,  true,  false, false, false, false,      false);
    Stanza D = new Stanza("D", 4.5, 4.0, 2.7, 2.8,  true,  false, true,  true,  true,  false,      false);
    Stanza E = new Stanza("E", 4.0, 4.0, 2.7, 2.0,  false, true,  false, true,  true,  false,      false);
    Stanza F = new Stanza("F", 4.6, 3.4, 2.7, 3.5,  true,  false, true,  true,  false, true,       false);
    
    /* aggiungo le stanze agli appartamenti */

    a0.addStanza(A);
    a0.addStanza(C);
    a0.addStanza(D);
    
    a1.addStanza(B);
    a1.addStanza(D);
    a1.addStanza(E);
    a1.addStanza(F);
    
    a2.addStanza(A);
    a2.addStanza(E);
    a2.addStanza(F);
    
    a3.addStanza(A);
    a3.addStanza(C);
    a3.addStanza(E);
    a3.addStanza(F);
    
    a4.addStanza(E);
    a4.addStanza(F);
    
    a5.addStanza(B);
    a5.addStanza(D);
    
    
    /* calcoli dei singoli appartamenti */
    
    System.out.println("\n"+"Vuoi sapere i dati dei singoli appartamenti? Scrivi SI o NO");
    String scelta1;
    scelta1=s.next();
    if (scelta1.equals("SI")){
    	a0.ouputDatiAppartamenti();
    	a1.ouputDatiAppartamenti();
        a2.ouputDatiAppartamenti();
        a3.ouputDatiAppartamenti();
        a4.ouputDatiAppartamenti();
        a5.ouputDatiAppartamenti();
    }

    
    /* calcoli totali dell'edificio */
    
    double volumi=0;
    double superfici=0;
    double disperdenteLorda=0;
    double disperdenteNetta=0;
    
    
    for (int i=0; i<numeroApp; i++) {
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
    	for (int i=0; i<numeroApp; i++) { 
    			System.out.println("L'appartamento al piano "+Appartamenti[i].getNumPiano()+", con "+ Appartamenti[i].getNumeroStanze()+" stanze, il cui numero interno e' "+Appartamenti[i].getNumInterno()+" ha "+Appartamenti[i].getNumProp()+"\n"+
    	                " proprietari: "+Appartamenti[i].P1.getNome()+" "+Appartamenti[i].P1.getCognome()+", con codice fiscale: "+Appartamenti[i].P1.getCf());
    	}
    	System.out.println("\n"+"Ok, grazie per aver usato questo programma");
    }
    else System.out.println("\n"+"Ok, grazie per aver usato questo programma");
    

}}
