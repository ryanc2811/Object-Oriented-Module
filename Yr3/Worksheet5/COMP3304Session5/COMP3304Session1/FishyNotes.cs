﻿using Backend;
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
    public partial class FishyNotes : Form, IFishyNotes
    {
        //DECLARE An IList of type form, named notes, for storing a reference to each form
        private IDictionary<int,Form> noteForms;

        private INotes noteData;

        private int currentFormIndex=-1;
        /// <summary>
        /// Fish Notes Constructor
        /// </summary>
        public FishyNotes()
        {
            InitializeComponent();
            noteData = new NoteData();
        }
        public void AddNotes(IDictionary<int, Form> pNotes)
        {
            noteForms = pNotes;
        }
        /// <summary>
        /// Listens for when a note has been destroyed
        /// </summary>
        /// <param name="sender">object that has been destroyed</param>
        /// <param name="e">Event args</param>
        private void OnNoteDestroyed(int formIndex)
        {
            //Unsubscribe from the event
            ((IFishyNote)noteForms[formIndex]).DisposeObject -= OnNoteDestroyed;
            ((IFishyNote)noteForms[formIndex]).RetrieveText -= RetrieveText;
            ((IFishyNote)noteForms[formIndex]).UpdateText -= UpdateText;
            noteForms.Remove(formIndex);
            noteData.RemoveNoteData(formIndex);
            Console.WriteLine(noteForms);
        }
        private void UpdateText(int formIndex, string text)
        {
            ((INoteText)noteData).ReplaceText(formIndex,text);
        }
        
        private string RetrieveText(int formIndex)
        {
            return ((INoteText)noteData).RetrieveText(formIndex);
        }
        /// <summary>
        /// Adds a new note on button click
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void AddNoteButton_Click(object sender, EventArgs e)
        {
            currentFormIndex++;

            noteData.AddNoteData(currentFormIndex);
            IService factory = FactoryLocator.Instance.GetService<FormFactory>();
            //CREATE new instance of Form
            object newNote = ((IFactory)factory).Create<FishyNote>();

            ((IFishyNote)newNote).Initialise(currentFormIndex,((INoteImage)noteData).RetrieveImage(currentFormIndex),OnNoteDestroyed,UpdateText,RetrieveText);
            noteForms.Add(currentFormIndex,(Form)newNote);
            
            //SHOW the new note form
            ((Form)newNote).Show();
        }
    }
}
