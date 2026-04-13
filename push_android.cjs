const { execSync } = require('child_process');
try {
    process.chdir('temp_android_fix');
    execSync('git add -A', { stdio: 'inherit' });
    execSync('git commit -m "fix: handle JS Double→Long conversion for fileSize in initStream"', { stdio: 'inherit' });
    execSync('git push crono-apps cineflix-android', { stdio: 'inherit' });
    console.log('\n✅ Pushed. APK will rebuild.');
} catch (e) {
    console.error('Error:', e.message);
}
