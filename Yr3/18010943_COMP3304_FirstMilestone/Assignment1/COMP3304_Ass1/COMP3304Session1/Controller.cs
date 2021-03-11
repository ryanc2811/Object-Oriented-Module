using System;
using System.Windows.Forms;
using Backend.Services;
using Backend.ImageManipulation;
using ManipulationTool.ImageManagement;
namespace ManipulationTool
{
    class Controller
    {
        public Controller()
        {
            //Create Factory locator
            IServiceLocator serviceLocator = new FactoryLocator();
            //Create Generic Factory
            IService genericFactory=serviceLocator.GetService<GenericFactory>();
            //Create ImageManager
            IModel imageManager=((IFactory)genericFactory).Create<ImageManager>();
            //Subscribe RequestExistingService to Service Request
            ((IServiceRequester)imageManager).ServiceRequest += serviceLocator.RequestExistingService;
            //Create Gallery form
            IFileImporter fileImporter=((IFactory)genericFactory).Create<Gallery>();
            //Subscribe imagemanager to the fileadded event
            fileImporter.FileAddedHandler += imageManager.load;
            //Subscribe imagemanager to the ImageRequest event
            fileImporter.ImageRequest += imageManager.getImage;
            //Run appllication
            Application.Run((Form)fileImporter);
            //Unsubscribe from events
            fileImporter.FileAddedHandler -= imageManager.load;
            fileImporter.ImageRequest -= imageManager.getImage;
            ((IServiceRequester)imageManager).ServiceRequest -= serviceLocator.RequestExistingService;
            //Dispose of objects
            ((IDisposable)fileImporter).Dispose();
            ((IDisposable)imageManager).Dispose();
            ((IDisposable)serviceLocator).Dispose();
        }
    }
}
