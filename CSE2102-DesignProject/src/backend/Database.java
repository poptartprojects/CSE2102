package backend;
import java.util.ArrayList;
import java.util.List;
import com.google.maps.model.PlacesSearchResult;

public class Database {

	public static void main(String[] args) {
		//going to create a cache of locations
		/*
		List<String> traderJoes = new ArrayList<String>();
		BufferedReader br = null;
		try{
			String sCurrentLine;
			br = new BufferedReader(new FileReader("C:/Users/Owner/Documents/traderjoes.txt"));
			while((sCurrentLine = br.readLine()) != null){
				//System.out.println(sCurrentLine);
				traderJoes.add(sCurrentLine);
			}

		}
		catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(br != null)
					br.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		List<String> wholeFoods = new ArrayList<String>();
		try{
			String sCurrentLine;
			br = new BufferedReader(new FileReader("C:/Users/Owner/Documents/wholefoods.txt"));
			while((sCurrentLine = br.readLine()) != null){
				//System.out.println(sCurrentLine);
				wholeFoods.add(sCurrentLine);

			}

		}
		catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(br != null)
					br.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		System.out.println(traderJoes);
		System.out.println(wholeFoods);
	}
	*/
	}
	List<Search> history = new ArrayList<Search>();
	public PlacesSearchResult[] showMe(Search info)
	{
		PlacesSearchResult[] response = new PlacesSearchResult[60];
		String infoString = info.getInput();
		for(int i = 0; i < history.size(); i++)
		{
			if(history.get(i).getInput().equals(infoString))
			{
				response = history.get(i).getResults();
				System.out.println("DATABASE");
				return response;
			}
		}
		info.setResults(APIUse.Run(info));
		history.add(info);
		System.out.println("API USED");
		for(PlacesSearchResult result: info.getResults()){
			System.out.println(result.formattedAddress);
		}
		return info.getResults();
	}
	public List<Search> getHistory(){
		return this.history;
	}
}

