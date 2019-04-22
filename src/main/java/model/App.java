package model;

import java.util.Scanner;

public final class App {
	private static final String
		INPUT_FILENAME = System.getProperty("user.dir") + "\\resources\\PetriNet.txt",
		OUTPUT_FILENAME = System.getProperty("user.dir") + "\\resources\\ExportedNetwork.txt";

    private App() {
    }

    public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		PetriNetworkBuilder builder = new PetriNetworkBuilder();

		PetriNetwork network = builder.buildFromFile(INPUT_FILENAME);

		System.out.println("Petri Network Simulator");
		System.out.println("Pressione ENTER para executar os ciclos da simulação.");
		System.out.println("Outras opções: ");
		System.out.println("	S:	Salvar rede em arquivo.");

		while (!network.EOF()) {
			String input = scanner.nextLine();

			int cycle = 0;

			switch (input) {
				case "S":
					PetriNetworkWriter writer = new PetriNetworkWriter();

					writer.saveToFile(network, OUTPUT_FILENAME);

				break;

				default:
					network.printCurrentCycle(cycle);

					cycle++;
				break;
			}
		}

		scanner.close();

    }
}
