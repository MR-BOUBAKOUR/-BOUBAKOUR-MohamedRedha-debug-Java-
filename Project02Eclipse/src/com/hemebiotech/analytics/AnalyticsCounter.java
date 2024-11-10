package com.hemebiotech.analytics;

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
		// Tri des symptômes par ordre alphabétique en utilisant un TreeMap
		Map<String, Integer> sortedCounters = new TreeMap<>(counters);

		// Ecriture des symptoms ainsi que leur fréquence dans le fichiers cible
		// "result.txt"
		WriteSymptomDataToFile symptomDataWriter = new WriteSymptomDataToFile("result.txt");
		symptomDataWriter.writeSymptoms(sortedCounters);
	}
}
