using System;
using System.Collections.Generic;
using System.Drawing;
using System.Text;

namespace ManipulationTool
{
    class DataElement:IInternalNoteEventPublisher
    {
        /// <summary>
        /// Contains the text of a not
        /// </summary>
        public string NoteText { get; private set; }
        /// <summary>
        /// Contains the path of the image
        /// </summary>
        public Image Image { get; private set; }

        public event EventHandler<NoteEventArgs> NoteEvent;

        public DataElement(string pNoteText, Image pImage)
        {
            NoteText = pNoteText;
            Image = pImage;
            NoteEvent = null;
        }

        public void SetText(string pText)
        {
            OnDataChanged(pText);
        }

        public void SetNewImage(Image pImage)
        {
            Image = pImage;
        }
        public void RetrieveImage()
        {
            OnImageChanged(Image);
        }
        public void RetrieveText()
        {
            OnDataChanged(NoteText);
        }
        private void OnImageChanged(Image image)
        {
            NoteEventArgs args = new NoteEventArgs(image);
            NoteEvent(this, args);
        }
        private void OnDataChanged(string data)
        {
            NoteEventArgs args = new NoteEventArgs(data);
            NoteEvent(this, args);
        }
        public void AddEventHandler(EventHandler<NoteEventArgs> eventHandler)
        {
            NoteEvent += eventHandler;
        }

        public void RemoveEventHandler(EventHandler<NoteEventArgs> eventHandler)
        {
            NoteEvent -= eventHandler;
        }
    }
}
