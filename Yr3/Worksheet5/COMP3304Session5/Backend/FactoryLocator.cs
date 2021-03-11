using System;
using System.Collections.Generic;
using System.Text;

namespace Backend
{
    public class FactoryLocator : IServiceLocator
    {
        private IDictionary<Type, IService> factories;

        public static FactoryLocator Instance;
        public FactoryLocator()
        {
            Instance = this;
            factories = new Dictionary<Type, IService>();
        }

        public IService GetService<T>() where T : IService, new()
        {
            if (!factories.ContainsKey(typeof(T)))
            {
                factories.Add(typeof(T), new T());
            }

            Console.WriteLine(factories.Count);
            return factories[typeof(T)];
        }
    }
}
