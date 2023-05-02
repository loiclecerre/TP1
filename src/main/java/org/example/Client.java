package org.example;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {

        // Se connecter au serveur sur le port 1234
        Socket socket = new Socket("localhost", 1234);

        // Créer un PrintWriter pour envoyer des données au serveur
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Envoyer un message au serveur
        out.println("Bonjour serveur!");

        // Fermer la connexion
        out.close();
        socket.close();
    }
}
