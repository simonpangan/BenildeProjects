using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MyCollection;
using UserAccount;

namespace TI102_Quiz3Solution
{
    class Program
    {
        static void Main(string[] args)
        {

            #region accounts
            MyQueue<int> myQueue = new MyQueue<int>();
            int choice = 0;
            int choice2 = 0;
            int choice3 = 0;
            int account = 1;

            // List of all Acounts
            MyList<MyBankAccount> Allaccounts = new MyList<MyBankAccount>();
            int numberacc = 1; //number of accounts allowed in the memory is only 1
            int AccountID = 11800000;

            //acount 1 ~ automatic login
            MyList<MyBankAccount> account1 = new MyList<MyBankAccount>();
            account1.Add(new MyBankAccount(11800000, "Simon", "Pangan", "simonpangan", "0411", 09474411444, 1440));
             Allaccounts.Add(new MyBankAccount(11800000, "Simon", "Pangan", "simonpangan", "0411", 09474411444, 1440)); // add to the list of all accounts
            MyStack<string> account1history = new MyStack<string>();
            AccountID++;

            //acount 2 ~ create account
            MyList<MyBankAccount> account2 = new MyList<MyBankAccount>();       
            MyStack<string> account2history = new MyStack<string>();

            #endregion

    
         #region que
            Console.Write("\t\t\t\tHi!! Welcome To");
                Console.ForegroundColor = ConsoleColor.Green; Console.Write(" National Bank"); Console.ResetColor();

            Console.Write("\n\n   Press ");Console.ForegroundColor = ConsoleColor.Yellow; Console.Write("<enter> "); Console.ResetColor();
            Console.Write("to get ticket que"); Console.ReadLine();
            Random r = new Random();
            int queticket = r.Next(1, 10);
            Console.SetCursorPosition(2, 0);
            Console.Write("\n\n  Your are "); Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" Person #" + queticket); Console.ResetColor();
                Console.Write(" please fall in line. Press");
            Console.ForegroundColor = ConsoleColor.Yellow; Console.Write(" <enter> "); Console.ResetColor();
          Console.Write(" to proceed."); Console.ReadLine();

            //-----------------------------------
            for (int i = 0; i < queticket; i++)
            {
                myQueue.Enqueue(i + 1);

            }

            foreach (int item in myQueue.Display())
            {
                Console.Clear();
                Console.Write("\t\t\t\tHi!! Welcome To");
                Console.ForegroundColor = ConsoleColor.Green; Console.Write(" National Bank"); Console.ResetColor();
                Console.SetCursorPosition(2, 0);
                Console.Write("\n\n  Your are "); Console.ForegroundColor = ConsoleColor.Cyan;
                Console.Write(" Person #" + queticket); Console.ResetColor();
                Console.Write(" please fall in line.");


            
                Console.WriteLine("\n");

                if (myQueue.Count() == 2)
                {
                    if (myQueue.Display()[1] == queticket)
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.Write("\t\tPerson #" + myQueue.Display()[0]); Console.ResetColor();
                            Console.Write(" is current in the bank.  ");
                        Console.Write("\n\n\t\tWhile "); Console.ForegroundColor = ConsoleColor.Cyan;
                        Console.Write("Person #" + myQueue.Display()[1]); Console.ResetColor();
                            Console.Write(" which is you is right next to go to bank.  ");
                        Console.Write("\n\n\t\tYou are currently in line ");
                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write((myQueue.Count() - 1)); Console.ResetColor(); 
                           Console.Write( " Press");
                        Console.ForegroundColor = ConsoleColor.Yellow; Console.Write(" <enter> "); Console.ResetColor();
                        Console.Write(" to proceed.");

                    }
                }

                else if (myQueue.Count() >= 2)
                {
                    Console.ForegroundColor = ConsoleColor.Red;
                    Console.Write("\t\tPerson #" + myQueue.Display()[0]); Console.ResetColor(); Console.Write(" is current in the bank.  ");
                    Console.Write("\n\n\t\tWhile"); Console.ForegroundColor = ConsoleColor.Magenta;
                     Console.Write(" Person #" + myQueue.Display()[1]); Console.ResetColor();
                    Console.Write(" is currently in the line.");
                    Console.Write("\n\n\t\tYou are currently in line ");
                    Console.ForegroundColor = ConsoleColor.Cyan; Console.Write((myQueue.Count() - 1)); Console.ResetColor();Console.Write(" Press");
                        Console.ForegroundColor = ConsoleColor.Yellow; Console.Write(" <enter> "); Console.ResetColor();
                    Console.Write(" to proceed.");
                }
                else if (myQueue.Count() == 1)
                {
                    Console.ForegroundColor = ConsoleColor.Cyan;
                    Console.Write("\n\t\tPerson #" + myQueue.Display()[0]); Console.ResetColor();
                    Console.Write(" which is you is up next  in the bank. Please press");
                    Console.ForegroundColor = ConsoleColor.Yellow; Console.Write(" <enter> "); Console.ResetColor();Console.Write(" to proceed."); Console.ReadKey();
                    Console.SetCursorPosition(16, 5);
                    Console.Write("                                                                                                                                                            ");
                    Console.SetCursorPosition(0, 2);
                    Console.Write("                                                                                                                                                            ");

Console.SetCursorPosition(16, 5); Console.Write("You are in the bank right now.... Press ");
                    Console.ForegroundColor = ConsoleColor.Yellow; Console.Write(" <enter> "); Console.ResetColor();
                        Console.Write(" to proceed.");
                }


