using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace COMP3304Session1
{
    class FormFactory : IFactory, IService
    {
        public object Create<T>() where T : new()
        {
            T form = new T();

            return form;
        }
    }
}
