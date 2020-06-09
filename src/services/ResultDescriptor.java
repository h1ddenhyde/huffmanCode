package services;

public class ResultDescriptor {

    CodingCommand codingCommand;

    public ResultDescriptor(CodingCommand codingCommand) {
        this.codingCommand = codingCommand;
    }

    public void describeResults() {
        System.out.println("String " + codingCommand.string);
        System.out.println("String size " + codingCommand.string.length());
        System.out.println("Coded word size " + codingCommand.word.toString().toCharArray().length);
        System.out.println("Result " + codingCommand.getResult());
        System.out.println("Codes " + codingCommand.codes.toString());
    }

    void estimate() {

    }

}
