/*  Calendar
DayPlanner.java
Maxwell
mwbockma
4 */

import java.util.*;
import java.io.*;

public class DayPlanner{
  public static void main(String [] args)throws IOException, InterruptedException{ //main
    System.out.println("Welcome to day planner!");
    System.out.println("What is your name?");
    Scanner scan = new Scanner(System.in);
    String name = scan.nextLine();
    File dir = new File("Database/"+name); //opens new folder with this person's information
    
    if (!dir.exists()){ //if it doesnt exist case
      System.out.println("Greetings, stranger! We made a new file under your name!");
      dir.mkdirs();
    }else{//if it does exist case
     Random rand = new Random(); //(RANDOM)
     int val = rand.nextInt(5); 
     
     switch(val) { //greets with random value
       case 0:
       System.out.println("Greetings, "+name+"!");
       break;
       case 1:
       System.out.println("Welcome back, "+name+"!");
       break;
       case 2:
       System.out.println("Why hello there, "+name+"!");
       break;
       case 3:
       System.out.println(name+", we missed you!");
       break;
       case 4:
       System.out.println("Hi "+name+", we hope you enjoy your stay!");
       break;
       default:
         System.out.println("");
         break;
      }
    }
     File january = new File("Database/"+name+"/January"); //creats database of months
         january.mkdirs();
         File february = new File("Database/"+name+"/February");
         february.mkdirs();
         File march = new File("Database/"+name+"/March");
         march.mkdirs();
         File april = new File("Database/"+name+"/April");
         april.mkdirs();
         File may = new File("Database/"+name+"/May");
         may.mkdirs();
         File june = new File("Database/"+name+"/June");
         june.mkdirs();
         File july = new File("Database/"+name+"/July");
         july.mkdirs();
         File august = new File("Database/"+name+"/August");
         august.mkdirs();
         File september = new File("Database/"+name+"/September");
         september.mkdirs();
         File october = new File("Database/"+name+"/October");
         october.mkdirs();
         File november = new File("Database/"+name+"/November");
         november.mkdirs();
         File december = new File("Database/"+name+"/December");
         december.mkdirs();
         
    Thread.sleep(2000);
     
    boolean y = false; //(BOOL)
    
    while (y == false){
    char selection = printMenu(); //opens menu and runs program
    dispatch(selection,name); 
    }
  }
  
  
  public static char printMenu()//(MYMETH) prints the menu out for the user to select an option
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("\n Menu \n");
    System.out.print(" ====\n");
    System.out.print("a) Add event\n"); //text input
    System.out.print("b) Sort events\n"); //sorts array of objects
    System.out.print("c) Remove event\n"); 
    System.out.print("d) Modify event\n"); //search array of objects
    System.out.print("e) Display events\n");
    System.out.print("f) Print events to a file\n"); //output file
    System.out.print("g) Exit\n");
    System.out.print("\nEnter your choice: ");
    char a = scan.nextLine().charAt(0);
    return a;
   }

  public static void dispatch(char choice,String name) throws IOException, InterruptedException //runs a course of action based on user choice from menu in a switch statement
  {
  
    Scanner scan=new Scanner(System.in);
    switch(choice) {
      case 'A': //adds an event
      case 'a':
        System.out.println("What month is it?"); //checks for month
        String month = scan.nextLine();
        int numDays=0;
        if (month.equals("January")||month.equals("january")
           ||month.equals("March")||month.equals("march")
           ||month.equals("May")||month.equals("may")
           ||month.equals("July")||month.equals("july")
           ||month.equals("August")||month.equals("august")
           ||month.equals("October")||month.equals("october")
           ||month.equals("December")||month.equals("december"))
        {
          numDays = 31;
        }else if(month.equals("April")||month.equals("april")
                ||month.equals("June")||month.equals("june")
                ||month.equals("September")||month.equals("september")
                ||month.equals("November")||month.equals("november"))
        {
          numDays = 30; 
        }else if(month.equals("February")||month.equals("february"))
        {
          numDays = 28;
        }else{
         System.out.println("Incorrect month. Please restart program.");
         System.exit(0);
        }

         month.substring(0,1).toUpperCase();
         Day[] events = new Day[numDays]; //initializes array of object event based on numDays
         for(int i = 1; i <= numDays; i++)
        {
           File day = new File("Database/"+name+"/"+month+"/Day_"+i+".txt");
           int val = i - 1;
           events[val] = new Day();
        }
         
         System.out.println("What day would you like to add an event to? (Number of the month)");
         int day = scan.nextInt();
         scan.nextLine();
         
         System.out.println("What time is the event at? (military time format)");
         String time = scan.nextLine();
         
         System.out.println("Where and what is the event?");
         String event = scan.nextLine();
         
         File written = new File ("Database/"+name+"/"+month+"/Day_"+(day)+".txt");
         PrintWriter write = new PrintWriter(new FileWriter(written,true));
         
         write.println(time+" - "+event);
         write.close();
        
         System.out.println("Successfully printed event!");
         Thread.sleep(1000);
         break;
         
      case 'B': //sorts events
      case 'b':
        
        System.out.println("What month is it?"); //checks for month
        String month2 = scan.nextLine();
        int numDays2=0;
        if (month2.equals("January")||month2.equals("january")
           ||month2.equals("March")||month2.equals("march")
           ||month2.equals("May")||month2.equals("may")
           ||month2.equals("July")||month2.equals("july")
           ||month2.equals("August")||month2.equals("august")
           ||month2.equals("October")||month2.equals("october")
           ||month2.equals("December")||month2.equals("december"))
        {
          numDays2 = 31;
        }else if(month2.equals("April")||month2.equals("april")
                ||month2.equals("June")||month2.equals("june")
                ||month2.equals("September")||month2.equals("september")
                ||month2.equals("November")||month2.equals("november"))
        {
          numDays2 = 30; 
        }else if(month2.equals("February")||month2.equals("february"))
        {
          numDays2 = 28;
        }else{
         System.out.println("Incorrect month. Please restart program.");
         System.exit(0);
        }
        month2.substring(0,1).toUpperCase();
        
        System.out.println("What day would you like to have events sorted for?");
         int day2 = scan.nextInt();
         scan.nextLine();

        System.out.println("Events being sorted by time...");
        Thread.sleep(500);
        
        File sort = new File("Database/"+name+"/"+month2+"/Day_"+(day2)+".txt"); //(I/O)
        Scanner filescanner = new Scanner(sort);
         
        int counter = 0;
        
        while (filescanner.hasNextLine()) {
        counter++;
        filescanner.nextLine();
        }
        Day[] events2 = new Day[numDays2]; //(AR)
        Scanner filescan = new Scanner(sort); 
        
        for (int i = 0; i < counter; i++)
        {
          if (filescan.hasNext()){
          int tempval = filescan.nextInt();
          String temp = filescan.nextLine();
          events2[i] = new Day(name,tempval,temp);   
          }
        }
        

        for (int i = 0; i < counter; i++) //sorting algorithm
        {
          
          for (int j = 0; j < counter-1; j++){ //(SORT)
          if (events2[j].getTime() > events2[j+1].getTime())
          {
            Day swap = events2[j];
            events2[j] = events2[j+1];
            events2[j+1]=swap;
          }
          }
          }
        
        File sorts = new File("Database/"+name+"/"+month2+"/Day_"+(day2)+".txt");
        FileWriter sortwrite = new FileWriter(sorts);
        sortwrite.write("");
        sortwrite.close();
        
        System.out.println("Sorted list: \n ==");
        Thread.sleep(100);
        for (int l = 0; l < counter; l++)
        {
          String sorted = events2[l].toString();
          System.out.println(sorted);
          Thread.sleep(20);
          PrintWriter out = new PrintWriter(new FileWriter(sorts,true));
          out.println(sorted);
          out.close();
        }
        System.out.println("Completed sort!");
        Thread.sleep(1000);
        break;
      case 'C':
      case 'c':
        System.out.println("What month is the event you'd like to remove?"); //checks for month
        String month3 = scan.nextLine();
        int numDays3=0;
        if (month3.equals("January")||month3.equals("january")
           ||month3.equals("March")||month3.equals("march")
           ||month3.equals("May")||month3.equals("may")
           ||month3.equals("July")||month3.equals("july")
           ||month3.equals("August")||month3.equals("august")
           ||month3.equals("October")||month3.equals("october")
           ||month3.equals("December")||month3.equals("december"))
        {
          numDays3 = 31;
        }else if(month3.equals("April")||month3.equals("april")
                ||month3.equals("June")||month3.equals("june")
                ||month3.equals("September")||month3.equals("september")
                ||month3.equals("November")||month3.equals("november"))
        {
          numDays3 = 30; 
        }else if(month3.equals("February")||month3.equals("february"))
        {
          numDays3 = 28;
        }else{
         System.out.println("Incorrect month. Please restart program.");
         System.exit(0);
        }
        month3.substring(0,1).toUpperCase();
        
        System.out.println("What day is the event you'd like to remove?");
        int day3 = scan.nextInt();
        scan.nextLine();
         
        File sort3 = new File("Database/"+name+"/"+month3+"/Day_"+(day3)+".txt"); //INPUT FILE
        Scanner filescancounter = new Scanner(sort3);
        Scanner filescancounter2 = new Scanner(sort3);
         
        int counter3 = 0;
        
        
        System.out.println("Here are you current events:");
        while (filescancounter2.hasNextLine()) {
        counter3++;
        System.out.print(counter3+") ");
        String event3 = filescancounter2.nextLine();
        System.out.println(event3);
        Thread.sleep(20);
        
        }
        
        String[] events3 = new String[counter3];
        

        Thread.sleep(500);
        for(int i = 0; i < counter3; i++){
         events3[i]=filescancounter.nextLine();
        }
        
        System.out.println("Please indicate the number for which event you would like removed.");
        int remove = scan.nextInt();
        scan.nextLine();
        
        remove = remove - 1;
        
        PrintWriter clear = new PrintWriter(sort3);
        clear.print("");
        
        events3[remove] = null;
        
        System.out.println("Updated event list:");
        FileWriter writedelete = new FileWriter(sort3,true);
        for(int i = 0; i < events3.length - 1; i++)
        {
          System.out.println(events3[i]);
          writedelete.write(events3[i]);
          writedelete.write(System.getProperty( "line.separator" ));
        }
        writedelete.close();
        
        break;
      case 'D':
      case 'd':
      System.out.println("What month is the event you'd like to modify?"); //checks for month
        String month4 = scan.nextLine();
        int numDays4=0;
        if (month4.equals("January")||month4.equals("january")
           ||month4.equals("March")||month4.equals("march")
           ||month4.equals("May")||month4.equals("may")
           ||month4.equals("July")||month4.equals("july")
           ||month4.equals("August")||month4.equals("august")
           ||month4.equals("October")||month4.equals("october")
           ||month4.equals("December")||month4.equals("december"))
        {
          numDays4 = 31;
        }else if(month4.equals("April")||month4.equals("april")
                ||month4.equals("June")||month4.equals("june")
                ||month4.equals("September")||month4.equals("september")
                ||month4.equals("November")||month4.equals("november"))
        {
          numDays3 = 30; 
        }else if(month4.equals("February")||month4.equals("february"))
        {
          numDays4 = 28;
        }else{
         System.out.println("Incorrect month. Please restart program.");
         System.exit(0);
        }
        month4.substring(0,1).toUpperCase();
        
        System.out.println("What day is the event you'd like to modify?");
         int day4 = scan.nextInt();
         scan.nextLine();  
      
        File sort4 = new File("Database/"+name+"/"+month4+"/Day_"+(day4)+".txt");
        Scanner filescancounter4 = new Scanner(sort4);
        int counter4 = 0;
         
        System.out.println("Here are you current events:");
        while (filescancounter4.hasNextLine()) {
        counter4++;
        System.out.print(counter4+") ");
        String event4 = filescancounter4.nextLine();
        System.out.println(event4);
        Thread.sleep(20);
        }
        
        System.out.println("Please indicate the number for which event you want to modify.");
        int modify = scan.nextInt();
        scan.nextLine();
        
        System.out.println("Would you like to modify the time or the event? (t/e)");
        String cut = scan.nextLine();
        char answer = cut.charAt(0);
        
        Day[] days = new Day[counter4];
        
        Scanner filescan4 = new Scanner(sort4); 
        Scanner filescanner4 = new Scanner(sort4); 
        
        for (int i = 0; i < counter4; i++)
        {
          if (filescan4.hasNext()){
          int tempval = filescan4.nextInt();
          String temp = filescan4.nextLine();
          days[i] = new Day(name,tempval,temp);  
          search(days,modify);
          }
        }
        
        PrintWriter clear4 = new PrintWriter(sort4);
        clear4.print("");
        
        modify = modify - 1;
        
        if (answer == 't')
        {
          System.out.println("What would you like the new time to be?");
          int replacement = scan.nextInt();
          scan.nextLine();
          int found = search(days, modify);
          days[found].setTime(replacement);
          for (int i = 0; i < counter4; i++)
        {
          if (filescanner4.hasNext()){
            
            
              String temp = days[i].toString();
              System.out.println(temp);
            
          }
           String temp = days[i].toString();
           FileWriter writeUpdate = new FileWriter(sort4,true);
           writeUpdate.write(temp);
           writeUpdate.write(System.getProperty( "line.separator" ));
           writeUpdate.close();
        }  
        }
        else if (answer == 'e')
        {
          System.out.println("What would you like the new event to be?");
          String replacement = scan.nextLine();
          days[modify].setEvent(replacement);
          for (int i = 0; i < counter4; i++)
        {
          if (filescanner4.hasNext()){
            
            if (i == modify)
            {
              String temp = days[i].toString2();
              System.out.println(temp);
            }else{
              String temp = days[i].toString();
              System.out.println(temp);
            }
            
          }
          
          if (i == modify)
            {
              String temp = days[i].toString2();
              FileWriter writeUpdate = new FileWriter(sort4,true);
              writeUpdate.write(temp);
              writeUpdate.write(System.getProperty( "line.separator" ));
              writeUpdate.close();
            }else{
              String temp = days[i].toString();
              FileWriter writeUpdate = new FileWriter(sort4,true);
              writeUpdate.write(temp);
              writeUpdate.write(System.getProperty( "line.separator" ));
              writeUpdate.close();
            }
          
        }
        }
        else
        {
         System.out.println("Faulty input."); 
        }
         
        break; //display weekly events
      case 'E': 
      case 'e':
        
        System.out.println("What month is the day of events you'd like to display?"); //checks for month
        String month5 = scan.nextLine();
        
        System.out.println("What day would you like to display?"); 
        String day5 = scan.nextLine();
        
        month5.substring(0,1).toUpperCase();
        
        File print = new File("Database/"+name+"/"+month5+"/Day_"+(day5)+".txt"); //print
        Scanner filecounter5 = new Scanner(print);
        Scanner collect = new Scanner(print);
        
        int counter5 = 0;
        
        while (filecounter5.hasNextLine())
        {
         counter5++;
         filecounter5.nextLine();
        }
        int appeal = 72;
        
        System.out.println("Today's Events:");
        
        for(int i = 0; i < appeal; i++)
        {
          System.out.print("-");
        }  
        
        int[] times = new int[counter5];
        String[] eventlist = new String[counter5];
        
        for(int i = 0; i < counter5; i++)
        {
          times[i] = collect.nextInt();
          eventlist[i] = collect.nextLine();
        }
        
        System.out.println();
        for(int i = 0; i < counter5; i++)
        {
          System.out.printf("| %5d%-63s |",times[i],eventlist[i]);
          System.out.println();
        }
        
        for(int i = 0; i < appeal; i++)
        {
          System.out.print("-");
        }  
        Thread.sleep(10000);
        break;
      case 'F': //outputs file outside of directory
      case 'f':
        System.out.println("What month is the day of events you'd like to display?"); //checks for month
        String month6 = scan.nextLine();
        month6.substring(0,1).toUpperCase();
        
        System.out.println("What day would you like to display?"); //checks for day
        String day6 = scan.nextLine();
        
        File printer = new File("Database/"+name+"/"+month6+"/Day_"+(day6)+".txt"); //reads input file
        Scanner filecounter6 = new Scanner(printer);
        Scanner finale = new Scanner(printer);
        
        File output = new File(name+", "+month6+", "+day6+".txt"); //(I/O)
        FileWriter outputwrite = new FileWriter(output,true); //writtes to file
        
        int counter6 = 0;
        
        while (filecounter6.hasNextLine()) //counts values in file
        {
         counter6++;
         filecounter6.nextLine();
        }
        
        for (int i = 0; i < counter6; i++) //loops for values in file
        {
          String outputs = finale.nextLine(); //scans next line
          outputwrite.write(outputs); //prints to it
          outputwrite.write(System.getProperty( "line.separator" )); //skips line
        }
        outputwrite.close();
        System.out.println("Completed print!"); 
        Thread.sleep(1000);
        break;
      case 'G': //exits program
      case 'g':
        System.exit(0);
        break;
        default:
            System.out.print("Invalid choice.\n");
    }
  }
  
  public static int search(Day[] days,int target){ //(MYMETH(O)) + (SEARCH) search method
    for (int i = 0; i < days.length; i++)
    {
      if (i == target){
       return i; 
      }
    }
    return target;
  }
  
}
