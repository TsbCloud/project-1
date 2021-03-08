import java.util.*;
public class FunFactory {
    //int game_card=0;
    static String[]games= {"G1","G2","G3","G4","G5","G6","G7","G8","G9","G10"};
              
   //static String username1;
    //static int password1;
   static  Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    static Date date= calendar.getTime();
    static int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
   static  int test=6;
   static int total=0;
  static int game_Count;
//   static String username= "Gamerman123";
//    static int password= 12345678;
    static int balance=10;
    static Scanner sc= new Scanner(System.in);
    
    static public void update_Balance(int x) //insert balance
    {
        System.out.println("Current Balance "+balance);
        balance =balance +x;
        System.out.println("Balance updated successfully");
        System.out.println("Here is the updated balance "+balance);
    }
    
    static public void balance_Check() // to check balance
    {
        if(balance<10)
         {
             System.out.println("Not enought balance  can't play add more funds");
         }
        else
        {
            System.out.println("Current balance is "+balance);
        }
    }
    
    static public void play_Game() // to play the game
    {
      System.out.println("Here are the games which are available to play");
       for(String x1:games)
       {
           System.out.print(x1+" ");
       }
       System.out.println("Select thea games you want to play");
       switch(games[0])
       {
           
       }
      System.out.println("\nEnter the number of games you want to play");  
       game_Count= sc.nextInt();
       if(game_Count<=0)
         {
             System.out.println("Zero games selected");
         }
         else if(game_Count>10)
         {
             System.out.println("Select a valid Game");
         }
         else if((game_Count>0)&& (game_Count<=10))
         {
             System.out.println("Games selected are");
             for(int i=0;i<game_Count;i++)
             {
                 System.out.println(games[i]);
             }
             game_Price();
             transaction();
         }
    }
    static public void start()
    {
        
    }
    static public void game_Price() // calculate the price of game
    {
        if((test==6)||(test==7))
         {
             System.out.println("!!-NOTE WEEKEND PRICE IS 20rs PER GAME");
             total=game_Count*20;
         }
         else
         {
             System.out.println("Game price per game is 10rs");
             total= game_Count*10;
         }
         System.out.println("The total for "+game_Count+" games is "+total);
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
             }
    }
    public static void main(String[]ar)
    {
        System.out.println("Welcome to FunFactory");
        System.out.println("Please Enter your card");
//        System.out.println("Enter username");
//        username1= sc.nextLine();
//        System.out.println("Enter password");
//        password1= sc.nextInt();
        System.out.println("If you want to check balance then type 'balance' ");
        System.out.println("If you want to update balance then type 'update' ");
        System.out.println("If you are ready to play game then type 'play' ");
        String s1=sc.nextLine();
        if(s1.equalsIgnoreCase("balance"))
        {
            balance_Check();
        }
        else if(s1.equalsIgnoreCase("update"))
        {
            System.out.println("Enter the amount you want to add to balance ");
            int update= sc.nextInt();
            update_Balance(update);
        }
        else if(s1.equalsIgnoreCase("play"))
        {
            play_Game();
        }
    
}}
