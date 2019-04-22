package model;

import java.io.*;

public class PetriNetworkWriter {
	private PetriNetwork network;

	public PetriNetworkWriter() {

	}

	public void saveToFile(PetriNetwork network, String filename) {
		this.network = network;

		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
	   
		try {

            fileWriter = new FileWriter(filename);
			bufferedWriter = new BufferedWriter(fileWriter);

			// QTD_LUGAR
			bufferedWriter.append(this.getPlaceCount());
			bufferedWriter.append(System.lineSeparator());

			// QTD_TRANSICAO
			bufferedWriter.append(this.getTransitionCount());
			bufferedWriter.append(System.lineSeparator());

			// LUGARES_ENTRADA
			bufferedWriter.append(this.getInputPlaces());
			bufferedWriter.append(System.lineSeparator());

			// LUGARES_SAIDA
			bufferedWriter.append(this.getOutputPlaces());
			bufferedWriter.append(System.lineSeparator());

			// QTD_MARCAS
			bufferedWriter.append(this.getTokenCounts());
			bufferedWriter.append(System.lineSeparator());

			// PESO_ARCO
			bufferedWriter.append(this.getArcWeights());
			bufferedWriter.append(System.lineSeparator());

			bufferedWriter.flush();
			bufferedWriter.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getPlaceCount() {
		String placeCount = "";

		return placeCount;
	}

	private String getTransitionCount() {
		String transitionCount = "";

		return transitionCount;
	}

	private String getInputPlaces() {
		String inputPlaces = "";

		return inputPlaces;
	}

	private String getOutputPlaces() {
		String outputPlaces = "";

		return outputPlaces;
	}

	private String getTokenCounts() {
		String tokenCounts = "";

		return tokenCounts;
	}

	private String getArcWeights() {
		String arcWeights = "";

		return arcWeights;
	}
}