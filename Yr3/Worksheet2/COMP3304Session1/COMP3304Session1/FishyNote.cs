﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace COMP3304Session1
{
    public partial class FishyNote : Form
    {

        bool minimised = false;
        bool textClicked = false;
        string noteText = "";
        #region Code Snippet: makes this borderless window movable
        // Modified from https://stackoverflow.com/a/24561946 and attributed to user jay_t55

        // DECLARE a boolean that is set to true when a mouse down event is detected, call it _mouseDown:
        private bool _mouseDown = false;

        // DECLARE a Point object to store the last location of the window origin (ie memory), call it _lastLocation:
        private Point _lastLocation;
        int originalWidth;
        int originalHeight;
        
        #endregion
        public FishyNote()
        {
            InitializeComponent();
            originalHeight = this.Height;
            originalWidth = this.Width;
        }

        

        private void DeleteButton_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void CollapseButton_Click(object sender, EventArgs e)
        {
            minimised = !minimised;
            if (minimised)
            {
                this.NoteTextBox.Visible = false;
                
                Height = originalHeight - 350;
            }
            else
            {
                this.NoteTextBox.Visible = true;
                Width = originalWidth;
                Height = originalHeight;
            }
        }
        // Mouse down event handler
        private void FishyNote_MouseDown(object sender, MouseEventArgs e)
        {
            // SET _mouseDown true:
            _mouseDown = true;

            // STORE current location to _lastLocation:
            _lastLocation = e.Location;
        }

        // Mouse move event handler
        private void FishyNote_MouseMove(object sender, MouseEventArgs e)
        {
            // Only act if mouse button is down...
            if (_mouseDown)
            {
                // SET new location according to mouse movement from _lastLocation:
                this.Location = new Point(
                    (this.Location.X - _lastLocation.X) + e.X, (this.Location.Y - _lastLocation.Y) + e.Y);

                // UPDATE this window:
                this.Update();
            }
        }

        // Mouse up event handler
        private void FishyNote_MouseUp(object sender, MouseEventArgs e)
        {
            // RESET _mouseDown to false:
            _mouseDown = false;
        }
        private void NoteTextBox_TextChanged(object sender, EventArgs e)
        {
            noteText = this.NoteTextBox.Text;
        }

        private void NoteTextBox_Click(object sender, EventArgs e)
        {
            if (!textClicked)
            {
                textClicked = true;
                this.NoteTextBox.Text = "";
            }
        }
    }
}
