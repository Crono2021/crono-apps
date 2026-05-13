import { defineConfig, externalizeDepsPlugin } from 'electron-vite'
import { resolve, dirname, join } from 'path'
import { fileURLToPath } from 'url'
import { copyFileSync, mkdirSync, existsSync, readdirSync } from 'fs'
import { nodePolyfills } from 'vite-plugin-node-polyfills'

const __dirname = dirname(fileURLToPath(import.meta.url))

// Copy electron/api CJS files to out/main/api after build (not bundled by Vite)
function copyApiPlugin() {
  return {
    name: 'copy-api-files',
    closeBundle() {
      const srcDir = resolve(__dirname, 'electron/api')
      const destDir = resolve(__dirname, 'out/main/api')
      if (!existsSync(srcDir)) return
      mkdirSync(destDir, { recursive: true })
      for (const f of readdirSync(srcDir)) {
        try { copyFileSync(join(srcDir, f), join(destDir, f)) } catch {}
      }
    }
  }
}

export default defineConfig({
  main: {
    plugins: [externalizeDepsPlugin(), copyApiPlugin()],
    build: {
      lib: { entry: resolve(__dirname, 'electron/main.js') },
    },
  },
  preload: {
    plugins: [externalizeDepsPlugin()],
    build: {
      lib: { entry: resolve(__dirname, 'electron/preload.js') },
    },
  },
  renderer: {
    plugins: [
      nodePolyfills({
        globals: { Buffer: true, global: true, process: true },
        protocolImports: true,
      }),
      // Fix GramJS Buffer instanceof check (same patch as web version)
      {
        name: 'fix-gramjs-buffer-instanceof',
        transform(code, id) {
          if (id.includes('generationHelpers')) {
            return code
              .replace(
                '!(data instanceof Buffer)',
                '!ArrayBuffer.isView(data) && !Buffer.isBuffer(data)'
              )
              .replace(
                'throw Error(`Bytes or str expected, not ${data.constructor.name}`)',
                'data = Buffer.from(data instanceof ArrayBuffer ? data : data.buffer || data); /* gramjs-patch */'
              )
          }
        },
      },
    ],
    resolve: {
      alias: { buffer: resolve('./node_modules/buffer') },
    },
    root: resolve(__dirname, '.'),
    build: {
      outDir: 'out/renderer',
      rollupOptions: {
        input: resolve(__dirname, 'index.html'),
      },
    },
    server: { port: 7500 },
  },
})
