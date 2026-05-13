using System;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Drawing.Imaging;

class Program {
    static void Main() {
        try {
            int targetWidth = 320;
            int targetHeight = 180;
            
            using (Bitmap banner = new Bitmap(targetWidth, targetHeight))
            using (Graphics g = Graphics.FromImage(banner))
            using (Image logo = Image.FromFile(@"logo_real.png")) {
                
                g.SmoothingMode = SmoothingMode.HighQuality;
                g.InterpolationMode = InterpolationMode.HighQualityBicubic;
                g.Clear(Color.Black);
                
                // Calculate scale to fill the entire 320x180 area (Zoom/Center Crop)
                float scale = Math.Max((float)targetWidth / logo.Width, (float)targetHeight / logo.Height);
                int newWidth = (int)(logo.Width * scale);
                int newHeight = (int)(logo.Height * scale);
                
                // Center the image (this will crop any excess part)
                int x = (targetWidth - newWidth) / 2;
                int y = (targetHeight - newHeight) / 2;
                
                g.DrawImage(logo, x, y, newWidth, newHeight);
                
                banner.Save(@"android\app\src\main\res\drawable\tv_banner.png", ImageFormat.Png);
                Console.WriteLine("Taller user logo applied with center-crop to 320x180 successfully!");
            }
        } catch (Exception ex) {
            Console.WriteLine("Error: " + ex.Message);
        }
    }
}
