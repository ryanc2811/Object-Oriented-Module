using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Backend;
using ManipulationTool.Delegate;

namespace ManipulationTool
{
    public interface IServiceRequester
    {
        /// <summary>
        /// Requests a new service
        /// </summary>
        ServiceRequestCallback ServiceRequest{ get; set; }
    }
}
