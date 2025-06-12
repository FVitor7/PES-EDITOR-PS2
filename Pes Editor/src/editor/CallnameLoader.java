package editor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CallnameLoader {
    public static List<CallnameEntry> load(File file) {
        List<CallnameEntry> list = new ArrayList<CallnameEntry>();
        if (file == null || !file.exists()) {
            return list;
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.length() == 0 || line.startsWith("#")) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    try {
                        int call = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        list.add(new CallnameEntry(call, name));
                    } catch (NumberFormatException e) {
                        // ignore malformed line
                    }
                }
            }
        } catch (Exception e) {
            // ignore
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
            }
        }
        return list;
    }
}
