package backend;
import java.util.concurrent.TimeUnit;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlacesApi;
import com.google.maps.TextSearchRequest;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

public class APIUse {
	public static PlacesSearchResult[] Run(Search search){
		//Set api keys
		final String GEOCODING_API_KEY =  "AIzaSyD6ietwqG-woi90kQFzPViniL_iJ4RtCbs";
		final String PLACES_API_KEY = "AIzaSyB2HVM_57qllCnn8wV8VLcPh4zKgsebtz0";
		//creating contexts
		GeoApiContext context = new GeoApiContext().setApiKey(GEOCODING_API_KEY);
		GeoApiContext context2 = new GeoApiContext().setApiKey(PLACES_API_KEY);

		/*
		 * This is the geocoding process
		 * We get the latlng of the string that the user inputs, userLocation	
		 */
		GeocodingResult[] coded = null;
		try {
			coded = GeocodingApi.geocode(context,
					search.getInput()).await();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Getting the stores within a radius 
		PlacesSearchResult[] results = new PlacesSearchResult[60]; //Google will only give us 60 results
		PlacesSearchResponse response = null;
		try{
			//Look at other SearchQueries and figure out how to customize them. 
			TextSearchRequest attempt = PlacesApi.textSearchQuery(context2, search.getStores());
			//here is where we configure the NearbySearchRequest
			attempt.location(coded[0].geometry.location);
			//attempt.name(search.getStores());
			attempt.radius(40234); //25 miles supposedly = 40234 Google returns data further away
			response = attempt.await();
			int page = 0;
			for(int i = 0; i < response.results.length; i++){
				results[20*page + i] = response.results[i];
			}
			if(response.nextPageToken != null){
				TextSearchRequest attempt2 = PlacesApi.textSearchNextPage(context2, response.nextPageToken); 
				page++;
				TimeUnit.SECONDS.sleep(2); //Google needs us to wait 2 seconds before we can find the next page
				response = attempt2.await();
				for(int i = 0; i < response.results.length; i++){
					results[20*page + i] = response.results[i];
				}
			}
			if(response.nextPageToken != null){
				TextSearchRequest attempt3 = PlacesApi.textSearchNextPage(context2, response.nextPageToken); 
				page++;
				TimeUnit.SECONDS.sleep(2); //Google needs us to wait 2 seconds before we can find the next page
				response = attempt3.await();
				for(int i = 0; i < response.results.length; i++){
					results[20*page + i] = response.results[i];
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return results;
	}
}

