package org.example;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {

        // Créer un ServerSocket pour écouter sur le port 1234
        ServerSocket serverSocket = new ServerSocket(1234);

        // Attendre une connexion entrante
        System.out.println("Attente de connexion...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Connexion établie!");

        // Créer un BufferedReader pour lire les données envoyées par le client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Lire les données envoyées par le client et les afficher sur la console
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Message reçu du client: " + inputLine);
        }

        // Fermer la connexion
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
