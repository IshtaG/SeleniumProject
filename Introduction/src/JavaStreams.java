import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams {

	// count the names starting with a
//@Test
	public void Regular() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Ishita");
		names.add("b");
		names.add("Abhijeet");
		names.add("Aks");

		int count = 0;
		for (String name : names) {
			if (name.startsWith("A")) {
				count = count + 1;
			}
		}

		System.out.println(count);
	}

//@Test
	public void StreamFilter() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Ishita");
		names.add("b");
		names.add("Abhijeet");
		names.add("Aks");

		Long c = names.stream().filter(s -> s.startsWith("A")).count();

		System.out.println(c);

		Stream.of("Ishita", "b", "Abijeet", "Aks").filter(s -> s.startsWith("A")).count();

		// print all the names

		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

		// set limit to print only one name

		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}

//@Test
	public void StreamMap() {
		Stream.of("Abhjeet", "Don", "Ishita", "Alekhya").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// print name first letter as a with uppercase and sorted

		List<String> names = Arrays.asList("Azbhjeet", "Don", "Ishita", "Alekhya");

		List<String> names1 = Arrays.asList("man", "Don", "women", "kids");

		names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

//concatenation o two list

		Stream<String> newstream = Stream.concat(names.stream(), names1.stream());
		// newstream.sorted().forEach(s->System.out.println(s));

		// match the stream
		boolean flag = newstream.anyMatch(s -> s.equalsIgnoreCase("Alekhywa"));
		// System.out.println(flag);

		Assert.assertTrue(flag);

	}

	@Test
	public void StreamCollect() {
		// list
		// new list

		List<String> ls = Stream.of("Abhjeet", "Don", "Ishita", "Alekhya").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
	}
	
	@Test
	public void UniqueNumber()
	{
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		
		//values.stream().distinct().forEach(s->System.out.println(s));
		
		List<Integer> listinteger = values.stream().distinct().sorted().collect(Collectors.toList());
		
		System.out.println(listinteger.get(2));
	}

}
