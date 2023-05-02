package org.example;

import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) {
        String serverName = "localhost"; // le nom ou l'adresse IP du serveur
        int port = 64555; // le port sur lequel le serveur écoute les connexions

        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket clientSocket = new Socket(serverName, port);

            System.out.println("Connected to " + clientSocket.getRemoteSocketAddress());

            // ouvrir un flux d'entrée pour recevoir les données envoyées par le serveur
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputStream));

            // ouvrir un flux de sortie pour envoyer des données au serveur
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter outputWriter = new PrintWriter(outputStream, true);

            // envoyer une requête au serveur
            String request = "Hello, server!";
            outputWriter.println(request);

            // lire la réponse du serveur
            String response = inputReader.readLine();
            System.out.println("Server response: " + response);

            // fermer la connexion
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
