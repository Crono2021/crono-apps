const { execSync } = require('child_process');
try {
    execSync('git add package.json package-lock.json src/telegram.js', { stdio: 'inherit' });
    execSync('git commit -m "fix(web): install capacitor/core globally and import registerPlugin properly"', { stdio: 'inherit' });
    execSync('git push origin master', { stdio: 'inherit' });
    console.log("Committed web fix successfully!");
} catch (e) {
    console.error("Error:", e.message);
}
