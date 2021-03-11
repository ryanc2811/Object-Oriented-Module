using System;
using System.Collections.Generic;
using System.Text;

namespace Backend.Services
{
    /// <summary>
    /// Locates and creates factories
    /// </summary>
    public class FactoryLocator : IServiceLocator,IDisposable
    {
        //DECLARE an IDictionary for storing a collction of factories, call it factories
        private IDictionary<Type, IService> factories;

        public FactoryLocator()
        {
            //Instantiate factories dictionary
            factories = new Dictionary<Type, IService>();
        }
        /// <summary>
        /// Dispose of factories colleciton
        /// </summary>
        public void Dispose()
        {
            factories.Clear();
        }
        /// <summary>
        /// Creates a new factory if one does not already exist of that type in the collection
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns>Returns the factory of the T type</returns>
        public IService GetService<T>() where T : IService, new()
        {
            //If a factory of the given type does not already exist within the collection of factories
            if (!factories.ContainsKey(typeof(T)))
            {
                //Add the factory to the collection
                factories.Add(typeof(T), new T());
            }
            //Return factory
            return factories[typeof(T)];
        }
        /// <summary>
        /// Gets a service that already exists within the collection
        /// </summary>
        /// <param name="type"></param>
        /// <returns>Factory of the passed type</returns>
        public IService RequestExistingService(Type type)
        {
            if (!factories.ContainsKey(type))
            {
                throw new Exception();
            }
            return factories[type];
        }
    }
}
