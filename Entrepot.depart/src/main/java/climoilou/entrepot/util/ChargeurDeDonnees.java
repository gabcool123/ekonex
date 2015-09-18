/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climoilou.entrepot.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Martin Simoneau
 * @version 0.0.0
 */
public class ChargeurDeDonnees {
	
	private Stream<String> stream;
	private String fileName;

	public  List<String> charger() throws IOException,
			URISyntaxException {
		List<String> retVals;
		try (Stream<String> stream = Files.lines(getResourcePath(
				ChargeurDeDonnees.class, fileName))) {
			retVals = stream.collect(Collectors.toList());
		}
		return retVals;
	}
	
	public ChargeurDeDonnees(String path){
		fileName = path;
	}

	/**
	 * 
	 * @param resourceClass
	 *            la classe référence
	 * @param resourceName
	 *            le nom de la resource
	 * @return un path vers la resource
	 * @throws URISyntaxException
	 */
	private static Path getResourcePath(Class<?> resourceClass,
			String resourceName) throws URISyntaxException {
		URL url = resourceClass.getResource(resourceName);
		return Paths.get(url.toURI());
	}

	public static void main(String[] args) throws IOException,
			URISyntaxException {
		ChargeurDeDonnees chargeur = new ChargeurDeDonnees("liste.de.mots.francais.frgut.utf8.txt");
		
		Collection<String> all = chargeur.charger();
		
		for (int i = 0; i < 100; i++) {
			System.out.println(((List<String>) all).get(i) );
		}
		System.out.println("le nombre de lignes est: " +all.size());
	}

}
