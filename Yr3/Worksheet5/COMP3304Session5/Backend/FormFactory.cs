using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace Backend
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
