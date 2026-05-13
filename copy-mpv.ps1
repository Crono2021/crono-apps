$src = "C:\Users\crono\AppData\Local\Programs\crono-resolver\mpv\mpv.exe"
$dst = "c:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Cineflix Desktop\resources\mpv.exe"
New-Item -ItemType Directory -Force -Path (Split-Path $dst) | Out-Null
Copy-Item $src $dst -Force
$size = [Math]::Round((Get-Item $dst).Length / 1MB, 0)
Write-Host "OK: mpv.exe copiado ($size MB) a resources/"
