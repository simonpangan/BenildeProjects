    using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace MyCollection
{
    public class MyStack<T>
    {
     
        T[] arraystack = new T[10]; //fixed value of stack
         int top = 0; // stack is empty at first
  

        public int Tracker()
        {
            return top;
        }
        public void Push(T item)
        {
            if(top >= 5) //stack is dynamic
            {
                T[] temp = new T[arraystack.Length + 1];

                for (int i = 0; i < top; i++)
                {
                    temp[i] = arraystack[i];
                }

                arraystack = temp;
            }
           
            arraystack[top] = item;
            top++;

        }
        public T[] Display()
        {    
            T[] temp = new T[top];
            for (int i = 0; i < top; i++)
            {
                temp[i] = arraystack    [i];
            }
            return temp;
        }

        public void Peek()
        {

            if (Tracker() != 0)
            {
                Console.Write("\n\n\t\t\t\tYour Previous Transaction:   ");
                Console.ForegroundColor = ConsoleColor.Cyan; Console.Write(arraystack[top - 1]);
            }
            else
            {
                Console.WriteLine("\n\n\t\t\t\t      You have no recent Transaction ");
            }

             
        }


        public T Pop()
        {
            return arraystack[top--];
        }
         
    }
}

