import java.util.Scanner;
import java.util.Random;

public class Main {

	static int[] arrayOfRandom;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char user_input = ' ';
		int array_size, max_value;
		
		
		while(user_input != 'q') {//loops until user quits program
			
			System.out.println("List of Commands");
			System.out.println("Enter a new list: s");
			System.out.println("Choose a sorting algorithm: c");
			System.out.println("Quit: q" + "\n");
			System.out.println("Enter a command");
			
			user_input = scanner.next().charAt(0);
			//Determines what user input is
			switch(user_input) {
			case 's':
				System.out.println("Enter the size of the list");
				array_size = scanner.nextInt();
				System.out.println("Enter the max value for an item in the list");
				max_value = scanner.nextInt();
				arrayOfRandom = generatelist(array_size, max_value);
				break;
				
			case 'c':
				System.out.println("List of Sorting Algorithms");
				System.out.println("Selection sort: s");
				System.out.println("Bubble sort: b");
				System.out.println("Insertion sort: i");
				System.out.println("Merge sort: m");
				System.out.println("Heap sort: h");
				System.out.println("Quicksort: q" + "\n");
				System.out.println("Enter a command");
				//System.out.println("Learn more about the sorting algorithms: l" + "\n");
				user_input = scanner.next().charAt(0);//gets user input
				preformsort(user_input);
				break;
				
			case 'q':
				break;
			default:
				System.out.println("Error: Please enter another command");
			}
			
		}

	}
	
	public static int[] generatelist(int size, int max_value) {
		Random rand = new Random();
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = rand.nextInt(max_value);
		}
		return array;
	}
	
	public static void preformsort(char user_sort) {
		long completion_time;
		SortingAlgorithms sortalg = new SortingAlgorithms();
		System.out.println("Sorting started");
		
		//generates a new array copy so original array is saved
		int[] current_list = arrayOfRandom.clone(); 
		
		switch(user_sort) {
		case 's':
			completion_time = sortalg.selectionsort(current_list);
			System.out.println("Selection sort completed, took " + completion_time + " nanoseconds." + "\n");
			break;
		case 'b':
			completion_time = sortalg.bubblesort(current_list);
			System.out.println("Bubble sort completed, took " + completion_time + " nanoseconds." + "\n");
			break;
		case 'i':
			completion_time = sortalg.insertionsort(current_list);
			System.out.println("Insertion sort completed, took " + completion_time + " nanoseconds." + "\n");
			break;
		case 'm':
			completion_time = sortalg.sort(current_list, 0, current_list.length - 1);
			System.out.println("Mergesort completed, took " + completion_time + " nanoseconds." + "\n");
			break;
		case 'h':
			completion_time = sortalg.heapsort(current_list);
			System.out.println("Heapsort completed, took " + completion_time + " nanoseconds." + "\n");
			break;
		case 'q':
			completion_time = sortalg.quicksort(current_list, 0, current_list.length - 1);
			System.out.println("Quicksort completed, took " + completion_time + " nanoseconds." + "\n");
			break;
		/*case 'l':
			break;*/
		default:
			System.out.println("Error could not sort, incorrect input");
		}
	}

}
