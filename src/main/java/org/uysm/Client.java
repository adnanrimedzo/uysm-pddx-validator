package org.uysm;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.uysm.fileoperation.FileOperations;
import org.uysm.pddx.PDDXValidator;

import java.util.ArrayList;
import java.util.List;

public class Client {

    @Option(name = "-s", usage = "status")
    private String status = "validate";

    @Option(name = "-uid", usage = "user id")
    public String userId = "";

    @Option(name = "-p", usage = "user password")
    public String password = "";

    @Option(name = "-pddx", usage = "pddx file path")
    public String path = "";

    @Argument
    private List<String> arguments = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        try {
            new Client().doMain(args);
            System.exit(0);
        }catch (Exception e) {
            System.exit(-1);
        }
    }

    public void doMain(String[] args) throws Exception {
        CmdLineParser parser = new CmdLineParser(this);

        parser.setUsageWidth(80);

        try {
            parser.parseArgument(args);

            Boolean result = false;

            if ("validate".equals(status)) {
                String pddx = FileOperations.openFile(path);
                result = PDDXValidator.validate(pddx, userId, password);
            }

            System.err.println("****Result: "+result);

            if (arguments.isEmpty())
                throw new CmdLineException(parser, "No argument is given");

            if (result) {
                throw new Exception("invalid pddx");
            } else {
                return;
            }

        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java SampleMain [options...] arguments...");
            parser.printUsage(System.err);
            System.err.println();

            return;
        }

    }
}
