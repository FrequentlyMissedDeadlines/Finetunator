package com.frequentlymisseddeadlines.finetunator.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigGeneratorTest {
    @Test
    public void defaultConfigShouldBeWrittenToOutputFile(@TempDir Path tempDir) throws IOException {
        ConfigGenerator cg = new ConfigGenerator();
        String tmp = tempDir.resolve("sample.yaml").toString();
        InputStream expected = getClass().getClassLoader().getResourceAsStream("example.yaml");

        cg.generateDefaultConfigFile(tmp);

        Yaml yaml = new Yaml(new Constructor(FinetunatorConfig.class));
        InputStream actual = new FileInputStream(tmp);
        FinetunatorConfig expectedConfig = yaml.load(expected);
        FinetunatorConfig sampleConfig = yaml.load(actual);

        actual.close();

        assertEquals(expectedConfig, sampleConfig);
    }
}
