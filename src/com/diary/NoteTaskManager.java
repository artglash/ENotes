package com.diary;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class NoteTaskManager  {
	
	private List<NoteTask> list;
	
		
	public NoteTaskManager(List<NoteTask> list) {
		super();
		this.list = list;
	}
	
		public List<NoteTask> getList() {
		return list;
	}

	public void setList(List<NoteTask> list) {
		this.list = list;
	}


	
		
	public List<NoteTask> sortByPriority(){
		List<NoteTask> resultList = new ArrayList<NoteTask>(); //+TODO: Where are coping of list?
		for(int i=0; i<list.size();  i++) {
			resultList.add(list.get(i));	} // I'm cope lis here
		Collections.sort(resultList);
		return resultList;
	}
			
		//		List<NoteTask> resultList = new ArrayList<NoteTask>(this.list); 
		//		Collections.sort(resultList); 
//		
	/*+TODO: The body of method must be such as
	 * 		{
	 * 			List<NoteTask> resultList = new ArrayList<NoteTask>(this.list);
	 * 			Collections.sort(resultList);
	 * 			return resultList;	
	 *  	}
	 */
	
	
	public int countDone(){  //TODO: You must get a list from the private field not from the method argument.
		int countofdone=0;    //TODO: This variable can be named more compact. For example: count = 0; Yes I'm agree, but I create different values 
								//in different methods so I decide to do different variables
	
	/*+TODO: Only one type of loop must be chosen. 
		    You use simultaneously three forms of loop.
	*/
		for (NoteTask task : list){
			if (task.getStatus() == Status.DONE){
					countofdone++;	}      //+TODO: An expression "count++" is more compact :)))
			}
	 
		return countofdone;
	}
	/*TODO: The body of method must be such as
	 * 		{
	 * 			int count = 0;
	 * 			for(NoteTask task : list){
	 * 				if(task.status == Status.DONE){count++;}
	 * 			}
	 * 			return count;
	 *  	}
	 */
	
	
	
	
	public int countFinished(){
		int countoffinished=0;
		for (NoteTask task : list){
			if (task.getStatus()==Status.FINISHED){
				countoffinished++;
			}
		}
		return countoffinished;
	}
	
	public int countActual(){
		int countofactual=0;
		for (NoteTask task : list){
			if (task.getStatus()==Status.ACTUAL) {
				countofactual++;
			}
		}
		return countofactual;
	}

}

