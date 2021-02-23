using System;
using System.Collections.Generic;
using System.Text;

namespace Backend
{
    struct DataElement
    {
        public string NoteText { get; private set; }
        public string ImageData { get; private set; }

        public DataElement(string pNoteText, string pImageData)
        {
            NoteText = pNoteText;
            ImageData = pImageData;
        }

        public void SetText(string pText) => NoteText = pText;
        public void SetImageData(string pImageData) => ImageData = pImageData;
    }
}
