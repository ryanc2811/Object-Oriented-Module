using System;
using System.Collections.Generic;
using System.Text;

namespace COMP3304Session1
{
    public interface INoteText
    {
        void ReplaceText(int index, string text);
        string RetrieveText(int index);
    }
}
