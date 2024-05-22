using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace BookLendingSystem
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        // SETUP OF THE DATA STRUCTURE
        // The class record is followed by initialisation of the Global Array
        // which holds the actual books

        public class Book
        {
            // The record structure itself
            public string Title;
            public string Author;
            public int Year;
            public string Genre;

            // The constructor class runs when an instance of a book is created
            // but as no fields need initialising, no code is needed.
            public Book() { }
        }

        // The global book array, and record of maximum. Ignoring record 0 (hence 501).
        int MaxNumberOfBooks = 1;
        int NumberOfBooks = 0;
        Book[] MyBooks = new Book[1];

        private void butSubmit_Click(object sender, EventArgs e)
        {

            if (NumberOfBooks == MaxNumberOfBooks) 
            {
                MaxNumberOfBooks++;
                Array.Resize(ref MyBooks, MaxNumberOfBooks);
            }

            Book tempBook = new Book();

            if (tbAuthor.Text != "")
            {
                tempBook.Author = tbAuthor.Text;
            }


            tempBook.Genre = tbGenre.Text;
            tempBook.Title = tbTitle.Text;

            try
            {

                if (int.Parse(tbYear.Text) <= 2015)
                {
                    tempBook.Year = int.Parse(tbYear.Text);
                }
            }
            catch
            {
                MessageBox.Show("Error in date");
            }
            
            MyBooks[NumberOfBooks] = tempBook;
            NumberOfBooks++;
                       

            
            
            // Extract new record from UI, with validation
            
            // So, this boolean variable is used to lock out any storage if error has occurred.

                // IF validated ok, Check array is big enough for a new record. Expand if necessary.
                // Store the new record
                // Output successful status message

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void btSearch_Click(object sender, EventArgs e)
        {
            string sauthor = tbSearchAuthor.Text;

            for (int n = 0; n < NumberOfBooks; n++)
            {
                if (MyBooks[n].Author == sauthor)
                {
                    tbTitle.Text = MyBooks[n].Title;
                    tbGenre.Text = MyBooks[n].Genre;
                    tbAuthor.Text = MyBooks[n].Author;
                    tbYear.Text = MyBooks[n].Year.ToString();
                    break;
                }
            
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string currentBook;

            for (int b = 0; b < NumberOfBooks; b++ )
            {
                currentBook = MyBooks[b].Author + ", " + MyBooks[b].Title +
                    ", " + MyBooks[b].Genre + ", " + MyBooks[b].Year.ToString();
                LBDisplay.Items.Add(currentBook);
            }
        }

        private void btSave_Click(object sender, EventArgs e)
        {
            string currentBook;
            StreamWriter fileWriter = new StreamWriter("C:\\Documents and Settings\\VPCUsers\\My Documents\\file.txt");

            for (int b = 0; b < NumberOfBooks; b++)
            {
                currentBook = MyBooks[b].Author + "," + MyBooks[b].Title +
                    "," + MyBooks[b].Genre + "," + MyBooks[b].Year.ToString();
                fileWriter.WriteLine(currentBook);
            }
            fileWriter.Close();
        }

        private void btLoad_Click(object sender, EventArgs e)
        {
            string currentBook;
            string[] words;

            StreamReader fileReader = new StreamReader("C:\\Documents and Settings\\VPCUsers\\My Documents\\file.txt");
            int b = 0;
            int w = 1;  

             while (!fileReader.EndOfStream)
            {
                currentBook = fileReader.ReadLine();
                words = currentBook.Split(',');
               
                Book tempBook = new Book();

                for(int s=0;s<words.Count();s++)
                {
                                        
                   LBDisplay.Items.Add(s);

                    if(w==1){
                            tempBook.Author = words[s];
                    }
                    else if(w==2){
                            tempBook.Title = words[s];
                    }
                    else if(w==3){ 
                            tempBook.Genre = words[s];
                    }
                    else if(w==4){
                        tempBook.Year = int.Parse(words[s]);

                        if (b == MaxNumberOfBooks)
                        {
                            MaxNumberOfBooks++;
                            Array.Resize(ref MyBooks, MaxNumberOfBooks);
                        }
                         MyBooks[b] = tempBook;
                         b++;
                         w = 0;
                    }
                    w++;
                 }
                
             }
                    
                
             fileReader.Close();

        }


            


        

            

        }
    }

