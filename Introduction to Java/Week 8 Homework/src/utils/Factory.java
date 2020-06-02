package utils;


import models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Factory {


    public static List<Adult> createObjects(String path) throws IOException {
        List<Adult> data = new ArrayList<>();

        FileReader fileReader = new FileReader(new File(path));

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while (!(line = bufferedReader.readLine()) .equals("")) {
            String[] split = line.split("::");
            Adult person = createSpecificInstance(split);
            if (person == null) {
                System.out.println("Invalid data!");
                continue;
            }
            System.out.println("Imported successful!");
            data.add(person);

        }
        return data;

    }

    private static Adult createSpecificInstance(String[] data) {
        String mainData = data[0];
        String specificData = data[1];

        Pattern pattern = Pattern.compile(Regexp.BASE_REGEX);
        Matcher matcher = pattern.matcher(mainData);

        Adult person = null;

        if (matcher.find()) {
            char type = matcher.group("type").charAt(0);
            String firstName = matcher.group("firstName");
            String lastName = matcher.group("lastName");
            int age = Integer.parseInt(matcher.group("age"));
            char sex = matcher.group("sex").charAt(0);
            String address = matcher.group("address");
            String phonenumber = matcher.group("phone");

            person = build(type, firstName, lastName, age, sex, address, phonenumber, specificData);

        }


        return person;
    }

    private static Adult build(char type, String firstName, String lastName, int age, char sex, String address, String phoneNumber, String specificData) {
        Adult object = new Adult(type, firstName, lastName, age, address, phoneNumber, sex);


        if (type == 'M') {
            buildMother(specificData, object);
        } else {
            buildOther(specificData,object);
        }


        return object;

    }

    private static void buildOther(String specificData, Adult object) {
        String regex = Regexp.PENSION_SALARY_FINDER_REGEX;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher=pattern.matcher(specificData);

        if (matcher.find()) {
            double money = Double.parseDouble(matcher.group("money"));
            object.setMoney(money);

        }


    }

    private static void buildMother(String specificData, Adult adult) {
        List<Kid> kids = new ArrayList<>();

        String regex = Regexp.KID_SEARCHER_REGEX;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        String[] kidsSpecificData = specificData.split(":");

        for (String kid : kidsSpecificData) {
            matcher = pattern.matcher(kid);
            if (matcher.find()) {
                kids.add(new Kid(matcher.group("firstName")
                        , matcher.group("lastName"), Integer.parseInt(matcher.group("age")), 'C'));
            } else {
                System.out.println("Invalid kid!");
            }
        }

        adult.setMoney(-1);
        adult.setKids(kids);
    }
}
