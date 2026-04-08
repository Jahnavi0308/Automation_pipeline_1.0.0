package Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import Utilities.Config;

public class readini {
    private Map<String, Object> configMap;
    
    public Map<String, Object> readini(String filePath) {
        configMap = new HashMap<>();
        parseIniFile(filePath);
        return configMap;
    }
    
    /**
     * Parse INI file and extract key=value pairs
     * Format: key = value (spaces around = are trimmed)
     */
    public void parseIniFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip empty lines and comments
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#") || line.startsWith(";")) {
                    continue;
                }
                
                // Skip section headers [like this]
                if (line.startsWith("[") && line.endsWith("]")) {
                    continue;
                }
                
                // Parse key=value
                if (line.contains("=")) {
                    String[] parts = line.split("=", 2); // Split only on first =
                    String key = parts[0].trim();
                    String value = (parts.length > 1) ? parts[1].trim() : "";
                    configMap.put(key, value);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading INI file: " + e.getMessage());
        }
    }
    

    public Object getPropertyObject(String key) {
        return Config.resolveVars(key, configMap);
    }

    
    
}
