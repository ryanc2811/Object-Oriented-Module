using System;
using System.Collections.Generic;
using System.Drawing;
using Backend.Services;

namespace ManipulationTool.Delegate
{
    public delegate IList<string> NewFileAddedHandler(IList<string> filePath);
    public delegate IService ServiceRequestCallback(Type type);
    public delegate Image ImageRequestCallback(string key, int frameWidth, int frameHeight);
}
