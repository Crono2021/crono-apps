const { execSync } = require('child_process');

try {
    execSync('git add src/main.js src/telegram.js package.json package-lock.json', { stdio: 'inherit' });
    execSync('git commit -m "fix: resolve playInMpv export syntax error and correctly register ExoPlayer plugin"', { stdio: 'inherit' });
    execSync('git push origin master', { stdio: 'inherit' });
    console.log("Committed to master successfully!");
} catch (e) {
    console.error("Error:", e.message);
}
