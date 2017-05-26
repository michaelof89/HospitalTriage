package DoublyLinkedList;

public class Link {
	private Patient data; //change to private Patient data, in all instances
	public Link previous;
	public Link next;
	
	public Link(Patient data)
	{
		previous = null;
		this.data = data;
		next = null;
	}
	
	public Link(Link previous, Patient data, Link next)
	{
		this.previous = previous;
		this.data = data;
		this.next = next;
	}
	
	public Patient Data()
	{
		return data;
	}
}
