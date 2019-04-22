package model;

import java.io.*;

public class PetriNetworkBuilder {
	private PetriNetwork network;

	public PetriNetworkBuilder() {
		this.network = new PetriNetwork();
	}

	public PetriNetwork buildFromFile(String filename) {
		FileReader fileReader;
		BufferedReader bufferedReader;
		
        String currentLine = "";
	   
		try {

            fileReader = new FileReader(filename);
			bufferedReader = new BufferedReader(fileReader);
			
            currentLine = bufferedReader.readLine();

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}

		while (currentLine != null) {
			String[] lineKeyValue = currentLine.split(" = ");

			String keyCommand = lineKeyValue[0].split(" ")[0];

			String keyReference = lineKeyValue[0].split(" ")[1];

			switch (keyCommand) {
				
				case "QTD_LUGAR":
					addPlaces(Integer.valueOf(lineKeyValue[1]));
				break;

				case "QTD_TRANSICAO":
					addTransitions(Integer.valueOf(lineKeyValue[1]));
				break;

				case "LUGARES_ENTRADA":
					setInputPlaces(
						keyReference,
						lineKeyValue[1]
					);
				break;

				case "LUGARES_SAIDA":
					setOutputPlaces(
						keyReference,
						lineKeyValue[1]
					);
				break;

				case "QTD_MARCAS":
					setTokenCount(
						keyReference,
						Integer.valueOf(lineKeyValue[1])
					);
				break;

				case "PESO_ARCO":
					String[] arcReferences = keyReference.split("_");

					setArcWeight(
						arcReferences[0],
						arcReferences[1],
						Integer.valueOf(lineKeyValue[1])
					);
					
				break;

			}
		}

		return this.network;

	}

	private void addPlaces(int count) {
		for (int i = 1; i <= count; i++) {
			Place place = new Place("L" + Integer.toString(count));

			this.network.getPlaces().add(place);
		}
	}

	private void addTransitions(int count) {
		for (int i = 1; i <= count; i++) {
			Transition transition = new Transition("T" + Integer.toString(count));

			this.network.getTransitions().add(transition);
		}
	}

	private void setInputPlaces(String transitionName, String placesList) {
		
	}
	
	private void setOutputPlaces(String transitionName, String placesList) {

	}

	private void setTokenCount(String placeName, int tokenCount) {
		for (int i = 0; i < this.network.getPlaces().size(); i++)
			if (this.network.getPlaces().get(i).getName().equals(placeName))
				this.network.getPlaces().get(i).setTokenCount(tokenCount);
	}

	private void setArcWeight(String originName, String destinationName, int weight) {
		for (int i = 0; i < this.network.getArcs().size(); i++)
			if (this.network.getArcs().get(i).getOrigin().getName().equals(originName))
				if (this.network.getArcs().get(i).getDestination().getName().equals(destinationName))
					this.network.getArcs().get(i).setWeight(weight);
	}

}