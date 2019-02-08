package edificio;
import java.util.*;



public class Stanza {   
    Scanner s = new Scanner(System.in);
    private String nome;
    private int lun;
    private int lar;
    private int alt;
    private int supFin;
    private boolean confinaRisc;
    private boolean cucina;

    
    
    public Stanza(String nome, int lun, int lar, int alt, int supFin, boolean confinaRisc, boolean cucina) {
    this.nome = nome;
    this.lun = lun;
    this.lar = lar;
    this.alt = alt;
    this.supFin = supFin;
    this.confinaRisc = confinaRisc;
    this.cucina = cucina;
    }

    Stanza(Stanza Vuota) {
        this.nome="Vuota";
        this.lun=0;
        this.lar=0;
        this.alt=0;
        this.supFin=0;
        this.confinaRisc=false;
        this.cucina=false;
    }

    public int getAlt() {
        return alt;
    }

    public void setAlt(int alt) {
        this.alt = alt;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLun() {
        return lun;
    }

    public void setLun(int lun) {
        this.lun = lun;
    }

    public int getLar() {
        return lar;
    }

    public void setLar(int lar) {
        this.lar = lar;
    }

    public int getSupFin() {
        return supFin;
    }

    public void setSupFin(int supFin) {
        this.supFin = supFin;
    }

    public boolean isConfinaRisc() {
        return confinaRisc;
    }

    public void setConfinaRisc(boolean confinaRisc) {
        this.confinaRisc = confinaRisc;
    }
    
    public boolean isCucina() {
    	return cucina;
    }
    
    public void setCucina(boolean cucina) {
    	this.cucina=cucina;
    }
    
    public int calcolaVolume() {
        System.out.println("Il volume della stanza "+nome+" e': "+(this.lun*this.lar*this.alt));
        int volume=this.lun*this.lar*this.alt;
        return volume;
    }
    
    public int calcolaSupTot() {
        System.out.println("La superficie totale della stanza "+nome+" e': "+(2*(lun*lar)+2*(alt*lun)+2*(alt*lar)));
        int suptot=2*(lun*lar)+2*(alt*lun)+2*(alt*lar);
        return suptot;
    }
    public int supDisperdenteLorda() {
        int supdisp;
        if (this.isConfinaRisc()==true) {
            System.out.println("La superficie disperdente lorda della stanza "+nome+" e': "+(2*(lun*lar)+2*(alt*lun)+2*(alt*lar)));
            supdisp=2*(lun*lar)+2*(alt*lun)+2*(alt*lar);
            return supdisp;

        }
        else {
            System.out.println("La superficie disperdente lorda della stanza "+nome+" e' 0");
            supdisp=0;
        }
                    return supdisp;

    }
    
    public int supDisperdenteNetta() {
        int supdispnetta;
        if (this.isConfinaRisc()==true) {
            /* System.out.println("La superficie disperdente netta della stanza e': "+(2*(lun*lar)+2*(alt*lun)+2*(alt*lar)-supFin));  */
            supdispnetta=2*(lun*lar)+2*(alt*lun)+2*(alt*lar)-supFin;
            return supdispnetta;
        }
        else supdispnetta=0;
        return supdispnetta;
    }
    
}
