using System;
using System.Collections.Generic;
using System.Text;

namespace COMP3304Session1
{
    class NoteData:INoteText, INotes, INoteImage
    {
        private IDictionary<int, DataElement> data;

        private IList<string> imageNames;

        private const string IMAGEPATH = "..\\..\\FishAssets\\";

        public NoteData()
        {
            data = new Dictionary<int, DataElement>();
            imageNames = new List<string>() 
            { 
                "JavaFish.png",
                "OrangeFish.png",
                "AnglerFish_Lit.png",
                "AnglerFish_Unlit.png",
                "PiranhaGreen.png",
                "PiranhaRed.png",
                "Seahorse.png",
                "Urchin.png"
            };
        }
        #region INotes Interface
        public void AddNoteData(int index)
        {
            Random random = new Random();
            //get a random index for the image names list
            int randomImage = random.Next(0, imageNames.Count);

            //Add a new entry to the data dictionary
            data.Add(index, new DataElement("",IMAGEPATH+imageNames[randomImage]));
        }

        public void RemoveNoteData(int index)
        {
            data.Remove(index);
        }
        #endregion
        #region INoteText Interface
        public void ReplaceText(int index, string text)
        {
            data[index].SetText(text);
        }

        public string RetrieveText(int index)
        {
            return data[index].NoteText;
        }

        public void ReplaceImage(int index, string imageName)
        {
            data[index].SetImageData(IMAGEPATH + imageName);
        }

        public string RetrieveImage(int index)
        {
            return data[index].ImageData;
        }
        #endregion
    }
}
