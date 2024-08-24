package com.curso.v0;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// From a client portafolio of a loan office, get the first high debt profile in alphabetical order
public class Principal {

	public static void main(String[] args) {
		
        List<ClientProfile> clientsList1 = new ArrayList<>();
        clientsList1.add(new ClientProfile("Juan Perez", 5000, 250.50, 2));
        clientsList1.add(new ClientProfile("Ana Gomez", 3000, 150.75, 1));
        clientsList1.add(new ClientProfile("Luis Ramirez", 7000, 350.00, 3));

        List<ClientProfile> clientsList2 = new ArrayList<>();
        clientsList2.add(new ClientProfile("Maria Lopez", 2000, 100.00, 0));
        clientsList2.add(new ClientProfile("Carlos Sanchez", 4500, 225.25, 2));
        clientsList2.add(new ClientProfile("Lucia Fernandez", 3200, 160.80, 1));
        clientsList2.add(new ClientProfile("Jorge Ruiz", 6000, 300.60, 3));
        clientsList2.add(new ClientProfile("Elena Castro", 5100, 255.10, 1));

        List<ClientProfile> clientsList3 = new ArrayList<>();
        clientsList3.add(new ClientProfile("Sofia Alvarez", 3500, 175.75, 2));
        clientsList3.add(new ClientProfile("Raul Jimenez", 2800, 140.40, 0));
        clientsList3.add(new ClientProfile("Andrea Morales", 6100, 305.00, 3));
        clientsList3.add(new ClientProfile("Miguel Ortiz", 4700, 235.60, 1));

        List<ClientProfile> clientsList4 = new ArrayList<>();
        clientsList4.add(new ClientProfile("Alberto Torres", 5000, 250.75, 2));
        clientsList4.add(new ClientProfile("Carmen Flores", 3200, 160.35, 0));
        clientsList4.add(new ClientProfile("Jose Vargas", 4200, 210.20, 1));
        clientsList4.add(new ClientProfile("Patricia Reyes", 6100, 305.10, 3));
        clientsList4.add(new ClientProfile("Diego Castro", 5300, 265.50, 1));
        clientsList4.add(new ClientProfile("Laura Hernandez", 4700, 235.75, 2));
        clientsList4.add(new ClientProfile("Fernando Diaz", 3800, 190.30, 0));

        List<List<ClientProfile>> allClients = new ArrayList<>();
        allClients.add(clientsList1);
        allClients.add(clientsList2);
        allClients.add(clientsList3);
        allClients.add(clientsList4);
        
        
        
        Optional<DebtClasification> firstHighRisk = allClients.stream()
        	.flatMap(x -> x.stream()) // Join the lists on a single stream
        	.filter(cl -> cl.getFaildeMonths() > 0) // Remove the clients with no failed Months
        	.map(cl -> new DebtClasification(cl.getName(), cl.getGeneratedInterest() > 300 ? "High Risk" : "Medium Risk")) // Create a debt clasification object list and set the risk depending on the generated interest
        	.sorted((cl1, cl2) -> cl1.getName().compareTo(cl2.getName())) // Sort the objects by name
        	.filter(cl -> cl.getClasification() == "High Risk") // Get the high risk debtors
        	.findFirst(); // Get the first high risk debtor if it exists

        System.out.println(firstHighRisk.get().getName());
	}

}
