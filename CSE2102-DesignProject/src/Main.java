import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
public class Main {

	public static void main(String[] args){
		final String API_KEY =  "AIzaSyD6ietwqG-woi90kQFzPViniL_iJ4RtCbs";
		GeoApiContext context = new GeoApiContext().setApiKey(API_KEY);
		GeocodingResult[] results;
		try {
			results = GeocodingApi.geocode(context,
			    "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
			System.out.println(results[0].formattedAddress);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
