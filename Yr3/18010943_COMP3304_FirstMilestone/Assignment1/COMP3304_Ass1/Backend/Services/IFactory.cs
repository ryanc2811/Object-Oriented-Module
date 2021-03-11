using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace Backend.Services
{
    public interface IFactory
    {
        /// <summary>
        /// Create a new object of type T
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns>return generic object </returns>
        T Create<T>() where T :new();
    }
}
