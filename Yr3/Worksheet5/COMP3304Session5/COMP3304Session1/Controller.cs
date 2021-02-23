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

            IServiceLocator serviceLocator = new FactoryLocator();

            IService formFactory=serviceLocator.GetService<FormFactory>();

            object fishyNotes=((IFactory)formFactory).Create<FishyNotes>();

            ((IFishyNotes)fishyNotes).AddNotes(noteForms);
            Application.Run((Form)fishyNotes);
        }
    }
}
