using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace COMP3304Session1
{
    public interface IFactory
    {
        object Create<T>() where T :new();
    }
}
