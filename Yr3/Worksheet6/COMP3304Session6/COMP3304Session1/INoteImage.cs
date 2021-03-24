using System;
using System.Collections.Generic;
using System.Text;

namespace COMP3304Session1
{
    public interface INoteImage
    {
        void ReplaceImage(int index, string imageData);
        string RetrieveImage(int index);
    }
}
