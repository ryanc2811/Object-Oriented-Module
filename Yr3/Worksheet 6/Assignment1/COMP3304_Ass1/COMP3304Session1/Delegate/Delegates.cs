using System;
using System.Collections.Generic;
using System.Drawing;
using Backend.Services;

namespace ManipulationTool.Delegate
{
    public delegate IList<string> NewFileAddedHandler(IList<string> filePath);
    public delegate IService ServiceRequestCallback(Type type);
    public delegate void ImageRequestCallback(int key, Size size);
    public delegate void DisposeObjectCallback(int index);
    public delegate void UpdateTextHandler(int index, string text);
    public delegate void RetrieveTextCallback(int index);
}
