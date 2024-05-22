namespace BookLendingSystem
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.laFormTitle = new System.Windows.Forms.Label();
            this.laTitle = new System.Windows.Forms.Label();
            this.tbTitle = new System.Windows.Forms.TextBox();
            this.tbAuthor = new System.Windows.Forms.TextBox();
            this.laAuthor = new System.Windows.Forms.Label();
            this.butSubmit = new System.Windows.Forms.Button();
            this.tbYear = new System.Windows.Forms.TextBox();
            this.laYear = new System.Windows.Forms.Label();
            this.laGenre = new System.Windows.Forms.Label();
            this.tbGenre = new System.Windows.Forms.ComboBox();
            this.laStatus = new System.Windows.Forms.Label();
            this.btSearch = new System.Windows.Forms.Button();
            this.tbSearchAuthor = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.LBDisplay = new System.Windows.Forms.ListBox();
            this.btOutput = new System.Windows.Forms.Button();
            this.btSave = new System.Windows.Forms.Button();
            this.btLoad = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // laFormTitle
            // 
            this.laFormTitle.AutoSize = true;
            this.laFormTitle.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.laFormTitle.Location = new System.Drawing.Point(13, 13);
            this.laFormTitle.Name = "laFormTitle";
            this.laFormTitle.Size = new System.Drawing.Size(212, 24);
            this.laFormTitle.TabIndex = 0;
            this.laFormTitle.Text = "Book Lending System";
            // 
            // laTitle
            // 
            this.laTitle.AutoSize = true;
            this.laTitle.Location = new System.Drawing.Point(54, 50);
            this.laTitle.Name = "laTitle";
            this.laTitle.Size = new System.Drawing.Size(55, 13);
            this.laTitle.TabIndex = 1;
            this.laTitle.Text = "Book Title";
            // 
            // tbTitle
            // 
            this.tbTitle.Location = new System.Drawing.Point(57, 67);
            this.tbTitle.Name = "tbTitle";
            this.tbTitle.Size = new System.Drawing.Size(205, 20);
            this.tbTitle.TabIndex = 2;
            // 
            // tbAuthor
            // 
            this.tbAuthor.Location = new System.Drawing.Point(57, 107);
            this.tbAuthor.Name = "tbAuthor";
            this.tbAuthor.Size = new System.Drawing.Size(205, 20);
            this.tbAuthor.TabIndex = 4;
            // 
            // laAuthor
            // 
            this.laAuthor.AutoSize = true;
            this.laAuthor.Location = new System.Drawing.Point(54, 90);
            this.laAuthor.Name = "laAuthor";
            this.laAuthor.Size = new System.Drawing.Size(66, 13);
            this.laAuthor.TabIndex = 3;
            this.laAuthor.Text = "Book Author";
            // 
            // butSubmit
            // 
            this.butSubmit.Location = new System.Drawing.Point(57, 226);
            this.butSubmit.Name = "butSubmit";
            this.butSubmit.Size = new System.Drawing.Size(75, 23);
            this.butSubmit.TabIndex = 5;
            this.butSubmit.Text = "Add book";
            this.butSubmit.UseVisualStyleBackColor = true;
            this.butSubmit.Click += new System.EventHandler(this.butSubmit_Click);
            // 
            // tbYear
            // 
            this.tbYear.Location = new System.Drawing.Point(57, 147);
            this.tbYear.Name = "tbYear";
            this.tbYear.Size = new System.Drawing.Size(205, 20);
            this.tbYear.TabIndex = 7;
            // 
            // laYear
            // 
            this.laYear.AutoSize = true;
            this.laYear.Location = new System.Drawing.Point(54, 130);
            this.laYear.Name = "laYear";
            this.laYear.Size = new System.Drawing.Size(57, 13);
            this.laYear.TabIndex = 6;
            this.laYear.Text = "Book Year";
            // 
            // laGenre
            // 
            this.laGenre.AutoSize = true;
            this.laGenre.Location = new System.Drawing.Point(54, 170);
            this.laGenre.Name = "laGenre";
            this.laGenre.Size = new System.Drawing.Size(64, 13);
            this.laGenre.TabIndex = 8;
            this.laGenre.Text = "Book Genre";
            // 
            // tbGenre
            // 
            this.tbGenre.FormattingEnabled = true;
            this.tbGenre.Items.AddRange(new object[] {
            "Horror",
            "Thriller",
            "Crime",
            "Science Fiction",
            "Romance",
            "Biography",
            "Autobiography",
            "Non-fiction"});
            this.tbGenre.Location = new System.Drawing.Point(57, 187);
            this.tbGenre.Name = "tbGenre";
            this.tbGenre.Size = new System.Drawing.Size(205, 21);
            this.tbGenre.TabIndex = 9;
            // 
            // laStatus
            // 
            this.laStatus.AutoSize = true;
            this.laStatus.Location = new System.Drawing.Point(54, 277);
            this.laStatus.Name = "laStatus";
            this.laStatus.Size = new System.Drawing.Size(127, 13);
            this.laStatus.TabIndex = 10;
            this.laStatus.Text = "Status : waiting for data...";
            // 
            // btSearch
            // 
            this.btSearch.Location = new System.Drawing.Point(301, 69);
            this.btSearch.Name = "btSearch";
            this.btSearch.Size = new System.Drawing.Size(75, 23);
            this.btSearch.TabIndex = 11;
            this.btSearch.Text = "Search for book";
            this.btSearch.UseVisualStyleBackColor = true;
            this.btSearch.Click += new System.EventHandler(this.btSearch_Click);
            // 
            // tbSearchAuthor
            // 
            this.tbSearchAuthor.Location = new System.Drawing.Point(301, 43);
            this.tbSearchAuthor.Name = "tbSearchAuthor";
            this.tbSearchAuthor.Size = new System.Drawing.Size(205, 20);
            this.tbSearchAuthor.TabIndex = 13;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(298, 26);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(66, 13);
            this.label1.TabIndex = 12;
            this.label1.Text = "Book Author";
            // 
            // LBDisplay
            // 
            this.LBDisplay.FormattingEnabled = true;
            this.LBDisplay.Location = new System.Drawing.Point(301, 130);
            this.LBDisplay.Name = "LBDisplay";
            this.LBDisplay.Size = new System.Drawing.Size(205, 95);
            this.LBDisplay.TabIndex = 14;
            // 
            // btOutput
            // 
            this.btOutput.Location = new System.Drawing.Point(301, 243);
            this.btOutput.Name = "btOutput";
            this.btOutput.Size = new System.Drawing.Size(140, 23);
            this.btOutput.TabIndex = 15;
            this.btOutput.Text = "Output Books to List";
            this.btOutput.UseVisualStyleBackColor = true;
            this.btOutput.Click += new System.EventHandler(this.button1_Click);
            // 
            // btSave
            // 
            this.btSave.Location = new System.Drawing.Point(301, 272);
            this.btSave.Name = "btSave";
            this.btSave.Size = new System.Drawing.Size(91, 23);
            this.btSave.TabIndex = 16;
            this.btSave.Text = "Save to File";
            this.btSave.UseVisualStyleBackColor = true;
            this.btSave.Click += new System.EventHandler(this.btSave_Click);
            // 
            // btLoad
            // 
            this.btLoad.Location = new System.Drawing.Point(398, 272);
            this.btLoad.Name = "btLoad";
            this.btLoad.Size = new System.Drawing.Size(91, 23);
            this.btLoad.TabIndex = 17;
            this.btLoad.Text = "Load from File";
            this.btLoad.UseVisualStyleBackColor = true;
            this.btLoad.Click += new System.EventHandler(this.btLoad_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(541, 314);
            this.Controls.Add(this.btLoad);
            this.Controls.Add(this.btSave);
            this.Controls.Add(this.btOutput);
            this.Controls.Add(this.LBDisplay);
            this.Controls.Add(this.tbSearchAuthor);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btSearch);
            this.Controls.Add(this.laStatus);
            this.Controls.Add(this.tbGenre);
            this.Controls.Add(this.laGenre);
            this.Controls.Add(this.tbYear);
            this.Controls.Add(this.laYear);
            this.Controls.Add(this.butSubmit);
            this.Controls.Add(this.tbAuthor);
            this.Controls.Add(this.laAuthor);
            this.Controls.Add(this.tbTitle);
            this.Controls.Add(this.laTitle);
            this.Controls.Add(this.laFormTitle);
            this.Name = "Form1";
            this.Text = "Book Lending System";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label laFormTitle;
        private System.Windows.Forms.Label laTitle;
        private System.Windows.Forms.TextBox tbTitle;
        private System.Windows.Forms.TextBox tbAuthor;
        private System.Windows.Forms.Label laAuthor;
        private System.Windows.Forms.Button butSubmit;
        private System.Windows.Forms.TextBox tbYear;
        private System.Windows.Forms.Label laYear;
        private System.Windows.Forms.Label laGenre;
        private System.Windows.Forms.ComboBox tbGenre;
        private System.Windows.Forms.Label laStatus;
        private System.Windows.Forms.Button btSearch;
        private System.Windows.Forms.TextBox tbSearchAuthor;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ListBox LBDisplay;
        private System.Windows.Forms.Button btOutput;
        private System.Windows.Forms.Button btSave;
        private System.Windows.Forms.Button btLoad;
    }
}

