package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> results = new ArrayList<String>();

		if (filepath != null) {
			// Tentative de lecture du fichier avec un BufferedReader pour une meilleure
			// gestion des flux
			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				// Lecture ligne par ligne jusqu'à la fin du fichier. Stockage dans la liste
				// results
				String line;
				while ((line = reader.readLine()) != null) {
					results.add(line);
				}
			} catch (IOException e) {
				System.err.println("Erreur lors de la lecture du fichier : " + filepath + e.getMessage());
			}
		}
		return results;
	}
}
