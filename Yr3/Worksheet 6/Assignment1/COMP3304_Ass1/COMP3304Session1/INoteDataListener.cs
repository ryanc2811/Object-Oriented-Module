using System;
using System.Collections.Generic;
using System.Text;

namespace ManipulationTool
{
    public interface INoteDataListener
    {
        public void NewData(object source, NoteEventArgs args);
    }
}
