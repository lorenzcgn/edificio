package edificio;
import java.util.*;

public class Stanza {   
    Scanner s = new Scanner(System.in);
    private String nome;
    private double lun;
    private double lar;
    private double alt;
    private double supFin;
    private boolean cucina;
    private boolean est;
    private boolean ovest;
    private boolean soffitto;
    private boolean pavimento;
    private boolean nord;
    private boolean sud;
    private double pNord;
    private double pSud;
    private double pEst;
    private double pOvest;
    private double pPavimento;
    private double pSoffitto;
    
    public Stanza(String nome, double lun, double lar, double alt, double supFin, boolean nord, boolean sud, boolean est, boolean ovest, boolean pavimento, boolean soffitto, boolean cucina) {
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
    
    /* Inizializzo le parenti all'interno del costruttore per non doverle ricreare dentro ogni metodo */
    
    /* Secondo il mio programma la parete nord � altezza x larghezza */
	pNord = this.getAlt()*this.getLar();
	
	/* Secondo il mio programma la parete sud � altezza x larghezza */
	pSud = this.getAlt()*this.getLar();

	/* Secondo il mio programma la parete est � altezza x lunghezza */
	pEst = this.getAlt()*this.getLun();

	/* Secondo il mio programma la parete ovest � altezza x lunghezza */
	pOvest = this.getAlt()*this.getLun();

	pPavimento = this.getLar()*this.getLun();
	pSoffitto = this.getLar()*this.getLun();
    
    }

    public double getAlt() {
        return alt;
    }

    public void setAlt(double alt) {
        this.alt = alt;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLun() {
        return lun;
    }

    public void setLun(double lun) {
        this.lun = lun;
    }

    public double getLar() {
        return lar;
    }

    public void setLar(double lar) {
        this.lar = lar;
    }

    public double getSupFin() {
        return supFin;
    }

    public void setSupFin(double supFin) {
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
	
	
	/* metodo per calcolare il volume della stanza */
	public double calcolaVolume() {
        System.out.println("Il volume della stanza "+nome+" e': "+(this.lun*this.lar*this.alt));
        double volume=this.lun*this.lar*this.alt;
        return volume;
    }
    
	/* metodo per calcolare la superficie totale */
    public double calcolaSupTot() {
    	
    	double suptot=pPavimento+pSoffitto+pNord+pSud+pEst+pOvest;
        System.out.println("La superficie totale della stanza "+nome+" e': "+suptot);
        return suptot;
    }
    
    /* metodo per calcolare la superficie disperdente lorda (con finestre) */
    public int supDisperdenteLorda() {
        int supdisp=0;
        
        if (this.isEst()==true) {
        	supdisp+=pEst;
        }
        else if (this.isOvest()==true) {
        	supdisp+=pOvest;
        }
        else if (this.isNord()==true) {
        	supdisp+=pNord;
        }
        else if (this.isSud()==true) {
        	supdisp+=pSud;
        }
        else if (this.isPavimento()==true) {
        	supdisp+=pPavimento;
        }
        else if (this.isSoffitto()==true) {
        	supdisp+=pSoffitto;
        }
        System.out.println("La superficie disperdente lorda della stanza "+this.nome+" e': "+supdisp);
        return supdisp;
    }
    
    
    /* metodo per calcolare la superficie disperdente netta (senza finestre) */
    public double supDisperdenteNetta() {
    	double supdispnetta=0;
        
        if (this.isEst()==true) {
        	supdispnetta+=pEst;
        }
        else if (this.isOvest()==true) {
        	supdispnetta+=pOvest;
        }
        else if (this.isNord()==true) {
        	supdispnetta+=pNord;
        }
        else if (this.isSud()==true) {
        	supdispnetta+=pSud;
        }
        else if (this.isPavimento()==true) {
        	supdispnetta+=pPavimento;
        }
        else if (this.isSoffitto()==true) {
        	supdispnetta+=pSoffitto;
        }
        
        supdispnetta=supdispnetta-this.supFin;
        if (supdispnetta<0) {
        	supdispnetta=0;
        }
        System.out.println("La superficie disperdente netta della stanza "+this.nome+" e': "+supdispnetta);
        return supdispnetta;    
    }

    
    
}
