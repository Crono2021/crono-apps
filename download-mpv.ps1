$ErrorActionPreference = "Stop"
$dest = "c:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Cineflix Desktop\resources"
$zip  = "$env:TEMP\mpv_portable.7z"

New-Item -ItemType Directory -Force -Path $dest | Out-Null

Write-Host "Buscando mpv.exe en Sourceforge..."

[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12

try {
    $wc = New-Object System.Net.WebClient
    $wc.Headers.Add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
    $wc.DownloadFile(
        "https://sourceforge.net/projects/mpv-player-windows/files/release/mpv-x86_64-20250330-git-f0e0c88.7z/download",
        $zip
    )
    Write-Host "Descarga OK: $([Math]::Round((Get-Item $zip).Length / 1MB, 1)) MB"
} catch {
    Write-Host "Fallo Sourceforge: $($_.Exception.Message)"

    try {
        $wc2 = New-Object System.Net.WebClient
        $wc2.Headers.Add("User-Agent", "Mozilla/5.0")
        $wc2.DownloadFile(
            "https://nightly.link/mpv-player/mpv/workflows/build/master/mpv-x86_64-windows-msvc.zip",
            "$env:TEMP\mpv_msvc.zip"
        )
        Write-Host "Alternativa descargada"
        Expand-Archive -Path "$env:TEMP\mpv_msvc.zip" -DestinationPath "$env:TEMP\mpv_extracted" -Force
        $found = Get-ChildItem -Recurse "$env:TEMP\mpv_extracted" -Filter "mpv.exe" | Select-Object -First 1
        if ($found) {
            Copy-Item $found.FullName "$dest\mpv.exe" -Force
            Write-Host "OK: mpv.exe copiado (alternativa MSVC)"
        }
    } catch {
        Write-Host "Todas las descargas fallaron: $($_.Exception.Message)"
        Write-Host ""
        Write-Host "SOLUCION MANUAL:"
        Write-Host "1. Ve a https://mpv.io/installation/"
        Write-Host "2. Descarga 'mpv-x86_64-*.7z' de shinchiro"
        Write-Host "3. Extrae mpv.exe y copialo a:"
        Write-Host "   c:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Cineflix Desktop\resources\mpv.exe"
        exit 1
    }
}

if (-not (Test-Path $zip)) {
    Write-Host "No hay zip que descomprimir. Saliendo."
    exit 1
}

$sevenZip = "C:\Program Files\7-Zip\7z.exe"
if (-not (Test-Path $sevenZip)) {
    $sevenZip = "C:\Program Files (x86)\7-Zip\7z.exe"
}

if (Test-Path $sevenZip) {
    Write-Host "Extrayendo mpv.exe con 7-Zip..."
    & $sevenZip e $zip mpv.exe "-o$dest" -y
    if (Test-Path "$dest\mpv.exe") {
        Write-Host "`nOK: mpv.exe listo en resources/ ($([Math]::Round((Get-Item "$dest\mpv.exe").Length / 1MB, 1)) MB)"
    } else {
        Write-Host "ERROR: mpv.exe no encontrado en el archivo. Intentando extraccion completa..."
        & $sevenZip x $zip "-o$env:TEMP\mpvdir" -y
        $found = Get-ChildItem -Recurse "$env:TEMP\mpvdir" -Filter "mpv.exe" | Select-Object -First 1
        if ($found) {
            Copy-Item $found.FullName "$dest\mpv.exe" -Force
            Write-Host "OK: mpv.exe copiado desde subdirectorio"
        } else {
            Write-Host "FALLO: mpv.exe no encontrado. Extraccion manual requerida."
        }
    }
} else {
    Write-Host "7-Zip no encontrado. Instala 7-Zip o extrae mpv.exe manualmente."
}
