import java.lang.Object;
import java.util.ArrayList;
import java.util.List;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

public class Database {

	public static void main(String[] args) {
		//going to create a cache of locations
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
}

