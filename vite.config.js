import { defineConfig } from 'vite';
import { nodePolyfills } from 'vite-plugin-node-polyfills';
import { resolve } from 'path';

export default defineConfig({
    base: process.env.VITE_BASE || './',
    plugins: [
        nodePolyfills({
            globals: {
                Buffer: true,
                global: true,
                process: true,
            },
            protocolImports: true,
        }),
        // Fix GramJS serializeBytes: in production builds class names are minified
        // so `instanceof Buffer` fails for Uint8Array returned by Web Crypto API.
        // We patch the check to use ArrayBuffer.isView() which works for both.
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
                        );
                }
            },
        },
    ],
    resolve: {
        alias: {
            // Ensure ALL modules that import 'buffer' get the same package
            buffer: resolve('./node_modules/buffer'),
        },
    },
    build: {
        outDir: 'dist',
        sourcemap: false,
    },
    server: {
        port: 3001,
    },
    preview: {
        host: '0.0.0.0',
        allowedHosts: ['cineflix-production-19e3.up.railway.app', '.railway.app'],
    },
});
