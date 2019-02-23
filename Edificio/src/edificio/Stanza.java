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
    
    public Stanza(String nome, double lun, double lar, double alt, double supFin, boolean est, boolean nord, boolean ovest, boolean sud, boolean soffitto, boolean pavimento, boolean cucina) {
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
    
    /* Secondo il mio programma la parete nord e' altezza x larghezza */
	pNord = alt*lar;
	
	
	/* Secondo il mio programma la parete sud e' altezza x larghezza */
	pSud = alt*lar;

	/* Secondo il mio programma la parete est e' altezza x lunghezza */
	pEst = alt*lun;

	/* Secondo il mio programma la parete ovest e' altezza x lunghezza */
	pOvest = alt*lun;

	pPavimento = lar*lun;
	pSoffitto = lar*lun;
    
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

	
	public double getpNord() {
		return pNord;
	}

	public void setpNord(double pNord) {
		this.pNord = pNord;
	}

	public double getpSud() {
		return pSud;
	}

	public void setpSud(double pSud) {
		this.pSud = pSud;
	}

	public double getpEst() {
		return pEst;
	}

	public void setpEst(double pEst) {
		this.pEst = pEst;
	}

	public double getpOvest() {
		return pOvest;
	}

	public void setpOvest(double pOvest) {
		this.pOvest = pOvest;
	}

	public double getpPavimento() {
		return pPavimento;
	}

	public void setpPavimento(double pPavimento) {
		this.pPavimento = pPavimento;
	}

	public double getpSoffitto() {
		return pSoffitto;
	}

	public void setpSoffitto(double pSoffitto) {
		this.pSoffitto = pSoffitto;
	}

	/* metodo per calcolare il volume della stanza */
	public double calcolaVolume() {
        System.out.println("Il volume della stanza "+nome+" e': "+(this.lun*this.lar*this.alt));
        double volume=this.lun*this.lar*this.alt;
        return volume;
    }
	
    
	/* metodo per calcolare la superficie totale */
    public double calcolaSupTot() {
    	
    	double suptot=this.getpPavimento()+this.getpSoffitto()+this.getpSud()+this.getpNord()+this.getpEst()+this.getpOvest();
        System.out.println("La superficie totale della stanza "+nome+" e': "+suptot);
        return suptot;
    }
    
    /* metodo per calcolare la superficie disperdente lorda (con finestre) */
    public double supDisperdenteLorda() {
        double supdisp=0.0;
        
        if (this.isEst()==true) {
        	supdisp+=this.getpEst();
        }
        if (this.isOvest()==true) {
        	supdisp+=this.getpOvest();
        }
        if (this.isNord()==true) {
        	supdisp+=this.getpNord();
        }
        if (this.isSud()==true) {
        	supdisp+=this.getpSud();
        }
        if (this.isPavimento()==true) {
        	supdisp+=this.getpPavimento();
        }
        if (this.isSoffitto()==true) {
        	supdisp+=this.getpSoffitto();
        }
        System.out.println("La superficie disperdente lorda della stanza "+this.nome+" e': "+supdisp);
        return supdisp;
    }
    
    
    /* metodo per calcolare la superficie disperdente netta (senza finestre) */
    public double supDisperdenteNetta() {
    	double supdispnetta=0.0;
        
    	if (this.isEst()==true) {
    		supdispnetta+=this.getpEst();
        }
        if (this.isOvest()==true) {
        	supdispnetta+=this.getpOvest();
        }
        if (this.isNord()==true) {
        	supdispnetta+=this.getpNord();
        }
        if (this.isSud()==true) {
        	supdispnetta+=this.getpSud();
        }
        if (this.isPavimento()==true) {
        	supdispnetta+=this.getpPavimento();
        }
        if (this.isSoffitto()==true) {
        	supdispnetta+=this.getpSoffitto();
        }
        
        supdispnetta=supdispnetta-this.getSupFin();
        if (supdispnetta<0) {
        	supdispnetta=0;
        }
        System.out.println("La superficie disperdente netta della stanza "+this.nome+" e': "+supdispnetta);
        return supdispnetta;    
    }

    
    
}
