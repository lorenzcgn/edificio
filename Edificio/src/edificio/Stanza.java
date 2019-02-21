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
    private int pNord;
    private int pSud;
    private int pEst;
    private int pOvest;
    private int pPavimento;
    private int pSoffitto;
    
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
    
    /* Inizializzo le parenti all'interno del costruttore per non doverle ricreare dentro ogni metodo */
    
    /* Secondo il mio programma la parete nord è altezza x larghezza */
	pNord = this.getAlt()*this.getLar();
	
	/* Secondo il mio programma la parete sud è altezza x larghezza */
	pSud = this.getAlt()*this.getLar();

	/* Secondo il mio programma la parete est è altezza x lunghezza */
	pEst = this.getAlt()*this.getLun();

	/* Secondo il mio programma la parete ovest è altezza x lunghezza */
	pOvest = this.getAlt()*this.getLun();

	pPavimento = this.getLar()*this.getLun();
	pSoffitto = this.getLar()*this.getLun();
    
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
	
	
	/* metodo per calcolare il volume della stanza */
	public int calcolaVolume() {
        System.out.println("Il volume della stanza "+nome+" e': "+(this.lun*this.lar*this.alt));
        int volume=this.lun*this.lar*this.alt;
        return volume;
    }
    
	/* metodo per calcolare la superficie totale */
    public int calcolaSupTot() {
    	
    	int suptot=pPavimento+pSoffitto+pNord+pSud+pEst+pOvest;
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
    public int supDisperdenteNetta() {
    	int supdispnetta=0;
        
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
        return supdispnetta;    
    }

    
    
}