                myQueue.Dequeue();
                Console.ReadKey();

            }


#endregion   

            do
           {
                Console.Clear();
                
                Console.Write("\t\t\t\tHi!! Welcome To");
                Console.ForegroundColor = ConsoleColor.Green; Console.Write(" National Bank "); Console.ResetColor();
                Console.Write("PLease choose from the following:");
                Console.WriteLine();
                Console.WriteLine();
           
                Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n\n[1]"); Console.ResetColor();
                Console.Write("- Login");

                Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[2]"); Console.ResetColor();
                Console.Write("- Create New Account");


                Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[0]"); Console.ResetColor();
                Console.Write("- Quit");
                Console.Write("\n\nEnter Choice: "); int.TryParse(Console.ReadLine(), out choice);
                switch (choice)
                {

                    #region inputs
                    case 1:
                        {
                            string usernamecheck; string ReadPassword;
                            Console.Write("\n\tEnter Username: "); usernamecheck = Console.ReadLine();
                            Console.Write("\n\tEnter Password: "); string passwordcheck = "";
                            ConsoleKeyInfo info = Console.ReadKey(true);
                            while (info.Key != ConsoleKey.Enter)
                            {
                                if (info.Key != ConsoleKey.Backspace)
                                {
                                    Console.Write("*");
                                    passwordcheck += info.KeyChar;
                                }
                                else if (info.Key == ConsoleKey.Backspace)
                                {
                                    if (!string.IsNullOrEmpty(passwordcheck))
                                    {
                                        // remove one character from the list of password characters
                                        passwordcheck = passwordcheck.Substring(0, passwordcheck.Length - 1);
                                        // get the location of the cursor
                                        int pos = Console.CursorLeft;
                                        // move the cursor to the left by one character
                                        Console.SetCursorPosition(pos - 1, Console.CursorTop);
                                        // replace it with space
                                        Console.Write(" ");
                                        // move the cursor to the left by one character again
                                        Console.SetCursorPosition(pos - 1, Console.CursorTop);
                                    }
                                }
                                info = Console.ReadKey(true);
                            }

                            // add a new line because user pressed enter at the end of their password
                            Console.WriteLine();
                            ReadPassword = passwordcheck;


                            #endregion






                            #region default account
                            if (usernamecheck == Allaccounts.GetList()[0].username && passwordcheck == Allaccounts.GetList()[0].password)
                            {
                                Console.WriteLine();
                                Console.WriteLine("\tLogin successfully.. Press Enter to Proceed");
                                Console.ReadKey();
                                Console.Clear();
                                do
                                {
                                    Console.Clear();
                                    Console.Write("Choose from the following: ");
                                    Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n\n[1]"); Console.ResetColor();
                                    Console.Write("- Balance inquiry");
                                    Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[2]"); Console.ResetColor();
                                    Console.Write("- Cash Deposit");
                                    Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[3]"); Console.ResetColor();
                                    Console.Write("- Cash Withdrawal");
                                    Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[4]"); Console.ResetColor();
                                    Console.Write("- View Your transaction History");
                                   
                                    Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[5]"); Console.ResetColor();
                                    Console.Write("- Delete your previous Transaction History");
                                    Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[6]"); Console.ResetColor();
                                    Console.Write("- View Your Profile");
                                    Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[0]"); Console.ResetColor();
                                    Console.Write("- To Log Out");


                                    Console.Write("\nEnter Choice: "); int.TryParse(Console.ReadLine(), out choice2);
                                    switch (choice2)
                                    {
                                        case 1:


                                            Console.Write("\n\n\t\t\t\tYour Current Balance is : ");
                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account1.Total()); Console.ResetColor();
                                            Console.ReadKey();
                                            break;

                                        case 2:

                                            Console.Clear();
                                            Console.WriteLine("\n\n\t\t\tHow much do you want to deposit? ");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[1]"); Console.ResetColor();
                                            Console.Write("- 100");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[2]"); Console.ResetColor();
                                            Console.Write("- 200");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[3]"); Console.ResetColor();
                                            Console.Write("- 300");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[4]"); Console.ResetColor();
                                            Console.Write("- 400");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[5]"); Console.ResetColor();
                                            Console.Write("- 500");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[6]"); Console.ResetColor();
                                            Console.Write("- 600");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[7]"); Console.ResetColor();
                                            Console.Write("- 700");

                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[8]"); Console.ResetColor();
                                            Console.Write("- 800");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[9]"); Console.ResetColor();
                                            Console.Write("- 900");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[10]"); Console.ResetColor();
                                            Console.Write("- 1000");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[0]"); Console.ResetColor();

                                            Console.Write("- To Exit");


                                            Console.Write("\n\nEnter Choice: "); int.TryParse(Console.ReadLine(), out choice3);

                                            switch (choice3)
                                            {
                                                case 1:
                                                    account1.Sum(100);
                                                    Console.Write("\n\t\t\t\tYou have successfully add");
                                                    Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 100 "); Console.ResetColor();
                                                    Console.Write("pesos in your bank");
                                                    account1history.Push("You have add 100 pesos to your account");
                                                    break;
                                                case 2:
                                                    account1.Sum(200);
                                                    Console.Write("\n\t\t\t\tYou have successfully add");
                                                    Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 200 "); Console.ResetColor();
                                                    Console.Write("pesos in your bank");
                                                    account1history.Push("You have add 200 pesos to your account");
                                                    break;
                                                case 3:
                                                    account1.Sum(300);
                                                    Console.Write("\n\t\t\t\tYou have successfully add");
                                                    Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 300 "); Console.ResetColor();
                                                    Console.Write("pesos in your bank");
                                                    account1history.Push("You have add 300 pesos to your account");
                                                    break;
                                                case 4:
                                                    account1.Sum(400);
                                                    Console.Write("\n\t\t\t\tYou have successfully add");
                                                    Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 400 "); Console.ResetColor();
                                                    Console.Write("pesos in your bank");
                                                    account1history.Push("You have add 400 pesos to your account");
                                                    break;
                                                case 5:
                                                    account1.Sum(500);
                                                    Console.Write("\n\t\t\t\tYou have successfully add");
                                                    Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 500 "); Console.ResetColor();
                                                    Console.Write("pesos in your bank");
                                                    account1history.Push("You have add 500 pesos to your account");
                                                    break;
                                                case 6:
                                                    account1.Sum(600);
                                                    Console.Write("\n\t\t\t\tYou have successfully add");
                                                    Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 600 "); Console.ResetColor();
                                                    Console.Write("pesos in your bank");
                                                    account1history.Push("You have add 600 pesos to your account");
                                                    break;
                                                case 7:
                                                    account1.Sum(700);
                                                    Console.Write("\n\t\t\t\tYou have successfully add");
                                                    Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 700 "); Console.ResetColor();
                                                    Console.Write("pesos in your bank");
                                                    account1history.Push("You have add 700 pesos to your account");
                                                    break;
                                                case 8:
                                                    account1.Sum(800);
                                                    Console.Write("\n\t\t\t\tYou have successfully add");
                                                    Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 800 "); Console.ResetColor();
                                                    Console.Write("pesos in your bank");
                                                    account1history.Push("You have add 800 pesos to your account");
                                                    break;
                                                case 9:
                                                    account1.Sum(900);
                                                    Console.Write("\n\t\t\t\tYou have successfully add");
                                                    Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 900 "); Console.ResetColor();
                                                    Console.Write("pesos in your bank");
                                                    account1history.Push("You have add 900 pesos to your account");
                                                    break;
                                                case 10:
                                                    account1.Sum(1000);
                                                    Console.Write("\n\t\t\t\tYou have successfully add");
                                                    Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 1000 "); Console.ResetColor();
                                                    Console.Write("pesos in your bank");
                                                    account1history.Push("You have add 1000 pesos to your account");
                                                    break;
                                                default:
                                                    break;


                                            }
                                            Console.ReadKey();
                                            break;


                                        case 3:
                                            Console.Clear();
                                            Console.WriteLine("\n\n\t\t\tHow much do you want to withdraw? ");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[1]"); Console.ResetColor();
                                            Console.Write("- 100");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[2]"); Console.ResetColor();
                                            Console.Write("- 200");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[3]"); Console.ResetColor();
                                            Console.Write("- 300");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[4]"); Console.ResetColor();
                                            Console.Write("- 400");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[5]"); Console.ResetColor();
                                            Console.Write("- 500");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[6]"); Console.ResetColor();
                                            Console.Write("- 600");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[7]"); Console.ResetColor();
                                            Console.Write("- 700");

                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[8]"); Console.ResetColor();
                                            Console.Write("- 800");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[9]"); Console.ResetColor();
                                            Console.Write("- 900");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[10]"); Console.ResetColor();
                                            Console.Write("- 1000");
                                            Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[0]"); Console.ResetColor();

                                            Console.Write("- To Exit");


                                            Console.Write("\n\nEnter Choice: "); int.TryParse(Console.ReadLine(), out choice3);

                                                switch (choice3)
                                                {


                                                    case 1:

                                                    if(account1.Total() >= 100)
                                                    {
                                                        account1.Minus(100);
                                                        Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 100 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account1history.Push("You have withdraw 100 pesos to your account");
                                                    } else
                                                    {
                                                        Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account1.Total()); Console.ResetColor(); Console.Write(" balance");
                                                    }
                                                    break;
                                                    case 2:
                                                    if (account1.Total() >= 200)
                                                    {
                                                        account1.Minus(200);
                                                        Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 200 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account1history.Push("You have withdraw 200 pesos to your account");
                                                    }
                                                    else
                                                    {
                                                        Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account1.Total()); Console.ResetColor(); Console.Write(" balance");
                                                    }
                                                 
                                                        break;
                                                    case 3:
                                                    if (account1.Total() >= 300)
                                                    {
                                                        account1.Minus(300);
                                                        Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 300 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account1history.Push("You have withdraw 300 pesos to your account");
                                                    }
                                                    else
                                                    {
                                                        Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account1.Total()); Console.ResetColor(); Console.Write(" balance");
                                                    }


                                                
                                                        break;
                                                    case 4:
                                                    if (account1.Total() >= 400)
                                                    {

                                                        account1.Minus(400);
                                                        Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 400 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account1history.Push("You have withdraw 400 pesos to your account");
                                                    }
                                                    else
                                                    {
                                                        Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account1.Total()); Console.ResetColor(); Console.Write(" balance");
                                                    }



                                                        break;
                                                    case 5:
                                                    if (account1.Total() >= 500)
                                                    {
                                                        account1.Minus(500);
                                                        Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 500 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account1history.Push("You have withdraw 500 pesos to your account");
                                                    }
                                                    else
                                                    {
                                                        Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account1.Total()); Console.ResetColor(); Console.Write(" balance");
                                                    }



                                             
                                                        break;
                                                    case 6:

                                                    if (account1.Total() >= 600)
                                                    {
                                                        account1.Minus(600);
                                                        Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 600 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account1history.Push("You have withdraw 600 pesos to your account");
                                                    }
                                                    else
                                                    {
                                                        Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account1.Total()); Console.ResetColor(); Console.Write(" balance");
                                                    }


                                              
                                                        break;
                                                    case 7:

