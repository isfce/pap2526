package tp02;

import util.IStack;
import util.StackArray;

public class Recursivite {
	/**
	 * Factorielle version récursive
	 * 
	 * @param n >=0
	 * @return
	 */
	public static long fact(int n) {
		assert n >= 0 : "n>=0!!";
		if (n <= 1)
			return 1;
		return n * fact(n - 1);
	}

	public static long fact2(int n) {
		assert n >= 0 : "n>=0!!";
		long res = 1;
		for (int i = 2; i <= n; i++)
			res = res * i;
		return res;
	}

	/**
	 * Calcul récursif pour x^y
	 * 
	 * @param x
	 * @param y >=0
	 * @return
	 */
	public static double power(final double x, int y) {
		assert y >= 0 && !(x == 0 & y == 0) : "y>=0 !!";
		if (y == 0)
			return 1;
		if (y == 1 || x == 0 || x == 1)
			return x;
		double res = power(x, y / 2);
		res *= res;
		if (y % 2 != 0)
			res = res * x;
		return res;
	};

	/**
	 * Calcule x^y en faisant x....x y*
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static double power0(final double x, int y) {
		if (y == 0)
			return 1;
		if (y == 1 || x == 0 || x == 1)
			return x;
		double res = x;
		for (int i = 1; i < y; i++)
			res = res * x;
		return res;
	}

	/**
	 * Tour de Hanoï
	 * 
	 * @param n
	 * @param d 0..2
	 * @param a 0..2
	 */
	public static void deplacer(int n, int d, int a) {
		if (n == 1)
			System.out.println("deplacer de " + d + " vers " + a);
		else {
			int i = 3 - d - a;// calcule le piquet interm
			deplacer(n - 1, d, i);
			deplacer(1, d, a);
			deplacer(n - 1, i, a);
		}
	}

	/**
	 * PosPivot pour quicksort (non recursive)
	 * 
	 * @param v
	 * @param d
	 * @param f
	 * @return
	 */
	public static int posPivot(int[] v, int d, int f) {
		assert d <= f : "d doit être <= f";
		int i = d;
		int j = f - 1;
		int pivot = v[f];
		while (i <= j) {
			while (v[i] < pivot)
				i++;

			while (j >= 0 && v[j] >= pivot)
				j--;

			if (i < j) {
				int tmp = v[j];
				v[j] = v[i];
				v[i] = tmp;
			}
		}
		v[f] = v[i];
		v[i] = pivot;
		return i;
	}

	// pour le quicksort
	private record RDF(int d, int f) {
	}

	/**
	 * Quicksort
	 * Version avec stack
	 * 
	 * @param v
	 */
	public static int[] quicksort(int[] v) {
		IStack<RDF> s = new StackArray<>(30);
		s.push(new RDF(0, v.length - 1));
		while (!s.empty()) {
			RDF rdf = s.pop();
			int p = posPivot(v, rdf.d, rdf.f);
			if (p - rdf.d > 1)
				s.push(new RDF(rdf.d, p - 1));
			if (rdf.f - p > 1)
				s.push(new RDF(p + 1, rdf.f));
		}
		System.out.println(((StackArray)s).getMaxi());
		return v;
	}

	/**
	 * Quicksort récursif
	 * 
	 * @param v
	 * @param d
	 * @param f
	 */
	private static void quickSort(int[] v, int d, int f) {
		assert d <= f : " d doit être <= à f ";
		int i = d;
		int j = f - 1;
		int pivot = v[f];

		while (i <= j) {
			while (v[i] < pivot)
				i++;
			while (j >= 0 && v[j] >= pivot)
				j--;
			if (i < j) {// swap
				int tmp = v[i];
				v[i] = v[j];
				v[j] = tmp;
			}
		}
		// place le pivot
		v[f] = v[i];
		v[i] = pivot;
		// appels recursifs
		int tailleG = i - d;
		int tailleD = f - i;
		// traite d'abord les petits intervalles
		if (tailleG < tailleD) {
			if (tailleG > 1)
				quickSort(v, d, i - 1);
			if (tailleD > 1)
				quickSort(v, i + 1, f);
		} else {
			if (tailleD > 1)
				quickSort(v, i + 1, f);
			if (tailleG > 1)
				quickSort(v, d, i - 1);
		}
	}

	public static void main(String[] args) {
		/*
		 * long t0=System.nanoTime(); System.out.println(power(0.175676, 100000));long
		 * t1=System.nanoTime(); System.out.println(power0(0.175676, 100000));long
		 * t2=System.nanoTime(); System.out.println("v1: "+(t1-t0));
		 * System.out.println("v0: "+(t2-t1));
		 */
		// deplacer(4, 0, 2);
		long t0 = System.nanoTime();
		double r0 = power(0.12, 256);
		long t1 = System.nanoTime();
		double r1 = power0(0.12, 256);
		long t2 = System.nanoTime();
		//System.out.println("r0: " + r0 + " nano:" + (t1 - t0));
		//System.out.println("r1: " + r1 + " nano:" + (t2 - t1));
		// System.out.println("v2: " + (t2 - t1));
		//deplacer(4, 0, 2);
		int cpt=2000000;
		int[] v= new int[cpt];
		for(int i=0;i<cpt;i++)
			v[i]=(int) (Math.random()*100000);
		quicksort(v);
	}

}
