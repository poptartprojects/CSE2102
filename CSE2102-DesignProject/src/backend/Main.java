package backend;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;
public class Main {
	//design idea: The application has an instance of database. First, check the database to see if a search has been run 
	//before. Filtering through cached locations.....If a search has been run before, pull some distance matrix api stuff? 
	//Nah... that still uses API requests and those uses are limited. Just store the date of the search and then also store 
	//the results gathered from that search with that search 
	public static void main(String[] args){
		Database cache = new Database();
		Search searcher = new Search();
		searcher.setInput("06269");
		cache.showMe(searcher);
		cache.showMe(searcher);
	}
}
