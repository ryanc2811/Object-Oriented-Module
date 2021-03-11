using System;
using System.Collections.Generic;
using System.Text;

namespace Backend.Services
{
    public interface IServiceLocator
    {
        /// <summary>
        /// Creates a new Service
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns>new newly created service</returns>
        IService GetService<T>() where T : IService, new();
        /// <summary>
        /// Finds a Service that exists within the collection
        /// </summary>
        /// <param name="type"></param>
        /// <returns>The service with the same type as the passed type</returns>
        IService RequestExistingService(Type type);
    }
}
