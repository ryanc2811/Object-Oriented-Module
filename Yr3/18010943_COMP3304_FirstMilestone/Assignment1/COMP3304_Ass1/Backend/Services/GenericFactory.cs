using System;
using System.Collections.Generic;
using System.Text;

namespace Backend.Services
{
    /// <summary>
    /// Creates any object
    /// </summary>
    public class GenericFactory : IFactory, IService
    {
        /// <summary>
        /// Create a new object of type T
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns>return generic object </returns>
        public T Create<T>() where T : new()
        {
            //Create new object of type T
            T genericObject = new T();

            return genericObject;
        }
    }
}
