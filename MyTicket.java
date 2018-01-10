//-------------------------------------------------------
// ************* Booking Your Tickets ************
// -------------------------------------------------------- 

import java.util.Scanner;

public class MyTicket
{
    public static void main(String[] args)
    { 
	int i,j;
	final int ROWS = 6;
	final int SEAT_PER_ROW = 7;
	char[][] seats;

	// initialize your booking layout
	seats = new char[ROWS][SEAT_PER_ROW+1]; // array stores booking layout
 

      	seats[0][0] = '1';
      	seats[1][0] = '2';
      	seats[2][0] = '3';
      	seats[3][0] = '4';
      	seats[4][0] = '5';
      	seats[5][0] = '6';
      
	for (i=0;i<ROWS;i++)
		seats[i][1] = 'A';

	for (i=0;i<ROWS;i++)
		seats[i][2] = 'B';

	for (i=0;i<ROWS;i++)
		seats[i][3] = 'C';

	for (i=0;i<ROWS;i++)
		seats[i][4] = 'D';
	
	for (i=0;i<ROWS;i++)
		seats[i][5] = 'E';

	for (i=0;i<ROWS;i++)
		seats[i][6] = 'F';

	for (i=0;i<ROWS;i++)
		seats[i][7] = 'G';


	Scanner keyboard = new Scanner(System.in);

        // Display a welcome message, available seats and prices 

	System.out.println();
	System.out.println("\t-------------------------------------------------\n" +
			 "\t--------COMP248 Concert IS BACK IN TOWN------------\n"
                        +"\t         Hurry book your ticket Now!!           \n" +
			 "\t--------------------------------------------------\n");

	displayLayout(seats); // method to print booking layout


	System.out.println();
	System.out.println("Rows 1 & 2 Gold   100 $/ticket");
	System.out.println("Rows 3 & 4 Silver  70 $/ticket");      
	System.out.println("Rows 5 & 6 Bronze  40 $/ticket");

	String NewBooking;
	do      // begin booking session 
	{
	int TicketNo;
	int Emptyseats;

	// input number of tickets you need to reserve in this session

	System.out.println("How many tickets do you need?");
	TicketNo=keyboard.nextInt();
	Emptyseats=availableSeats(seats); // method to calculate empty seats

	if (Emptyseats<TicketNo) 
	{
		System.out.println("Sorry cannot process your resquest ");
		System.out.println("No more seat are available ");
		break; // terminate program if not enough seats are available 
	}
	char InputRow;
	int InputRowIndex=0;
	int InputSeatIndex=0;
	char SeatLetter;
	String InputSeat;
	double TktPrice=0;
	boolean valid;
	double balance=0;

	for (int k=1; k<=TicketNo; k++) // begin booking the tickets
	{

	do
	{            


 	System.out.println("Input your seat selection ");
 	System.out.println("Enter the row number and then the seat letter "
	+ "(example: 3B)");
 	InputSeat=keyboard.next();

	// Input seat selection and check its validity
	if (InputSeat.length()==2)
	{
	InputRow=InputSeat.charAt(0);
	SeatLetter=InputSeat.charAt(1);
	valid=true;

	switch(InputRow) // check validity of input row and calculate price
	{
	case '1': InputRowIndex=0; 
	  	TktPrice=100;
	  break;   		
	case '2': InputRowIndex=1;
	  TktPrice=100;
	  break; 	
	case '3': InputRowIndex=2;
	  TktPrice= 70;	
	  break;
	case '4': InputRowIndex=3;
	  TktPrice= 70;	
	  break;
	case '5': InputRowIndex=4;
	  TktPrice= 40;	
	  break;
	case '6': InputRowIndex=5;
	  TktPrice=40;
	  break;
	default: System.out.println("Invalid row number -try again");
	valid=false; 
	}

	switch(SeatLetter)  // check validity of input
	{
	case 'A': InputSeatIndex=1;
	  break;  	    		
	case 'B': InputSeatIndex=2;
	  break; 	
	case 'C': InputSeatIndex=3;
	  break; 
	case 'D': InputSeatIndex=4;
	  break; 
	case 'E': InputSeatIndex=5;
	  break; 
	case 'F': InputSeatIndex=6;
	  break; 
	case 'G': InputSeatIndex=7;
	  break; 
	default: System.out.println("Invalid Seat letter - try again ");
	valid=false;
	}
	// Seat already taken?
	if (valid && seats[InputRowIndex][InputSeatIndex]== 'X')
	{
	System.out.println("Sorry seat is not available ");
	valid=false;
	}

	}
	else
	{
	valid= false;
	System.out.println("Invalid Seat assignment ");
	}
	}while (!valid); // repeat if the input is not valid

	// make reservation, calculate price and new display layout
	seats[InputRowIndex][InputSeatIndex]='X';
	balance=balance+ TktPrice;
	System.out.println("Your seat is reserved. Your balance is " + balance);//"+ InputRow + SeatLetter +" 
	displayLayout(seats);



        } // end of for loop, i.e this booking session is complete


	System.out.println("Reservation complete! Please proceed to payment");
	System.out.println("Do you wish to start a new booking? (y/n)? ");
	NewBooking = keyboard.next();
	} while (NewBooking.equalsIgnoreCase("y")); // start a new session?

	System.out.println("Thank you for choosing our reservation system!!");
	}


public static void displayLayout(char[][] anArray)	
{
int i,j;

for (i=0;i< anArray.length;i++)
{
for (j=0;j< anArray[0].length; j++)
	System.out.print(anArray[i][j]+ " " );
System.out.println();
}
}

public static int availableSeats(char[][] anArray)	
{
int i,j,count=0;

for (i=0;i< anArray.length;i++)
for (j=1;j< anArray[0].length; j++)
	if (anArray[i][j] != 'X')
		count++;
System.out.println("Available seats " + count);
return(count);

}



}
