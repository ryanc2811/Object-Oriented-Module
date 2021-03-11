using Backend.ImageManipulation;
using Backend.Services;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Text;
using ManipulationTool.Delegate;
namespace ManipulationTool.ImageManagement
{
    /// <summary>
    /// Manages and loads new images into a collection
    /// </summary>
    class ImageManager : IModel, IServiceRequester,IDisposable
    {
        //DECLARE an IDictionary for storing a collection of images, call it images
        private IDictionary<string, Image> images;
        #region IServiceRequester
        //DECLARE a ServiceRequestCallback for returning a Service, call it ServiceRequest
        public ServiceRequestCallback ServiceRequest { get; set; }
        #endregion
        public ImageManager()
        {
            //Instantiate the images dictionary
            images = new Dictionary<string, Image>();
        }
        #region IModel
        /// <summary>
        /// Return a copy of the image specified by 'key', scaled according to the dimentsions of the visual container (ie frame) it will be viewed in.
        /// </summary>
        /// <param name="key">the unique identifier for the image to be returned</param>
        /// <param name="frameWidth">the width (in pixels) of the 'frame' it is to occupy</param>
        /// <param name="frameHeight">the height (in pixles) of the 'frame' it is to occupy</param>
        /// <returns>the Image pointed identified by key</returns>
        public Image getImage(string key, int frameWidth, int frameHeight)
        {
            //Request Factory Service
            IService factory=ServiceRequest?.Invoke(typeof(GenericFactory));
            //Create imageManipulator
            IImageManipulator imageManipulator=((IFactory)factory).Create<ImageManipulator>();
            //Return Scaled image
            return imageManipulator.ScaleImage(images[key], frameWidth, frameHeight);
        }
        /// <summary>
        /// Load the media items pointed to by 'pathfilenames' into the 'Model'
        /// </summary>
        /// <param name="pathfilenames">a vector of strings; each string containing path/filename for an image file to be loaded</param>
        /// <returns>the unique identifiers of the images that have been loaded</returns>
        public IList<string> load(IList<string> pathfilenames)
        {
            //Request Factory Service
            IService factory = ServiceRequest?.Invoke(typeof(GenericFactory));
            //Create imageManipulator
            IImageManipulator imageManipulator = ((IFactory)factory).Create<ImageManipulator>();
            //Create a list of strings, call it uniqueIdentifiers
            IList<string> uniqueIdentifiers = new List<string>();
            
            foreach (string fileName in pathfilenames)
            {
                //if the images dictionary doesnt already contain an image with the filename
                if (!images.ContainsKey(fileName))
                {
                    //Create a new image object using the filename
                    Image newImage = imageManipulator.LoadImage(fileName);
                    //Add the image to the dictionary
                    images.Add(fileName, newImage);
                }
            }
            //for each image in the collection
            foreach(KeyValuePair<string,Image> entry in images)
            {
                //add the pathfile name key to the unique identifier
                uniqueIdentifiers.Add(entry.Key);
            }

            return uniqueIdentifiers;
        }
        #endregion
        #region IDisposable
        /// <summary>
        /// Disposes of the collection of images
        /// </summary>
        public void Dispose()
        {
            images.Clear();
        }
        #endregion
    }
}
