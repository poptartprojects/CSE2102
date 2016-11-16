package backend;
import com.google.maps.model.PlacesSearchResponse;

public class Search {

	private String input;
	private PlacesSearchResponse results;
	private boolean McD, BK, W, PH, TJ, WF = false;
	private String stores = "";
	private void setStores(){
		if(McD){
			stores +=" McDonald's";
		}
		if(BK){
			stores +=" BurgerKing";
		}
		if(W){
			stores +=" Wendy's";
		}
		if(PH){
			stores +=" PizzaHut";
		}
		if(TJ){
			stores +=" TraderJoe's";
		}
		if(WF){
			stores +=" WholeFoods";
		}
	}

	public PlacesSearchResponse showMe(){
		this.setStores();
		this.setResults(APIUse.Run(this));
		return this.getResults();
	}



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
	public void setMcD(boolean value){
		McD = value;
	}
	public void setBK(boolean value){
		BK = value;
	}
	public void setW(boolean value){
		W = value;
	}
	public void setPH(boolean value){
		PH = value;
	}
	public void setTJ(boolean value){
		TJ = value;
	}
	public void setWF(boolean value){
		WF = value;
	}
	public String getStores(){
		return stores;
	}
}
