using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace MyCollection
{
    public class MyList<T>
    {
        T[] array;
        int index = 0;
        int total;

        public MyList()
        {
            array = new T[5];
            total = 0;

        }

       
        
        public int Count()
        {
            return index;
        }
        public int Total()
        {
            return total;
        }


        public int Sum(int input)
        {
            int sum = 0;
            sum += input;
            total += sum;
            return sum;
        }

        public void Minus(int input)
        {
           
            total = total - input;
            

        }

        public void Add(T item)
        {
            if (index >= 5)
            {
                T[] temp = new T[array.Length + 1];

                for (int i = 0; i < index; i++)
                {
                    temp[i] = array[i];
                }

                array = temp;
            }
            array[index] = item;  
            index++; 
        }


        public T[] GetList()
        {
            T[] temp = new T[index];
            for (int i = 0; i < index; i++)
            {
                temp[i] = array[i];
            }
            return temp;
        }
    }

 
}
