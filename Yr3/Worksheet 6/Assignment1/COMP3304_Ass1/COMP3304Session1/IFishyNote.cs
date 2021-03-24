using ManipulationTool.Delegate;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Text;

namespace ManipulationTool
{
    public interface IFishyNote
    {
        DisposeObjectCallback DisposeObject { get; set; }
        UpdateTextHandler UpdateText { get; set; }
        RetrieveTextCallback RetrieveText { get; set; }

        void Initialise(int pFormIndex, ImageRequestCallback pImageRequest, DisposeObjectCallback pDisposeObject, UpdateTextHandler pUpdateText, RetrieveTextCallback pRetrieveText);
    }
}
