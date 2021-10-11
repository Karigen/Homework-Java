package Unit03;

public class Homework09_12 {

    public static void main(String[] args) {
	Robot rb=new Robot("abc", 3);
	rb.move(1);
	System.out.println(rb);
	
	SmartRobot srb=new SmartRobot("def", 0);
	srb.move(2);
	System.out.println(srb);
	
	Robot[] rbs= {rb,srb};
	
	for (Robot robot : rbs) {
	    robot.turnRight();
	    robot.move(2);
	    System.out.println(robot);
	}
    }
    
}

class Coord {
    public int x=0;
    public int y=0;
    
    public void getPosition() {
	System.out.println("("+x+","+y+")");
    }
}

class Robot {
    public final String name;
    //private int direction=0;//1n 2s 3w 4e
    protected int direction;//0n 1e 2s 3w
    protected Coord coord=new Coord();
    

    public Robot(String name) {
	super();
	this.name = name;
    }
    
    public Robot(String name, int direction) {
	this(name);
	this.direction=direction;
    }

    public void move(int steps) {
	/*
	
	if (this.direction==DIRECTION.north) {
	    coord.y+=steps;
	} else if (this.direction==DIRECTION.south) {
	    coord.y-=steps;
	} else if (this.direction==DIRECTION.west) {
	    coord.x-=steps;
	} else if (this.direction==DIRECTION.east) {
	    coord.x+=steps;
	}
	
	*/
	
	/*
	
	if (direction<=1) {
	    coord.coord[direction%2]-=steps;
	} else {
	    coord.coord[direction%2]+=steps;
	}
	
	*/
	switch(direction) {
	case 0://n
	    coord.x-=steps;
	    break;
	case 1://e
	    coord.y+=steps;
	    break;
	case 2://s
	    coord.x+=steps;
	    break;
	case 3://w
	    coord.y-=steps;
	    break;
	}
    }
    
    public void turnLeft() {
	
	/*
	
	if (this.direction==DIRECTION.north) {
	    this.direction=DIRECTION.west;
	} else if(this.direction==DIRECTION.west) {
	    this.direction=DIRECTION.south;
	} else if (this.direction==DIRECTION.south) {
	    this.direction=DIRECTION.east;
	}else if (this.direction==DIRECTION.east) {
	    this.direction=DIRECTION.north;
	}
	
	*/
	
	direction=(direction-1+4)%4;
    }
    
    public void turnRight() {
	
	/*
	
	if (this.direction==DIRECTION.north) {
	    this.direction=DIRECTION.east;
	} else if(this.direction==DIRECTION.east) {
	    this.direction=DIRECTION.south;
	} else if (this.direction==DIRECTION.south) {
	    this.direction=DIRECTION.west;
	}else if (this.direction==DIRECTION.west) {
	    this.direction=DIRECTION.north;
	}
	
	*/
	
	direction=(direction+1+4)%4;
    }
    
    public Coord getPositon() {
	return coord;
    }
    
    @Override
    public String toString() {
        // TODO 自动生成的方法存根
        return name+"：（"+(coord.x+1)+"，"+(coord.y)+"）";
    }
}

class SmartRobot extends Robot {
    int[][] map=new int[7][9];
    
    public SmartRobot() {
	this("王琳", 0);
    }
    
    public SmartRobot(String name, int direction) {
	super(name,direction);
	
	/*
	
	getCoord().x=3;
	getCoord().y=4;
	
	*/
	
	coord.x=3;
	coord.y=4;
	
	map[coord.x][coord.y]=1;
    }
    
    @Override
    public void turnLeft() {
        super.turnLeft();
    }
    
    @Override
    public void turnRight() {
        super.turnRight();
    }
    
    @Override
    public void move(int steps) {
	//Coord temp1=getCoord();
	int tempX=coord.x;
	int tempY=coord.y;
	
        super.move(steps);
        
        switch(direction) {
        case 0:
            for (int i = 1; i <= steps; i++) {
		map[tempX-i][tempY]=1;
	    }
            break;
        case 1:
            for (int i = 1; i <= steps; i++) {
        	map[tempX][tempY+i]=1;
	    }
            break;
        case 2:
            for (int i = 1; i <= steps; i++) {
        	map[tempX+i][tempY]=1;
	    }
            break;
        case 3:
            for (int i = 1; i <= steps; i++) {
        	map[tempX][tempY-i]=1;
	    }
            break;
        }
        
        //Coord temp2=getCoord();
        
        /*
        
        int sign=0;
        
        if(tempdir%2==0) {//南北
            sign=-(tempdir-1);
            for(int i=1;i<=steps;i++) {
        	map[tempX+sign*i][tempY]=1;
            }
        } else {//东西
            sign=-(tempdir-2);
	    for (int i = 1; i <= steps ; i++) {
		map[tempX][tempY+sign*i]=1;
	    }
	}
	
	*/
        
        /*
        
        if (temp2.x-temp2.x>0) {
	    for (int i =temp1.x; i < temp2.x; i++) {
		map[i][getCoord().y]=1;
	    }
	} else if (temp2.x-temp1.x<0) {
	    for (int i =temp1.x; i > temp2.x; i--) {
		map[i][getCoord().y]=1;
	    }
	} else if (temp2.y-temp1.y>0) {
	    for (int i =temp1.y; i < temp2.y; i++) {
		map[getCoord().x][i]=1;
	    }
	} else if (temp2.y-temp1.y<0) {
	    for (int i =temp1.y; i > temp2.y; i--) {
		map[getCoord().x][i]=1;
	    }
	} else {
	    System.out.println("哈哈哈");
	}
	
	*/
        
    }
    
    /*
    
    @Override
    public Coord getPosition() {
        return super.getPosition();
    }
    
    */
    
    @Override
    public Coord getPositon() {
        // TODO 自动生成的方法存根
        return super.getPositon();
    }
    
    @Override
    public String toString() {
        // TODO 自动生成的方法存根
	for (int i = 0; i < map.length; i++) {
	    for (int j = 0; j < map[i].length; j++) {
		System.out.print(map[i][j]+" ");
	    }
	    
	    System.out.println();
	}
        return name+"：（3，4）->（"+coord.x+"，"+coord.y+"）";
    }
    
}