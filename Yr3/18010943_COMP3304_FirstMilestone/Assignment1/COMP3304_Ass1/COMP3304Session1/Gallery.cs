using System;
using System.Collections.Generic;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using ManipulationTool.ImageManagement;
using ManipulationTool.Delegate;
namespace ManipulationTool
{
    /// <summary>
    /// Displays images
    /// </summary>
    class Gallery : Form, IFileImporter
    {
        //DECLARE a Button for storing a reference to the button that cycles to the previous image in the collection
        private Button btnPreviousImage;
        //DECLARE a Button for storing a reference to the button that cycles to the next image in the collection
        private Button btnNextImage;
        //DECLARE a Button for storing a reference to the button loads an image in the collection
        private Button btnLoadImage;
        //DECLARE a OpenFileDialog for opening the file dialog popup, call it openFileDialog
        private OpenFileDialog openFileDialog;
        //DECLARE a PictureBox for holding the currently displayed image
        private PictureBox imageContainer;
        #region IFileImporter
        //DECLARE a NewFileAddedHandler for handling a new file being added, call it FileAddedHandler
        public NewFileAddedHandler FileAddedHandler { get; set; }
        //DECLARE an ImageRequestCallback for Handling loading and scaling of a new image
        public ImageRequestCallback ImageRequest { get; set; }
        #endregion
        //DECLARE an IList<string> for storing all the unique identifiers, call it uniqueIdentifiers
        private IList<string> uniqueIdentifiers;
        //DECLARE an int for storing the index of the currently displayed image
        private int currentImageIndex = -1;
        public Gallery()
        {
            InitializeComponent();
            uniqueIdentifiers = new List<string>();
        }

        private void InitializeComponent()
        {
            this.imageContainer = new System.Windows.Forms.PictureBox();
            this.btnPreviousImage = new System.Windows.Forms.Button();
            this.btnNextImage = new System.Windows.Forms.Button();
            this.btnLoadImage = new System.Windows.Forms.Button();
            this.openFileDialog = new System.Windows.Forms.OpenFileDialog();
            ((System.ComponentModel.ISupportInitialize)(this.imageContainer)).BeginInit();
            this.SuspendLayout();
            // 
            // imageContainer
            // 
            this.imageContainer.Location = new System.Drawing.Point(-9, -1);
            this.imageContainer.Name = "imageContainer";
            this.imageContainer.Size = new System.Drawing.Size(800, 500);
            this.imageContainer.TabIndex = 0;
            this.imageContainer.TabStop = false;
            // 
            // btnPreviousImage
            // 
            this.btnPreviousImage.Location = new System.Drawing.Point(100, 525);
            this.btnPreviousImage.Name = "btnPreviousImage";
            this.btnPreviousImage.Size = new System.Drawing.Size(75, 23);
            this.btnPreviousImage.TabIndex = 1;
            this.btnPreviousImage.Text = "<";
            this.btnPreviousImage.UseVisualStyleBackColor = true;
            this.btnPreviousImage.Click += new System.EventHandler(this.btnPreviousImage_Click);
            // 
            // btnNextImage
            // 
            this.btnNextImage.Location = new System.Drawing.Point(600, 525);
            this.btnNextImage.Name = "btnNextImage";
            this.btnNextImage.Size = new System.Drawing.Size(75, 23);
            this.btnNextImage.TabIndex = 2;
            this.btnNextImage.Text = ">";
            this.btnNextImage.UseVisualStyleBackColor = true;
            this.btnNextImage.Click += new System.EventHandler(this.btnNextImage_Click);
            // 
            // btnLoadImage
            // 
            this.btnLoadImage.Location = new System.Drawing.Point(350, 525);
            this.btnLoadImage.Name = "btnLoadImage";
            this.btnLoadImage.Size = new System.Drawing.Size(100, 25);
            this.btnLoadImage.TabIndex = 3;
            this.btnLoadImage.Text = "Load Image";
            this.btnLoadImage.UseVisualStyleBackColor = true;
            this.btnLoadImage.Click += new System.EventHandler(this.btnLoadImage_Click);
            // 
            // openFileDialog
            // 
            this.openFileDialog.FileName = "openFileDialog";
            this.openFileDialog.Multiselect = true;
            // 
            // Gallery
            // 
            this.BackColor = System.Drawing.SystemColors.ActiveBorder;
            this.ClientSize = new System.Drawing.Size(784, 561);
            this.Controls.Add(this.btnLoadImage);
            this.Controls.Add(this.btnNextImage);
            this.Controls.Add(this.btnPreviousImage);
            this.Controls.Add(this.imageContainer);
            this.Name = "Gallery";
            ((System.ComponentModel.ISupportInitialize)(this.imageContainer)).EndInit();
            this.ResumeLayout(false);

        }

        /// <summary>
        /// Handles loading an image from the file directory
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnLoadImage_Click(object sender, EventArgs e)
        {
            //Set the filter for the file dialog
            this.openFileDialog.Filter ="Images (*.BMP;*.JPG;*.GIF,*.PNG,*.TIFF)|" +
                "*.BMP;*.JPG;*.GIF;*.PNG;*.TIFF|" +"All files (*.*)|*.*";

            //Enable multiselect
            this.openFileDialog.Multiselect = true;
            //Set the title of the dialog
            this.openFileDialog.Title = "Select Photos";
            //Store the dialog result
            DialogResult dr = this.openFileDialog.ShowDialog();
            //Create a new list of string for storing file names
            IList<string> fileNames = new List<string>();
            //if the user has confirmed which files to add
            if (dr == System.Windows.Forms.DialogResult.OK)
            {
                foreach (String file in openFileDialog.FileNames)
                {
                    try
                    {
                        //Add path name to filenames list
                        fileNames.Add(file);
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show("Error: " + ex.Message);
                    }
                }
                
                //Load images and set unique identifiers
                uniqueIdentifiers = FileAddedHandler?.Invoke(fileNames);
                //set the current image index to the last file added
                currentImageIndex = uniqueIdentifiers.Count-1;
                DisplayCurrentImage();
            }
        }
        /// <summary>
        /// Cycles to the previous image in the collection
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnPreviousImage_Click(object sender, EventArgs e)
        {
            //if there is more than one file name in the unique identifiers
            if (uniqueIdentifiers.Count > 1)
            {
                
                if (currentImageIndex <= 0)
                {
                    //Set current Image index to the last image in the collection
                    currentImageIndex = uniqueIdentifiers.Count-1;
                }
                else
                {
                    //Go to previous image index
                    currentImageIndex--;
                }
                //Displays the current image
                DisplayCurrentImage();
            }
            
        }
        /// <summary>
        /// Cycles to the next image in the collection
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btnNextImage_Click(object sender, EventArgs e)
        {
            //if there is more than one file name in the unique identifiers
            if (uniqueIdentifiers.Count > 1)
            {
                if (currentImageIndex == uniqueIdentifiers.Count - 1)
                {
                    //Set current Image index to the first image in the collection
                    currentImageIndex = 0;
                }
                else
                {
                    //Go to next image index
                    currentImageIndex++;
                }
                //Displays the current image
                DisplayCurrentImage();
            }
        }
        /// <summary>
        /// Displays the current image in the collection
        /// </summary>
        void DisplayCurrentImage()
        {
            string currentImageName = uniqueIdentifiers[currentImageIndex];
            //Store a scaled version of the current image in the image container
            imageContainer.Image = ImageRequest?.Invoke(currentImageName, imageContainer.Width, imageContainer.Height);
        }

    }
}