namespace ContrastAdjuster
{
    public partial class OutputForm : Form
    {
        private readonly string _pgmData;
        private readonly Bitmap _displayImage;

        public OutputForm(ContrastAdjustResult result)
        {
            InitializeComponent();
            _pgmData = result.OutputPgmContent;
            _displayImage = result.DisplayImage;
        }

        private void OutputForm_Load(object sender, EventArgs e)
        {
            pictureBox1.Image = _displayImage;
            pictureBox1.Size = _displayImage.Size;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            var saveFileDialog = new SaveFileDialog();
            saveFileDialog.Title = "Запазете вашият PGM файл";
            saveFileDialog.Filter = "PGM изображения (*.pgm)|*.pgm|Всички файлове (*.*)|*.*";
            

            if (saveFileDialog.ShowDialog() == DialogResult.OK)
            {
                File.WriteAllText(saveFileDialog.FileName, _pgmData);
            }
        }
    }
}
