
//Don't change the class name
public class Container{
	private Point data;//Don't delete or change this field;
	private Container prev;
	private Container next;
	private Container twin;
	public Boolean axis;
	public Container(Point data,boolean axis) {
		this.data=data;
		prev=null;
		next=null;
		twin=null;
		this.axis=axis;
	}
	public Container(Container other) {
		this.data=other.data;
		this.prev=other.prev;
		this.next=other.next;
		this.twin=other;
		this.axis=!other.axis;
	}
	//Don't delete or change this function
	// Getters and Setters
	public Point getData()
	{
		return data;
	}
	public int getAxisValue() {
		if(axis) return data.getX();
		return data.getY();
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
	public void setTwin(Container twn) {
		twin=twn;
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
		else
			getNext().add(toAdd);
	}
}
