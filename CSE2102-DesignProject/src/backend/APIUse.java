package backend;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.NearbySearchRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.PlacesSearchResponse;

public class APIUse {
	public static PlacesSearchResponse Run(String userLocation){
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
				userLocation).await();
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
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	return results;
}}
