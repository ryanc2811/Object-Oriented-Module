using System;
using System.Windows.Forms;
using Backend.Services;
using Backend.ImageManipulation;
using ManipulationTool.ImageManagement;
using System.Collections.Generic;

namespace ManipulationTool
{
    class Controller
    {
        public Controller()
        {
            IDictionary<int, Form> noteForms = new Dictionary<int, Form>();
            //Create Factory locator
            IServiceLocator serviceLocator = new FactoryLocator();
            //Create Generic Factory
            IService genericFactory=serviceLocator.GetService<GenericFactory>();
            IFishyNotes fishyNotes = ((IFactory)genericFactory).Create<FishyNotes>();
            ((IServiceRequester)fishyNotes).ServiceRequest += serviceLocator.RequestExistingService;
            fishyNotes.AddNotes(noteForms);
            //Run appllication
            Application.Run((Form)fishyNotes);
            //Unsubscribe from events
            ((IServiceRequester)fishyNotes).ServiceRequest -= serviceLocator.RequestExistingService;
            //Dispose of objects
            ((IDisposable)serviceLocator).Dispose();
        }
    }
}
