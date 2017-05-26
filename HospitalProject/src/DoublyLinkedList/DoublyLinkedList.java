package DoublyLinkedList;

//NOTE: The "head" is the part that is growing - the end of the doubly linked list
public class DoublyLinkedList 
{
	private Link head;
	private int size;
	
	public DoublyLinkedList()
	{
		head = null; 
		size = 0;
	}
	
	//Sorting algorithm - grabs highest priority patient. TODO: Not yet implemented - also intended to remove patient from the list
	public Patient GiveHighestPriorityPatient()
	{
		if(head == null)
		{	
			return new Patient();
		}
		
		Link current = head;
		Patient MockPatient = current.Data();
		int HighestPrio = current.Data().PriorityField;
		
		while(current.next != null)
		{
			if(HighestPrio < current.next.Data().PriorityField)
			{
				HighestPrio = current.next.Data().PriorityField;
				MockPatient = current.next.Data();
			}
			current = current.next;
		}
		return MockPatient;
	}
	
	//Adding to the "head" of the list
	public void addFront(Patient data)
	{
		if (head == null)
			head = new Link(null, data, null);
		else{
			Link newLink = new Link(null, data, head);
			head.previous = newLink;
			head = newLink;
		}
		size++;
	}
	
	//Removes the "oldest" patient from the list, and returns a copy of it
	public Patient GetLastPatient()
	{
		if(head == null) return new Patient();
		Patient result = head.Data();
		removeAt(0);
		return result;
	}
	
	public int size()
	{
		return size;
	}

	public boolean isEmpty()
	{
		return head == null;
	}
	
	public void removeAt(int index)
	{
		if(head == null) return;
		if(index < 1 || index > size) return;
		
		Link current = head;
		int i = 0; 
		while(i < index)
		{
			current = current.next;
			i++;
		}
		if(current.next == null)
		{
			current.previous.next = null;
		}
		else if(current.previous == null)
		{
			current = current.next;
			current.previous = null;
			head = current;
		}
		else
		{
			current.previous.next = current.next;
			current.next.previous = current.previous;
		}
		//size--;
	}
}
