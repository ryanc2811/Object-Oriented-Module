using System;
using System.Collections.Generic;
using System.Text;

namespace Backend
{
    public class FormFactory : IFactory, IService
    {
        public object Create<T>() where T : new()
        {
            T form = new T();

            return form;
        }
    }
}
