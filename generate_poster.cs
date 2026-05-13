using System;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Drawing.Imaging;
using System.IO;

class Program {
    static void Main() {
        try {
            int width = 320;
            int height = 480;
            
            using (Bitmap banner = new Bitmap(width, height))
            using (Graphics g = Graphics.FromImage(banner))
            using (Image logo = Image.FromFile(@"ai_poster.png")) {
                
                g.SmoothingMode = SmoothingMode.HighQuality;
                g.InterpolationMode = InterpolationMode.HighQualityBicubic;
                g.Clear(Color.Black);
                
                // Draw the generated AI poster to fill the 320x480 canvas perfectly
                g.DrawImage(logo, 0, 0, width, height);
                
                banner.Save(@"android\app\src\main\res\drawable\tv_banner.png", ImageFormat.Png);
                Console.WriteLine("AI Poster applied successfully!");
            }
        } catch (Exception ex) {
            Console.WriteLine("Error: " + ex.Message);
        }
    }
}
