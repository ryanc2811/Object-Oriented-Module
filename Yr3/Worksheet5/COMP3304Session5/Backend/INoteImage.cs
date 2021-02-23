using System;
using System.Collections.Generic;
using System.Text;

namespace Backend
{
    public interface INoteImage
    {
        void ReplaceImage(int index, string imageData);
        string RetrieveImage(int index);
    }
}
