package edu.institution.actions.asn5;

import java.util.List;

public class Utilities {
	public <T> void removeDuplicates(List<T> items){
		if(items == null) {return;}

		for (int x = 0; x < items.size(); x++) {
			 
			for(int y = x + 1; y < items.size(); y++) {
				
				 if(items.get(x).equals(items.get(y))){
					 
                     items.remove(y);
                     y--;
                     
                 }
			 }
         }
	}
	
	public <E> E linearSearch(List<E> list, E key){
		if((list == null) || (key == null)) {return null;}
		
		for(int x = 0; x < list.size(); x++) {
			
			if(list.get(x).equals(key)) {

                  return list.get(x);
                  
			}
		}
		
		return null;
	
	}
	
}
