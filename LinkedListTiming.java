public class LinkedListTiming {

/*
* @author Sarthak Goyal
*/
		public static void main(String[] args) {
			int[] arr1 = new int[10000];
			  // Do 10000 lookups and use the average running time.
		    int timesToLoop = 5000;
		    
		    // For each problem size n . . .
		    for (int n = 1000; n <= 10000; n += 1000) {
		      long startTime, midpointTime, stopTime;
		      startTime = System.nanoTime();
		      while (System.nanoTime() - startTime < 1000000000) { // empty block 
		      }

		      LinkedListStack<Integer> lls = new LinkedListStack<Integer>();
		      ArrayStack<Integer> arr = new ArrayStack<Integer>();
		      
		    /*  for(int i = 0; i < timesToLoop; i++) {               //push 
			    	 //lls.push(i);
		    	  	 arr.push(i);
			      }*/
		      
		      // Now, run the test.  
		      startTime = System.nanoTime();

		      for (int i = 0; i < timesToLoop; i++) {               //push
		    	 lls.push(i);
		    	 //arr.push(i);
		      }

		      midpointTime = System.nanoTime();

/*		      for(int i = 0; i < timesToLoop; i++) { 	             //pop
		    	  //lls.pop(); 
		    	  //arr.pop();
		      }*/
		      
/*		      for (int i = 0; i < timesToLoop; i++) {        //peek
		    	 //lls.peek();
		    	 //arr.peek();
		        }*/

		      stopTime = System.nanoTime();

		      // Compute the time, subtract the cost of running the loop
		      // from the cost of running the loop and doing the lookups.
		      // Average it over the number of runs.
		      double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
		          / timesToLoop;

		      System.out.println(n + "\t" + averageTime);
		  }

		}
			
}
