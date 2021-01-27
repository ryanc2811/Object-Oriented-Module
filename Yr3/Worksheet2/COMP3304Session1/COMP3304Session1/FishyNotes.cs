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
        //DECLARE An IList of type form, named notes, for storing a reference to each form
        IList<Form> notes;
        /// <summary>
        /// Fish Notes Constructor
        /// </summary>
        public FishyNotes(IList<Form>pNotes)
        {
            InitializeComponent();
            notes = pNotes;
        }

        private void OnNoteDestroyed(object sender, EventArgs e)
        {
            // newNote = null;
            ((Form)sender).Disposed -= OnNoteDestroyed;
            notes.Remove((Form)sender);
            Console.WriteLine(notes);
        }
        /// <summary>
        /// Adds a new note on button click
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void AddNoteButton_Click(object sender, EventArgs e)
        {
            //CREATE new instance of Form
            Form newNote = new FishyNote();
            notes.Add(newNote);

            //SUBSCRIBE to dispose event
            newNote.Disposed += OnNoteDestroyed;

            //SHOW the new note form
            newNote.Show();
        }
    }
}
