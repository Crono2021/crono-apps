"""
Generate Android app icons from the Cineflix logo.
Creates all mipmap density variants + adaptive icon resources.
"""
from PIL import Image, ImageDraw
import os
import sys

# The source image path (user will place it here)
SOURCE = sys.argv[1] if len(sys.argv) > 1 else "cineflix_logo.png"

# Standard Android mipmap sizes for launcher icons
SIZES = {
    "mipmap-mdpi": 48,
    "mipmap-hdpi": 72,
    "mipmap-xhdpi": 96,
    "mipmap-xxhdpi": 144,
    "mipmap-xxxhdpi": 192,
}

# Adaptive icon foreground sizes (108dp * density)
ADAPTIVE_SIZES = {
    "mipmap-mdpi": 108,
    "mipmap-hdpi": 162,
    "mipmap-xhdpi": 216,
    "mipmap-xxhdpi": 324,
    "mipmap-xxxhdpi": 432,
}

RES_DIR = os.path.join("android", "app", "src", "main", "res")

def make_round(img, size):
    """Create a circular version of the icon."""
    mask = Image.new("L", (size, size), 0)
    draw = ImageDraw.Draw(mask)
    draw.ellipse((0, 0, size - 1, size - 1), fill=255)
    result = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    result.paste(img, (0, 0), mask)
    return result

def create_adaptive_foreground(img, size):
    """
    Create adaptive icon foreground.
    The icon is centered within the 108dp canvas, occupying the inner 72dp (66%).
    """
    canvas = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    # Inner safe zone is 66% of total
    icon_size = int(size * 0.66)
    resized = img.resize((icon_size, icon_size), Image.LANCZOS)
    offset = (size - icon_size) // 2
    canvas.paste(resized, (offset, offset), resized if resized.mode == "RGBA" else None)
    return canvas

def main():
    if not os.path.exists(SOURCE):
        print(f"ERROR: Source image '{SOURCE}' not found!")
        print("Please place your Cineflix logo as 'cineflix_logo.png' in this directory.")
        sys.exit(1)

    img = Image.open(SOURCE).convert("RGBA")
    print(f"Loaded source image: {img.size[0]}x{img.size[1]}")

    # The logo is rectangular with text below. Crop to just the icon (top-center square).
    w, h = img.size
    # Take the top portion (the play triangle icon, roughly top 70% of height)
    icon_h = int(h * 0.70)
    icon_region = img.crop((0, 0, w, icon_h))
    # Now make it square by centering
    rw, rh = icon_region.size
    sq = max(rw, rh)
    square_canvas = Image.new("RGBA", (sq, sq), (20, 20, 43, 255))  # dark navy bg
    offset_x = (sq - rw) // 2
    offset_y = (sq - rh) // 2
    square_canvas.paste(icon_region, (offset_x, offset_y), icon_region)
    img = square_canvas
    print(f"Cropped to square icon: {img.size[0]}x{img.size[1]}")

    # 1. Standard launcher icons (ic_launcher.png and ic_launcher_round.png)
    for folder, size in SIZES.items():
        out_dir = os.path.join(RES_DIR, folder)
        os.makedirs(out_dir, exist_ok=True)

        # Square icon
        square = img.resize((size, size), Image.LANCZOS)
        square_path = os.path.join(out_dir, "ic_launcher.png")
        square.save(square_path, "PNG")
        print(f"  OK {square_path} ({size}x{size})")

        # Round icon
        round_icon = make_round(img.resize((size, size), Image.LANCZOS), size)
        round_path = os.path.join(out_dir, "ic_launcher_round.png")
        round_icon.save(round_path, "PNG")
        print(f"  ✓ {round_path} ({size}x{size} round)")

    # 2. Adaptive icon foreground
    for folder, size in ADAPTIVE_SIZES.items():
        out_dir = os.path.join(RES_DIR, folder)
        os.makedirs(out_dir, exist_ok=True)

        fg = create_adaptive_foreground(img, size)
        fg_path = os.path.join(out_dir, "ic_launcher_foreground.png")
        fg.save(fg_path, "PNG")
        print(f"  ✓ {fg_path} ({size}x{size} foreground)")

    # 3. Adaptive icon XML (mipmap-anydpi-v26)
    v26_dir = os.path.join(RES_DIR, "mipmap-anydpi-v26")
    os.makedirs(v26_dir, exist_ok=True)

    # ic_launcher.xml
    with open(os.path.join(v26_dir, "ic_launcher.xml"), "w") as f:
        f.write("""<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@color/ic_launcher_background"/>
    <foreground android:drawable="@mipmap/ic_launcher_foreground"/>
</adaptive-icon>
""")

    # ic_launcher_round.xml
    with open(os.path.join(v26_dir, "ic_launcher_round.xml"), "w") as f:
        f.write("""<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@color/ic_launcher_background"/>
    <foreground android:drawable="@mipmap/ic_launcher_foreground"/>
</adaptive-icon>
""")

    # 4. Background color resource
    values_dir = os.path.join(RES_DIR, "values")
    os.makedirs(values_dir, exist_ok=True)
    colors_path = os.path.join(values_dir, "ic_launcher_background.xml")
    with open(colors_path, "w") as f:
        f.write("""<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="ic_launcher_background">#14142B</color>
</resources>
""")
    print(f"  ✓ {colors_path}")

    print("\n✅ All icons generated successfully!")

if __name__ == "__main__":
    main()
