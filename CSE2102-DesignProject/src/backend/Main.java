package backend;
public class Main {
	//design idea: The application has an instance of database. First, check the database to see if a search has been run 
	//before. Filtering through cached locations.....If a search has been run before, pull some distance matrix api stuff? 
	//Nah... that still uses API requests and those uses are limited. Just store the date of the search and then also store 
	//the results gathered from that search with that search 
	public static void main(String[] args){
		
		//I want to make the database a text file, which we can read from on application start up, so it actually saves between uses. 
		Database cache = new Database();
		Search searcher = new Search();
		searcher.setInput("06269");
		cache.showMe(searcher);
		cache.showMe(searcher);
	}
}
