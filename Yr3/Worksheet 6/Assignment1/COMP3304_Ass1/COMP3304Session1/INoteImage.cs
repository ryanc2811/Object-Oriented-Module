using System;
using System.Collections.Generic;
using System.Drawing;
using System.Text;

namespace ManipulationTool
{
    public interface INoteImage
    {
        void ReplaceImage(int index, string imageData);
        void RetrieveImage(int index, Size size);
    }
}
