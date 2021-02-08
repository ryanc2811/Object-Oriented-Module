using System;
using System.Collections.Generic;
using System.Text;

namespace COMP3304Session1
{
    public delegate void DisposeObjectCallback(int index);
    public delegate void UpdateTextHandler(int index,string text);
    public delegate string RetrieveTextCallback(int index);
}
