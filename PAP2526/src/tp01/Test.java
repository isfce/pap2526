package tp01;

public class Test {
	public static int[] genV_Trie(int n) {
		int[] v = new int[n];
		for (int i = 0; i < n; i++)
			v[i] = i;
		return v;
	}

	public static int[] genV_Trie_Inv(int n) {
		int[] v = new int[n];
		for (int i = 0; i < n; i++)
			v[i] = n - i;
		return v;
	}

	public static int[] genV_RND(int n) {
		int[] v = new int[n];
		for (int i = 0; i < n; i++)
			v[i] = (int) (Math.random() * 10000);
		return v;
	}

	public static void main(String[] args) {
		int n = 50000;
		int[] v01 = genV_Trie(n);
		int[] v02 = genV_Trie_Inv(n);
		int[] v03 = genV_RND(n);
		int[] v1, v2, v3;
		String algo;
		long t1, t2, t3, t4;

		// TEST INS Linéaire
		algo = "INSERTION LINEAIRE";
		v1 = MyVect.clone(v01);
		v2 = MyVect.clone(v02);
		v3 = MyVect.clone(v03);

		t1 = System.currentTimeMillis();
		MyVect.triInsertion(v1);
		t2 = System.currentTimeMillis();
		MyVect.triInsertion(v2);
		t3 = System.currentTimeMillis();
		MyVect.triInsertion(v3);
		t4 = System.currentTimeMillis();
		System.out.println("Résultats: " + algo);

		System.out.printf("v1 %s: %,15d%n",algo, (t2 - t1));
		System.out.printf("v2 %s: %,15d%n",algo, (t3 - t2));
		System.out.printf("v3 %s: %,15d%n",algo, (t4 - t3));
		/******************************************************/

		// TEST INS Linéaire
		algo = "INSERTION BULLE0";
		v1 = MyVect.clone(v01);
		v2 = MyVect.clone(v02);
		v3 = MyVect.clone(v03);

		t1 = System.currentTimeMillis();
		MyVect.triBulle0(v1);
		t2 = System.currentTimeMillis();
		MyVect.triBulle0(v2);
		t3 = System.currentTimeMillis();
		MyVect.triBulle0(v3);
		t4 = System.currentTimeMillis();
		System.out.println("Résultats: " + algo);

		System.out.printf("v1 %s: %,15d%n",algo, (t2 - t1));
		System.out.printf("v2 %s: %,15d%n",algo, (t3 - t2));
		System.out.printf("v3 %s: %,15d%n",algo, (t4 - t3));
		/******************************************************/
		/******************************************************/

		
		algo = "INSERTION BULLE";
		v1 = MyVect.clone(v01);
		v2 = MyVect.clone(v02);
		v3 = MyVect.clone(v03);

		t1 = System.currentTimeMillis();
		MyVect.triBulle(v1);
		t2 = System.currentTimeMillis();
		MyVect.triBulle(v2);
		t3 = System.currentTimeMillis();
		MyVect.triBulle(v3);
		t4 = System.currentTimeMillis();
		System.out.println("Résultats: " + algo);

		System.out.printf("v1 %s: %,15d%n",algo, (t2 - t1));
		System.out.printf("v2 %s: %,15d%n",algo, (t3 - t2));
		System.out.printf("v3 %s: %,15d%n",algo, (t4 - t3));
		/******************************************************/
/******************************************************/

		
		algo = "INSERTION DOUBLE BULLE";
		v1 = MyVect.clone(v01);
		v2 = MyVect.clone(v02);
		v3 = MyVect.clone(v03);

		t1 = System.currentTimeMillis();
		MyVect.triBulle3(v1);
		t2 = System.currentTimeMillis();
		MyVect.triBulle3(v2);
		t3 = System.currentTimeMillis();
		MyVect.triBulle3(v3);
		t4 = System.currentTimeMillis();
		System.out.println("Résultats: " + algo);

		System.out.printf("v1 %s: %,15d%n",algo, (t2 - t1));
		System.out.printf("v2 %s: %,15d%n",algo, (t3 - t2));
		System.out.printf("v3 %s: %,15d%n",algo, (t4 - t3));
		/******************************************************/

	}

}
