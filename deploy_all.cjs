const { execSync } = require('child_process');
try {
    // 1. Push web source
    execSync('git add src/telegram.js', { stdio: 'inherit' });
    execSync('git commit -m "feat: switch to HLS/M3U8 streaming via NanoHTTPD HlsProxy"', { stdio: 'inherit' });
    execSync('git push origin master', { stdio: 'inherit' });
    console.log('✅ Web source pushed');

    // 2. Copy build + push android
    execSync('xcopy /E /I /Y dist\\* temp_android_fix\\www', { stdio: 'inherit' });
    process.chdir('temp_android_fix');
    execSync('git add -A', { stdio: 'inherit' });
    execSync('git commit -m "feat: HLS M3U8 via NanoHTTPD HlsProxy - replaces raw ServerSocket"', { stdio: 'inherit' });
    execSync('git push crono-apps cineflix-android', { stdio: 'inherit' });
    console.log('✅ Android pushed — APK building...');
} catch (e) {
    console.error('Error:', e.message);
}
