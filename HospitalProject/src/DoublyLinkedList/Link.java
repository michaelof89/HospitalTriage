package DoublyLinkedList;

public class Link {
	private Patient data; //change to private Patient data, in all instances
	public Link previous;
	public Link next;
	
	//Creating nodes on the doubly linked list
	public Link(Patient data)
	{
		previous = null;
		this.data = data;
		next = null;
	}
	
	//Constructor for nodes on doubly linked list
	public Link(Link previous, Patient data, Link next)
	{
		this.previous = previous;
		this.data = data;
		this.next = next;
	}
	
	//Data is the centre of the node - carrying the information
	public Patient Data()
	{
		return data;
	}
}
