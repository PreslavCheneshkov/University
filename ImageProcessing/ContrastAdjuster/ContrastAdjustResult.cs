namespace ContrastAdjuster;

public class ContrastAdjustResult
{
    public ContrastAdjustResult(Bitmap displayImage, string outputPgmContent)
    {
        DisplayImage = displayImage;
        OutputPgmContent = outputPgmContent;
    }

    public Bitmap DisplayImage { get; set; }

    public string OutputPgmContent { get; set; }
}
