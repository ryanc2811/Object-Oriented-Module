using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace COMP3304Session1
{
    public partial class FishyNote : Form
    {

        bool minimised = false;
        bool textClicked = false;
        string noteText = "";
        public FishyNote()
        {
            InitializeComponent();
        }

        

        private void DeleteButton_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void CollapseButton_Click(object sender, EventArgs e)
        {
            minimised = !minimised;
            if (minimised)
            {
                this.NoteTextBox.Visible = false;
                
            }
            else
            {
                this.NoteTextBox.Visible = true;
            }
        }

        private void NoteTextBox_TextChanged(object sender, EventArgs e)
        {
            noteText = this.NoteTextBox.Text;
        }

        private void NoteTextBox_Click(object sender, EventArgs e)
        {
            if (!textClicked)
            {
                textClicked = true;
                this.NoteTextBox.Text = "";
            }
        }
    }
}
