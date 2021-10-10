using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UserAccount
{
  
    class MyBankAccount 
    {
        public string Firstname;
        public string Lastname;
        public long PhoneNumber;

        public long PostalCode;
        public long AccountID;
        public string username;
        public string password;

    
        public MyBankAccount(long AccountID,string Firstname, string Lastname, string username,string password, long PhoneNumber, long PostalCode)
        {
            this.AccountID = AccountID;
            this.Firstname = Firstname;
            this.Lastname = Lastname;
            this.PhoneNumber = PhoneNumber;
            this.PostalCode = PostalCode;
            this.username = username;
            this.password = password;
            AccountID++;
        }
      
        public void name()
        {
            Console.WriteLine(AccountID +  "\t"+ Firstname + "\t\t" + Lastname + "\t\t" + username + "\t" + PhoneNumber + "\t" + PostalCode);
        }
    }
}
