namespace ContrastAdjuster;

public partial class ContrastAdjusterInputForm : Form
{
    private const int FORM_WIDTH = 1200;

    public ContrastAdjusterInputForm()
    {
        InitializeComponent();
    }

    private void button1_Click(object sender, EventArgs e)
    {
        OpenFileDialog openFileDialog = new OpenFileDialog();
        openFileDialog.Title = "Изберете PGM файл";
        openFileDialog.Filter = "PGM изображения (*.pgm)|*.pgm|Всички файлове (*.*)|*.*";

        if (openFileDialog.ShowDialog() == DialogResult.OK)
        {
            string filePath = openFileDialog.FileName;
            var image = PgmTransformer.ConvertPgmToBitmap(filePath);

            pictureBox1.Image = image;
            pictureBox1.Padding = new Padding
            {
                Left = (FORM_WIDTH - image.Width) / 2,
                Top = 60,
                Right = 0,
                Bottom = 0,
            };

            input_r1.Enabled = true;
            input_s2.Enabled = true;
            input_r2.Enabled = true;
            input_s1.Enabled = true;
        }
    }

    private void button2_Click(object sender, EventArgs e)
    {
        var adjustedImageResult = PgmTransformer.AdjustContrast((Bitmap)pictureBox1.Image, (int)input_r1.Value, (int)input_s1.Value, (int)input_r2.Value, (int)input_s2.Value);
        var outputForm = new OutputForm(adjustedImageResult);
        outputForm.Show();
    }

    private void input_r1_ValueChanged(object sender, EventArgs e)
    {
        if (input_r1?.Value != null && input_r2?.Value != null)
        {
            button2.Enabled = input_r1.Value < input_r2.Value;
            label6.Visible = input_r1.Value >= input_r2.Value;
        }
    }

    private void input_r2_ValueChanged(object sender, EventArgs e)
    {
        if (input_r1?.Value != null && input_r2?.Value != null)
        {
            button2.Enabled = input_r1.Value < input_r2.Value;
            label6.Visible = input_r1.Value >= input_r2.Value;
        }
    }
}
