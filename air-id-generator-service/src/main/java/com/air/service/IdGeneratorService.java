package com.air.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class IdGeneratorService {

    private static String FILE_PATH;

    private final Object lock = new Object();

    @Autowired
    private Environment env;

    @Autowired
    public IdGeneratorService(Environment env) {
        this.env = env;
        FILE_PATH = env.getProperty("file_path");
    }

    public String generateId() {
        synchronized (lock) {
            int lastId = readLastIdFromFile();
            lastId++;
            writeLastIdToFile(lastId);
            return String.format("%c%04d", 'A', lastId);
        }
    }

    private int readLastIdFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = reader.readLine();
            if (line != null && !line.isEmpty()) {
                return Integer.parseInt(line);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return 0; // Default to 0 if file doesn't exist or cannot be read
    }

    private void writeLastIdToFile(int lastId) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(String.valueOf(lastId));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
