package todd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		
		List<String> fruit = new ArrayList<>();
		fruit.add("banana");
		fruit.add("grape");
		fruit.add("apple");
		
		Stream<String> stream = fruit.stream();
		
		Stream<String> myFruit = stream
				.map(x -> x + ".")
				.filter(x -> !x.startsWith("ba"))
				.sorted();

//		Optional<String> first = myFruit.findFirst();
//		System.out.println(first.get());
		
		myFruit.forEach(x -> System.out.println(x));
	}

}
