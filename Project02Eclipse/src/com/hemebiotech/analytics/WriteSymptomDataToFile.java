package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

/**
 * Implementation of ISymptomWriter that writes symptom data to a file.
 * The symptoms are written as "symptom : frequency" pairs, one per line.
 * 
 * The file is overwritten if it already exists.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;

    /**
     * Constructor that initializes the file path where symptoms will be written.
     * 
     * @param filepath The full path to the file where symptom data will be saved.
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Writes the provided symptom data to the specified file.
     * Each symptom and its frequency are written as "symptom : frequency" pairs,
     * one per line.
     * 
     * @param symptoms A map where the key is the symptom (String) and the value is
     *                 the frequency (Integer).
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(filepath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
            }
        } catch (Exception e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + filepath + e.getMessage());
        }
    }

}
