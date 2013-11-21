package bobby;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableExplanation {
	public HashTableExplanation(){
		Hashtable<String, Integer> frequencyTable = new Hashtable<String, Integer>();
		
		String key = Float.toString(5.0f);
		Integer value = (frequencyTable.containsKey(key) ? frequencyTable.get(key) + 1 : 1);
		frequencyTable.put(key, value);
		
		Enumeration<String> keys = frequencyTable.keys();
		
		String currentKey;
		while ((currentKey = keys.nextElement()) != null){
			Integer frequency = frequencyTable.get(currentKey);
			
		}
	}
}
