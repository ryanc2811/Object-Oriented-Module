using System;
using System.Collections.Generic;
using System.Text;

namespace Backend
{
    public interface INotes
    {
        void AddNoteData(int index);
        void RemoveNoteData(int index);
    }
}
