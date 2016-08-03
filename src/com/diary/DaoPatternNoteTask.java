package com.diary;

import java.util.List;
import java.util.Scanner;

public class DaoPatternNoteTask {

//	public static void main(String[] args) {
//		NoteTaskDAO notetaskDao = new InMemoryNoteTaskDAO();
//		
//		//print all tasks
//for (NoteTask task: notetaskDao.list()){
//	System.out.println(task.getId()+task.getTitle()+task.getStatus()+task.getImportance()+task.getUrgency());
//}
//	//update task
//NoteTask task1= notetaskDao.list().get(0);
//task1.setTitle("NNNN");
//notetaskDao.update(task1);
//
//	Scanner scanner = new Scanner(System.in);
//	while(true){
//	
//
//	}
	
	/*
	 * 
	 * ћд¤...
	 * 
	 * привожу ¤к у тебе повинен вигл¤дати main
	 */
	 	public static void main(String[] args) {
	 	NoteTaskDAO notetaskDao = new InMemoryNoteTaskDAO();
	   	Scanner scanner = new Scanner(System.in);
	  	
	  	while(true){
	   	String cmd = scanner.nextLine();
	 			switch(cmd){
	 				case "list":
	 				notetaskDao.list();
	 					//TODO: Print all task to the screen
	 					//...
	 					break;
	 				case "add":
	 					/**
	 					 * Только для тебя :) 
	 					 */
	 					NoteTask  t = new NoteTask(null,null,null,null,null); // А лучше сделать конструктор по умолчанию NoteTask()
	 					System.out.print("title:");
	 					t.setTitle(scanner.nextLine());
	 					
	 					System.out.print("status:");
	 					try{
	 						t.setStatus(Status.valueOf(scanner.nextLine().toUpperCase()));
	 					} catch(IllegalArgumentException e){
	 						System.out.println("Value of status must be one of done, finished, actual");
	 						System.out.println("Enter a new command");
	 					}
	 					
	 					System.out.print("importance:");
	 					try{
	 						t.setImportance(Importance.valueOf(scanner.nextLine().toUpperCase()));
	 					} catch(IllegalArgumentException e){
	 						System.out.println("Value of importance must be one of high, middle, low");
	 						System.out.println("Enter a new command");
	 					}
	 					
	 					System.out.print("urgency:");
	 					try{
	 						t.setUrgency(Urgency.valueOf(scanner.nextLine().toUpperCase()));
	 					} catch(IllegalArgumentException e){
	 						System.out.println("Value of urgency must be one of HIGH, MIDDLE, LOW");
	 						System.out.println("Enter a new command");
	 					}
	 					
	 					Long id = notetaskDao.add(t); // что вот такое должно быть?
	 					System.out.println("The id of the inputed task is " + id);
	 					break;
	 					//TODO:  Add a task. Print an id of added task
	 					//...
	 				
	 				
	 				
	 				case "update":
	 					// Не могу понять куда впихнуть этот сканнер внутрь гета? ему так не нравится,
	 					// тут должно быть два сканнера? один для того чтобы получать данные а другой чтобы вбивать новые данные?
	 				   	Scanner sc1 = new Scanner(System.in);
	 				  	
	 					List<NoteTask> listofTasks = notetaskDao.list();
	 					NoteTask m = listofTasks.get(task.getId());
	 					// get title to change
	 					
	 					System.out.print("You want to update title of task"+m.getTitle());
	 					System.out.print("You are update title to:");	 					
	 					m.setTitle(sc1.nextLine());
	 					// get status to change
	 					m.getStatus();
	 					System.out.print("You are update status to:");
	 					try{
	 						m.setStatus(Status.valueOf(sc1.nextLine().toUpperCase()));
	 					} catch(IllegalArgumentException e){
	 						System.out.println("Value of status must be one of done, finished, actual");
	 						System.out.println("Enter a new command");
	 					}
	 					
	 					System.out.print("You are update importance:");
	 					m.getImportance();
	 					try{
	 						m.setImportance(Importance.valueOf(sc1.nextLine().toUpperCase()));
	 					} catch(IllegalArgumentException e){
	 						System.out.println("Value of importance must be one of high, middle, low");
	 						System.out.println("Enter a new command");
	 					}
	 					
	 					System.out.print("You are update urgency:");
	 					m.getUrgency();
	 					try{
	 						m.setUrgency(Urgency.valueOf(sc1.nextLine().toUpperCase()));
	 					} catch(IllegalArgumentException e){
	 						System.out.println("Value of urgency must be one of HIGH, MIDDLE, LOW");
	 						System.out.println("Enter a new command");
	 					}
	 					
	 					notetaskDao.update(m); // Это получается не нужно?
	 					//TODO: Update a task by id
	 					//...	
	 					break;
	 					
	 				case "remove":
	 					
	 					NoteTask k = listofTasks.remove(task.getId()); // этого достаточно или нет или тоже нужно по очереди все вызывать и 
	 					// удалять каждое поле, должно же быть достаточно удаления элемента по айди ???
	 					notetaskDao.delete(m); 
	 					//TODO: Remove a task by id.
	 					//...	
	 					break;
	 				case "exit":
	 					
	 					// Exit from the programm
	 					//...
	 				default: 
	 					// Treatment of not registered command
	 					//...
	 			}
	  		}
	  }
	

}