                                                    if (account1.Total() >= 700)
                                                    {
                                                        account1.Minus(700);
                                                        Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 700 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account1history.Push("You have withdraw 700 pesos to your account");
                                                    }
                                                    else
                                                    {
                                                        Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account1.Total()); Console.ResetColor(); Console.Write(" balance");
                                                    }


                                            
                                                        break;
                                                    case 8:

                                                    if (account1.Total() >= 800)
                                                    {
                                                        account1.Minus(800);
                                                        Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 800 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account1history.Push("You have withdraw 800 pesos to your account");
                                                    }
                                                    else
                                                    {
                                                        Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account1.Total()); Console.ResetColor(); Console.Write(" balance");
                                                    }


                                                
                                                        break;
                                                    case 9:

                                                    if (account1.Total() >= 900)
                                                    {
                                                        account1.Minus(900);
                                                        Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 900 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account1history.Push("You have withdraw 900 pesos to your account");
                                                    }
                                                    else
                                                    {
                                                        Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account1.Total()); Console.ResetColor(); Console.Write(" balance");


                                                    }
                                                    
                                                        break;
                                                    case 10:

                                                    if (account1.Total() >= 1000)
                                                    {
                                                        account1.Minus(1000);
                                                        Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 1000 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account1history.Push("You have withdraw 1000 pesos to your account");
                                                    }
                                                    else
                                                    {
                                                        Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account1.Total()); Console.ResetColor(); Console.Write(" balance");
                                                    }

                                              
                                                        break;
                                                    default:
                                                        break;


                                                }
                                            
                                            
                                                
                                            

                                           
                                            Console.ReadKey();
                                            break;

                                        case 4:




                                            if (account1history.Tracker() != 0)
                                            {

                                                Console.WriteLine();
                                                Console.WriteLine("\n\n\t\t\t\tYour Transaction History:  ");
                                                Console.WriteLine();

                                                int number = 1;

                                                foreach (String item in account1history.Display())
                                                {
                                                    Console.Write("    ");
                                                    Console.ForegroundColor = ConsoleColor.Cyan;
                                                    Console.Write(number); Console.ResetColor();
                                                    Console.WriteLine(". " + item);

                                                    number++;
                                                }
                                            }
                                            else Console.WriteLine("\n\n\t\t\t\t You have no recent Transaction  ");

                                            Console.ReadKey();
                                            break;

                                         


                                  

                                        case 5
                                        :
                                            Console.WriteLine();
                                            if (account1history.Tracker() != 0)
                                            {
                                                Console.Write("\tYour Previous Transaction:   \"");
                                                Console.ForegroundColor = ConsoleColor.Cyan;
                                                Console.Write(account1history.Display()[account1history.Tracker() - 1]); Console.ResetColor();
                                                Console.Write("\" has  been successfully deleted");
                                                account1history.Pop();
                                                Console.ReadKey();


                                                break;

                                            }
                                            else
                                            {
                                                Console.WriteLine("\t\t\t\t\t Cant delete any transaction since you have no recent Transaction ");
                                            }

                                            Console.ReadKey();
                                            break;
                                        case 6:


                                            Console.WriteLine();
                                            Console.ForegroundColor = ConsoleColor.Green; Console.Write("\n\n\tAsccount ID: "); Console.ResetColor(); Console.Write(Allaccounts.GetList()[0].AccountID);
                                            Console.ForegroundColor = ConsoleColor.Green; Console.Write("\n\n\tFirstname: "); Console.ResetColor(); Console.Write(Allaccounts.GetList()[0].Firstname);
                                            Console.ForegroundColor = ConsoleColor.Green; Console.Write("\n\n\tLastname: "); Console.ResetColor(); Console.Write(Allaccounts.GetList()[0].Lastname);
                                            Console.ForegroundColor = ConsoleColor.Green; Console.Write("\n\n\tUsername: "); Console.ResetColor(); Console.Write(Allaccounts.GetList()[0].username);
                                            Console.ForegroundColor = ConsoleColor.Green; Console.Write("\n\n\tPhoneNumber: "); Console.ResetColor(); Console.Write(Allaccounts.GetList()[0].PhoneNumber);
                                            Console.ForegroundColor = ConsoleColor.Green; Console.Write("\n\n\tPostalCode:"); Console.ResetColor(); Console.Write(Allaccounts.GetList()[0].PostalCode);


                                            Console.ReadKey();
                                            break;


                                   



                                    }
                                } while (choice2 != 0);

                                break;
                            }

                            #endregion

    
                            #region create account memory
                            else if( Allaccounts.Count() > 1 )
                            {

                                 if (usernamecheck == Allaccounts.GetList()[1].username && passwordcheck == Allaccounts.GetList()[1].password)
                                {
                                    Console.WriteLine();
                                    Console.WriteLine("\tLogin successfully.. Press Enter to Proceed");
                                    Console.ReadKey();
                                    Console.Clear();

                                    do
                                    {
                                        Console.Clear();
                                        Console.Write("Choose from the following: ");
                                        Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n\n[1]"); Console.ResetColor();
                                        Console.Write("- Balance inquiry");
                                        Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[2]"); Console.ResetColor();
                                        Console.Write("- Cash Deposit");
                                        Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[3]"); Console.ResetColor();
                                        Console.Write("- Cash Withdrawal");
                                        Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[4]"); Console.ResetColor();
                                        Console.Write("- View Your transaction History");
                                        
                                        Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[5]"); Console.ResetColor();
                                        Console.Write("- Delete your previous Transaction History");
                                        Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[6]"); Console.ResetColor();
                                        Console.Write("- View Profile");
                                        Console.ForegroundColor = ConsoleColor.DarkYellow; Console.Write("\n[0]"); Console.ResetColor();
                                        Console.Write("- To Log Out");

                                        Console.Write("\n\nEnter Choice: "); int.TryParse(Console.ReadLine(), out choice2);
                                        switch (choice2)
                                        {
                                            case 1:

                                                Console.Write("\n\n\t\t\t\tYour Current Balance is : ");
                                                Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account2.Total()); Console.ResetColor();
                                                Console.ReadKey();
                                                break;

                                            case 2:

                                                Console.Clear();
                                                Console.WriteLine("\n\n\t\t\tHow much do you want to deposit? ");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[1]"); Console.ResetColor();
                                                Console.Write("- 100");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[2]"); Console.ResetColor();
                                                Console.Write("- 200");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[3]"); Console.ResetColor();
                                                Console.Write("- 300");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[4]"); Console.ResetColor();
                                                Console.Write("- 400");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[5]"); Console.ResetColor();
                                                Console.Write("- 500");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[6]"); Console.ResetColor();
                                                Console.Write("- 600");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[7]"); Console.ResetColor();
                                                Console.Write("- 700");

                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[8]"); Console.ResetColor();
                                                Console.Write("- 800");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[9]"); Console.ResetColor();
                                                Console.Write("- 900");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[10]"); Console.ResetColor();
                                                Console.Write("- 1000");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[0]"); Console.ResetColor();

                                                Console.Write("- To Exit");
                                                Console.Write("\nEnter Choice: "); int.TryParse(Console.ReadLine(), out choice3);

                                                switch (choice3)
                                                {
                                                    case 1:
                                                        account2.Sum(100);
                                                        Console.Write("\n\t\t\t\tYou have successfully add");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 100 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account2history.Push("You have add 100 pesos to your account");
                                                        break;
                                                    case 2:
                                                        account2.Sum(200);
                                                        Console.Write("\n\t\t\t\tYou have successfully add");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 200 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account2history.Push("You have add 200 pesos to your account");
                                                        break;
                                                    case 3:
                                                        account2.Sum(300);
                                                        Console.Write("\n\t\t\t\tYou have successfully add");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 300 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account2history.Push("You have add 300 pesos to your account");
                                                        break;
                                                    case 4:
                                                        account2.Sum(400);
                                                        Console.Write("\n\t\t\t\tYou have successfully add");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 400 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account2history.Push("You have add 400 pesos to your account");
                                                        break;
                                                    case 5:
                                                        account2.Sum(500);
                                                        Console.Write("\n\t\t\t\tYou have successfully add");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 500 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account2history.Push("You have add 500 pesos to your account");
                                                        break;
                                                    case 6:
                                                        account2.Sum(600);
                                                        Console.Write("\n\t\t\t\tYou have successfully add");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 600 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account2history.Push("You have add 600 pesos to your account");
                                                        break;
                                                    case 7:
                                                        account2.Sum(700);
                                                        Console.Write("\n\t\t\t\tYou have successfully add");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 700 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account2history.Push("You have add 700 pesos to your account");
                                                        break;
                                                    case 8:
                                                        account2.Sum(800);
                                                        Console.Write("\n\t\t\t\tYou have successfully add");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 800 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account2history.Push("You have add 800 pesos to your account");
                                                        break;
                                                    case 9:
                                                        account2.Sum(900);
                                                        Console.Write("\n\t\t\t\tYou have successfully add");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 900 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account2history.Push("You have add 900 pesos to your account");
                                                        break;
                                                    case 10:
                                                        account2.Sum(1000);
                                                        Console.Write("\n\t\t\t\tYou have successfully add");
                                                        Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 1000 "); Console.ResetColor();
                                                        Console.Write("pesos in your bank");
                                                        account2history.Push("You have add 1000 pesos to your account");
                                                        break;


                                                    default:
                                                        break;


                                                }
                                                Console.ReadKey();
                                                break;


                                            case 3:
                                                Console.Clear();
                                                Console.ResetColor();
                                                Console.WriteLine("\n\n\t\t\tHow much do you want to withdraw? ");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[1]"); Console.ResetColor();
                                                Console.Write("- 100");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[2]"); Console.ResetColor();
                                                Console.Write("- 200");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[3]"); Console.ResetColor();
                                                Console.Write("- 300");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[4]"); Console.ResetColor();
                                                Console.Write("- 400");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[5]"); Console.ResetColor();
                                                Console.Write("- 500");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[6]"); Console.ResetColor();
                                                Console.Write("- 600");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[7]"); Console.ResetColor();
                                                Console.Write("- 700");

                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[8]"); Console.ResetColor();
                                                Console.Write("- 800");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[9]"); Console.ResetColor();
                                                Console.Write("- 900");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[10]"); Console.ResetColor();
                                                Console.Write("- 1000");
                                                Console.ForegroundColor = ConsoleColor.DarkGreen; Console.Write("\n[0]"); Console.ResetColor();

                                                Console.Write("- To Exit");
                                                Console.Write("\nEnter Choice: "); int.TryParse(Console.ReadLine(), out choice3);


                                                switch (choice3)
                                                {
                                                    case 1:

                                                        if (account2.Total() >= 100)
                                                        {
                                                            account2.Minus(100);
                                                            Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 100 "); Console.ResetColor();
                                                            Console.Write("pesos in your bank");
                                                            account2history.Push("You have withdraw 100 pesos to your account");

                                                        }
                                                        else
                                                        {
                                                            Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account2.Total()); Console.ResetColor(); Console.Write(" balance");

                                                        }
                                                        break;
                                                    case 2:

                                                        if (account2.Total() >= 200)
                                                        {
                                                            account2.Minus(200);
                                                            Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 200 "); Console.ResetColor();
                                                            Console.Write("pesos in your bank");
                                                            account2history.Push("You have withdraw 200 pesos to your account");
                                                        }
                                                        else
                                                        {
                                                            Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account2.Total()); Console.ResetColor(); Console.Write(" balance");

                                                        }

                                                        break;
                                                    case 3:

                                                        if (account2.Total() >= 300)
                                                        {
                                                            account2.Minus(300);
                                                            Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 300 "); Console.ResetColor();
                                                            Console.Write("pesos in your bank");
                                                            account2history.Push("You have withdraw 300 pesos to your account");
                                                        }
                                                        else
                                                        {
                                                            Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account2.Total()); Console.ResetColor(); Console.Write(" balance");

                                                        }
                                                        break;
                                                    case 4:

                                                        if (account2.Total() >= 400)
                                                        {

                                                            account2.Minus(400);
                                                            Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 400 "); Console.ResetColor();
                                                            Console.Write("pesos in your bank");
                                                            account2history.Push("You have withdraw 400 pesos to your account");
                                                        }
                                                        else
                                                        {
                                                            Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account2.Total()); Console.ResetColor(); Console.Write(" balance");

                                                        }


                                                        break;
                                                    case 5:

                                                        if (account2.Total() >= 500)
                                                        {
                                                            account2.Minus(500);
                                                            Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 500 "); Console.ResetColor();
                                                            Console.Write("pesos in your bank");
                                                            account2history.Push("You have withdraw 500 pesos to your account");
                                                        }
                                                        else
                                                        {
                                                            Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account2.Total()); Console.ResetColor(); Console.Write(" balance");

                                                        }

                                                        break;
                                                    case 6:

                                                        if (account2.Total() >= 600)
                                                        {
                                                            account2.Minus(600);
                                                            Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 600 "); Console.ResetColor();
                                                            Console.Write("pesos in your bank");
                                                            account2history.Push("You have withdraw 600 pesos to your account");
                                                        }
                                                        else
                                                        {
                                                            Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account2.Total()); Console.ResetColor(); Console.Write(" balance");

                                                        }


                                                        break;
                                                    case 7:

                                                        if (account2.Total() >= 700)
                                                        {

                                                            account2.Minus(700);
                                                            Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 700 "); Console.ResetColor();
                                                            Console.Write("pesos in your bank");
                                                            account2history.Push("You have withdraw 700 pesos to your account");
                                                        }
                                                        else
                                                        {
                                                            Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account2.Total()); Console.ResetColor(); Console.Write(" balance");

                                                        }

                                                        break;
                                                    case 8:

                                                        if (account2.Total() >= 800)
                                                        {
                                                            account2.Minus(800);
                                                            Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 800 "); Console.ResetColor();
                                                            Console.Write("pesos in your bank");
                                                            account2history.Push("You have withdraw 800 pesos to your account");
                                                        }
                                                        else
                                                        {
                                                            Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account2.Total()); Console.ResetColor(); Console.Write(" balance");

                                                        }

                                                        break;
                                                    case 9:

                                                        if (account2.Total() >= 900)
                                                        {


                                                            account2.Minus(900);
                                                            Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 900 "); Console.ResetColor();
                                                            Console.Write("pesos in your bank");
                                                            account2history.Push("You have withdraw 900 pesos to your account");
                                                        }
                                                        else
                                                        {
                                                            Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account2.Total()); Console.ResetColor(); Console.Write(" balance");

                                                        }

                                                        break;
                                                    case 10:

                                                        if (account2.Total() >= 1000)
                                                        {
                                                            account2.Minus(1000);
                                                            Console.Write("\n\t\t\t\tYou have successfully withdraw");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(" 1000 "); Console.ResetColor();
                                                            Console.Write("pesos in your bank");
                                                            account2history.Push("You have withdraw 1000 pesos to your account");
                                                        }

                                                        else
                                                        {
                                                            Console.Write("\n\t\t\t\tYou can't withdraw anymore since you have ");
                                                            Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(account2.Total()); Console.ResetColor(); Console.Write(" balance");

                                                        }

                                                            break;



                                                        
                                                }
                                                
                        
                                                Console.ReadKey();
                                                break;

                                            case 4:

                                                if (account2history.Tracker() != 0)
                                                {

                                                    Console.WriteLine();
                                                    Console.WriteLine("\n\n\t\t\t\tYour Transaction History:  ");
                                                    Console.WriteLine();

                                                    int number = 1;

                                                    foreach (String item in account2history.Display())
                                                    {
                                                        Console.Write("    ");
                                                        Console.ForegroundColor = ConsoleColor.Cyan;
                                                        Console.Write(number); Console.ResetColor();
                                                        Console.Write(". " + item);

                                                        number++;
                                                    }
                                                }
                                                else Console.WriteLine("\n\n\t\t\t\t You have no recent Transaction  ");

                                                Console.ReadKey();
                                                break;


                                            case 5
                                            :
                                                Console.WriteLine();
                                                if (account2history.Tracker() != 0)
                                                {
                                                    Console.Write("\tYour Previous Transaction:   \"");
                                                    Console.ForegroundColor = ConsoleColor.Cyan;
                                                    Console.Write(account2history.Display()[account2history.Tracker() - 1]); Console.ResetColor();
                                                    Console.Write("\" has  been successfully deleted");
                                                    account2history.Pop();
                                                    Console.ReadKey();
                                                    break;

                                                }
                                                else
                                                {
                                                    Console.WriteLine("\t\t\t\t\t Cant delete any transaction since you have no recent Transaction ");
                                                }
                                                Console.ReadKey();
                                                break;

                                            case 6:
                                                Console.WriteLine();
                                                Console.ForegroundColor = ConsoleColor.Green; Console.Write("\n\n\tAsccount ID: "); Console.ResetColor(); Console.Write(Allaccounts.GetList()[1].AccountID);
                                                Console.ForegroundColor = ConsoleColor.Green; Console.Write("\n\n\tFirstname: "); Console.ResetColor(); Console.Write(Allaccounts.GetList()[1].Firstname);
                                                Console.ForegroundColor = ConsoleColor.Green; Console.Write("\n\n\tLastname: "); Console.ResetColor(); Console.Write(Allaccounts.GetList()[1].Lastname);
                                                Console.ForegroundColor = ConsoleColor.Green; Console.Write("\n\n\tUsername: "); Console.ResetColor(); Console.Write(Allaccounts.GetList()[1].username);
                                                Console.ForegroundColor = ConsoleColor.Green; Console.Write("\n\n\tPhoneNumber: "); Console.ResetColor(); Console.Write(Allaccounts.GetList()[1].PhoneNumber);
                                                Console.ForegroundColor = ConsoleColor.Green; Console.Write("\n\n\tPostalCode:"); Console.ResetColor(); Console.Write(Allaccounts.GetList()[1].PostalCode);


                                                Console.ReadKey();

                                                break;


                                            default:

                                                break;
                                        }
                                    } while (choice2 != 0);

                                }
                                else
                                {
                                    Console.Write("\n\n\t\tLogin Failed!! PLease Try Again");
                                }

                            }
                            else
                            {
                                Console.Write("\n\n\t\tLogin Failed!! PLease Try Again");
                            }




                        }
                           
                            break;
                        
                    #endregion




            

                    #region create and view accounts
                    case 2:

                        if (numberacc == 1)
                        {
                            int PostalCode; long PhoneNumber; string ReadPassword;

                            string Firstname; string Lastname; string username; 
                            Console.WriteLine("\t\t\t\tCreate an Account\n");
                            Console.WriteLine();
                            Console.WriteLine();
                            Console.Write("\n\tEnter Firstname: "); Firstname = Console.ReadLine();
                            Console.Write("\n\tEnter Lastname: "); Lastname = Console.ReadLine();
                            Console.Write("\n\tEnter Username: "); username = Console.ReadLine();

                            Console.Write("\n\tEnter Password: "); string passwordcheck = "";
                            ConsoleKeyInfo info = Console.ReadKey(true);
                            while (info.Key != ConsoleKey.Enter)
                            {
                                if (info.Key != ConsoleKey.Backspace)
                                {
                                    Console.Write("*");
                                    passwordcheck += info.KeyChar;
                                }
                                else if (info.Key == ConsoleKey.Backspace)
                                {
                                    if (!string.IsNullOrEmpty(passwordcheck))
                                    {
                                        // remove one character from the list of password characters
                                        passwordcheck = passwordcheck.Substring(0, passwordcheck.Length - 1);
                                        // get the location of the cursor
                                        int pos = Console.CursorLeft;
                                        // move the cursor to the left by one character
                                        Console.SetCursorPosition(pos - 1, Console.CursorTop);
                                        // replace it with space
                                        Console.Write(" ");
                                        // move the cursor to the left by one character again
                                        Console.SetCursorPosition(pos - 1, Console.CursorTop);
                                    }
                                }
                                info = Console.ReadKey(true);
                            }

                            // add a new line because user pressed enter at the end of their password
                            Console.WriteLine();
                            ReadPassword = passwordcheck;

                            Console.Write("\n\tEnter Year PhoneNumber: "); long.TryParse(Console.ReadLine(), out PhoneNumber);
                            Console.Write("\n\tEnter Year PostalCode: "); int.TryParse(Console.ReadLine(), out PostalCode);

                            string phonenumber = PhoneNumber.ToString(); string postalcode = PostalCode.ToString();


                       


                            if ( 
                                
                                Firstname != "" && Lastname != "" && username != "" && ReadPassword != "" && phonenumber!= 0.ToString() && postalcode != 0.ToString()
                                )
                                

                            { 
                            //mylist implemenetation
                            Allaccounts.Add(new MyBankAccount(AccountID, Firstname, Lastname, username, ReadPassword, PhoneNumber, PostalCode));
                            account2.Add(new MyBankAccount(AccountID, Firstname, Lastname, username, ReadPassword, PhoneNumber, PostalCode));
                            Console.WriteLine(); AccountID++;

                            //stack implementation
                            account2history.Push("You have created your account");
                                Console.Write("\t\t\tHello ");
                                Console.ForegroundColor = ConsoleColor.Cyan;
                                
                                Console.Write(Firstname + " " + Lastname); Console.ResetColor();
                                Console.Write(" your account has been successfully  created please login now ");
                            numberacc++; }

                        else
                        {
                            Console.Write("\n\t\tCan't create account .. Please fill up all necessary information");
                        }
                         
                        }
                        else
                        {
                            Console.WriteLine("\n\n\t\tCan't create Account.. Our Memory is already full");
                        }
                                            
                        Console.ReadKey();
                        
                        break;

               
                        #endregion
                }
                Console.ReadLine();
            } while (choice != 0);
        }
    }
}

   

