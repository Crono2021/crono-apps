const { execSync } = require('child_process');

try {
    console.log("Running npm build...");
    execSync('npm run build', { stdio: 'inherit' });
    
    console.log("Copying dist to www...");
    execSync('xcopy /E /I /Y dist\\* temp_android_fix\\www', { stdio: 'inherit' });
    
    console.log("Committing to github...");
    process.chdir('temp_android_fix');
    execSync('git add www', { stdio: 'inherit' });
    execSync('git commit -m "fix(native): correctly register and import local Capacitor ExoPlayer plugin"', { stdio: 'inherit' });
    
    execSync('git push crono-apps cineflix-android', { stdio: 'inherit' });
    console.log("Done!");
} catch (e) {
    console.error("Error:", e.message);
}
