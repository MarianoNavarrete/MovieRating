import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.TreeMap;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		List<String> namesSorted = new LinkedList<String>();
		if(movieRatings == null) {
			return namesSorted;
		}else if(movieRatings.isEmpty()) {
			return namesSorted;
		}
		SortedMap<String, PriorityQueue<Integer>> sortedMovies = movieRatings;
		for(Map.Entry<String, PriorityQueue<Integer>> movies: sortedMovies.entrySet() ) {
			namesSorted.add(movies.getKey());
		}
		return namesSorted; 
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		List<String> scoredSorted = new LinkedList<String>();
		if(movieRatings == null) {
			return scoredSorted;
		} else if(movieRatings.isEmpty()) {
			return scoredSorted;
		}
		SortedMap<String, PriorityQueue<Integer>> sortedMovies = movieRatings;
		for(Map.Entry<String, PriorityQueue<Integer>> movies: sortedMovies.entrySet() ) {
			if(movies.getValue().peek()>rating) {
				scoredSorted.add(movies.getKey());
			}
		}
		return scoredSorted;
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		int count = 0;
		TreeMap<String, Integer> removeRatings = new TreeMap<String, Integer>();
		
		if(movieRatings == null) {
			return removeRatings;
		} else if(movieRatings.isEmpty()) {
			return removeRatings;
		}
		System.out.println(movieRatings);
		System.out.println(rating);
		for(Map.Entry<String, PriorityQueue<Integer>> movies : movieRatings.entrySet()) {
			PriorityQueue<Integer> pivot = new PriorityQueue<Integer>(movies.getValue());
			
			while(true) {
				if(pivot.peek()<rating) {
					pivot.remove();
					count++;
				}else{
					break;
				}
			}

			if(pivot.isEmpty()) {
				movieRatings.remove(movies.getKey());
			}else {
				movieRatings.put(movies.getKey(), pivot);
			}
			removeRatings.put(movies.getKey(), count);
			count = 0;
		}
		System.out.println(movieRatings);
		System.out.println();
		System.out.println(removeRatings);
		return removeRatings;
	}
}
