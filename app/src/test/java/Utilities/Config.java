package Utilities;

import java.util.Map;

public class Config {

    public static Object resolveVars(String value, Map<String, Object> configMap) {
        // If null, return empty string
        if (value == null) {
            return "";
        }
        
        String stringValue = (String) value;
        
        if (stringValue.isEmpty()) {
            return stringValue;
        }
        
        // Check if value starts with # or $
        if (stringValue.startsWith("#") || stringValue.startsWith("$")) {
            String refKey = stringValue.substring(1); // Remove # or $
            Object refValue = getValueCaseInsensitive(refKey, configMap);
            if (refValue != null) {
                stringValue = String.valueOf(refValue);
            } else {
                throw new RuntimeException("Element not found for reference: " + refKey);
            }
        }

        if (stringValue.equalsIgnoreCase("random_email")) {
            return generateRandomEmail();
        }

        if (stringValue.equalsIgnoreCase("random_password")) {
            return generateRandomPassword();
        }
      
        return stringValue;
    }
    
    /**
     * Case-insensitive lookup in configMap
     */
    private static Object getValueCaseInsensitive(String key, Map<String, Object> configMap) {
        if (key == null) {
            return null;
        }
        
        // First try exact match
        if (configMap.containsKey(key)) {
            return configMap.get(key);
        }
        
        // Try case-insensitive match
        for (String mapKey : configMap.keySet()) {
            if(mapKey.equalsIgnoreCase(key)) {
                return configMap.get(mapKey);
            }
        }
        
        return null;
    }

    private static String generateRandomEmail() {
        return "user" + System.currentTimeMillis() + "@gmail.com";
    }

    private static String generateRandomPassword() {
        return "Test@" + System.currentTimeMillis();
    }
    
}
