package utils;

public class Regexp {
    public static final String BASE_REGEX="\\{TYPE}=\\[(?<type>[RWM])\\]@\\{FNAME}=\\[(?<firstName>[A-Z][a-z]+)\\]@\\{LNAME}=\\[(?<lastName>[A-Z]{1}[a-z]+)\\]@\\{AGE}=\\[(?<age>[0-9]+)\\]@\\{SEX}=\\[(?<sex>[MF])\\]@\\{ADDRESS}=\\[(?<address>[A-Z][a-z]+)\\]@\\{PHONE}=\\[(?<phone>[0-9]{10})\\]";
    public static final String KID_SEARCHER_REGEX="\\{KID}=\\[\\{KFNAME}=\\[(?<firstName>[A-Z][a-z]+)\\]@\\{KLNAME}=\\[(?<lastName>[A-Z][a-z]+)\\]@\\{KAGE}=\\[(?<age>[0-9]+)\\]\\]";
    public static final String PENSION_SALARY_FINDER_REGEX="\\{(PENSION|SALARY)}=\\[(?<money>[0-9]+)\\]";
    public static final String COMMAND_INTERPRETER_REGEX="\\{(?<criteria>[A-Z_]+)}=\\[(?<value>[A-Za-z0-9]+)\\]";
}
