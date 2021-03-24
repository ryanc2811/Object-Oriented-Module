using System;
using System.Collections.Generic;
using System.Drawing;
using System.Text;

namespace COMP3304Session1
{
    public class NoteEventArgs:EventArgs
    {
        public Image GetImage { get; private set; }
        public string NoteData { get; private set; }

        public NoteEventArgs(Image image)
        {
            GetImage = image;
        }
        public NoteEventArgs(string noteData)
        {
            NoteData = noteData;
        }
    }
}
