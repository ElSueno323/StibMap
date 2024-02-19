package Config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author <@Gabriel.espinosa>
 */
public class ConfigManager {

    private final Properties prop;
    private final String url;
    private static final String FILE = "./config/config.properties";

    private ConfigManager() {
        prop = new Properties();
        url = getClass().getClassLoader().getResource(FILE).getFile();
    }

    public void load() throws IOException {
        try {

            InputStream input = new FileInputStream(url);
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Echec chargement config : "+ e.getMessage());//?????
        }
    }

    public static ConfigManager getInstance() {
        return ConfigManagerHolder.INSTANCE;
    }

    public String getProperties(String names) {
        return prop.getProperty(names);
    }

    private static class ConfigManagerHolder {

        private static final ConfigManager INSTANCE = new ConfigManager();
    }
}





















