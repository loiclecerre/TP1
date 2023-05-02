package org.example;

import java.io.*;
import java.net.*;

public class Serveur {
    public static void main(String[] args) {
        int port = 64555; // port à écouter
        ServerSocket serveurSocket = null;
        Socket clientSocket = null;
        BufferedReader entree = null;
        PrintWriter sortie = null;
        try {
            serveurSocket = new ServerSocket(port); // création du serveur sur le port spécifié
            System.out.println("Serveur démarré sur le port " + port);
            while (true) { // boucle infinie pour écouter en permanence les connexions des clients
                clientSocket = serveurSocket.accept(); // attendre la connexion d'un client
                System.out.println("Nouvelle connexion de " + clientSocket.getInetAddress().getHostName());
                entree = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // ouverture du flux entrant
                sortie = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true); // ouverture du flux sortant
                String messageClient;
                while ((messageClient = entree.readLine()) != null) { // boucle pour lire les messages du client
                    System.out.println("Message reçu de " + clientSocket.getInetAddress().getHostName() + ": " + messageClient);
                    sortie.println("Message reçu : " + messageClient); // envoi d'une réponse au client
                }
                System.out.println("Fin de connexion avec " + clientSocket.getInetAddress().getHostName());
                entree.close(); // fermeture des flux et de la connexion avec le client
                sortie.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Erreur : " + e);
        }
    }
}
