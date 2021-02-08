using System;
using System.Collections.Generic;
using System.Text;

namespace COMP3304Session1
{
    public interface IFishyNote
    {
        DisposeObjectCallback DisposeObject { get; set; }
        public UpdateTextHandler UpdateText { get; set; }
        public RetrieveTextCallback RetrieveText { get; set; }
    }
}
