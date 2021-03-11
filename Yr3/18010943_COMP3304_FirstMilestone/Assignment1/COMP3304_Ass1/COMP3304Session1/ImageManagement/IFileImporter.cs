using System;
using System.Collections.Generic;
using System.Text;
using ManipulationTool.Delegate;
namespace ManipulationTool.ImageManagement
{
    public interface IFileImporter
    {
        /// <summary>
        /// Handles adding a new file
        /// </summary>
        NewFileAddedHandler FileAddedHandler { get; set; }
        /// <summary>
        /// Handles loading a scales image
        /// </summary>
        ImageRequestCallback ImageRequest { get; set; }
    }
}
