namespace ContrastAdjuster
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            pictureBox1 = new PictureBox();
            pictureBox2 = new PictureBox();
            openFileDialog1 = new OpenFileDialog();
            button1 = new Button();
            input_r1 = new NumericUpDown();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            input_s1 = new NumericUpDown();
            panel1 = new Panel();
            label6 = new Label();
            button2 = new Button();
            label4 = new Label();
            input_s2 = new NumericUpDown();
            label5 = new Label();
            input_r2 = new NumericUpDown();
            ((System.ComponentModel.ISupportInitialize)pictureBox1).BeginInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox2).BeginInit();
            ((System.ComponentModel.ISupportInitialize)input_r1).BeginInit();
            ((System.ComponentModel.ISupportInitialize)input_s1).BeginInit();
            panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)input_s2).BeginInit();
            ((System.ComponentModel.ISupportInitialize)input_r2).BeginInit();
            SuspendLayout();
            // 
            // pictureBox1
            // 
            pictureBox1.Image = (Image)resources.GetObject("pictureBox1.Image");
            pictureBox1.Location = new Point(67, 177);
            pictureBox1.Name = "pictureBox1";
            pictureBox1.Size = new Size(361, 362);
            pictureBox1.TabIndex = 0;
            pictureBox1.TabStop = false;
            // 
            // pictureBox2
            // 
            pictureBox2.Image = (Image)resources.GetObject("pictureBox2.Image");
            pictureBox2.Location = new Point(869, 177);
            pictureBox2.Name = "pictureBox2";
            pictureBox2.Size = new Size(361, 362);
            pictureBox2.TabIndex = 1;
            pictureBox2.TabStop = false;
            // 
            // openFileDialog1
            // 
            openFileDialog1.FileName = "openFileDialog1";
            openFileDialog1.FileOk += openFileDialog1_FileOk;
            // 
            // button1
            // 
            button1.Location = new Point(127, 79);
            button1.Name = "button1";
            button1.Size = new Size(236, 51);
            button1.TabIndex = 2;
            button1.Text = "Отворете PGM изображение";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // input_r1
            // 
            input_r1.Enabled = false;
            input_r1.Location = new Point(56, 91);
            input_r1.Maximum = new decimal(new int[] { 255, 0, 0, 0 });
            input_r1.Name = "input_r1";
            input_r1.Size = new Size(60, 27);
            input_r1.TabIndex = 3;
            input_r1.ValueChanged += input_r1_ValueChanged;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(7, 31);
            label1.Name = "label1";
            label1.Size = new Size(322, 20);
            label1.TabIndex = 7;
            label1.Text = "Задайте стойности за корекция на контраста";
            label1.Click += label1_Click;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(28, 93);
            label2.Name = "label2";
            label2.Size = new Size(22, 20);
            label2.TabIndex = 8;
            label2.Text = "r1";
            label2.Click += label2_Click;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(172, 95);
            label3.Name = "label3";
            label3.Size = new Size(23, 20);
            label3.TabIndex = 10;
            label3.Text = "s1";
            label3.Click += label3_Click;
            // 
            // input_s1
            // 
            input_s1.Enabled = false;
            input_s1.Location = new Point(200, 93);
            input_s1.Maximum = new decimal(new int[] { 255, 0, 0, 0 });
            input_s1.Name = "input_s1";
            input_s1.Size = new Size(60, 27);
            input_s1.TabIndex = 9;
            input_s1.ValueChanged += numericUpDown5_ValueChanged;
            // 
            // panel1
            // 
            panel1.BorderStyle = BorderStyle.FixedSingle;
            panel1.Controls.Add(label6);
            panel1.Controls.Add(button2);
            panel1.Controls.Add(label4);
            panel1.Controls.Add(label1);
            panel1.Controls.Add(input_s2);
            panel1.Controls.Add(label5);
            panel1.Controls.Add(input_r2);
            panel1.Controls.Add(label3);
            panel1.Controls.Add(input_s1);
            panel1.Controls.Add(label2);
            panel1.Controls.Add(input_r1);
            panel1.Location = new Point(496, 182);
            panel1.Name = "panel1";
            panel1.Size = new Size(334, 329);
            panel1.TabIndex = 11;
            panel1.Paint += panel1_Paint;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Font = new Font("Segoe UI", 9F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label6.ForeColor = Color.Red;
            label6.Location = new Point(17, 212);
            label6.Name = "label6";
            label6.Size = new Size(308, 20);
            label6.TabIndex = 16;
            label6.Text = "r1 трябва да е с по-малка стойност от r2!";
            label6.Visible = false;
            // 
            // button2
            // 
            button2.Enabled = false;
            button2.Location = new Point(67, 235);
            button2.Name = "button2";
            button2.Size = new Size(181, 29);
            button2.TabIndex = 15;
            button2.Text = "Променете контраста";
            button2.UseVisualStyleBackColor = true;
            button2.Click += button2_Click;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(172, 165);
            label4.Name = "label4";
            label4.Size = new Size(23, 20);
            label4.TabIndex = 14;
            label4.Text = "s2";
            // 
            // input_s2
            // 
            input_s2.Enabled = false;
            input_s2.Location = new Point(200, 163);
            input_s2.Maximum = new decimal(new int[] { 255, 0, 0, 0 });
            input_s2.Name = "input_s2";
            input_s2.Size = new Size(60, 27);
            input_s2.TabIndex = 13;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(28, 163);
            label5.Name = "label5";
            label5.Size = new Size(22, 20);
            label5.TabIndex = 12;
            label5.Text = "r2";
            // 
            // input_r2
            // 
            input_r2.Enabled = false;
            input_r2.Location = new Point(56, 161);
            input_r2.Maximum = new decimal(new int[] { 255, 0, 0, 0 });
            input_r2.Name = "input_r2";
            input_r2.Size = new Size(60, 27);
            input_r2.TabIndex = 11;
            input_r2.ValueChanged += input_r2_ValueChanged;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1310, 681);
            Controls.Add(panel1);
            Controls.Add(button1);
            Controls.Add(pictureBox2);
            Controls.Add(pictureBox1);
            Name = "Form1";
            Text = "ContrastAdjuster";
            Load += Form1_Load;
            ((System.ComponentModel.ISupportInitialize)pictureBox1).EndInit();
            ((System.ComponentModel.ISupportInitialize)pictureBox2).EndInit();
            ((System.ComponentModel.ISupportInitialize)input_r1).EndInit();
            ((System.ComponentModel.ISupportInitialize)input_s1).EndInit();
            panel1.ResumeLayout(false);
            panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)input_s2).EndInit();
            ((System.ComponentModel.ISupportInitialize)input_r2).EndInit();
            ResumeLayout(false);
        }

        #endregion

        private PictureBox pictureBox1;
        private PictureBox pictureBox2;
        private OpenFileDialog openFileDialog1;
        private Button button1;
        private NumericUpDown input_r1;
        private Label label1;
        private Label label2;
        private Label label3;
        private NumericUpDown input_s1;
        private Panel panel1;
        private Label label4;
        private NumericUpDown input_s2;
        private Label label5;
        private NumericUpDown input_r2;
        private Button button2;
        private Label label6;
    }
}
