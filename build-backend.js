import esbuild from 'esbuild';

esbuild.build({
  entryPoints: ['temp_android_fix/www/nodejs-project/index.js'],
  bundle: true,
  platform: 'node',
  target: 'node18',
  outfile: 'temp_android_fix/www/nodejs-project/main.js',
  external: ['bridge', 'pg-native'], 
}).then(() => console.log('Node.js Mobile backend bundled successfully!'))
  .catch(() => process.exit(1));
