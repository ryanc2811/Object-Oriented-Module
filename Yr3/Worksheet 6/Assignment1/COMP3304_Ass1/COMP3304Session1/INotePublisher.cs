using System;
using System.Collections.Generic;
using System.Text;

namespace ManipulationTool
{
    public interface INotePublisher
    {
        void Subscribe(int index, EventHandler<NoteEventArgs> eventHandler);
        void Unsubscribe(int index, EventHandler<NoteEventArgs> eventHandler);
    }
}
