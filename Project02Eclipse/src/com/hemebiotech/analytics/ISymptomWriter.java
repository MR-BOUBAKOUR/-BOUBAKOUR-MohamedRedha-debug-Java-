package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for components that write symptom data to a data source.
 * The symptom data is provided as a map where the key is the symptom (String)
 * and the value is the frequency of that symptom (Integer).
 * 
 * Implementations of this interface will write the symptom data to a file
 */
public interface ISymptomWriter {

    /**
     * Writes the provided symptom data to a destination.
     * 
     * The data is represented as a map where the key is the symptom (String)
     * and the value is the frequency (Integer) of that symptom.
     * 
     * @param symptoms a map containing symptom names as keys and their frequencies
     *                 as values
     */
    public void writeSymptoms(Map<String, Integer> symptoms);

}
