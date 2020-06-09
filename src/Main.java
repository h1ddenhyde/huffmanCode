import services.CodingCommand;
import services.ResultDescriptor;

class Main {
    public static void main(String[] args) {
        CodingCommand codingCommand = new CodingCommand();
        codingCommand.execute();
        new ResultDescriptor(codingCommand).describeResults();
    }
}


