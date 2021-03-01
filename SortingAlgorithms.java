

public class SortingAlgorithms {
	static long startTime, endTime;

	
	public static long bubblesort(int[] array) {
		startTime = System.nanoTime();
		int length = array.length; 
		
		
		//loops through list n^2 times and checks if left value 
		//is greater than right value and needs to be switched
        for (int i = 0; i < length-1; i++) 
            for (int j = 0; j < length-i-1; j++) 
                if (array[j] > array[j+1]) 
                { 
                    int temp = array[j]; 
                    array[j] = array[j+1]; 
                    array[j+1] = temp; 
                } 
	    
		endTime = System.nanoTime();
		return (endTime-startTime);
	}
	
	public static long selectionsort(int[] arr) {
		startTime = System.nanoTime();
		int n = arr.length; 
		  
        // parses thorugh array
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) {
                	min_idx = j; 
                }
                    
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
		endTime = System.nanoTime();
		return (endTime-startTime);
	}
	public static long insertionsort(int[] arr) {
		startTime = System.nanoTime();
		int n = arr.length;
		
		//iterates through array
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
 
            // Move elements of array that are
            //greater than key, to one position ahead
            // of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
		endTime = System.nanoTime();
		return (endTime-startTime);
	}
	
	//Only used to time the performance of the quicksort
	public static long quicksort(int arr[], int begin, int end) {
		startTime = System.nanoTime();
		recursivequicksort(arr, begin, end);
		endTime = System.nanoTime();
		return (endTime-startTime);
	}
	
	//as quicksort is recursive the timer is
	//started multiple times and slowes down performance.
	//This is the seperate recursive main function so there is no timer
	public static void recursivequicksort(int arr[], int begin, int end) {
		if (begin < end) {
	        int partitionIndex = partition(arr, begin, end);

	        recursivequicksort(arr, begin, partitionIndex-1);
	        recursivequicksort(arr, partitionIndex+1, end);
	    }
	}
	
	
	//Quicksort partions left and right of array
	//puts everything less than key on left, greater than key on right
	private static int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;

	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;

	    return i+1;
	}
	
	public static void mergesort(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
	}
	
	
	public static long sort(int arr[], int l, int r)
    {
		startTime = System.nanoTime();
        recursivesort(arr, l, r);
        endTime = System.nanoTime();
		return (endTime-startTime);
    }
	//as mergesort is recursive, the timer is
	//started multiple times and slowes down performance.
	//This is the seperate recursive main function so there is no timer
	public static void recursivesort(int arr[], int l, int r) {
		int n = arr.length;
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
 
            // Sort first and second halves
            recursivesort(arr, l, m);
            recursivesort(arr, m + 1, r);
 
            // Merge the sorted halves
            mergesort(arr, l, m, r);
        }
	}
	
	
	
	public static long heapsort(int[] arr) {
		startTime = System.nanoTime();
        int n = arr.length;
        
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
		endTime = System.nanoTime();
		return (endTime-startTime);
	}
	
	static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
