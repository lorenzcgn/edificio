
package edificio;
import java.util.*;


/**
 *
 * @author Cagni Lorenzo
 */
public class Edificio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int numeroPiani;
    
    Scanner s = new Scanner(System.in);
    
    /* Chiedo il numero dei piani */
    
    System.out.println("Inserisci il numero di piani dell'edificio (un piano corrisponde ad un appartamento)");
    do{
        numeroPiani=s.nextInt();
    }while(numeroPiani<1);
   
    
    /* Array di oggetti */
    
    Appartamento Appartamenti[]= new Appartamento[numeroPiani];
    /* Proprietario Proprietari[]= new Proprietario[numeroPiani]; */

    
    /* Chiedo i dati del proprietario e degli appartamenti */
    
    for (int i=0; i<numeroPiani; i++) {
        Appartamenti[i]= new Appartamento(0,0,0,7,0,0,0,0);
        /* Proprietari[i]= new Proprietario("","",""); */
    }
    
    for (int i=0; i<numeroPiani; i++) {
        /* Appartamenti[i].chiediDatiAppartamento(); */
        /* Appartamenti[i].chiediDatiStanze(); */
        /* Proprietari[i].chiediDatiProp(); */
    }
    
    int volumi=0;
    int superfici=0;
    int disperdenteLorda=0;
    int disperdenteNetta=0;
    
    Stanza Vuota= new Stanza("v", 0, 0, 0, 0, false, false);
    
    Stanza A= new Stanza("Stanza1", 30, 10, 10, 10, false, false);
    Stanza B= new Stanza("Stanza2", 20, 10, 10, 10, false, false);

    Appartamento a1= new Appartamento(1,1,1,7,0,0,0,0);
    
    a1.inizializza(Vuota);
    
    a1.addStanza(A,Vuota);
    a1.addStanza(B,Vuota);
    
    
    for (int i=0; i<1; i++) {
            volumi+=a1.getVol();
            superfici+=a1.getSup();
            disperdenteLorda+=a1.getSupDisp();
            disperdenteNetta+=a1.getSupDispN();
    }
    
    System.out.println(
    		"Volumi totali: "+volumi+"\n"+
    		"Superfici totali: "+superfici+"\n"+
    		"Superfici disperdenti lorde: "+disperdenteLorda+"\n"+
    		"Superfici disperdenti nette: "+disperdenteNetta
    );
    
    
    
    

}}
