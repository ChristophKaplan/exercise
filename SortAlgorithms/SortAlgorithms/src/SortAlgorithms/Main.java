//**
//*
//* Uni class "Datenstrukturen & Algorithmen"
//* Sortalgortihms practise/lesson
//* Christoph Kaplan
//*
//**

package SortAlgorithms;

class Elem{
	int entry;
	Elem(int i){
		this.entry = i;
	}
	
	String GetName() {
		return this.entry + "";
	}
	
	boolean isLess(Elem other) {
		return this.entry < other.entry;
	}
	boolean isEqual(Elem other) {
		return this.entry == other.entry;
	}
}

class SortAlgs{

	
	public static void selectionSort(Elem[] S) {
		System.out.println("\n\nselectionSort");
		
		Elem min;
		int minindex;
		
		for(int i = 0; i < S.length-1;i++) {
			min=S[i]; minindex=i;
				
			for(int j = i+1; j < S.length;j++) {
				if(S[j].isLess(min)) {
					min = S[j]; minindex = j;
				}
			}
			swap(S,i,minindex);
		}
		
	}
	
	public static void insertionSort(Elem[] S) {
		System.out.println("\n\ninsertionSort");
		
		Elem r;
		int j;
		
		for(int i = 1; i < S.length;i++) {
			r = S[i];
			j = i-1;
			
			while(j >= 0 && r.isLess(S[j])) {
				S[j+1] = S[j];
				j--;
			}
			S[j+1]=r;
		}
		
	}
	
	
	public static void mergeSort(Elem[] S) {
		System.out.println("\n\nmergeSort");
	}
	
	
	public static void quickSort(Elem[] S) {
		System.out.println("\n\nquickSort");
		quickSort(S,0,S.length-1);
	}
	public static void quickSort(Elem[] S, int i, int j) {
		int k, xindex;
		
		if(i<j) {
			xindex = findx(S,i,j);
			if(xindex != -1) {
				//Devide
				k=partition(S,i,j,S[xindex]);
				//Conquer
				quickSort(S,i,k-1); quickSort(S,k,j);
			}
		}
	}
	private static int findx(Elem[] S, int i, int j) {
		int k = i+1;
		while(k<=j && S[k].isEqual(S[k-1]))k++;
		if(k>j)	return -1;
		else if(S[k-1].isLess(S[k])) return k; else return k-1;
	}
	private static int partition(Elem[] S, int i, int j,Elem x) {
		int l=i; int r=j;
		while(l<r) {
			while(S[l].isLess(x))l++;
			while(!S[r].isLess(x))r--;
			if(l<r)swap(S,l,r);
		}
		return l;
	}
	
	
	private static void swap(Elem[] S,int n ,int m) {
		Elem tmp = S[n];
		S[n] = S[m]; S[m] = tmp;
	}
	
	
	//OTHER HELPER FUNCTIONS
	public static void PrintArray(Elem[] S) {
		for(int i = 0; i<S.length; i++) {
			System.out.print(S[i].GetName() + ", ");
		}
	}
	public static Elem[] CreateArrayRandomNumbers(int n, int min, int max) {
		Elem[] e= new Elem[n];
		for(int i = 0; i<e.length; i++) {
			int randomNumber = (int)(Math.random() * (max - min + 1) + min);
			e[i] = new Elem(randomNumber);;
		}
		return e;
	}
}


public class Main {

	//Array Length
	static int n = 10;
	//Array to sort
	static Elem[] arrayToSort = SortAlgs.CreateArrayRandomNumbers(n, 0, 10);
	
	
	public static void main(String[] args) {

		
		System.out.println("Before");
		//Print the Array
		SortAlgs.PrintArray(arrayToSort);
		
		//Apply Sort
		SortAlgs.quickSort(arrayToSort);
				
		System.out.println("After");
		//Print the Array
		SortAlgs.PrintArray(arrayToSort);
	}
}
