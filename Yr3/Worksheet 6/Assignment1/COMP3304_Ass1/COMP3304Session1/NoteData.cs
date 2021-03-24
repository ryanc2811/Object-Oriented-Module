using Backend.ImageManipulation;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Text;

namespace ManipulationTool
{
    class NoteData:INoteText, INotes, INoteImage, INotePublisher
    {
        private IDictionary<int, DataElement> data;

        private IList<string> imageNames;

        IImageManipulator imageManipulator;

        private const string IMAGEPATH = "..\\..\\FishAssets\\";

        public NoteData()
        {
            data = new Dictionary<int, DataElement>();
            imageManipulator = new ImageManipulator();
            imageNames = Directory.GetFiles(IMAGEPATH);
        }
        #region INotes Interface
        public void AddNoteData(int index)
        {
            Random random = new Random();
            //get a random index for the image names list
            int randomImage = random.Next(0, imageNames.Count);

            Image image=imageManipulator.LoadImage(imageNames[randomImage]);
            //Add a new entry to the data dictionary
            data.Add(index, new DataElement("",image));
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

        public void RetrieveText(int index)
        {
            data[index].RetrieveText();
        }

        public void ReplaceImage(int index, string imageName)
        {
            data[index].SetNewImage(imageManipulator.LoadImage(IMAGEPATH+imageName));
        }

        public void RetrieveImage(int index,Size size)
        {
            Image image = imageManipulator.ScaleImage(data[index].Image,size);
            data[index].SetNewImage(image);
            data[index].RetrieveImage();
        }

        public void Subscribe(int index,EventHandler<NoteEventArgs> eventHandler)
        {
            ((IInternalNoteEventPublisher)data[index]).AddEventHandler(eventHandler);
        }

        public void Unsubscribe(int index,EventHandler<NoteEventArgs> eventHandler)
        {
            ((IInternalNoteEventPublisher)data[index]).RemoveEventHandler(eventHandler);
        }
        #endregion
    }
}
