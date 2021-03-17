package edu.institution.midterm;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class PartManagerImpl implements PartManager {
	
	HashMap<String, Part> collection = new HashMap<String, Part>(); // collection with key value pairs
	
	public int importPartStore(String filePath) {		
		
		String jsonData = "";
		try {
			jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Part[] parts = gson.fromJson(jsonData, Part[].class);
		
		for(Part p : parts) {
			if(!(collection.containsKey(p.getPartNumber()))) {
				collection.put(p.getPartNumber(), p);
			}
			
		}

		return parts.length; 
	}

	public Part costPart(String partNumber){
		// TODO Auto-generated method stub
		
		if(collection.get(partNumber).getBillOfMaterial() == null) {
			return collection.get(partNumber);
	    } 
		
		float total = 0;
	       for(BomEntry p : collection.get(partNumber).getBillOfMaterial()) {
	           Part subPart = retrievePart(p.getPartNumber());
	           float extendedPrice = roundForMoney(costPart(subPart.getPartNumber()).getPrice() * p.getQuantity());
	           total = roundForMoney(total + extendedPrice);
	       }
	       
		collection.get(partNumber).setPrice(total);
		return collection.get(partNumber);
	}
	
	private float roundForMoney(float value) {
		 
		return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).floatValue();
	}
	
	public Part retrievePart(String partNumber) {
		// TODO Auto-generated method stub
		if(collection.containsKey(partNumber)) {
			return collection.get(partNumber);
		}
		return null;
	}

	public List<Part> getFinalAssemblies() {
		// TODO Auto-generated method stub
		List<Part> out = new ArrayList<Part>();
		for (Map.Entry mapElement : collection.entrySet()) { 
            Part p = (Part)mapElement.getValue(); 
            if (p.getPartType().equals("ASSEMBLY")) {
            	out.add(p);
            }
		}
		
		Collections.sort(out, new Comparator<Part>() {
	           public int compare(Part o1, Part o2) {
	               String p1 = o1.getPartNumber();
	               String p2 = o2.getPartNumber();
	               int diff = p1.compareToIgnoreCase(p2);

	               if (diff < 0) {
	                   return -1;
	               }
	               else if (diff > 0) {
	                   return 1;
	               }
	               else {
	                   return 0;
	               }
	           }
	       });
		
		return out;
	}

	public List<Part> getPurchasedPartsByPrice() {
		// TODO Auto-generated method stub
		List<Part> out = new ArrayList<Part>();
		for (Map.Entry mapElement : collection.entrySet()) { 
            Part p = (Part)mapElement.getValue(); 
            if (p.getPartType().equals("PURCHASE")) {
            	out.add(p);
            }
		}
		
		 Collections.sort(out, new Comparator<Part>() {
	           public int compare(Part o1, Part o2) {
	               float p1 = o1.getPrice();
	               float p2 = o2.getPrice();
	               if(p1 == p2) {
	                   return 0;
	               } else if (p1 < p2) {
	                   return 1;
	               } else {
	                   return -1;
	               }
	           }
	       });
		
		return out;
	}

}
