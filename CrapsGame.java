package craps;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class CrapsGame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel dicetitle;
	public TitledBorder sumofdicetitle;
	public JButton roll;
	public JButton play;
	public JLabel result;
	public JTextField	result2;
	public JButton Tutorial;
	
	
	
	int sumofdice;
	int sumofdice2;
	public  CrapsGame() {
		
		
	}
	public int Rolling(){
		int z;
		Random dice = new Random();
		z= dice.nextInt(11) + 2;
		
		return z;
	}
	
	
	
	public void GUImethod(){
		JFrame jframe=new JFrame("Game");	
		sumofdicetitle=new TitledBorder("Craps");
		 dicetitle=new JPanel();
		 dicetitle.setBounds(16, 16, 200, 116);
		 dicetitle.setLayout(null);
		 dicetitle.setBorder(sumofdicetitle);
		 play = new JButton();
	      play.setBounds( 232, 16, 88, 23 );
	      play.setText( "Play" );
	      play.setEnabled( false );
	      dicetitle.add( play );
	    
		 roll=new JButton();
		 roll.setBounds(232, 70, 88, 24 );
		 roll.setText("ROLL");
		 roll.setEnabled( false );
		 dicetitle.add(roll);
		 result = new JLabel();
	      result.setBounds( 232, 90, 48, 16 );
	      result.setText( "Result:" );
	      dicetitle.add( result );
	      
	      Tutorial=new JButton();
	      Tutorial.setBounds(232, 40, 95, 30 );
	      Tutorial.setText("TUTORIAL");
	      Tutorial.setEnabled( true );
	      dicetitle.add(Tutorial);
	      Tutorial.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
	    		  JOptionPane.showMessageDialog(null,"TUTORIAL\n"+"- Craps is played with two dice so the possible numbers rolled are 2 through 12\n" + "On the Come-Out Roll:\n"
	    	  +"- 7 or 11 are automatic Pass Line winners and the series ends. (This is essentially a one-roll series.)\n"
	    	  +"- 2, 3, or 12 (known as craps) are automatic Pass Line losers and the series ends. (This also is essentially a one-roll series.)\n"
	    	  +"- Any other number rolled (4,5,6,8,9,10) becomes the shooter's point and the series continues\n"
	    	  +"- When the series continues....:\n"
	    	  +"- If the shooter establishes a point, the series continues and the shooter continues to roll the dice. The object of the game now becomes for the shooter to roll their point number again before they roll a 7.\n"
	    	  + "- If any number other than the point or a 7 is rolled, nothing happens and the shooter rolls again\n"
	    	  +"- If the point is rolled, Pass Line bets win and the series ends\n"
	    	  +"- If a 7 is rolled, Pass Line bets lose (known as a \"seven out\") and the series ends\n"
	    	  +"- Until you win or lose, keep continue to press roll button");
	    				   play.setEnabled( true );
	    	  }
	      });
	     
	      
	      
	      
	      // set up resultJTextField
	      result2 = new JTextField();
	      result2.setBounds( 232, 106, 220, 220 );
	      result2.setHorizontalAlignment( JTextField.CENTER );
	      result2.setEditable( false );
	      dicetitle.add( result2 );
	      play.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
	    		   sumofdice2=Rolling();
	    		  
	    		   ImageIcon c1=new ImageIcon(CrapsGame.class.getResource("gif/animated-dice-image-0019.gif"));
	    		   JLabel panel=new JLabel((c1));
	    		   jframe.getContentPane().add(panel);
	    		   panel.setBounds(20,60,220,220);
	    		   panel.setLayout(null);
	    		   dicetitle.add(panel);
	    		   
	    		 
	    		   
	    		   
	    		  if (sumofdice2 == 7 ||sumofdice2== 11) {
	    			 
	    			  String string="LUCKY MAN"+"YOU WIN!!"+" "+sumofdice2;
	    			
					  result2.setText( string);
					
		               play.setEnabled( true );
		              

		              

				} 
	    		  else if (sumofdice2 == 2 ||sumofdice2 == 3 || sumofdice==12) {
				
	    			  result2.setText( "LOOSER!!."+sumofdice2 );
	    			  play.setEnabled( true );
	    			  sumofdicetitle.setTitle("Sum of Dice ");
	    		  } 
	    		  else{
	    			 result2.setText( "Roll again! Your sum of dice is:"+" "+sumofdice2 );
	    			  play.setEnabled(false);
	    			  roll.setEnabled( true );
	    			
	    		
	    			  
	    			  
	    			  
	    		  }
	    
			}

	    	
	    	  
	      });
	      
	     
	      
	      roll.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent e){
	    		 
	    		   sumofdice=Rolling();
	    		  
	    		 
	    		
	    		  if(sumofdice2 != 7 && sumofdice2!= 11 &&  sumofdice2 != 2 && sumofdice2 != 3 && sumofdice2!=12){
	    			
	    			 
	    			 
	    			  
				
				 
	    			  while (sumofdice < sumofdice2 && sumofdice>sumofdice2 && sumofdice != 7) {
					
	    				  
	    				 
	    				 
	    				  result2.setText("Roll again\nYour sum of dice is:"+" "+ sumofdice);
	    				 
	    				  play.setEnabled( false );
	    				  sumofdice = Rolling();
	    			  }
	    			  if (sumofdice == sumofdice2) {
					
	    				  result2.setText( "You win!!!"+" "+sumofdice);
	    				  roll.setEnabled( false );
	    				  play.setEnabled( true );

	    			  }
	    			  if (sumofdice == 7) {

	    				  result2.setText( "Sorry, you lose."+" "+ sumofdice );
	    				  roll.setEnabled( false );
	    				  play.setEnabled( true );
	              
	    			  }
	    		  }
			}

	    	
	    	  
	      });
	      
	    
		  
		
		
         
         jframe.setSize(500, 500);
		   jframe.setContentPane(dicetitle);
			 jframe.setVisible(true);
	}
}
				
				
				
				
				

			
		 
       
       
        
	



	

	
	

	



	

