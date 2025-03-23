import java.util.ArrayList;

import java.util.List;

public class Parser {
	
	private Parser() {
	}
	
	/**
	 * Parses the given line that returns a list of strings 
	 * @param buffer the given line to parse
	 * @return an array list of strings
	 */
	static List<String> parseLine(String buffer) {
		ArrayList<String> stringList = new ArrayList<String>();
		boolean quotes = false;
		int startIndex = 0;
		
		// iterate the characters in the string
		for (int i = 0; i < buffer.length(); i++) {
			
			// check if the character is a double quote or comma
			if (buffer.charAt(i) == '\"') {
				// toggle the quotes flag to determine status
				quotes = !quotes;
			} else if (buffer.charAt(i) == ',' && quotes == false) {
				
				// retrieve the string and add it to the list
				String str = buffer.substring(startIndex, i);
				if (str.isEmpty()) {
					stringList.add(str);
				} else if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
					stringList.add(str.substring(1, str.length() - 1));
				} else {
					stringList.add(str);
				}
				startIndex = i + 1;
			}
		}
		// add the last string
		String str = buffer.substring(startIndex);
		if (!str.isEmpty() && str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
			stringList.add(str.substring(1, str.length() - 1));
		} else {
			stringList.add(buffer.substring(startIndex));
		}
		return stringList;
	}
	
	/**
	 * Parses the header row and retrieves the order of the headers by index;
	 * @param buffer the given header row string
	 * @param the specified headers to retrieve index for - Note: the order of the elements is important!
	 * @return an array of the headers' indexes
	 */
	static int[] getHeaderIndexes(String buffer, String[] headers) {
		int[] index = new int[headers.length];
		
		// find out the header indexes
		List<String> headersList = Parser.parseLine(buffer);
		
		for (int i = 0; i < headers.length; i++) {
			for (int k = 0; k < headersList.size(); k++) {
				if (headersList.get(k).equals(headers[i])) {
					index[i] = k;
					break;
				}
			}
		}
		return index;
	}
}


