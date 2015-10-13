package mountain;


public class Side {
	Point start, dest, m;
	
	public Side(Point start, Point dest, Point m)	{
		this.start = start;
		this.dest = dest;
		this.m = m;
	}
	
	public Point getStart()		{
		return start;
	}
	
	public Point getDest()	{
		return dest;
	}
	
	public Point getMiddle()	{
		return m;
	}
}
