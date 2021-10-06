package tme2b;

public class CalculElem implements Runnable {
	private MatriceEntiere m, m1, m2;
	private int i, j;
	
	public CalculElem(MatriceEntiere m1, int i, MatriceEntiere m2, int j, MatriceEntiere m) {
		this.i = i;
		this.j = j;
		this.m1 = m1;
		this.m2 = m2;
		this.m = m;
	}
	
	public void run() {
		try {
			m.setElem(i, j, MatriceEntiere.produitLigneColonne(m1, i, m2, j));
		} catch (TaillesNonConcordantesException e) {
			e.printStackTrace();
		}
	}
}
