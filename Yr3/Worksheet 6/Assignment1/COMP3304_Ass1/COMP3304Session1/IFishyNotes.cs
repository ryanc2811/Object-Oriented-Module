using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace ManipulationTool
{
    public interface IFishyNotes
    {
        void AddNotes(IDictionary<int, Form> pNotes);
    }
}
