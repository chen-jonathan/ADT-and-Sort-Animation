/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstemplate;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Color;
import java.io.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.net.URL;
import javax.sound.sampled.*;
import java.util.*;
/**
 *
 * @author 023627
 */
class MyAppClass extends JPanel 
{
    Graphics me = null; 	
    private Timer timer = new Timer();  
    Clip clip;
    int screen = 0;   
    private Image offScreenImage = null;
    private Graphics offScreenGraphics = null;
    //Linked List pointers and variables
    LinkedList start=null;
    LinkedList end= null;
    LinkedList ltemp;
    int lx;
    int ly;
    //Stack pointers and variables    
    Stack top=null;
    int sx;
    int sy;
    Stack stemp;
    //Queue pointers and variables
    int qx;
    int qy;
    Queue front;
    Queue rear;
    Queue qtemp;
    //Binary Tree pointers and variables 
    Node root;  
    Node btemp;  
    int bx;
    int by;
    //Bars pointers and variables
    int barsx;
    int barsy;
    Bars [] array = new Bars[10];
    int index=2;
    int newlow;
    int newhigh;
    boolean divideList;
    public class MyKeyListener implements KeyListener {
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) 
        {        
            if (screen ==0)
            {  
                //run menu function 
                menu(e);
            }
            //linked list screen
            else if (screen ==1) 
            {          
                //return to main menu
                if (e.getKeyCode() == 'E')
                {
                    screen=0;                
                }
                //add a node to linked list 
                else if (e.getKeyCode() == 'A')
                {
                   addLinkedList();
                }
                //delete a node
                if (e.getKeyCode() == 'D')
                {
                    deleteLinkedList();                    
                }
            }   
            //stack screen
            else if (screen ==2)
            {              
                //return to main menu
                if (e.getKeyCode() == 'E')
                {
                    screen=0;                
                }
                 //push node onto stack
                else if (e.getKeyCode() == 'A')
                {                   
                    push();
                }
                //pop node from stack
                else if (e.getKeyCode() == 'D')
                {
                    pop();
                }          
            }
            //queue screen 
            else if (screen ==3)
            {
                //return to main menu
                if (e.getKeyCode() == 'E')
                {
                    screen=0;                
                }
                //enqueue (add a node to the queue)
                else if (e.getKeyCode() == 'A')
                {
                    enqueue();
                }  
                //dequeue (delete a node from the queue)
                else if (e.getKeyCode() == 'D')
                {                   
                   dequeue();
                }                
            }
            //binary tree screen 
            else if (screen ==4)
            {          
                Node n1;
                //return to main menu
                if (e.getKeyCode() == 'E')
                {
                    screen=0;                
                }
                //add a node to the screen 
                else if (e.getKeyCode() =='A')
                {  
                    Random r = new Random();
                    //get a random number from 0 to 20
                    int random = r.nextInt(21);
                    if (root == null)
                    {
                        root = new Node(10);//make value of root 10                        
                    }
                    else
                    {
                        //add the rest of the nodes in the binary tree 
                        n1 = new Node (null, null,random);
                        insertNode(root, n1);
                        System.out.println(random);    
                    }
                }
            }
            //bubble sort screen
            else if (screen ==5)
            {                
                //return to main menu
                if (e.getKeyCode() == 'E')
                {
                    screen=0;                
                }
                //bubble sort the array
                else if (e.getKeyCode() =='A')
                {           
                    int tempLength=0;  
                    for (int j =0; j<array.length-1; j++)
                    {
                        if (array[j].getLength() > array[j+1].getLength())
                        {
                            System.out.println("swap");
                            //swap lengths
                            tempLength = array[j].getLength();
                            array[j].setLength(array[j+1].getLength());
                            array[j+1].setLength(tempLength);                                   
                        }
                    }                                     
                }
            }
            //insertion sort screen 
            else if (screen ==6)
            {
                //return to main menu
                if (e.getKeyCode() == 'E')
                {
                    screen=0;                
                }
                //insertion sort the array
                else if (e.getKeyCode() =='A')
                {          
                    if (index <array.length)
                    {
                        int tempLength=0;
                        int key = array[index].getLength();                    
                        int j = index-1;
                        //update index value
                        index++;
                        //sort array 
                        while (j>=0 && array[j].getLength() > key)
                        {
                            //swap lengths
                            tempLength = array[j].length;                        
                            array[j+1].setLength(tempLength);  
                            j--;
                        }
                        array[j+1].setLength(key);                        
                    } 
                    else
                    {
                        //reset index value for next pass
                        index=2;                        
                    }
                }
            }
            //selection sort screen
            else if (screen ==7)
            {      
                boolean newmin= false;
                //return to main menu
                if (e.getKeyCode() == 'E')
                {
                    screen=0;                
                }
                 //selection sort the array
                else if (e.getKeyCode() =='A')
                { 
                    if (index<array.length-1)
                    {
                        int tempLength=0;                
                        int min= index;
                        int checkLength= array[min].getLength(); //variable to keep track of smallest value 
                        int minval=min;//variable for index of smallest min val                              
                        //find the smallest length in the array 
                        for (int i = min;i<array.length;i++)
                        {                
                            if (array[i].getLength()< checkLength)
                            {
                                minval = i;
                                checkLength = array[minval].getLength();
                                newmin=true;
                            }
                        }                
                        if (newmin==true)
                        {
                            //swap the smallest with the current position
                            tempLength = array[minval].getLength();
                            array[minval].setLength(array[min].getLength());
                            array[min].setLength(tempLength);
                            newmin = false;
                        }
                        //update index value
                        index++;
                    }
                    else
                    {
                        //reset index value for next pass
                        index=0;
                    }
                }
            }
            //quick sort screen 
            else if (screen ==8)
            {
                //return to main menu
                if (e.getKeyCode() == 'E')
                {
                    screen=0;                
                }   
                else if (e.getKeyCode() == 'A')
                {
                     if (divideList==false)
                    {
                        //first pass 
                        quickSort(0,array.length-1);
                    }
                    else
                    {
                        //sort the divided list
                        quickSort (0, newhigh);
                        quickSort (newlow,array.length-1);            
                    }
                }
            }
        }
/**************************************************
* FUNCTION: quickSort
* NAME: Jonathan Chen
* Date: June 13th, 2019
* Description:Quicksorts the list of bars based on the bar length 
* Inputs: int low (start of list), int high (end of list) 
* Outputs:none 
*****************************************************/
        private void quickSort(int low, int high) {
        int i = low;
        int j = high;
        int tempLength=0;
        // Get the pivot element from the middle of the list
        int pivot = array[low + (high-low)/2].getLength();
        // Divide into two lists
        while (i <= j)
        {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (array[i].getLength() < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (array[j].getLength() > pivot) {
                j--;
            }            
            if (i <= j) 
            {
                //swap lenghs 
               tempLength = array[i].getLength();
               array[i].setLength(array[j].getLength());
               array[j].setLength(tempLength);
                i++;
                j--;
            }
        }
        //set values for next pass (when list divides)
        newhigh=j;
        newlow=i;
        divideList=true;
    }
/**************************************************
* FUNCTION: insertNode
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Code to insert a node into the binary tree
* Inputs: Node n (node that we compare what we want to add), Node temp, node we want to add
* Outputs:None 
*****************************************************/
    void insertNode(Node n, Node temp)
    {               
        //get the integer values for the nodes 
        int ns = n.getData();
        int ts = temp.getData();
        //insert the node into the binary tree
        //add the node to right if temp value is greater than 
        if (ts>ns)
        {
            //base case
           if (n.getRight() == null)
           {
               n.setRight(temp);               
               return;
           }
           //if right of n node is not null, go to the next node 
           else
           { 
               insertNode(n.getRight(), temp);
           }
       }
       else
       {     
           //base case
           if (n.getLeft() == null)
           {              
               n.setLeft(temp);             
               return;
           }
            //if left of n node is not null, go to the next node 
           else
           {                        
               insertNode(n.getLeft(), temp);
           }
       }
    }    
/**************************************************
* FUNCTION: menu
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Code to navigate to various screens from the main menu and initialize values
* Inputs: Keyevent e
* Outputs:None 
*****************************************************/
	public void menu(KeyEvent e)
        {
            //go to the screen that the user picks from menu
                if (e.getKeyCode() == '1')
                {
                    screen=1;   
                    start = null;
                    end = null;
                    //set intial x and y values
                    lx= 50;
                    ly=350;
                }
                else if (e.getKeyCode() == '2')
                {
                    screen=2;
                    top = null;
                    //set intial x and y values
                    sx =450;
                    sy=800; 
                }
                else if (e.getKeyCode() == '3')
                {
                    screen=3;    
                    front = null;
                    rear = null;
                    //set intial x and y values
                    qx =450;
                    qy=100; 
                }
                else if (e.getKeyCode() == '4')
                {
                    screen=4;   
                    root = null;                
                    //set intial x and y values
                    bx =400;
                    by=100; 
                }
                else if (e.getKeyCode() == '5')
                {
                    screen=5; 
                    barsx=300;
                    barsy=250;
                    //get a random number between 20 and 220 for the length of the bars
                    Random r = new Random();                  
                    Bars b;
                    //make an array of varying bar sizes 
                    for (int i =0; i<10; i++)
                    {
                        int random = r.nextInt(201)+20;  
                        b = new Bars (barsx, barsy, random, 10);
                        array[i] = b;
                        barsx+=50;  
                    }
                }
                else  if (e.getKeyCode() == '6')
                {
                    screen=6; 
                    index=2;
                    barsx=200;
                    barsy=250;
                    //get a random number between 20 and 220 for the length of the bars
                    Random r = new Random();                  
                    Bars b;
                    for (int i =0; i<10; i++)
                    {
                        int random = r.nextInt(201)+20;  
                        b = new Bars (barsx, barsy, random, 10);
                        array[i] = b;
                        barsx+=50;            
                    }
                }
                else if (e.getKeyCode() == '7')
                {
                    screen=7; 
                    index=0;
                    barsx=200;
                    barsy=250;
                    //get a random number between 20 and 220 for the length of the bars
                    Random r = new Random();                  
                    Bars b;
                    for (int i =0; i<10; i++)
                    {
                        int random = r.nextInt(201)+20;  
                        b = new Bars (barsx, barsy, random, 10);
                        array[i] = b;
                        barsx+=50;            
                    }
                }
                else if (e.getKeyCode() == '8')
                {
                    screen=8;   
                    barsx=200;
                    barsy=250;
                    newlow=0;
                    newhigh=0;
                    divideList = false;
                    //get a random number between 20 and 220 for the length of the bars
                    Random r = new Random();                  
                    Bars b;
                    for (int i =0; i<10; i++)
                    {
                        int random = r.nextInt(201)+20;  
                        b = new Bars (barsx, barsy, random, 10);
                        array[i] = b;
                        barsx+=50;            
                    }

                }
        } 
 /**************************************************
* FUNCTION: addLinkList
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Adds a node to the link list 
* Inputs/Outputs: None 
*****************************************************/
        public void addLinkedList()
        {
             //first node in linked list
            if (start ==null && end == null)
            {                      
                LinkedList l1 = new LinkedList(lx, ly);
                start= l1;
                end=l1;
                ltemp = start;       
            }
            //rest of the nodes in the linked list
            else
            {  
                //update the x value as new node is instantiated
                lx+= 100;
                end = new LinkedList(lx,ly,end);
            }
        }
 /**************************************************
* FUNCTION: deleteLinkList
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Deletes a node from the link list 
* Inputs/Outputs: None 
*****************************************************/
        public void deleteLinkedList()
        {
            ltemp = end; 
            //if there is only one node in the linked list 
            if (start ==end)
            {
                start =null;
                end = null;
            }
            else
            {
                //make a new pointer called prev 
                LinkedList prev = start;
                //move prev pointer to one ahead of temp pointer
                while (prev.next!= ltemp)
                {
                    prev = prev.next;
                }
                //delete last node
                prev.next = null;
                end = prev;
                //reset x value
                lx-=100;
            }
        }
/**************************************************
* FUNCTION: pop
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Deletes the top node from the stack
* Inputs/Outputs: None 
*****************************************************/
        public void pop()
        {
            top = top.link;
            sy+=60;
        }
/**************************************************
* FUNCTION: push
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Add a node to the top of the stack 
* Inputs/Outputs: None 
*****************************************************/
        public void push()
        {
            //make the first node on the stack;
            if (top == null)
            {
                Stack s = new Stack(sx,sy);     
                top = s;
                sy-=60;  
            }
            //rest of the nodes in the stack
            else
            {
                top = new Stack (sx, sy, top);   
                sy-=60;
            }
        }
/**************************************************
* FUNCTION: enqueue
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Add a node to rear of the queue 
* Inputs/Outputs: None 
*****************************************************/
        public void enqueue()
        {
            Queue q = null;
            //create instance for the first node in the queue
            if (front == null && rear == null)
            {
                q = new Queue (qx, qy);
                qy+=60;
            } 
            //create the rest of the nodes in the queue
            else
            {
                q = new Queue (qx,qy);
                qy+=60;
            }
            //if queue is empty, the new node becomes the front of the queue
            if (front ==null)
            {
                front = q;
            } 
            //else add the node to the end of the queue 
            else 
            {
                rear.link = q;
            }
            //make the rear pointer the neweset node added 
            rear= q;
        }
/**************************************************
* FUNCTION: dequeue
* NAME: Jonathan Chen
* Date: June 1st, 2019
* Description:Add a node to rear of the queue 
* Inputs/Outputs: None 
*****************************************************/
        public void dequeue()
        {
             front = front.link;
             //if there is only one node in the queue
             if (front ==null)
             {
                 rear=null;
             }
        }
	@Override
	public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
		}
	}
    public class MyMouseListener implements MouseListener {
        	public void mouseClicked (MouseEvent mouseEvent) {
                    if (screen == 0) {
                    if (mouseEvent.getX() > 100 && mouseEvent.getX() <200) 
                        screen =1;
                    }
                } 
                
                public void mouseEntered (MouseEvent mouseEvent) {} 
                public void mousePressed (MouseEvent mouseEvent) {} 
                public void mouseReleased (MouseEvent mouseEvent) {}  
                public void mouseExited (MouseEvent mouseEvent) {}  

	}

    
    public void fire () {
           try {
         // Open an audio input stream.
         URL url = this.getClass().getClassLoader().getResource("laser.wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         // Get a sound clip resource.
         clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }        
    }    
    
    MyAppClass(){
        // maze 2 dimensional array	
         timer.schedule(new MyTimer(), 0, 1);
        KeyListener listener = new MyKeyListener();
        MouseListener mouselistener = new MyMouseListener();
        addKeyListener(listener);
        addMouseListener(mouselistener);
            
        setFocusable(true);

        
      
    }
    
    public void renderOffScreen( Graphics g) 
    {                 
        me = g;               
        if (screen == 0) 
        {
            //set up menu screen                    
            g.setFont(new Font("TimesRoman", Font.PLAIN, 36)); 
            g.drawString("Welcome to the ADT and Sort Interactive", 100,50);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
            g.drawString("Press 1 for Linked List", 100, 250);
            g.drawString("Press 2 for Stack", 100, 300);
            g.drawString("Press 3 for Queue", 100, 350);
            g.drawString("Press 4 for Binary Tree", 100, 400);
            g.drawString("Press 5 for Bubble Sort", 400, 250);
            g.drawString("Press 6 for Insertion Sort", 400, 300);
            g.drawString("Press 7 for Selection Sort", 400, 350);
            g.drawString("Press 8 for Quick Sort", 400, 400); 
        }
        //Linked List screen
        else if (screen == 1) 
        {        
           ltemp = start;
           //set up text for the screen
           g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
           g.drawString("Press 'E' to exit", 100,100);   
           g.drawString("Press 'A' to add node", 100,150); 
           g.drawString("Press 'D' to delete node", 100,200); 
           g.setFont(new Font("TimesRoman", Font.PLAIN, 36)); 
           g.drawString("Linked List", 400,50);       
           while (ltemp !=null)
          {              
             if (ltemp == start)
              {
                //draw start pointer
                g.fillRect(ltemp.getX()-30, ltemp.getY()+20,30,10);                             
              }
             if (ltemp ==end)
             {
                 //draw end pointer
                 g.fillRect(ltemp.getX()+90, ltemp.getY()+10,30,10);
             }             
             //draw the node
             g.fillRect(ltemp.getX(), ltemp.getY(),90,50); 
             //draw a rectangle to represent the "next" link between nodes
             g.fillRect(ltemp.getX()+90, ltemp.getY()+30, 10, 10);        
             ltemp = ltemp.next;
             
          }
        }
        //Stack screen
        else if (screen == 2) 
        {
            //set up text for the screen 
           g.setFont(new Font("TimesRoman", Font.PLAIN, 36)); 
           g.drawString("Stack", 400,50); 
           //set up text for the screen
           g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
           g.drawString("Press 'E' to exit", 10,100);   
           g.drawString("Press 'A' to push", 10,150); 
           g.drawString("Press 'D' to pop", 10,200);         
           stemp = top;           
           while (stemp !=null)
           {
               if (stemp==top)
               {
                   //draw the top pointer 
                   g.fillRect(stemp.getX()+55, stemp.getY()-30,10,30); 
               }
               //draw the node
               g.fillRect(stemp.getX(), stemp.getY(),90,40);   
               //draw a rectangle to represent the link between nodes
               g.fillRect(stemp.getX()+45, stemp.getY()+40,10,30); 
               stemp = stemp.link;
           }      
        }
        //Queue screen 
        else if (screen ==3)
        {
           //set up text for screen
           g.setFont(new Font("TimesRoman", Font.PLAIN, 36)); 
           g.drawString("Queue", 400,50); 
           //set up text for the screen
           g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
           g.drawString("Press 'E' to exit", 10,100);   
           g.drawString("Press 'A' to enqueue", 10,150); 
           g.drawString("Press 'D' to dequeue", 10,200);      
           qtemp = front;
           while (qtemp != null)
           {
               //draw the front pointer
               if (qtemp==front)
               {
                  g.fillRect(qtemp.getX()+45, qtemp.getY()-20,10,30);
               }
               //draw the rear pointer
               if (qtemp ==rear)
               {
                    g.fillRect(qtemp.getX()+65, qtemp.getY()+40,10,30);
               }
               //draw the node
               g.fillRect(qtemp.getX(), qtemp.getY(),90,40);
               //draw the links between the nodes 
               g.fillRect(qtemp.getX()+45, qtemp.getY()+40,10,20);
               qtemp = qtemp.link;
           }
        }
        //Binary Tree Screen
        else if (screen ==4)
        {
           //set up text for the screen
           g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
           g.drawString("Press 'E' to exit", 100,100);   
           g.drawString("Press 'A' to add node", 100,150);            
           g.setFont(new Font("TimesRoman", Font.PLAIN, 36)); 
           g.drawString("Binary Tree", 400,50);           
           btemp = root;
           //draw the node and links 
           if (btemp!=null)
           {
                g=displayTree(g, btemp, 0,0);        
            
           }
        }
         //bubble sort screen
        else if (screen == 5) 
        {
           //set up text for the screen
           g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
           g.drawString("Press 'E' to exit", 100,100);   
           g.drawString("Press 'A' to sort one pass", 100,150);
           g.setFont(new Font("TimesRoman", Font.PLAIN, 36)); 
           g.drawString("Bubble Sort", 400,50);  
           //display list 
           for (int i =0; i<array.length; i++)
           {
               g.fillRect(array[i].x, array[i].y, array[i].width, array[i].length);
           }        
        }  
        //insertion sort screen 
        else if (screen ==6)
        {
           //set up text for the screen
           g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
           g.drawString("Press 'E' to exit", 100,100);   
           g.drawString("Press 'A' to sort one pass", 100,150);
           g.setFont(new Font("TimesRoman", Font.PLAIN, 36)); 
           g.drawString("Insertion Sort", 400,50);  
           //display list 
           for (int i =0; i<array.length; i++)
           {
               g.fillRect(array[i].x, array[i].y, array[i].width, array[i].length);
           }     
        }
        //selection sort screen 
        else if (screen ==7)
        {
            //set up text for the screen
           g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
           g.drawString("Press 'E' to exit", 100,100);   
           g.drawString("Press 'A' to sort one pass", 100,150);
           g.setFont(new Font("TimesRoman", Font.PLAIN, 36)); 
           g.drawString("Selection Sort", 400,50);  
           //display list 
           for (int i =0; i<array.length; i++)
           {
               g.fillRect(array[i].x, array[i].y, array[i].width, array[i].length);
           }     
        }
        else if (screen ==8)
        {
           //set up text for the screen
           g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
           g.drawString("Press 'E' to exit", 100,100);   
           g.drawString("Press 'A' to sort one pass", 100,150);
           g.setFont(new Font("TimesRoman", Font.PLAIN, 36)); 
           g.drawString("Quick Sort", 400,50);  
           //display list 
           for (int i =0; i<array.length; i++)
           {
               g.fillRect(array[i].x, array[i].y, array[i].width, array[i].length);
           }   
        }
    }
/**************************************************
* FUNCTION: displayTree
* NAME: Jonathan Chen
* Date: June 10th, 2019
* Description:Recurse through the binary tree and display each node 
* Inputs:Graphics g, int horizontal (tell us what level we are at in tree), int vertical (what column we are at in tree)
* Outputs:
*****************************************************/
    Graphics displayTree(Graphics g, Node temp, int horizontal, int vertical)
    {         
        if (temp ==null)
        {
            return g;
        }
        else
        { 
            int x =bx+horizontal*130;
            int y = by+vertical*80;
            //draw the node   
            g.fillRect(x,y,90,40);            
            //draw the left and right pointers     
            g.drawLine(x+45, y+40, x-70, y+80);
            g.drawLine(x+45, y+40, x+120, y+80);
            //write the number
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.setColor(Color.white);
            g.drawString(String.valueOf(temp.getData()), x+43, y+20);
            //reset the colour back to black 
            g.setColor(Color.black);
            //recurse to left  
            g=displayTree(g, temp.getLeft(),horizontal-1, vertical+1);
            //recurse to right  
            g=displayTree(g, temp.getRight(), horizontal+1, vertical+1);      
        }
        return g;
    }

        private class MyTimer extends java.util.TimerTask { 
                public void run() { 
                 // Run thread on event dispatching thread 
                 if (!EventQueue.isDispatchThread()) { 
                     EventQueue.invokeLater(this); 
                 } else { 
                     if (MyAppClass.this != null) { 
                         MyAppClass.this.repaint();                         
                     } 
                 } 
                  
             } // End of Run 
         }         


        public void paint(Graphics g) {
            final Dimension d = getSize(); 

             if (offScreenImage == null) {    
                 // Double-buffer: clear the offscreen image.                 
                 offScreenImage = createImage(d.width, d.height);    
             }         
             offScreenGraphics  = offScreenImage.getGraphics();      
             offScreenGraphics.setColor(Color.white); 
             offScreenGraphics.fillRect(0, 0, d.width, d.height) ;      
            
            renderOffScreen(offScreenImage.getGraphics());
                
            g.drawImage(offScreenImage, 0, 0, null);
       
            }
        }