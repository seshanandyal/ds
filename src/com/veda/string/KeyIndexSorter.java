package com.veda.string;

public class KeyIndexSorter<T extends KeyIndexElement> {
	T[] mElements, mAux;
	int mRadix;
	
	public KeyIndexSorter(T[] elements, T[] aux, int radix) {
		mElements = elements;
		mAux = aux;
		mRadix = radix;
	}
	
	public void sort() {
		int[] temp = new int[mRadix + 1];
		for(int index = 0; index < mElements.length; index++) {
			int key = (int) mElements[index].getKey();
			temp[key]++; 
		}
		
		//Generate the cumulates
		int cumulate = 0;
		for(int index = 0; index < temp.length; index++) {
			temp[index] = cumulate+ temp[index];
			cumulate = temp[index];
		}
		
		//Use the cumulates and fill aux
		for(int index = 0; index < mElements.length; index++) {
			int cumulateIndex = ((int) mElements[index].getKey() - 1);
			int auxIndex = temp[cumulateIndex];
			temp[cumulateIndex]++;
			mAux[auxIndex] = mElements[index];
		}
		
		//Finally copy the elements from mAux to mElements
		for(int index = 0; index < mElements.length; index++) {
			mElements[index] = mAux[index];
		}
		
	}
	
	public void display() {
		for(int index = 0; index < mElements.length; index++) {
			System.out.println(mElements[index]);
		}
	}
	
	public static void main(String[] args) {
		KeyIndexElement<Integer>[] arr = constructTestData();
		KeyIndexSorter<KeyIndexElement> sorter = new KeyIndexSorter<>(arr, 
				new SectionKeyIndexElement[20], 4);
		sorter.sort();
		sorter.display();
	}
	
	public static KeyIndexElement<Integer>[] constructTestData() {
		KeyIndexElement<Integer>[] arr = new SectionKeyIndexElement[20];
		arr[0] = new SectionKeyIndexElement("Anderson", 2);
		arr[1] = new SectionKeyIndexElement("Brown", 3);
		arr[2] = new SectionKeyIndexElement("Davis", 3);
		arr[3] = new SectionKeyIndexElement("Garcia", 4);
		arr[4] = new SectionKeyIndexElement("Harris", 1);
		arr[5] = new SectionKeyIndexElement("Jackson", 3);
		arr[6] = new SectionKeyIndexElement("Johnson", 4);
		arr[7] = new SectionKeyIndexElement("Jones", 3);
		arr[8] = new SectionKeyIndexElement("Martin", 1);
		arr[9] = new SectionKeyIndexElement("Martinez", 2);
		arr[10] = new SectionKeyIndexElement("Miller", 2);
		arr[11] = new SectionKeyIndexElement("Moore", 1);
		arr[12] = new SectionKeyIndexElement("Robinson", 2);
		arr[13] = new SectionKeyIndexElement("Smith", 4);
		arr[14] = new SectionKeyIndexElement("Taylor", 3);
		arr[15] = new SectionKeyIndexElement("Thomas", 4);
		arr[16] = new SectionKeyIndexElement("Thompson", 4);
		arr[17] = new SectionKeyIndexElement("White", 2);
		arr[18] = new SectionKeyIndexElement("Williams", 3);
		arr[19] = new SectionKeyIndexElement("Wilson", 4);
		
		return arr;
	}
}
