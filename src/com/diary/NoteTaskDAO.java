package com.diary;


import java.util.List;



public interface NoteTaskDAO {
	
	public List<NoteTask> list();
	
	public Long add(NoteTask task);
	
	public void update (NoteTask task);
	
	public void delete (NoteTask task);
	
	public NoteTask get(Long id);
	
}
