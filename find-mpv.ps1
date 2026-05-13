$sevenZa = "c:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\DIXMAX DOWNLOADER\dixmax-win\node_modules\7zip-bin\win\x64\7za.exe"
$installer = "c:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\DIXMAX DOWNLOADER\Dixmax Downloader.exe"
$dest = "c:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Cineflix Desktop\resources"

Write-Host "Buscando mpv.exe dentro del instalador Dixmax..."
$result = & $sevenZa l $installer 2>&1 | Select-String "mpv"
Write-Host $result

if ($result) {
    Write-Host "Extrayendo mpv.exe del instalador..."
    & $sevenZa e $installer "*mpv.exe" "-o$dest" -r -y
    if (Test-Path "$dest\mpv.exe") {
        Write-Host "OK: mpv.exe copiado ($([Math]::Round((Get-Item "$dest\mpv.exe").Length / 1MB, 1)) MB)"
    } else {
        Write-Host "mpv.exe no estaba en el instalador de Dixmax."
    }
} else {
    Write-Host "mpv no encontrado en el instalador de Dixmax."
    Write-Host "Buscando en otros lugares..."
    
    # Check Program Files
    $pf = @(
        "C:\Program Files\mpv\mpv.exe",
        "C:\Program Files (x86)\mpv\mpv.exe",
        "$env:LOCALAPPDATA\mpv\mpv.exe"
    )
    foreach ($p in $pf) {
        if (Test-Path $p) {
            Write-Host "Encontrado en: $p"
            Copy-Item $p "$dest\mpv.exe" -Force
            Write-Host "OK copiado!"
            break
        }
    }
}
