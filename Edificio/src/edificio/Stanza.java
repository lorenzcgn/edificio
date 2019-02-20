package edificio;
import java.util.*;



public class Stanza {   
    Scanner s = new Scanner(System.in);
    private String nome;
    private int lun;
    private int lar;
    private int alt;
    private int supFin;
    private boolean cucina;
    private boolean est;
    private boolean ovest;
    private boolean soffitto;
    private boolean pavimento;
    private boolean nord;
    private boolean sud;    
    
    public Stanza(String nome, int lun, int lar, int alt, int supFin, boolean nord, boolean sud, boolean est, boolean ovest, boolean pavimento, boolean soffitto, boolean cucina) {
    this.nome = nome;
    this.lun = lun;
    this.lar = lar;
    this.alt = alt;
    this.supFin = supFin;
    this.est=est;
    this.ovest=ovest;
    this.nord=nord;
    this.sud=sud;
    this.pavimento=pavimento;
    this.soffitto=soffitto;
    this.cucina = cucina;
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
    
    public boolean isCucina() {
    	return cucina;
    }
    
    public void setCucina(boolean cucina) {
    	this.cucina=cucina;
    }
    
    public boolean isEst() {
		return est;
	}

	public void setEst(boolean est) {
		this.est = est;
	}

	public boolean isOvest() {
		return ovest;
	}

	public void setOvest(boolean ovest) {
		this.ovest = ovest;
	}

	public boolean isSoffitto() {
		return soffitto;
	}

	public void setSoffitto(boolean soffitto) {
		this.soffitto = soffitto;
	}

	public boolean isPavimento() {
		return pavimento;
	}

	public void setPavimento(boolean pavimento) {
		this.pavimento = pavimento;
	}

	public boolean isNord() {
		return nord;
	}

	public void setNord(boolean nord) {
		this.nord = nord;
	}

	public boolean isSud() {
		return sud;
	}

	public void setSud(boolean sud) {
		this.sud = sud;
	}
	
	/* Secondo il mio programma la parete nord è altezza x larghezza */
	int pNord = this.getAlt()*this.getLar();
	
	/* Secondo il mio programma la parete sud è altezza x larghezza */
	int pSud = this.getAlt()*this.getLar();

	/* Secondo il mio programma la parete est è altezza x lunghezza */
	int pEst = this.getAlt()*this.getLun();

	/* Secondo il mio programma la parete ovest è altezza x lunghezza */
	int pOvest = this.getAlt()*this.getLun();

	int pPavimento = this.getLar()*this.getLun();
	int pSoffitto = this.getLar()*this.getLun();


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
