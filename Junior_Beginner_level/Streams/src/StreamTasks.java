import java.util.*;
import java.util.stream.*;

public class StreamTasks {
	// private static final String Characters="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> Nlist=new ArrayList<Integer>();
		//Create List
		int size;
		do {
			size=new Random().nextInt(20);
		} while(size==0);
		// List with numbers
		for(int i=0;i<size;i++)
			Nlist.add(new Random().nextInt(50));
		//Print List
		System.out.println("Original Array");
		for(int i=0;i<size;i++)
			System.out.print(Nlist.get(i) +" ");
		System.out.println();
		
		// Find the average number of the elements of List
		double average =Nlist.stream()
				.mapToInt(i -> i) // for each element to int
				.average() // find average
				.getAsDouble(); // cast to double		
		//Print List
		System.out.println("\nAverage Array");
		System.out.println(average +" ");
		
		// Sort List
		List<Integer> sorted = Nlist.stream().sorted()
				.collect(Collectors.toList());
		//Print List
		System.out.println("\nSorted Array");
		for(int i=0;i<sorted.size();i++)
			System.out.print(sorted.get(i) +" ");
		
		System.out.println("\n");
		// Reducing list (all elements into 1 (e.g. sum of elements)
		System.out.println("Sum of list: "+ Nlist.stream().reduce(0,Integer::sum));
		
		//Counting List
		System.out.println("\nCount of even numbers in List are: "+ Nlist.stream()
														.filter(i-> i%2==0)
														.count());
		System.out.println();
		
		// Finding elements
		Optional<Integer> first = Nlist.stream()
							.filter(i-> i%2==0)
							.findFirst();
		
		Optional<Integer> any = Nlist.stream()
							.filter(i-> i%2==0)
							.findFirst();
		
		// Print optional numbers -> numbers 
		// ensuring that these numbers exist (there are even numbers in the list)
		first.ifPresent(n -> System.out.println("The first even number in List is: "+ n));
		any.ifPresent(n -> System.out.println("The found even number in List are: "+ n));
		
		//Create List
		// List with Strings
		// I make it simple in order to understand the below tasks better 
		List<String> Slist = Arrays.asList("apple", "Banana", "chair", "river", "sea", "school", 
									"Mountain", "Any", "bacon");
		
		// List with Strings with Characters only
		/*for(int i=0;i<size;i++) {
			//Slist.add(UUID.randomUUID().toString().replace('-',' '));
			String s=generateRandomString(20);
			Slist.add(s);
		}*/
		//Print List
		size = Slist.size();
		System.out.println("\nOriginal Array");
		for(int i=0;i<size;i++)
			System.out.println(Slist.get(i));
		
		// Mapping List
		// Turn the characters into uppercase and store them in new list
		List<String> SL= Slist.stream()
				.map(String::toUpperCase) // Turn to uppercase
				.collect(Collectors.toList()); // Collect them all in a List
		//Print List
		System.out.println("\nStream Array");
		for(int i=0;i<size;i++)
			System.out.println(SL.get(i));
		
		// Collect elements to list
		Set<String> ListSet= Slist.stream().collect(Collectors.toSet());
		//Print List
		System.out.println("\nSet Array");
		ListSet.forEach((s) -> System.out.print(s+" "));
		System.out.println();
		
		/* I add real String words in order to 
		   make then next example more understanding 
		Slist.add("apple");
		Slist.add("Any");
		Slist.add("bacon");
		Slist.add("football");
		*/
		// Find Strings who starts with a
		List<String> Sl=search(Slist);
		System.out.println("\nFiltered Array");
		if(Sl.isEmpty())
			System.out.println("No strings who starts with 'a'");
		else
			for(int i=0;i<Sl.size();i++)
				System.out.println(Sl.get(i));
		
		// Find Numbers and convert them into Strings with specific way
		System.out.println("\nStringed Number");
		String IntS=getString(Nlist);
		System.out.println(IntS);
		
		//Flat Map
		List<String> lines = Arrays.asList("one,two", "three,four");

		List<String> words = lines.stream()
		    .flatMap(line -> Arrays.stream(line.split(","))) // Whenever you find comma, separate the 
		    .collect(Collectors.toList());					// elements in different indexes

		System.out.println("\nInitial List");
		for(String line: lines)
			System.out.print(line +" ");
		//Print Flat Map
		System.out.println("\nFlat Map List");
		for(String word: words)
			System.out.print(word +" ");
		
		/* Also with flat Map you can convert Stream<List<String>> -> Stream<String>.
		   With this you can avoid nested loops
		List<List<String>> nested = Arrays.asList(
				Arrays.asList("a","b"),
				Arrays.asList("c","d"));
		
		List<String> flat = nested.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		
		System.out.println("\nNested List");
		for(List<String> nest: nested)
			for(String n: nest)
				System.out.print(n +" ");
		
		System.out.println("\nFlat Map List");
		for(String fl: flat)
			System.out.print(fl +" ");
		*/
		
		// Grouping
		System.out.println("\n");
		Map<Character,List<String>> groupped = Slist.stream()
										.collect(Collectors.groupingBy(s -> s.charAt(0)));
		System.out.println("Groupped List Map");
		System.out.println(groupped);
	}
	/* Create List with random Strings containing only Characters
	public static String generateRandomString(int length) {
		StringBuilder sb=new StringBuilder(length);
		for(int i=0;i<length;i++)
			sb.append(Characters.charAt(new Random().nextInt(Characters.length())));
		return sb.toString();
	}*/
	// Search Strings which fulfilled a filter condition
	public static List<String> search(List<String> list){
		return list.stream()
			   .filter(word -> word.startsWith(String.valueOf('a'))) // Filter Strings who starts with this value and have length this
			   .collect(Collectors.toList()); // Collect all the filtered String to a list
	}
	// Distinguish the numbers to even and odd and convert them to String 
	public static String getString(List<Integer> list) {
		return list.stream()
				.map(i-> i%2==0 ? "e"+i : "o"+i) // number odd -> o+number, number even -> e+number
				.collect(Collectors.joining(",")); // Separate them with comma
	}
}
