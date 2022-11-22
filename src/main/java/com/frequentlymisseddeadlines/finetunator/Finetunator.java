package com.frequentlymisseddeadlines.finetunator;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Finetunator {
    public static void main (String... args) {
        Options options = new Options();
        Option input = new Option("i", "input", true, "input config file path");
        input.setRequired(false);
        options.addOption(input);
        Option generate = new Option("g", "generate", false, "generate an example config file");
        input.setRequired(false);
        options.addOption(generate);
        Option help = new Option("h", "help", false, "print this help page");
        input.setRequired(false);
        options.addOption(help);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("Finetunator", options);
            System.exit(1);
        }

        if (cmd.hasOption("help")) {
            formatter.printHelp("Finetunator", options);
            System.exit(0);
        }

        return;
    }
}
