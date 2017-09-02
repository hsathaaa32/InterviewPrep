package facebook.phone;

import java.util.*;

class Interval implements Comparable {
	int min;
	int max;

	public String toString() {
		return min + "," + max;
	}

	public Interval(int x, int y) {
		if(x<y) {
			min = x;
			max = y;
		}
		else {
			min=y;
			max=x;
		}
	}

	public int compareTo(Object o) {
		Interval o1 = (Interval) o;
		return this.min-o1.min;
	}
}

public class MergeIntervals {

	public static List<Interval> mergeInterval(List<Interval> arr) {
		if(arr==null || arr.size()==0)
			return arr;
		Collections.sort(arr);
		List<Interval> result = new ArrayList<Interval>();
		result.add((Interval)arr.get(0));
		for(int i=1; i<arr.size(); i++) {
			Interval curr = result.get(result.size()-1);
			if(curr.max>=arr.get(i).min ) {
				if( curr.max<arr.get(i).max)
					curr.max = Math.max(curr.max, arr.get(i).max);
			}
			else {
				result.add(arr.get(i));
			}
		}
		return result;
	}
	public static void printList(List<Interval> lst) {
		Iterator<Interval> it = lst.iterator();
		while(it.hasNext()) {
			Interval in = it.next();
			System.out.println(in);
		}
		System.out.println();
	}
	public static void main(String[] args) {

		Interval i1 = new Interval(2,4);
		Interval i2 = new Interval(-1,3);
		Interval i3 = new Interval(5,6);
		Interval i4 = new Interval(9,-10);

		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		printList(list);
		List<Interval> result  = (ArrayList<Interval>) mergeInterval(list);
		printList(result);

	}

}
