package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {

		// Lecture des symptômes à partir du fichier "symptoms.txt"
		ReadSymptomDataFromFile symptomDataReader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = symptomDataReader.GetSymptoms();

		// Comptage des occurrences de chaque symptôme
		Map<String, Integer> counters = new HashMap<String, Integer>();
		symptoms.forEach(symptom -> {
			// Si le symptôme est déjà présent dans la map, on incrémente son compteur,
			// sinon on initialise à 1
			counters.put(symptom, counters.getOrDefault(symptom, 0) + 1);
		});

		Map<String, Integer> sortedCounters = new TreeMap<>(counters);

		// Écriture des résultats dans un fichier "result.out"
		try (FileWriter writer = new FileWriter("result.txt")) {
			// Boucle pour écrire chaque symptôme et son nombre d'occurrences
			for (Map.Entry<String, Integer> entry : sortedCounters.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
