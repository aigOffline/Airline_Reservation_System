package PartII;

import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {

	public Set<E> intersection(Set<E> s2) {
		Set<E> interSet = new HashSet(this);
		interSet.retainAll(s2);
		return interSet;
		
	}
	
	public Set<E> union(Set<E> s2) {
		Set<E> unionSet = new HashSet(this);
		unionSet.addAll(s2);
		return unionSet;
	}
	
	public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2) {
		Set<Pair<E,T>> set = new HashSet<Pair<E,T>>();
		for(E e : this) {
			for(T t : s2) {
				set.add(new Pair<E,T>(e, t));
			}
		}
		return set;

	}
	
	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		
		MathSet<Integer> ms = new MathSet<>();
		ms.add(10);
		ms.add(20);
		ms.add(30);
		ms.add(40);
		
		MathSet<Integer> ms2 = new MathSet<>();
		ms2.add(30);
		ms2.add(50);
		ms2.add(40);
		ms2.add(60);
		System.out.println("first set:");
		System.out.println(ms);
		System.out.println("second set:");
		System.out.println(ms2);
		
		Set<Integer> inters = ms.intersection(ms2);
		System.out.println("Intersections:");
		System.out.println(inters);
		
		System.out.println("Union:");
		Set<Integer> unions = ms.union(ms2);
		System.out.println(unions);
		
		
		
		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
		MathSet<Integer> mathSet1 = new MathSet<>();
		mathSet1.add(10);
		mathSet1.add(20);
		mathSet1.add(30);
	
		
		MathSet<String> mathSet2 = new MathSet<>();
		mathSet2.add("one");
		mathSet2.add("two");
		mathSet2.add("three");
		
		
		Set<Pair<Integer, String>> cart = mathSet1.cartesianProduct(mathSet2);
		System.out.println("cartesian:");
		System.out.println(cart);
		
		
		
		
	}
}
