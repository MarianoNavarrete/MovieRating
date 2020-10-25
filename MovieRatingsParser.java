import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		TreeMap<String, PriorityQueue<Integer>> ratings = new TreeMap<String, PriorityQueue<Integer>>();
		if(allUsersRatings == null) {
			return ratings;
		} else if(allUsersRatings.isEmpty()) {
			return ratings;
		}
		for(UserMovieRating userRating: allUsersRatings) {
			if(userRating != null) {
				if(userRating.getMovie() != null) {
					if(!userRating.getMovie().isEmpty() ) {
						if(userRating.getUserRating() > 0) {
							if(ratings.containsKey(userRating.getMovie().toLowerCase())) {
								PriorityQueue<Integer> pivot = new PriorityQueue<Integer>(ratings.get(userRating.getMovie()));
								pivot.add(userRating.getUserRating());
								ratings.put(userRating.getMovie().toLowerCase(), pivot);
							} else {
								PriorityQueue<Integer> pivot = new PriorityQueue<Integer>();
								pivot.add(userRating.getUserRating());
								ratings.put(userRating.getMovie().toLowerCase(), pivot);
							}
						}
						
					}
				}
				
			}
			
			
		}
		return ratings; 
	}

}
