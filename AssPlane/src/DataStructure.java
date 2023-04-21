
public class DataStructure implements DT {

    public ContainerList listX;
    public ContainerList listY;
    public Container maxX;
    public Container maxY;
    public Container senMinX;
    public Container senMinY; 
    public Container senMaxX;
    public Container senMaxY;
    
	//////////////// DON'T DELETE THIS CONSTRUCTOR ////////////////
	public DataStructure()
	{
		listX=new ContainerList();
		listY=new ContainerList();
		senMinX = new Container(new Point(Integer.MIN_VALUE,Integer.MIN_VALUE,"minSenX"),true);
		senMinY = new Container(new Point(Integer.MIN_VALUE,Integer.MIN_VALUE,"minSenY"),false);
	    senMaxX = new Container(new Point(Integer.MAX_VALUE,Integer.MAX_VALUE,"maxSenX"),true);
		senMaxY = new Container(new Point(Integer.MAX_VALUE,Integer.MAX_VALUE,"maxSenX"),false);
		maxX=senMinX;
		maxY=senMinY;
		senMinX.setTwin(senMinY);
		senMinY.setTwin(senMinX);
		senMaxX.setTwin(senMaxY);
		senMaxY.setTwin(senMaxX);
		senMinX.setNext(senMaxX);
		senMinY.setNext(senMaxY);
		senMaxX.setPrev(senMinX);
		senMaxY.setPrev(senMinY);
	}

	@Override
	public void addPoint(Point point) {
		Container toAddX= new Container(point,true);
		Container toAddY= new Container(toAddX);
		toAddX.setTwin(toAddY);
		listX.addContainer(toAddX);
		listY.addContainer(toAddY);
		maxX=senMaxX.getPrev();
		maxY=senMaxY.getPrev();
		}

	@Override
	public Point[] getPointsInRangeRegAxis(int min, int max, Boolean axis) {
        ContainerList search;
        Container sen;
        if(axis) {
        	search=listX;
            sen=senMaxX;
        }
        else {
        	search=listY;
        	sen=senMaxY;
        }
        int counter=0;
        Container currFoward=search.first.getNext();
        Container currBackward=sen.getPrev();
        while(currFoward.getAxisValue()<min & currFoward!=sen) {
        	counter++;
        	currFoward=currFoward.getNext();
        }
        while(currBackward.getAxisValue()>max & currBackward!=search.first) {
        	counter++;
        	currBackward=currBackward.getPrev();
        }
        Point arr[]= new Point[search.size-counter];
        for(int i=0;i<arr.length;i++) {
        	arr[i]=currFoward.getData();
        	currFoward=currFoward.getNext();
        }
        return arr;
	}

	@Override
	public Point[] getPointsInRangeOppAxis(int min, int max, Boolean axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getDensity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void narrowRange(int min, int max, Boolean axis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean getLargestAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Container getMedian(Boolean axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point[] nearestPairInStrip(Container container, double width,
			Boolean axis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point[] nearestPair() {
		// TODO Auto-generated method stub
		return null;
	}

	
	//TODO: add members, methods, etc.
	
}

