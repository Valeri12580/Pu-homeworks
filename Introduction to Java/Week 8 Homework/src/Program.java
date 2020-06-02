
import models.Adult;
import utils.Factory;
import utils.Regexp;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Program {
    private Repository repository;
    private BufferedReader reader;
    private Filter filter;

    public Program() {
        this.reader=new BufferedReader(new InputStreamReader(System.in));
        this.repository=new Repository();
        this.filter=new Filter();
    }

    public void start() {
        String input="";
        Pattern pattern= Pattern.compile(Regexp.COMMAND_INTERPRETER_REGEX);

        try {
            fillDataInRepository();
            System.out.println("Enter your query");

            while (!(input=reader.readLine()).equals("End")){

                List<Adult>filtered = this.repository.getData();

                String[] inputSplit = input.replace("SELECT", "").split("@");

                for (String command : inputSplit) {
                    Matcher matcher=pattern.matcher(command);
                    if(matcher.find()){
                        String criteria=matcher.group("criteria");
                        String value=matcher.group("value");
                        filtered=this.executeCommand(criteria,value,filtered);

                    }
                }
                printData(filtered);

                System.out.println("Enter your query");

            }


        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    private void printData(List<Adult> data) {
        if(data.size()==0){
            System.out.println("There is not data..check your input");
            return;
        }
        data.forEach(System.out::println);
    }

    private List<Adult> executeCommand(String criteria, String value,List<Adult>filtered){
        return filtered.stream().filter(this.filter.getPredicate(criteria,value)).collect(Collectors.toList());
    }


    private void fillDataInRepository() throws IOException {
      this.repository.addList(Factory.createObjects("src\\data\\data"));

    }
}
