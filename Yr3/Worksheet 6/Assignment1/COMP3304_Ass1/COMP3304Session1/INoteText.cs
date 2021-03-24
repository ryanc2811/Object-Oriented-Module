using System;
using System.Collections.Generic;
using System.Text;

namespace ManipulationTool
{
    public interface INoteText
    {
        void ReplaceText(int index, string text);
        void RetrieveText(int index);
    }
}
