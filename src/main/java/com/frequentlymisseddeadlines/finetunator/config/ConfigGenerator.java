package com.frequentlymisseddeadlines.finetunator.config;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class ConfigGenerator {
    public static void generateDefaultConfigFile(String filename) throws IOException {
        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        writer.append(yaml.dumpAs(FinetunatorConfig.ExampleConfig, Tag.MAP, null));
        FileWriter fw = new FileWriter(filename);
        fw.write(writer.toString());
        fw.close();
        writer.close();
    }
}
