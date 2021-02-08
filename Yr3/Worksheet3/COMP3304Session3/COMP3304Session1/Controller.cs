using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace COMP3304Session1
{
    class Controller
    {
        public Controller()
        {
            IDictionary<int,Form> noteForms = new Dictionary<int,Form>();

            Application.Run(new FishyNotes(noteForms));
        }
    }
}
