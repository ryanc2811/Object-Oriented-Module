using System;
using System.Collections.Generic;
using System.Text;

namespace Backend
{
    public interface IServiceLocator
    {
        IService GetService<T>() where T : IService, new();
    }
}
