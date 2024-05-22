using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace FullLinkedList
{
    public partial class Form1 : Form
    {
        // Initialisation of Node object
        public class node
        {
            public int data;
            public node nextNode;

            public node() { }
        }

        // Initialisation of list itself - called Head
        public node Head = null;

        // Procedure that adds current item in Textbox to list
        private void AddToList()
        {
            node Temp = new node();
            Temp.data = int.Parse(textBox1.Text);
            if (Head == null)
                Head = Temp;
            else if (Temp.data < Head.data)
            {
                Temp.nextNode = Head;
                Head = Temp;
            }
            else
            {
                node CurrentItem = Head;
                bool stored = false;
                do
                {
                    if (CurrentItem.nextNode == null)
                    {
                        CurrentItem.nextNode = Temp;
                        Temp.nextNode = null;
                        stored = true;
                    }
                    else if ((Temp.data > CurrentItem.data) && (Temp.data < CurrentItem.nextNode.data))
                    {
                        Temp.nextNode = CurrentItem.nextNode;
                        CurrentItem.nextNode = Temp;
                        stored = true;
                    }
                    else
                        CurrentItem = CurrentItem.nextNode;
                }
                while (!stored);
            }
            OutputList();
        }

        // Procedure runs through list and outputs into textbox2
        private void OutputList()
        {
            node Current = Head;
            textBox2.Text = "";
            while (Current != null)
            {
                textBox2.Text = textBox2.Text + " --> " + Current.data;
                Current = Current.nextNode;
            }
        }

        // Event handler - when button is clicked
        private void button1_Click(object sender, EventArgs e)
        {
            AddToList();
        }

        // Event handler - when enter key is pressed
        private void textBox1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (e.KeyChar == (char)Keys.Enter)
            {
                AddToList();
            }
        }
        public Form1()
        {
            InitializeComponent();
        }
    }
}
