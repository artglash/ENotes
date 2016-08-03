package com.diary;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NoteTask implements Comparable<NoteTask>{
	private Long id;                //+ TODO: Why are the fields public? They must be private with setters and getters 
	private String title;
	private Status status;
	private Importance importance;
	private Urgency urgency;
	
public NoteTask (Long id, String title, Status status, Importance importance, Urgency urgency) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.importance = importance;
		this.urgency = urgency;
	}

	
	
	public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getTitle() {
	return title;
}



public void setTitle(String title) {
	this.title = title;
}



public Status getStatus() {
	return status;
}



public void setStatus(Status status) {
	this.status = status;
}



public Importance getImportance() {
	return importance;
}



public void setImportance(Importance importance) {
	this.importance = importance;
}



public Urgency getUrgency() {
	return urgency;
}



public void setUrgency(Urgency urgency) {
	this.urgency = urgency;
}



	@Override
	public String toString() {
		return "\nNoteTask {id=" + id + ", title=" + title + ", status=" + status + ", importance=" + importance
				+ ", urgency=" + urgency + "}\n";
	}
	@Override
	public int compareTo(NoteTask o) {
		int result = this.importance.compareTo(o.importance)	;
		if (result!=0){
		  this.urgency.compareTo(o.urgency);
		   	
		}
		/*TODO: Must be such as
			if (result==0){
				result = this.urgency.compareTo(o.urgency);			   	
			}
		*/
		return result;
		
	
}
}
	
	
	

