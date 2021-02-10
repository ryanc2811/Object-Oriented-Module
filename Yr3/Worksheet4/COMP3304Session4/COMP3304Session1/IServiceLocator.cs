using System;
using System.Collections.Generic;
using System.Text;

namespace COMP3304Session1
{
    public interface IServiceLocator
    {
        IService GetService<T>() where T : IService, new();
    }
}
