using ImageProcessor;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Text;

namespace Backend.ImageManipulation
{
    public class ImageManipulator : IImageManipulator
    {
        /// <summary>
        /// Loads and create a new image using the passed path file name
        /// </summary>
        /// <param name="pathFileName"></param>
        /// <returns>The newly created image</returns>
        public Image LoadImage(string pathFileName)
        {
            //Instantiate an ImageFactory for resizing an image
            ImageFactory imageFactory = new ImageFactory(false);
            //Instantiate a Stream for storing the image
            Stream memoryStream = new MemoryStream();
            //Scale the image to new size and save it to memory steam
            imageFactory.Load(pathFileName).Save(memoryStream);
            imageFactory.Dispose();
            //Return processed image
            return Image.FromStream(memoryStream);
        }
        /// <summary>
        /// Scales the passed image to the passed size
        /// </summary>
        /// <param name="image"></param>
        /// <param name="width"></param>
        /// <param name="height"></param>
        /// <returns>Scaled image</returns>
        public Image ScaleImage(Image image, int width, int height)
        {
            //Instantiate an ImageFactory for resizing an image
            ImageFactory imageFactory = new ImageFactory(false);
            //Instantiate a Stream for storing the image
            Stream memoryStream = new MemoryStream();
            //Create a new size with the given parameters
            Size newSize = new Size(width, height);
            //Scale the image to new size and save it to memory steam
            imageFactory.Load(image).Resize(newSize).Save(memoryStream);
            imageFactory.Dispose();
            //Return processed image
            return Image.FromStream(memoryStream);
        }
    }
}
