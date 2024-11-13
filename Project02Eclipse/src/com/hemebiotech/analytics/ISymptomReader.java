package com.hemebiotech.analytics;

import java.util.List;

/**
 * Represents any component that retrieves symptom data from a data source.
 * The main requirement is that the returned value is a list of strings,
 * which may contain duplicate symptoms.
 * 
 * The order of the symptoms in the list is not important.
 */
public interface ISymptomReader {

	/**
	 * Retrieves a list of symptoms from the data source.
	 * If no data is available, returns an empty list.
	 * 
	 * @return an unsorted list of symptoms, which may contain duplicates
	 */
	List<String> getSymptoms();

}
