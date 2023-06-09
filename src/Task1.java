import java.util.ArrayList;
import java.util.List;

public class Task1 {

  // сортирую список строк, по методу compareTo()
  public static void main(String[] args) {
    List<String> stringList = new ArrayList<>(List.of("Мама", "Папа", "Jz", "Я", "Брат", "Сестра"));
    System.out.println(stringList);
    List<String> strLineSort = sortStringList(stringList);
    System.out.println(strLineSort);
  }

  @org.jetbrains.annotations.NotNull
  @org.jetbrains.annotations.Contract("null -> fail")
  public static List<String> sortStringList(List<String> stringList) {
    if (stringList.isEmpty()) {
      return stringList;
    }
    if (stringList.size() < 2) {
      return stringList;
    }
    int mid = stringList.size() / 2;
    List<String> stringList1 = stringList.subList(0, mid);
    List<String> stringList2 = stringList.subList(mid, stringList.size());
    stringList1 = sortStringList(stringList1);
    stringList2 = sortStringList(stringList2);
    return mergeString(stringList1, stringList2);
  }

  private static List<String> mergeString(List<String> list1, List<String> list2) {
    List<String> result = new ArrayList<>();
    int i1 = 0;
    int i2 = 0;
    while (i1 < list1.size() && i2 < list2.size()) {
      if (list1.get(i1).compareTo(list2.get(i2)) <= 0) {
        result.add(list1.get(i1));
        ++i1;
      } else {
        result.add(list2.get(i2));
        ++i2;
      }
    }
    if (i1 < list1.size()) {
      result.addAll(list1.subList(i1, list1.size()));
    } else {
      result.addAll(list2.subList(i2, list2.size()));
    }
    return result;
  }
}
