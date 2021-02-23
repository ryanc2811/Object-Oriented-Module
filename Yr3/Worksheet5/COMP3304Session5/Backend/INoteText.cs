using System;
using System.Collections.Generic;
using System.Text;

namespace Backend
{
    public interface INoteText
    {
        void ReplaceText(int index, string text);
        string RetrieveText(int index);
    }
}
