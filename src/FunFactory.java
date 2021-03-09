import java.util.*;
public class FunFactory {
    //int game_card=0;
    static String[]games= {"G1","G2","G3","G4","G5","G6","G7","G8","G9","G10"}; // games list
   static LinkedHashSet<String> l= new LinkedHashSet();          // to store selected games by user
   static  Calendar calendar = Calendar.getInstance(TimeZone.getDefault()); // to check whether date whether it's weekend or not
    static Date date= calendar.getTime();
    static int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
   //static  int test=6;    // to check date variations
   static int total=0; // to calculate total cost of session
  static int game_Count;  // number of games selected
    static int balance=1000;    // balance in card
    static Scanner sc= new Scanner(System.in);
    static String s;
    
    static public void update_Balance(int x) // method to insert balance
    {
        System.out.println("Current Balance "+balance);
        balance =balance +x;
        System.out.println("Balance updated successfully");
        System.out.println("Here is the updated balance "+balance);
    }
    
    static public void balance_Check() // to check balance
    {
        if(balance<10)  // condition check if balance is less than 10 in card can't play game
         {
             System.out.println("Not enought balance  can't play ,add more funds");
             System.out.println("Current balance is "+balance);
         }
        else           // else display balance
        {
            System.out.println("Current balance is "+balance);
        }
    }
    
    static public void play_Game() // to play the game
    {
      System.out.println("Here are the games which are available to play"); // shows available games to select from
       for(String x1:games)
       {
           System.out.print(x1+" "); // print out the list of games
       }
       start_Game();
//      System.out.println("\nEnter the number of games you want to play");  
//       game_Count= sc.nextInt();
//       try{
//       if(game_Count<=0)
//         {
//             System.out.println("Zero games selected");
//         }
//         else if(game_Count>10)
//         {
//             System.out.println("Select a valid Game");
//         }
//         else if((game_Count>0)&& (game_Count<=10))
//         {
//             start_Game();
//             game_Price();
//             transaction();
//         }}
//       catch(InputMismatchException  e)
//               {
//               System.out.println("Improper Input please Enter the proper names of games");
//               }
    }
    static public void start_Game()
    {
          System.out.println("\nSelect from the following games and type 'done' when finished selecting");
          for(String x1:games)
          {
              System.out.print(x1+" ");
          }
          System.out.println("\n");
          for(int i=0;i<10;i++)
          {
              s=sc.nextLine();

              if(s.equalsIgnoreCase("done")) // when user types done game selection process is over
              {
                  break;
              }
                  l.add(s); // Adding selected games to list
          }
//          if(l.size()==0)     // Condition check if list is empty No games selected
//          {
//              System.out.println("No games selected");
//          }
//          System.out.println("The selected games are ");   // else games displayed
//             game_Count= l.size();
//              if(s.equalsIgnoreCase("done"))
//              {
//                  break;
//              }
//                  l.add(s); // Adding selected games to list
//          
          if(l.size()==0)
          {
              System.out.println("No games selected");
          }
          System.out.println("The selected games are ");
          game_Count= l.size();
         for(Object x1:l)
         {
             System.out.println(x1);
         }
         game_Price();
         transaction();
    
    }
        static public void transaction() // initiate transaction and reflect to balance
    {
         if(total>balance)
                 {
                     System.out.println("Insufficient Balance");
                     System.out.println("Current Balance "+balance);
                 }
                 else{
                 balance= balance-total;
                 System.out.println("Current Balance is "+balance);
                 System.out.println("Game is about to start ");
             }
    }
    static public void game_Price() // calculate the price of game
    {
        if((dayOfWeek==6)||(dayOfWeek==7))   // Conditon check if it's weekend price per game is 20rs instead of 10rs.
         {
             System.out.println("!!-NOTE WEEKEND PRICE IS 20rs PER GAME");
             total=game_Count*20;
         }
         else
         {
             System.out.println("Game price per game is 10rs"); // Condition check if it's not weekend price per game is 10rs
             total= game_Count*10;
         }
         System.out.println("The total for "+game_Count+" games is "+total); // Prints the price for games selected
    }
    

    public static void main(String[]ar)    // main method
    {
        System.out.println("Welcome to FunFactory");
        System.out.println("Please Enter your card");
        int i=0;
        while(i<4) // Condition check maximum 3 tries or restart 
        { 
            if(i==3)
            { System.out.println("Restart game 3 wrong tries");
                System.exit(0);
            }
          System.out.println("Type 'Enter' to continue or 'NO' to cancel"); // type "ENTER" to enter game
          // "NO" to cancel 
        String temp;
        temp=sc.nextLine();
        if(temp.equalsIgnoreCase("Enter"))
        {
            System.out.println("Welcome"); // welcome message prints and move to next step
            break;
        }
        else if(temp.equalsIgnoreCase("No"))
        {
            System.out.println("Not starting the game"); // if pressed NO quit to main menu
            System.exit(0);
        }
        else
        {
            System.out.println("Wrong Input, Please enter one of the below inputs"); // IF typed wrong input 3 tries check
            i++;
        }
        }   

        System.out.println("If you want to check balance then type 'balance' "); // message to check Balance in card
        System.out.println("If you want to update balance then type 'update' "); // message to update Balance in card
        System.out.println("If you are ready to play game then type 'play' ");   // message to continue to play game
        
        
        String s1=sc.nextLine();
        if(s1.equalsIgnoreCase("balance")) // If typed "balance" then check balance
        {
            balance_Check();
        }
        else if(s1.equalsIgnoreCase("update"))
        {
            System.out.println("Enter the amount you want to add to balance "); // If typed "UPDATE" then update balance in card
            int update= sc.nextInt();
            update_Balance(update);
        }
        else if(s1.equalsIgnoreCase("play")) // If typed "play" continue to play game
        {
            play_Game();
        }
        else
        {
            System.out.println("Please enter one of the above to continue ");
        }
    
}}
