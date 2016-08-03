package com.diary;


import java.io.BufferedReader;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;


public class InMemoryNoteTaskDAO implements NoteTaskDAO {
private Map<Long, NoteTask> tasks;  
private Long currentId= 0L;



public InMemoryNoteTaskDAO() {
	tasks = (Map<Long, NoteTask>) new HashMap<Long, NoteTask>();
}

@Override
public List<NoteTask> list() {
	 List<NoteTask> list = new ArrayList<NoteTask>();
 	  for(Map.Entry<Long,NoteTask> entry : tasks.entrySet()){ 
 		  // тут таки ошибка может надо итератором наконец воспользоваться как он предлагает 
 		  // заменить возвращаемый тип на Map<Long,NoteTask> ты написал что нельзя
	   	NoteTask t = entry.getValue();
	   	list.add(new NoteTask(t.getId(),t.getTitle(),t.getStatus(),t.getImportance(),t.getUrgency()));
	   }  
	return (List<NoteTask>) tasks;
	
	
	// содать список с задачами каждую задачу копировать с помощью сеттров как и в get()
	// все значения нужно перекопировать в новый список
	
	// а почему я не могу сделать тут тоже Map? или могу? 
	// и почему это мне надо преобразовывать его, может и делать его Map сразу, чем туда сюда гонять? 
	// в общем еще буду разбираться с этим вопросом нашла только как из List сделать более сложную коллекцию
	/*  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 *  Map возвращать плохо, поскольку нас интересует только список задач,
	 *  Map нужен для того что бы производить поиск по ключам внутри InMemoryNoteTaskDAO
	 *  
	 *  Я тут подумал, что самый правильный вариант создать пустой список и в цикле по tasks добавлять 
	 *  в него записи
	 *  что то вроде этого:
	 *  
	 *  List<NoteTask> list = new ArrayList<NoteTask>();
	 *  
	 *  for(Map.Entry<Long,NoteTask> entry : tasks){
	 *  	NoteTask t = entry.getValue();
	 *  	list.add(new NoteTask(t.getId(),t.getTitle(),t.getStatus(),t.getImportance,t.getUrgency()));
	 *  }  
	 *  
	 *  Почему нужно использовать именно такой цикл с созаданием новых NoteTask и зачем так заморачиваться?
	 *  
	 *  Дело в логике. Если мы не будем копировать каждый раз задачу, а просто будем конвертировать 
	 *  Map в List (например вот так: list.addAll(tasks.values()) ), то мы сможем менять поля задачи (например id)
	 *  не пребегая r методу update. 
	 *  В нашем случае это может бы и проканало, но когда у нас большое приложение, и метод update
	 *  более сложный чем у нас (есть какие-то дополнительные преобразования над задачей перед тем как ее обновить),
	 *  то мы можем нарушить бизнес-логику приложения.
	 *  Во-вторых в коде мы случайно можем что-то поменять в задачах, и это сразу же обновиться в нашем inMemory хранилище
	 *  А так, что бы подтвердить изменения в задаче, нам нужно применить update.
	 */
	
}

@Override
public NoteTask get(Long id){
		//создать новую задачу  а потом сеттерами установить значения из задачи которая по айди взяла из tasks:
	NoteTask task1 = tasks.get(id); 
	NoteTask task2 = new NoteTask (null, null, null, null, null);
	task2.setTitle(task1.getTitle());
	task2.setStatus(task1.getStatus());
	task2.setImportance(task1.getImportance());
	task2.setUrgency(task1.getUrgency());
	return task2;
	
}
	//TODO: Добавь еще один метод в интерфейс
	//TODO: NoteTask get(Long id), он должен возвращать задачу по айди. Если нет задачи с таким айди возвращает null
	//TODO: Добавь имплементацию в InMemoryTaskDAO
	// Особенности имплементации. Ты должна передавать не ссылку на объект в хранилище, 
    // а новый объект с такими же самыми полями
    // получить по запрашиваемому айди объект и вернуть копию этого объекта который соответствует этому айди!


@Override
public Long add(NoteTask task) {
	
	// Тоже без этой строки
	//public NoteTask(Long id, String title, Status status, Importance importance, Urgency urgency);
	//NoteTask t = new NoteTask(id, title, status, importance, urgency);
	NoteTask t = new NoteTask(null, null, null, null, null);   // Можно сделать конструктор по умолчанию 
										// я тоже сначала так делала, но подумала, что это не логично, все нулями заполнять 
	t.setId(currentId++);		
	t.setTitle(task.getTitle());
	t.setStatus(task.getStatus());
	t.setImportance(task.getImportance());
	t.setUrgency(task.getUrgency());
	tasks.put(t.getId(),t);

	/*
	 *  Ми ж з тобою говорили, тут ніяких сканів бути не повинно. 
	 *  Тут повинна створити нову задачу (NoteTask t ) з полями як у task
	 *  В якості id вибрати t.setId(currentId++);
	 *  Добавити новий запис в карту типу tasks.put(t.getId(),t); 
	 */
	return currentId;
}
@Override
public void update(NoteTask task) {
	// tasks.get(task.getId()).setTitle(task.getTitle()).setStatus(task.getStatus()).setImportance(task.getImportance()).setUrgency(task.getUrgency());
	
	 NoteTask t = tasks.get(task.getId());
	 //tasks.get(task.getId());  // Без этой строки можно обойтись   
	 t.setTitle(task.getTitle()); 
	 t.setStatus(task.getStatus());
	 t.setImportance(task.getImportance());
	 t.setUrgency(task.getUrgency());
	/*
	 * Все чудово. тільки:
	 *  1. Чому ти приводиш до типу List, пиши просто tasks.get(task.getId()) 
	 *  2. Ланцюг визовів, такий як у тебе не спрацює. Оскільки сеттери у тебе повертають void, тому:
	 *     а) маєш створити тимчасову змінну t = tasks.get(task.getId())
	 *     б) для кожного поля окремо визвати сеттер.
	 */
}
@Override
public void delete(NoteTask task) {
	NoteTask t = tasks.remove(task.getId());
	// Моно обойтись без следующей стоки
	//t.getId(); // ТАК? или нужно делать вызовы как в методе update?
	
	/*
	 * Як в попередньому, пункт 1
	 */
}

}



