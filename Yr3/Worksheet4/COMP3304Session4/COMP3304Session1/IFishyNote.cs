using System;
using System.Collections.Generic;
using System.Text;

namespace COMP3304Session1
{
    public interface IFishyNote
    {
        DisposeObjectCallback DisposeObject { get; set; }
        UpdateTextHandler UpdateText { get; set; }
        RetrieveTextCallback RetrieveText { get; set; }

        void Initialise(int pFormIndex, string buttonImageData, DisposeObjectCallback pDisposeObject, UpdateTextHandler pUpdateText, RetrieveTextCallback pRetrieveText);
    }
}
