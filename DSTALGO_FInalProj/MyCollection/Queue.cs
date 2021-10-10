using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MyCollection;

namespace MyCollection
{
    public class MyQueue<T>
    {
        T[] arrayque = new T[10]; //fixed value of Que
        int top = 0; // que is empty at first


        public int Count()
        {
            return top;
        }
        public void Enqueue(T item)
        {
            if (top >= 5) //Que is dynamic
            {
                T[] temp = new T[arrayque.Length + 1];

                for (int i = 0; i < top; i++)
                {
                    temp[i] = arrayque[i];
                }

                arrayque = temp;
            }

            arrayque[top] = item;
            top++;

        }
        public T[] Display()
        {
            T[] temp = new T[top];
            for (int i = 0; i < top; i++)
            {
                temp[i] = arrayque[i];
            }
            return temp;
        }


        public T Dequeue()
        {
            for (int i = 0; i < top; i++)
            {
                arrayque[i] = arrayque[i + 1];
            }
            top--;
            return arrayque[0];
        }

    }

}
