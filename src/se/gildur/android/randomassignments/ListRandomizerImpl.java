package se.gildur.android.randomassignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ListRandomizerImpl implements ListRandomizer
{
	private ArrayList<String> list2;
	private ArrayList<String> randomizedList;
	
	public ListRandomizerImpl(ArrayList<String> names)
	{
		randomizeList(names);
	}

	public void randomizeList(ArrayList<String> list1) 
	{
		
		list2 = new ArrayList<String>(list1);
		
		while(list1.get(list1.size()-1) == list2.get(list2.size()-1)) 
		{
			long seed = System.nanoTime();
			Collections.shuffle(list2, new Random(seed));
		}

		ArrayList<String> rejectedList = new ArrayList<String>();
		randomizedList = new ArrayList<String>();
		
		for (String x : list1)
		{
			for (String y : list2)
			{
				if(x.equals(y)) 
				{
					continue;
				}
				else if(rejectedList.contains(y)) 
				{
					continue;
				}
				else 
				{
					randomizedList.add(y);
					rejectedList.add(y);
					break;
				}
			}
		}
		
		
//        theDict = {}
//        for x in list1:
//            theDict[x] = ""
//    
//        rejectedList = []
//        for x in list1:
//            for y in list2:
//                if x == y:
//                    continue
//                elif rejectedList.__contains__(y):
//                    continue
//                else:
//                    theDict[x] = y
//                    rejectedList.append(y)
//                    break
	
	}

	public ArrayList<String> getRandomizedList()
	{
		if(!randomizedList.isEmpty()) 
		{
			return randomizedList;
		}
		return null;
	}
}


