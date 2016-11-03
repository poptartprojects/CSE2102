import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.PlacesSearchResponse;
public class Main {

	public static void main(String[] args){
		final String GEOCODING_API_KEY =  "AIzaSyD6ietwqG-woi90kQFzPViniL_iJ4RtCbs";
		final String PLACES_API_KEY = "AIzaSyB2HVM_57qllCnn8wV8VLcPh4zKgsebtz0";
		GeoApiContext context = new GeoApiContext().setApiKey(GEOCODING_API_KEY);
		GeoApiContext context2 = new GeoApiContext().setApiKey(PLACES_API_KEY);
		GeocodingResult[] coded = null;
		try {
			coded = GeocodingApi.geocode(context,
					"06269").await();
			System.out.println(coded[0].geometry.location.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Getting the stores within a radius 		
		PlacesSearchResponse results = null;
		try{
			//Look at other SearchQueries and figure out how to customize them. 
			NearbySearchRequest attempt = PlacesApi.nearbySearchQuery(context2, coded[0].geometry.location);
			//here is where we configure the NearbySearchRequest
			attempt.name("Home Depot");
			attempt.radius(40234); //25 miles
			results = attempt.await();
			System.out.println(results.results[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
