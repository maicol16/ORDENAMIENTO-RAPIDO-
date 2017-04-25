import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class QuickSort {
             public static void main(String[] args) {

		QuickSort app = new QuickSort();
		
	    List<Integer> input = app.generateRandomNumbers(7);
	
	    System.out.println(input);
            
	    System.out.println(app.quicksort(input));   
	}
	private List<Integer> quicksort(List<Integer> input){
		
		if(input.size() <= 1){
			return input;
		}
		
		int mitad = (int) Math.ceil((double)input.size() / 2);
		int pivot = input.get(mitad);

		List<Integer> less = new ArrayList<Integer>();
		List<Integer> greater = new ArrayList<Integer>();
		
		for (int i = 0; i < input.size(); i++) {
			if(input.get(i) <= pivot){
				if(i == mitad){
					continue;
				}
				less.add(input.get(i));
			}
			else{
				greater.add(input.get(i));
			}
		}	
		return concatenate(quicksort(less), pivot, quicksort(greater));
	}
	private List<Integer> concatenate(List<Integer> less, int pivot, List<Integer> greater){
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < less.size(); i++) {
			list.add(less.get(i));
		}
		
		list.add(pivot);
		
		for (int i = 0; i < greater.size(); i++) {
			list.add(greater.get(i));
		}
		
		return list;
	}
	private List<Integer> generateRandomNumbers(int n){
		
	    List<Integer> list = new ArrayList<Integer>(n);
	    Random random = new Random();
		
	    for (int i = 0; i < n; i++) {
		    list.add(random.nextInt(n * 10));
	    }
	
	    return list;
	}

}
