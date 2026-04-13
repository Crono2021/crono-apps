const https = require('https');
https.get('https://api.github.com/repos/Crono2021/crono-apps/actions/runs?per_page=5', {
  headers: { 'User-Agent': 'Node.js' }
}, (res) => {
  let data = '';
  res.on('data', chunk => data += chunk);
  res.on('end', () => {
    const json = JSON.parse(data);
    json.workflow_runs.forEach(run => {
      console.log(`[${run.conclusion || run.status}] ${run.name} - ${run.head_commit.message.slice(0, 50)}`);
    });
  });
}).on('error', console.error);
