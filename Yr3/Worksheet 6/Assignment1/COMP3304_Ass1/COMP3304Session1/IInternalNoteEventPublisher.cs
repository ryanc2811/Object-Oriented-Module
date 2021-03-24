using System;
using System.Collections.Generic;
using System.Text;

namespace ManipulationTool
{
    public interface IInternalNoteEventPublisher
    {
        void AddEventHandler(EventHandler<NoteEventArgs> eventHandler);
        void RemoveEventHandler(EventHandler<NoteEventArgs> eventHandler);
    }
}
