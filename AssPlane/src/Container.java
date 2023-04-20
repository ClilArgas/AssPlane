
//Don't change the class name
public class Container{
	private Point data;//Don't delete or change this field;
	private Container prev;
	private Container next;
	private Container twin;
	public Boolean axis;
	public Container(Point data) {
		this.data=data;
		prev=null;
		next=null;
		twin=null;
		axis=null;
	}
	public Container(Point data, Container prev,Container next, Container twin, Boolean axis) {
		this.data=data;
		this.prev=prev;
		this.next=next;
		this.twin=twin;
		this.axis=axis;
	}
	//Don't delete or change this function
	// Getters and Setters
	public Point getData()
	{
		return data;
	}
	public Container getPrev() {
		return prev;
	}
	public Container getNext() {
		return next;
	}
	public Container getTwin() {
		return twin;
	}
	public void setPrev(Container prv) {
		prev=prv;
	}
	public void setNext(Container nxt) {
		next=nxt;
	}
	public void add(Container toAdd) {
		boolean stop;
		if(axis) stop=toAdd.getData().getX()<getNext().getData().getX();
		else stop=toAdd.getData().getY()<getNext().getData().getY();
		if(stop) {	
			toAdd.setPrev(this);
			toAdd.setNext(next);
			getNext().setPrev(toAdd);
			setNext(toAdd);
		}
		else {
			getNext().add(toAdd);
		}
	}
	
}
