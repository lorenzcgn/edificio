package edificio;
import java.util.*;
import java.lang.*;


/**
 *
 * @author Cagni Lorenzo
 */
public class Edificio {


    public static void main(String[] args) {
    int numeroPiani=7;
    int numProp[];
    numProp = new int[14];

    
    Scanner s = new Scanner(System.in);
    
    /* Chiedo il numero dei piani */
    
    System.out.println("Inserisci il numero di piani (un piano corrisponde ad un appartamento): ");
    do{
        numeroPiani=s.nextInt();
    }while(numeroPiani<1);
    
    
    /* Array di oggetti */
    
    Appartamento Appartamenti[]= new Appartamento[numeroPiani];
    
    
    for (int i=0;i<numeroPiani;i++) {
    System.out.println("Inserisci il numero dei proprietari (max 2) degli appartamenti: ");
    do{
        numProp[i]=s.nextInt();
    }while(numProp[i]<1 || numProp[i]>2);
   
    
    }
    
    /* Chiedo i dati del proprietario e instanzio gli appartamenti */
    
    for (int i=0; i<numeroPiani; i++) {
        Appartamenti[i]= new Appartamento(0,0,0,7,0,0,0,0);
    }

    int volumi=0;
    int superfici=0;
    int disperdenteLorda=0;
    int disperdenteNetta=0;
    
    Appartamento a1 = new Appartamento(1,numProp[0],1,7,0,0,0,0);
    Appartamento a2 = new Appartamento(2,numProp[1],2,7,0,0,0,0);
    
    a1.settaProprietari(numProp[0]);
    a2.settaProprietari(numProp[1]);
       
    Stanza A = new Stanza("Stanza1", 30, 10, 10, 10, true, false);
    Stanza B = new Stanza("Stanza2", 20, 10, 10, 10, true, false);

    a1.addStanza(A);
    a1.addStanza(B);
    
    a2.addStanza(A);
    a2.addStanza(B);
    
    
    for (int i=0; i<1; i++) {
            volumi+=a1.getVol()+a2.getVol();
            superfici+=a1.getSup()+a2.getSup();
            disperdenteLorda+=a1.getSupDisp()+a2.getSupDisp();
            disperdenteNetta+=a1.getSupDispN()+a2.getSupDispN();
    }
    
    System.out.println(
                "\n"+
                "Di seguito ecco i dati dell'intero edificio: "+
    		"Volumi totali: "+volumi+"\n"+
    		"Superfici totali: "+superfici+"\n"+
    		"Superfici disperdenti lorde: "+disperdenteLorda+"\n"+
    		"Superfici disperdenti nette: "+disperdenteNetta
    );
    
    System.out.println("Vuoi anche sapere chi sono i proprietari degli appartamenti? Scrivi SI o NO");
    String scelta;
    scelta=s.next();
    if (scelta.equals("SI")){
        System.out.println("L'appartamento al piano "+a1.getNumPiano()+", con "+ a1.getNumeroStanze()+" stanze, il cui numero interno e' "+a1.getNumInterno()+" ha "+a1.getNumProp()+"\n"+
                " proprietari: "+a1.P1.getNome());
    }
    else System.out.println("Ok, grazie per aver usato questo programma");
    

}}
