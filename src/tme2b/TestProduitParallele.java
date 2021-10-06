package tme2b;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class TestProduitParallele {

	public static void main(String[] args) {
		try {
			MatriceEntiere m1 = new MatriceEntiere(new File("/users/nfs/Etu3/21101133/Documents/prog co/tme2b/data/donnees_produit1"));
			MatriceEntiere m2 = new MatriceEntiere(new File("/users/nfs/Etu3/21101133/Documents/prog co/tme2b/data/donnees_produit2"));
	
			MatriceEntiere m = new MatriceEntiere(m1.getNbLignes(), m2.getNbColonnes());
			m.initZero();
			
			List<Thread> th = new ArrayList<Thread>();
			
			for(int x = 0; x < m1.getNbLignes(); x++)
			{
				for(int y = 0; y < m2.getNbColonnes(); y++) {
					Thread t = new Thread(new CalculElem(m1, x, m2, y, m));
					t.start();
					th.add(t);
				}
			}
			
			for(Thread t: th) {
				t.join();
			}
			
			System.out.println(m);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
