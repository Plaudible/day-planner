/*  Calendar
Day.java
Maxwell
mwbockma
4 */

public class Day{ //CL
  private String event;
  private String name;
  private int time;
  public Day(){

  }
  public Day(String n, int t, String e){
    time = t;
    name = n;
    event = e;
  }
  
  public String getName(){
   return name; 
  }
  
  public void setEvent(String e){ //setter
   event = e; 
  }
  
  public int getTime(){ //getter
   return time; 
  }
   
  public void setTime(int t){ //setter
   time = t; 
  }
  
  
  public String toString(){
    String str = (time+event);
    return str;
  }


   public String toString2(){
    String str = (time+" - "+event);
    return str;
  }
}