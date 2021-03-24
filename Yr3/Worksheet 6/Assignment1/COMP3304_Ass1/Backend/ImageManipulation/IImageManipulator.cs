using System;
using System.Collections.Generic;
using System.Drawing;
using System.Text;

namespace Backend.ImageManipulation
{
    public interface IImageManipulator
    {
        /// <summary>
        /// Scales the passed image to the passed size
        /// </summary>
        /// <param name="image"></param>
        /// <param name="width"></param>
        /// <param name="height"></param>
        /// <returns>Scaled image</returns>
        Image ScaleImage(Image image, Size size);
        /// <summary>
        /// Loads and create a new image using the passed path file name
        /// </summary>
        /// <param name="pathFileName"></param>
        /// <returns>The newly created image</returns>
        Image LoadImage(string pathFileName);
    }
}
