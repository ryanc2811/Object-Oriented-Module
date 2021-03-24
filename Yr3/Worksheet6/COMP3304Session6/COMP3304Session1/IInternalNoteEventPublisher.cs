using System;
using System.Collections.Generic;
using System.Text;

namespace COMP3304Session1
{
    public interface IInternalNoteEventPublisher
    {
        void Subscribe(EventHandler<NoteEventArgs> eventHandler);
        void Unsubscribe(EventHandler<NoteEventArgs> eventHandler);
    }
}
