package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        // Écriture des résultats dans un fichier "result.out"
        try (FileWriter writer = new FileWriter(filepath)) {
            // Boucle pour écrire chaque symptôme et son nombre d'occurrences
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture dans le fichier : " + filepath + e.getMessage());
        }
    }
}
