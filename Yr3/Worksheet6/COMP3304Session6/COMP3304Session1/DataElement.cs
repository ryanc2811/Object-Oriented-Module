using System;
using System.Collections.Generic;
using System.Text;

namespace COMP3304Session1
{
    class DataElement:IInternalNoteEventPublisher
    {
        public string NoteText { get; private set; }
        public string ImageData { get; private set; }

        public event EventHandler<NoteEventArgs> NoteEvent;

        public DataElement(string pNoteText, string pImageData)
        {
            NoteText = pNoteText;
            ImageData = pImageData;
            NoteEvent = null;
        }

        public void SetText(string pText) => NoteText = pText;
        public void SetImageData(string pImageData) => ImageData = pImageData;

        public void Subscribe(EventHandler<NoteEventArgs> eventHandler)
        {
            NoteEvent += eventHandler;
        }

        public void Unsubscribe(EventHandler<NoteEventArgs> eventHandler)
        {
            NoteEvent += eventHandler;
        }
    }
}
