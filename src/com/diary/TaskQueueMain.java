package com.diary;



import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskQueueMain {

	public static void main(String[] args) {
		List<NoteTask> listoftasks = new LinkedList<NoteTask>();
		listoftasks.add(new NoteTask(1L, "task1", Status.ACTUAL, Importance.MIDDLE, Urgency.LOW));
		listoftasks.add(new NoteTask(2L, "task2", Status.DONE, Importance.HIGH, Urgency.LOW));
		listoftasks.add(new NoteTask(3L, "task3", Status.FINISHED, Importance.LOW, Urgency.LOW));
		listoftasks.add(new NoteTask(4L, "task4", Status.DONE, Importance.HIGH, Urgency.MIDDLE));
		listoftasks.add(new NoteTask(5L, "task5", Status.ACTUAL, Importance.MIDDLE, Urgency.HIGH));
		listoftasks.add(new NoteTask(6L, "task6", Status.DONE, Importance.LOW, Urgency.LOW));
		listoftasks.add(new NoteTask(7L, "task7", Status.FINISHED, Importance.MIDDLE, Urgency.HIGH));
		
		System.out.println("There is full  list of created tasks without sorting:"); //TODO: more info
		System.out.println(listoftasks);
		
		NoteTaskManager note = new NoteTaskManager(listoftasks);
		
		System.out.println("There is sorted list of tasks by it's priority:"); //TODO: more info
		System.out.println(note.sortByPriority());
		System.out.println("There is amount of tasks which were already DONE:"); //TODO: more info
		System.out.println(note.countDone());
		System.out.println("There is amount of tasks which were already FINISHED:");
		System.out.println(note.countFinished());
		System.out.println("There is amount of tasks which are ACTUAL:");
		System.out.println(note.countActual());
	
		NoteTaskDAO listDao = new InMemoryNoteTaskDAO();
		for (NoteTask task : listDao.list()) {
			System.out.println("Notetask: [Id"+task.getId());
		}
}
}