namespace ContrastAdjuster;

public class PgmTransformer
{
    public static Bitmap ConvertPgmToBitmap(string sourceFilePath)
    {
        using var reader = new StreamReader(sourceFilePath);

        string line;
        do
        {
            line = reader.ReadLine();
        } while (string.IsNullOrWhiteSpace(line));
        if (line != "P2")
            throw new Exception("File is not a valid PGM Image with P2 identifier!");

        while (true)
        {
            line = reader.ReadLine();
            if (string.IsNullOrEmpty(line))
                throw new Exception("Unexpected end of file.");
            
            line = line.Trim();
            if (line.Length == 0 || line.StartsWith("#"))
                continue;
            break;
        }

        var sizeParts = line.Split(" ", StringSplitOptions.RemoveEmptyEntries);

        int width = int.Parse(sizeParts[0]);
        int height = int.Parse(sizeParts[1]);

        int maxValue;
        while (true)
        {
            line = reader.ReadLine();
            if (line == null) 
                throw new Exception("Unexpected end of file.");

            line = line.Trim();
            if (line.Length == 0 || line.StartsWith("#"))
                continue;

            maxValue = int.Parse(line);
            break;
        }

        var pixels = new List<int>();
        while (!reader.EndOfStream)
        {
            line = reader.ReadLine();
            if (line == null)
                break;

            line = line.Trim();
            if (line.Length == 0 || line.StartsWith("#"))
                continue;

            var pixelStringValues = line.Split(" ", StringSplitOptions.RemoveEmptyEntries);
            foreach (var pixelStringValue in pixelStringValues)
                pixels.Add(int.Parse(pixelStringValue));
        }

        if (pixels.Count != width * height)
            throw new Exception($"PGM pixel count ({pixels.Count}) does not match expected ({width} x {height} = {width * height})");

        var bitmap = new Bitmap(width, height);
        int currentPixelIndex = 0;
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                var value = pixels[currentPixelIndex++];
                if (maxValue != 255)
                    value = value * 255 / maxValue;

                value = Math.Min(255, Math.Max(0, value));
                bitmap.SetPixel(x, y, Color.FromArgb(value, value, value));
            }
        }

        return bitmap;
    }

    public static Bitmap AdjustContrast(Bitmap source, int r1, int s1, int r2, int s2)
    {
        var transformed = new Bitmap(source.Width, source.Height);

        for (int y = 0; y < source.Height; y++)
        {
            for (int x = 0; x < source.Width; x++)
            {
                Color orig = source.GetPixel(x, y);
                int gray = orig.R; // grayscale PGM images

                int newGray = Transform(gray, r1, s1, r2, s2);
                newGray = Math.Clamp(newGray, 0, 255);

                transformed.SetPixel(x, y, Color.FromArgb(newGray, newGray, newGray));
            }
        }

        return transformed;
    }

    private static int Transform(int value, int r1, int s1, int r2, int s2)
    {
        if (value < r1)
        {
            if (r1 == 0)
                return s1; // avoid division by zero

            return (int)Math.Round((double)s1 / r1 * value);
        }
        else if (value < r2)
        {
            if (r2 == r1)
                return s2;

            return (int)Math.Round((double)(s2 - s1) / (r2 - r1) * (value - r1) + s1);
        }
        else
        {
            if (r2 == 255)
                return 255;

            return (int)Math.Round((double)(255 - s2) / (255 - r2) * (value - r2) + s2);
        }
    }
}
