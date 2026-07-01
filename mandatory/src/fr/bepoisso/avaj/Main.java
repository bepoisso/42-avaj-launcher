package fr.bepoisso.avaj;

import fr.bepoisso.avaj.simulator.Simulator;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Wrong number of arguments");
			return;
		}

		System.out.println("========================");
		System.out.println("===== AVAJ-LUNCHER =====");
		System.out.println("========================\n");
		try {
			Simulator simulator = new Simulator(args[1]);
			simulator.parse();
			System.out.println("Done ✅");
			simulator.factory();
			System.out.println("Done ✅");
			simulator.run();
			System.out.println("Done ✅");
			System.out.println("\n--- End of simulation\n");

		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.out.println("Fail ❌");
		}
	}
}
