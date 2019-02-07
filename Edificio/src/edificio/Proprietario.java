
package edificio;
import java.util.*;


public class Proprietario {
    Scanner s = new Scanner(System.in);
    private String nome;
    private String cognome;
    private String cf;
            
    public Proprietario(String nome, String cognome, String cf) {
	this.nome = nome;
	this.cognome = cognome;
	this.cf = cf;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }
    
    public void chiediDatiProp() {
	  System.out.println("Inserisci il nome del proprietario:");
	  do{
		  this.nome=s.next();
	  }while(this.nome.length()<2);
	  System.out.println("Inserisci il cognome:");
	  do {
	  this.cognome=s.next();
	  }while(this.cognome.length()<2);
	  System.out.println("Inserisci il codice fiscale");
	  do {
	  this.cf=s.next();
          }while(this.cf.length()<11);
    }
    
    
}
