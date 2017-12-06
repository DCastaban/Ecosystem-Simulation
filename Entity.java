package work;

public class Entity {
	private int x;
	private int y;
	private int hunger;
	private int age;
	private int speed;
	private boolean fertile;
	
	//Original Constructors
	public Entity(int x, int y){
		this.x=x;
		this.y=y;
		fertile=false;
		hunger=0;
	}
	//Accessors
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getHunger(){
		return hunger;
	}
	public int getAge(){
		return age;
	}
	public boolean getFertile(){
		return fertile;
	}
	//Mutators
	public void setX(int x){
		if(checkLeft()&&checkRight()){
			this.x=x;
		}
		//else error1();
	}
	public void setY(int y){
		if(checkDown()&&checkUp()){
			this.y=y;
		}
		//else error2();
	}
	public void setSpeed(int x){
		if(speed>=0&&speed<=2){
			speed=x;
		}
		else {
			speed = 0;
			error3();
		}
	}
	public void setHunger(int x){
		if(x>=0&&x<=50){
			hunger=x;
		}
		else{
			hunger=0;
			error4();
		}
	}
	public void setAge(int x){
		if(x>=0&&x<=10000){
			age=x;
		}
		else{
			age=0;
			error5();
		}
	}
	public void setFertile(boolean a){
		fertile = a;
	}
	//Assorted
	public boolean checkLeft(){
		if(x>=10){
			return true;
		}
		return false;
	}
	public boolean checkRight(){
		if(x<=780){
			return true;
		}
		return false;
	}
	public boolean checkUp(){
		if(y>=10){
			return true;
		}
		return false;
	}
	public boolean checkDown(){
		if(y<=580){
			return true;
		}
		return false;
	}
	//error messages, Identify the error for me
	public void error1(){
		System.out.println("Error 1");
	}
	public void error2(){
		System.out.println("Error 2");
	}
	public void error3(){
		System.out.println("Error 3");
	}
	public void error4(){
		System.out.println("Error 4");
	}
	public void error5(){
		System.out.println("Error 5");
	}


}
