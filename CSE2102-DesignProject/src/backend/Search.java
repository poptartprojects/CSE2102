package backend;


import com.google.maps.model.PlacesSearchResponse;

public class Search {

	private String input;
	private PlacesSearchResponse results;
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public PlacesSearchResponse getResults() {
		return results;
	}
	public void setResults(PlacesSearchResponse results) {
		this.results = results;
	}
	
	
	
	
}
