
public class ContainerList {
	int size;
    public Container first;
	public ContainerList() {
		first=null;
		size=-2;
	}
	public void addContainer(Container toAdd) {
		if(toAdd==null) return;
		if(first==null) first=toAdd;
		else first.add(toAdd);
		size++;
	}
	public void deleteContainer(Container toDelete) {
		toDelete.getNext().setPrev(toDelete.getPrev());
		toDelete.getPrev().setNext(toDelete.getNext());
	}

}
