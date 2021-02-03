package com.amazon.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
    private String url;
    private String baseURI;
    private String configFilePath;

    public PropertyFileReader() {
        Properties prop = new Properties();
        InputStream input = null;
        configFilePath ="config.properties";

        try {
            input = new FileInputStream(configFilePath);
            prop.load(input);

            this.url = prop.getProperty("base_url");
            this.baseURI = prop.getProperty("base_uri");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUrl() { return url; }

    public String getBaseURI() {
        return baseURI;
    }


}
