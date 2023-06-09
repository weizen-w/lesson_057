public class Task2 {

  // сортирую строку, по возрастанию (каждый символ в строке)
  public static void main(String[] args) {
    String strLine = "Арифметика - это наука о цифрах.";
    System.out.println(strLine);
    String strLineSort = sortString(strLine);
    System.out.println(strLineSort);
  }

  public static String sortString(String str) {
    if (str == null) {
      throw new NullPointerException("Строка Null");
    }
    if (str.length() < 2) {
      return str;
    }
    int mid = str.length() / 2;
    String str1 = str.substring(0, mid);
    String str2 = str.substring(mid);
    str1 = sortString(str1);
    str2 = sortString(str2);
    return mergeString(str1, str2);
  }

  private static String mergeString(String str1, String str2) {
    StringBuilder result = new StringBuilder();
    int i1 = 0;
    int i2 = 0;
    while (i1 < str1.length() && i2 < str2.length()) {
      if (str1.charAt(i1) <= str2.charAt(i2)) {
        result.append(str1.charAt(i1));
        ++i1;
      } else {
        result.append(str2.charAt(i2));
        ++i2;
      }
    }
    if (i1 < str1.length()) {
      result.append(str1.substring(i1));
    } else {
      result.append(str2.substring(i2));
    }
    return result.toString();
  }
}
