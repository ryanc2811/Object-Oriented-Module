using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace COMP3304Session1
{
    public partial class FishyNotes : Form
    {
        //DECLARE a Form, named newNote for storing a reference to the new note form
        private Form newNote;

        /// <summary>
        /// Fish Notes Constructor
        /// </summary>
        public FishyNotes()
        {
            InitializeComponent();
        }

        private void OnNoteDestroyed(object sender, EventArgs e)
        {
            newNote = null;
        }
        /// <summary>
        /// Adds a new note on button click
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void AddNoteButton_Click(object sender, EventArgs e)
        {
            if (newNote != null)
            {
                return;
            }
            //CREATE new instance of Form
            newNote = new FishyNote();
            //SUBSCRIBE to dispose event
            newNote.Disposed += OnNoteDestroyed;
            //SHOW the new note form
            newNote.Show();
        }
    }
}
