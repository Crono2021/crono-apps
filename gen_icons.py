import sys
sys.stdout.reconfigure(encoding='utf-8')
from PIL import Image, ImageDraw
import os

SOURCE = 'cineflix_logo.png'
RES_DIR = os.path.join('android', 'app', 'src', 'main', 'res')

SIZES = {'mipmap-mdpi':48,'mipmap-hdpi':72,'mipmap-xhdpi':96,'mipmap-xxhdpi':144,'mipmap-xxxhdpi':192}
ADAPTIVE = {'mipmap-mdpi':108,'mipmap-hdpi':162,'mipmap-xhdpi':216,'mipmap-xxhdpi':324,'mipmap-xxxhdpi':432}

img = Image.open(SOURCE).convert('RGBA')
w,h = img.size
icon_h = int(h*0.70)
crop = img.crop((0,0,w,icon_h))
sq = max(crop.size)
canvas = Image.new('RGBA',(sq,sq),(20,20,43,255))
ox=(sq-crop.size[0])//2
oy=(sq-crop.size[1])//2
canvas.paste(crop,(ox,oy),crop)
img = canvas
print('Cropped to ' + str(img.size[0]) + 'x' + str(img.size[1]))

def make_round(i,s):
    mask=Image.new('L',(s,s),0)
    d=ImageDraw.Draw(mask)
    d.ellipse((0,0,s-1,s-1),fill=255)
    r=Image.new('RGBA',(s,s),(0,0,0,0))
    r.paste(i,(0,0),mask)
    return r

for folder,size in SIZES.items():
    d=os.path.join(RES_DIR,folder)
    os.makedirs(d,exist_ok=True)
    img.resize((size,size),Image.LANCZOS).save(os.path.join(d,'ic_launcher.png'),'PNG')
    make_round(img.resize((size,size),Image.LANCZOS),size).save(os.path.join(d,'ic_launcher_round.png'),'PNG')
    print('OK ' + folder + ' ' + str(size) + 'x' + str(size))

for folder,size in ADAPTIVE.items():
    d=os.path.join(RES_DIR,folder)
    os.makedirs(d,exist_ok=True)
    fg=Image.new('RGBA',(size,size),(0,0,0,0))
    is2=int(size*0.72)
    r=img.resize((is2,is2),Image.LANCZOS)
    off=(size-is2)//2
    fg.paste(r,(off,off),r)
    fg.save(os.path.join(d,'ic_launcher_foreground.png'),'PNG')
    print('OK fg ' + folder + ' ' + str(size) + 'x' + str(size))

v26=os.path.join(RES_DIR,'mipmap-anydpi-v26')
os.makedirs(v26,exist_ok=True)
xml_content = '<?xml version="1.0" encoding="utf-8"?>\n'
xml_content += '<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">\n'
xml_content += '    <background android:drawable="@color/ic_launcher_background"/>\n'
xml_content += '    <foreground android:drawable="@mipmap/ic_launcher_foreground"/>\n'
xml_content += '</adaptive-icon>\n'
with open(os.path.join(v26,'ic_launcher.xml'),'w') as f:
    f.write(xml_content)
with open(os.path.join(v26,'ic_launcher_round.xml'),'w') as f:
    f.write(xml_content)

vals=os.path.join(RES_DIR,'values')
os.makedirs(vals,exist_ok=True)
color_xml = '<?xml version="1.0" encoding="utf-8"?>\n'
color_xml += '<resources>\n'
color_xml += '    <color name="ic_launcher_background">#14142B</color>\n'
color_xml += '</resources>\n'
with open(os.path.join(vals,'ic_launcher_background.xml'),'w') as f:
    f.write(color_xml)

print('ALL DONE')
