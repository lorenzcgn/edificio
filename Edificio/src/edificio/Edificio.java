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
    
    /* System.out.println("Inserisci il numero di piani (un piano corrisponde ad un appartamento): ");
    do{
        numeroPiani=s.nextInt();
    }while(numeroPiani<1 || numeroPiani>2); */
    
    
    /* array di oggetti per l'intero edificio, che contiene pi� appartamenti, in base alla richiesta */
    
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
    Appartamento a2 = new Appartamento(1,numProp[1],2,7);
    Appartamento a3 = new Appartamento(3,numProp[1],3,7);
    Appartamento a4 = new Appartamento(4,numProp[1],4,7);
    Appartamento a5 = new Appartamento(5,numProp[1],5,7);
    Appartamento a6 = new Appartamento(6,numProp[1],6,7);
    Appartamenti[0]=a1;
    Appartamenti[1]=a2;
    Appartamenti[2]=a3;
    Appartamenti[3]=a4;
    Appartamenti[4]=a5;
    Appartamenti[5]=a6;
    
    
    /* chiedo i dati dei proprietari */
    
    /* System.out.println("Inserisci i dati del proprietario 1");
    a1.settaProprietari(numProp[0]);
    System.out.println("Ok, ora inserisci i dati del proprietario 2");
    a2.settaProprietari(numProp[1]);  */
       
    
    /* In ordine per istanziare una stanza servono i seguenti input:
     * nome, lunghezza, larghezza, altezza, superficie finestre ed infine, in boolean bisogna inserire se le pareti sono disperdenti,
     * nel seguente ordine: nord, sud, est, ovest, pavimento, soffitto     
     * ancora non ci serve la cucina quindi bisogna aggiungere sempre "false" in coda */
    
    /*                                           lar1, lar2, lun1, lun2, bottom, up - cucina*/
   Stanza A = new Stanza("A", 5.5, 4.0, 2.7, 5.5,true, true, false,true, false, true, false);
    Stanza B = new Stanza("B", 6, 3.5, 2.7, 6.5, true, false,true, true, true,  false,false);
    Stanza C = new Stanza("C", 3.5, 3, 2.7, 1.5, true, false,true, false,false, false,false);
    Stanza D = new Stanza("D", 4.5, 4, 2.7, 2.8, false,true, true, true, false, true, false);
        Stanza E = new Stanza("E", 4, 4, 2.7, 2, true, true, false,false,false, true, false);
  Stanza F = new Stanza("F", 4.6, 3.4, 2.7, 3.5, false,true, true, true, true,  false,false);
    
    /* aggiungo le stanze agli appartamenti */

    a1.addStanza(A);
    a1.addStanza(C);
    a1.addStanza(D);
    
    a2.addStanza(B);
    a2.addStanza(D);
    a2.addStanza(E);
    a2.addStanza(F);
    
    a3.addStanza(A);
    a3.addStanza(E);
    a3.addStanza(F);
    
    a4.addStanza(A);
    a4.addStanza(C);
    a4.addStanza(E);
    a4.addStanza(F);
    
    a5.addStanza(A);
    a5.addStanza(A);
    
    a6.addStanza(A);
    a6.addStanza(A);
    
    
    /* calcoli dei singoli appartamenti */
    
    System.out.println("\n"+"Vuoi sapere i dati dei singoli appartamenti? Scrivi SI o NO");
    String scelta1;
    scelta1=s.next();
    if (scelta1.equals("SI")){
    	a1.ouputDatiAppartamenti();
    	a2.ouputDatiAppartamenti();
        a3.ouputDatiAppartamenti();
        a4.ouputDatiAppartamenti();
        a5.ouputDatiAppartamenti();
        a6.ouputDatiAppartamenti();
    }

    
    /* calcoli totali dell'edificio */
    
    double volumi=0;
    double superfici=0;
    double disperdenteLorda=0;
    double disperdenteNetta=0;
    
    
    for (int i=0; i<6; i++) {
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
