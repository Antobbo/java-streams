//Based on https://www.baeldung.com/java-8-streams-introduction
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Test");
		String[] arr = new String[]{"angelo", "barocco", "carisma", "barasta", "desta", "biridio"};
//		Stream<String> stream = Arrays.stream(arr);
//		stream = Stream.of("a", "b", "c");
		
		//convert array to string with streams
		List<String> list = Arrays.stream(arr).collect(Collectors.toList()); 
		System.out.println("\nPrint with normal foreach loop: ");
		for(String s: list) {
			System.out.println(s);
		}
		
		printElements(list);
		
		System.out.println("\nSize of stream:");
		long count = list.stream().distinct().count();
		System.out.println(count);
		
		System.out.println("\nIs a in list with normal loop");
		System.out.println(isElementInList(list));
		
		System.out.println("\nIs a in list with streams");
		System.out.println(isElementInListWithStream(list));
		
		Stream<String> filteredStream = list.stream().filter(element -> element.contains("d"));
		System.out.println("\nIs filtered list with d");
		filteredStream.forEach(element -> System.out.println(element)); 		

	}
	
	static boolean isElementInList(List<String> list) {
		if(list.isEmpty()) {
			return false;
		}
		else {
			for (String string : list) {
			    if (string.contains("a")) {
			        return true;
			    }
			    else {
			    	return false;
			    }
			}
		}
		return false;
	}
	
	static boolean isElementInListWithStream(List<String> list) {
		return list.stream().anyMatch(element -> element.contains("a"));

	}
	
	static void printElements(List<String> list) {
		System.out.println("\nPrint with streams:");
		Stream<String> stream = list.stream();
		stream.forEach(element -> System.out.println(element));
	}
}
