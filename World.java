package work;
/********************************************
 * Wolves and Sheep Assignment
 * Devin Castaban
 * April 7th Friday(Tentative)
 * Object-Oriented Programming
 *******************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class World extends JPanel implements ActionListener {
	//Mr.O implemented stuff, 99% sure it is irrelevant in my program
	int worldX = 79;
	int worldY = 59;
	//Declaring Timer
	Timer time;
	//Making Randomizing possible
	Random rand = new Random();
	//Declaring entities array(length 100 atm)
	Entity[] entities = new Entity[1000];
	//Defining the brown background(Mr.O implemented)
	Color BROWN = new Color(139,69,19);
	//Constructor for World
	public World() {
		// create Sheep, Wolves and Grass entities in a loop 
		//Wolves
		for(int x=30;x>0;x--){
			entities[x] = new Wolf((rand.nextInt(78))*10,(rand.nextInt(57))*10);
		}
		//Sheep
		for(int x=100;x>30;x--){
			entities[x] = new Sheep((rand.nextInt(78))*10,(rand.nextInt(57))*10);
		}
		//Grass
		for(int x=700;x>100;x--){
			entities[x] = new Grass((rand.nextInt(78))*10,(rand.nextInt(57))*10);
		}
		//Fixed, hard coding spawns for everything, 18 total entities
		/*//Wolves
		entities[0] = new Wolf(20,120);
		entities[1] = new Wolf(320,230);
		entities[2] = new Wolf(160,340);
		//Sheep
		entities[3] = new Sheep(100, 100);
		entities[4] = new Sheep(300, 200);
		entities[5] = new Sheep(450, 500);
		entities[6] = new Sheep(500, 400);
		entities[7] = new Sheep(150, 150);
		//Grass
		entities[8] = new Grass(390,420);
		entities[9] = new Grass(290,530);
		entities[10] = new Grass(190,370);
		entities[11] = new Grass(50,70);
		entities[12] = new Grass(330,370);
		entities[13] = new Grass(240,170);
		entities[14] = new Grass(180,220);
		entities[15] = new Grass(510,340);
		entities[16] = new Grass(490,420);
		entities[17] = new Grass(510,370);*/

		//Start the simulation, by declaring timer to be half a second(500), then starting timer
		time = new Timer(400, this);
		time.start();
	}

	public void move(){
		//e is the amount of directions it can go, originally 4
		int e = 4;
		//Used to store the random variable determined using e
		int way;
		//Loop through the entities and move the sheep and wolves
		for(int x=0;x<entities.length;x++){
			if(entities[x] instanceof Sheep){
				//if it can move anywhere, randomize movement
				if(entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkUp()&&entities[x].checkDown()){
					way=rand.nextInt(e);
					if(way==0) entities[x].setX(entities[x].getX()+10);
					else if(way==1) entities[x].setX(entities[x].getX()-10);
					else if(way==2) entities[x].setY(entities[x].getY()+10);
					else if(way==3) entities[x].setY(entities[x].getY()-10);
				}
				//If at the top
				else if (entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkDown()){
					way=rand.nextInt(e-1);
					if(way==0) entities[x].setX(entities[x].getX()+10);
					else if(way==1) entities[x].setX(entities[x].getX()-10);
					else if(way==2) entities[x].setY(entities[x].getY()-10);
				}
				//If at the bottom
				else if (entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkUp()){
					way=rand.nextInt(e-1);
					if(way==0) entities[x].setX(entities[x].getX()+10);
					else if(way==1) entities[x].setX(entities[x].getX()-10);
					else if(way==2) entities[x].setY(entities[x].getY()+10);
				}
				//If at the right side
				else if (entities[x].checkLeft()&&entities[x].checkDown()&&entities[x].checkUp()){
					way=rand.nextInt(e-1);
					if(way==0) entities[x].setX(entities[x].getX()-10);
					else if(way==1) entities[x].setY(entities[x].getY()-10);
					else if(way==2) entities[x].setY(entities[x].getY()+10);
				}
				//If at the left side
				else if (entities[x].checkRight()&&entities[x].checkDown()&&entities[x].checkUp()){
					way=rand.nextInt(e-1);
					if(way==0) entities[x].setX(entities[x].getX()+10);
					else if(way==1) entities[x].setY(entities[x].getY()-10);
					else if(way==2) entities[x].setY(entities[x].getY()+10);
				}
				//If at top right corner
				else if(entities[x].checkLeft()&&entities[x].checkDown()){
					way=rand.nextInt(e-2);
					if(way==0)entities[x].setX(entities[x].getX()-10);
					else if(way==1)entities[x].setY(entities[x].getY()-10);
				}
				//If at top left corner
				else if(entities[x].checkRight()&&entities[x].checkDown()){
					way=rand.nextInt(e-2);
					if(way==0)entities[x].setX(entities[x].getX()+10);
					else if(way==1)entities[x].setY(entities[x].getY()-10);
				}
				//If at bottom right corner
				else if(entities[x].checkLeft()&&entities[x].checkUp()){
					way=rand.nextInt(e-2);
					if(way==0)entities[x].setX(entities[x].getX()-10);
					else if(way==1)entities[x].setY(entities[x].getY()+10);
				}
				//If at bottom left corner
				else if(entities[x].checkRight()&&entities[x].checkUp()){
					way=rand.nextInt(e-2);
					if(way==0)entities[x].setX(entities[x].getX()+10);
					else if(way==1)entities[x].setY(entities[x].getY()+10);
				}
			}
			else if(entities[x] instanceof Wolf){
				int o=0;
				while(o<2){
					//if it can move anywhere, randomize movement
					if(entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkUp()&&entities[x].checkDown()){
						way=rand.nextInt(e);
						if(way==0) entities[x].setX(entities[x].getX()+10);
						else if(way==1) entities[x].setX(entities[x].getX()-10);
						else if(way==2) entities[x].setY(entities[x].getY()+10);
						else if(way==3) entities[x].setY(entities[x].getY()-10);
					}
					//If at the top
					else if (entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkDown()){
						way=rand.nextInt(e-1);
						if(way==0) entities[x].setX(entities[x].getX()+10);
						else if(way==1) entities[x].setX(entities[x].getX()-10);
						else if(way==2) entities[x].setY(entities[x].getY()-10);
					}
					//If at the bottom
					else if (entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkUp()){
						way=rand.nextInt(e-1);
						if(way==0) entities[x].setX(entities[x].getX()+10);
						else if(way==1) entities[x].setX(entities[x].getX()-10);
						else if(way==2) entities[x].setY(entities[x].getY()+10);
					}
					//If at the right side
					else if (entities[x].checkLeft()&&entities[x].checkDown()&&entities[x].checkUp()){
						way=rand.nextInt(e-1);
						if(way==0) entities[x].setX(entities[x].getX()-10);
						else if(way==1) entities[x].setY(entities[x].getY()-10);
						else if(way==2) entities[x].setY(entities[x].getY()+10);
					}
					//If at the left side
					else if (entities[x].checkRight()&&entities[x].checkDown()&&entities[x].checkUp()){
						way=rand.nextInt(e-1);
						if(way==0) entities[x].setX(entities[x].getX()+10);
						else if(way==1) entities[x].setY(entities[x].getY()-10);
						else if(way==2) entities[x].setY(entities[x].getY()+10);
					}
					//If at top right corner
					else if(entities[x].checkLeft()&&entities[x].checkDown()){
						way=rand.nextInt(e-2);
						if(way==0)entities[x].setX(entities[x].getX()-10);
						else if(way==1)entities[x].setY(entities[x].getY()-10);
					}
					//If at top left corner
					else if(entities[x].checkRight()&&entities[x].checkDown()){
						way=rand.nextInt(e-2);
						if(way==0)entities[x].setX(entities[x].getX()+10);
						else if(way==1)entities[x].setY(entities[x].getY()-10);
					}
					//If at bottom right corner
					else if(entities[x].checkLeft()&&entities[x].checkUp()){
						way=rand.nextInt(e-2);
						if(way==0)entities[x].setX(entities[x].getX()-10);
						else if(way==1)entities[x].setY(entities[x].getY()+10);
					}
					//If at bottom left corner
					else if(entities[x].checkRight()&&entities[x].checkUp()){
						way=rand.nextInt(e-2);
						if(way==0)entities[x].setX(entities[x].getX()+10);
						else if(way==1)entities[x].setY(entities[x].getY()+10);
					}
					o++;
				}
			}
		}
	
	}
	public void death(){
		for(int x=0;x<entities.length;x++){
			if(!(entities[x]==null)){
				entities[x].setHunger(entities[x].getHunger()+1);
				entities[x].setAge(entities[x].getAge()+1);
				if(entities[x] instanceof Grass && entities[x].getAge()==10000){
					entities[x]=null;
				}
				else if(entities[x].getHunger()==50){
					entities[x]=null;
				}
				
				else if(entities[x].getAge()==250){
					entities[x]=null;
				}
			}
		}
	}
	public void birth(){
		for(int x=0;x<entities.length;x++){
			if(!(entities[x]==null)){
				if(entities[x] instanceof Grass){
					if (rand.nextInt(5)==3){
						entities[x].setFertile(true);
					}
				}
				if(entities[x].getFertile()){
						for(int z=0;z<entities.length;z++){
							if(entities[x].getFertile()){
								if(entities[z]==null){
									//Implement Checks for birthing in correct places
									if(entities[x] instanceof Sheep&&rand.nextInt(5)==3){
										int way;
										int e =4;
										//if it can birth anywhere,randomize birth place
										if(entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkUp()&&entities[x].checkDown()){
											way=rand.nextInt(e);
											if(way==0) entities[z] = new Sheep(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Sheep(entities[x].getX()-10,entities[x].getY());
											else if(way==2) entities[z] = new Sheep(entities[x].getX(),entities[x].getY()+10);
											else if(way==3) entities[z] = new Sheep(entities[x].getX(),entities[x].getY()-10);
										}
										//If at the top
										else if (entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkDown()){
											way=rand.nextInt(e-1);
											if(way==0) entities[z] = new Sheep(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Sheep(entities[x].getX()-10,entities[x].getY());
											else if(way==2) entities[z] = new Sheep(entities[x].getX(),entities[x].getY()-10);
										}
										//If at the bottom
										else if (entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkUp()){
											way=rand.nextInt(e-1);
											if(way==0) entities[z] = new Sheep(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Sheep(entities[x].getX()-10,entities[x].getY());
											else if(way==2) entities[z] = new Sheep(entities[x].getX(),entities[x].getY()+10);
										}
										//If at the right side
										else if (entities[x].checkLeft()&&entities[x].checkDown()&&entities[x].checkUp()){
											way=rand.nextInt(e-1);
											if(way==0) entities[z] = new Sheep(entities[x].getX()-10,entities[x].getY());
											else if(way==1) entities[z] = new Sheep(entities[x].getX(),entities[x].getY()-10);
											else if(way==2) entities[z] = new Sheep(entities[x].getX(),entities[x].getY()+10);
										}
										//If at the left side
										else if (entities[x].checkRight()&&entities[x].checkDown()&&entities[x].checkUp()){
											way=rand.nextInt(e-1);
											if(way==0) entities[z] = new Sheep(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Sheep(entities[x].getX(),entities[x].getY()-10);
											else if(way==2) entities[z] = new Sheep(entities[x].getX(),entities[x].getY()+10);
										}
										//If at top right corner
										else if(entities[x].checkLeft()&&entities[x].checkDown()){
											way=rand.nextInt(e-2);
											if(way==0) entities[z] = new Sheep(entities[x].getX()-10,entities[x].getY());
											else if(way==1) entities[z] = new Sheep(entities[x].getX(),entities[x].getY()-10);
										}
										//If at top left corner
										else if(entities[x].checkRight()&&entities[x].checkDown()){
											way=rand.nextInt(e-2);
											if(way==0) entities[z] = new Sheep(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Sheep(entities[x].getX(),entities[x].getY()-10);
										}
										//If at bottom right corner
										else if(entities[x].checkLeft()&&entities[x].checkUp()){
											way=rand.nextInt(e-2);
											if(way==0) entities[z] = new Sheep(entities[x].getX()-10,entities[x].getY());
											else if(way==1) entities[z] = new Sheep(entities[x].getX(),entities[x].getY()+10);
										}
										//If at bottom left corner
										else if(entities[x].checkRight()&&entities[x].checkUp()){
											way=rand.nextInt(e-2);
											if(way==0) entities[z] = new Sheep(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Sheep(entities[x].getX(),entities[x].getY()+10);
										}
										entities[x].setFertile(false);
									}
									else if(entities[x] instanceof Grass&&rand.nextInt(10)==3){
										int way;
										int e =4;
										//if it can birth anywhere,randomize birth place
										if(entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkUp()&&entities[x].checkDown()){
											way=rand.nextInt(e);
											if(way==0) entities[z] = new Grass(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Grass(entities[x].getX()-10,entities[x].getY());
											else if(way==2) entities[z] = new Grass(entities[x].getX(),entities[x].getY()+10);
											else if(way==3) entities[z] = new Grass(entities[x].getX(),entities[x].getY()-10);
										}
										//If at the top
										else if (entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkDown()){
											way=rand.nextInt(e-1);
											if(way==0) entities[z] = new Grass(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Grass(entities[x].getX()-10,entities[x].getY());
											else if(way==2) entities[z] = new Grass(entities[x].getX(),entities[x].getY()-10);
										}
										//If at the bottom
										else if (entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkUp()){
											way=rand.nextInt(e-1);
											if(way==0) entities[z] = new Grass(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Grass(entities[x].getX()-10,entities[x].getY());
											else if(way==2) entities[z] = new Grass(entities[x].getX(),entities[x].getY()+10);
										}
										//If at the right side
										else if (entities[x].checkLeft()&&entities[x].checkDown()&&entities[x].checkUp()){
											way=rand.nextInt(e-1);
											if(way==0) entities[z] = new Grass(entities[x].getX()-10,entities[x].getY());
											else if(way==1) entities[z] = new Grass(entities[x].getX(),entities[x].getY()-10);
											else if(way==2) entities[z] = new Grass(entities[x].getX(),entities[x].getY()+10);
										}
										//If at the left side
										else if (entities[x].checkRight()&&entities[x].checkDown()&&entities[x].checkUp()){
											way=rand.nextInt(e-1);
											if(way==0) entities[z] = new Grass(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Grass(entities[x].getX(),entities[x].getY()-10);
											else if(way==2) entities[z] = new Grass(entities[x].getX(),entities[x].getY()+10);
										}
										//If at top right corner
										else if(entities[x].checkLeft()&&entities[x].checkDown()){
											way=rand.nextInt(e-2);
											if(way==0) entities[z] = new Grass(entities[x].getX()-10,entities[x].getY());
											else if(way==1) entities[z] = new Grass(entities[x].getX(),entities[x].getY()-10);
										}
										//If at top left corner
										else if(entities[x].checkRight()&&entities[x].checkDown()){
											way=rand.nextInt(e-2);
											if(way==0) entities[z] = new Grass(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Grass(entities[x].getX(),entities[x].getY()-10);
										}
										//If at bottom right corner
										else if(entities[x].checkLeft()&&entities[x].checkUp()){
											way=rand.nextInt(e-2);
											if(way==0) entities[z] = new Grass(entities[x].getX()-10,entities[x].getY());
											else if(way==1) entities[z] = new Grass(entities[x].getX(),entities[x].getY()+10);
										}
										//If at bottom left corner
										else if(entities[x].checkRight()&&entities[x].checkUp()){
											way=rand.nextInt(e-2);
											if(way==0) entities[z] = new Grass(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Grass(entities[x].getX(),entities[x].getY()+10);
										}
										entities[x].setFertile(false);
									}
									else if(entities[x] instanceof Wolf&&rand.nextInt(10)==3){
										int way;
										int e =4;
										//if it can birth anywhere,randomize birth place
										if(entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkUp()&&entities[x].checkDown()){
											way=rand.nextInt(e);
											if(way==0) entities[z] = new Wolf(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Wolf(entities[x].getX()-10,entities[x].getY());
											else if(way==2) entities[z] = new Wolf(entities[x].getX(),entities[x].getY()+10);
											else if(way==3) entities[z] = new Wolf(entities[x].getX(),entities[x].getY()-10);
										}
										//If at the top
										else if (entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkDown()){
											way=rand.nextInt(e-1);
											if(way==0) entities[z] = new Wolf(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Wolf(entities[x].getX()-10,entities[x].getY());
											else if(way==2) entities[z] = new Wolf(entities[x].getX(),entities[x].getY()-10);
										}
										//If at the bottom
										else if (entities[x].checkLeft()&&entities[x].checkRight()&&entities[x].checkUp()){
											way=rand.nextInt(e-1);
											if(way==0) entities[z] = new Wolf(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Wolf(entities[x].getX()-10,entities[x].getY());
											else if(way==2) entities[z] = new Wolf(entities[x].getX(),entities[x].getY()+10);
										}
										//If at the right side
										else if (entities[x].checkLeft()&&entities[x].checkDown()&&entities[x].checkUp()){
											way=rand.nextInt(e-1);
											if(way==0) entities[z] = new Wolf(entities[x].getX()-10,entities[x].getY());
											else if(way==1) entities[z] = new Wolf(entities[x].getX(),entities[x].getY()-10);
											else if(way==2) entities[z] = new Wolf(entities[x].getX(),entities[x].getY()+10);
										}
										//If at the left side
										else if (entities[x].checkRight()&&entities[x].checkDown()&&entities[x].checkUp()){
											way=rand.nextInt(e-1);
											if(way==0) entities[z] = new Wolf(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Wolf(entities[x].getX(),entities[x].getY()-10);
											else if(way==2) entities[z] = new Wolf(entities[x].getX(),entities[x].getY()+10);
										}
										//If at top right corner
										else if(entities[x].checkLeft()&&entities[x].checkDown()){
											way=rand.nextInt(e-2);
											if(way==0) entities[z] = new Wolf(entities[x].getX()-10,entities[x].getY());
											else if(way==1) entities[z] = new Wolf(entities[x].getX(),entities[x].getY()-10);
										}
										//If at top left corner
										else if(entities[x].checkRight()&&entities[x].checkDown()){
											way=rand.nextInt(e-2);
											if(way==0) entities[z] = new Wolf(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Wolf(entities[x].getX(),entities[x].getY()-10);
										}
										//If at bottom right corner
										else if(entities[x].checkLeft()&&entities[x].checkUp()){
											way=rand.nextInt(e-2);
											if(way==0) entities[z] = new Wolf(entities[x].getX()-10,entities[x].getY());
											else if(way==1) entities[z] = new Wolf(entities[x].getX(),entities[x].getY()+10);
										}
										//If at bottom left corner
										else if(entities[x].checkRight()&&entities[x].checkUp()){
											way=rand.nextInt(e-2);
											if(way==0) entities[z] = new Wolf(entities[x].getX()+10,entities[x].getY());
											else if(way==1) entities[z] = new Wolf(entities[x].getX(),entities[x].getY()+10);
										}
										entities[x].setFertile(false);	
								}
								
							}
						}
					}
				}
			}
		}
}
	public void nom(){
		for(int x=0;x<entities.length;x++){
			for(int z=0;z<entities.length;z++){
				if(entities[x] instanceof Sheep&&entities[z] instanceof Grass){
					if(entities[x].getX()==entities[z].getX()&&entities[x].getY()==entities[z].getY()){
							eat(x,z);
					}
				}
				if(entities[x] instanceof Wolf&&entities[z] instanceof Sheep){
					if(entities[x].getX()==entities[z].getX()&&entities[x].getY()==entities[z].getY()){
							eat(x,z);
					}
				}
				
			}
		}
	}
	public void eat(int a,int b){
		entities[b]=null;
		if(entities[a].getHunger()<20){
			entities[a].setHunger(0);
		}
		else {
			entities[a].setHunger(entities[a].getHunger()-20);
		}
		entities[a].setFertile(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		
		//move, eat, die, reproduce
		move();
		nom();
		birth();
		death();
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(BROWN);
		g.fillRect(0, 0, 800, 600);

		//Loop through and draw all entities
		for(Entity x:entities){
			//Sheepo
			if(x instanceof Sheep){
				g.setColor(Color.white);
				g.fillRect(x.getX(), x.getY(), 10, 10);
			}
			//Grasso
			else if(x instanceof Grass){
				g.setColor(Color.green);
				g.fillRect(x.getX(), x.getY(), 10, 10);
			}
			//Wolfo
			else if (x instanceof Wolf){
				g.setColor(Color.black);
				g.fillRect(x.getX(), x.getY(), 10, 10);
			}
			
			
		}
	}

	public static void main(String[] args) {
		World w = new World();
		JFrame frame = new JFrame("Game Map");
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(w);
	}
}
