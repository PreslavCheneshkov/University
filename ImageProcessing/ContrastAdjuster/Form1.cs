namespace ContrastAdjuster;

public partial class Form1 : Form
{
    public Form1()
    {
        InitializeComponent();
    }

    private void Form1_Load(object sender, EventArgs e)
    {

    }

    private void openFileDialog1_FileOk(object sender, System.ComponentModel.CancelEventArgs e)
    {

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

            this.input_r1.Enabled = true;
            this.input_s2.Enabled = true;
            this.input_r2.Enabled = true;
            this.input_s1.Enabled = true;
        }
    }

    private void label1_Click(object sender, EventArgs e)
    {

    }

    private void label2_Click(object sender, EventArgs e)
    {

    }

    private void label3_Click(object sender, EventArgs e)
    {

    }

    private void numericUpDown5_ValueChanged(object sender, EventArgs e)
    {

    }

    private void panel1_Paint(object sender, PaintEventArgs e)
    {

    }

    private void button2_Click(object sender, EventArgs e)
    {
        var adjustedImage = PgmTransformer.AdjustContrast((Bitmap)pictureBox1.Image, (int)input_r1.Value, (int)input_s1.Value, (int)input_r2.Value, (int)input_s2.Value);
        pictureBox2.Image = adjustedImage;
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
