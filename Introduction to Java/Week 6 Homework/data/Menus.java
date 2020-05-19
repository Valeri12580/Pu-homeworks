package data;

public final class Menus {

    //can't be instantiated
    private Menus() {
    }

    public static final String MAIN_MENU = "1. Работа с числа\n2. Работа с думи\n3. Изход от програмата";
    public static final String ARRAY_NUMBER_UTIL_MENU = "1. Извеждане само на простите числа от масива\n" +
            "2. Извеждане на най-често срещан елемент в масива\n" +
            "3. Извеждане на максимална редица от нарастващи елементи в масива\n" +
            "4. Извеждане на максимална редица от намаляващи елементи в масива\n" +
            "5. Извеждане на максимална редица от еднакви елементи в масива\n" +
            "6. Извеждане на последователност от числа от масива, които имат сума равна на число, генерирано на случаен принцип\n" +
            "7. Връщане назад към основното меню";

    public static final String ARRAY_STRING_UTIL_MENU = "1. Обърнете буквите на думите от масива наобратно и ги визуализирайте в конзолата\\n\" +\n" +
            "                \"2. Изведете броя на повтарящите се символи за всяка една от думите в масива\\n\" +\n" +
            "                \"3. Изведете броя на символите за всяка една от думите в масива\\n\" +\n" +
            "                \"4. Изведете броя на повтарящите се думи от масива\\n\" +\n" +
            "                \"5. Връщане назад към основното меню\"";
}
